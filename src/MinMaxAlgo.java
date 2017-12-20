import java.util.ArrayList;

public class MinMaxAlgo {
	private Map gameMap;
	private Map minMaxTempMap;
	private GameLogicMeneger gameLogicMeneger;

	/**
	 * get the best move for a given player and a given map situation
	 */
	public Point getBestMove(Map m, GameLogicMeneger g, String color) {

		Point point = null;
		this.gameMap = m;
		this.gameLogicMeneger = g;
		this.minMaxTempMap = m;
		ArrayList<Point> pointOptions = new ArrayList<>();

		//run on the empty spaces put a player from the given color
		//check what is the heuristic result for each move
		//and choose the max result
		for (int i = 0; i < this.gameMap.getSize(); i++) {
			for (int j = 0; j < this.gameMap.getSize(); j++) {
				if ((this.gameMap.getNodeStatus(i, j).equals("E")) && (this.gameLogicMeneger.checkMove(this.gameMap, i, j))) {
					this.minMaxTempMap = this.gameMap;
					this.minMaxTempMap = this.gameLogicMeneger.ExecuteMove(i, j, color, this.minMaxTempMap);
					int val = (this.minMaxValuePerPoint(this.minMaxTempMap, 2, false, color));
					pointOptions.add(new Point(i, j, val));
				}
			}
		}

		//get the max result
		point = pointOptions.remove(0);
		for (Point p : pointOptions) {
			if (p.getHuristic() > point.getHuristic()) {
				point = p;
			}
		}
		return point;
	}

	/**
	 * the recursion function that develops the game "tree"
	 * and return the result or the operation
	 */
	private int minMaxValuePerPoint(Map map, int depth, boolean maxPlayer, String color) {
		if ((depth == 0) || (this.gameLogicMeneger.checkEnd(this.minMaxTempMap))) {
			return this.gameLogicMeneger.calcHuristic(this.minMaxTempMap);
		}
		if (maxPlayer) {
			int bestVal = Integer.MIN_VALUE;
			int retVal = 0;
			for (int i = 0; i < this.gameMap.getSize(); i++) {
				for (int j = 0; j < this.gameMap.getSize(); j++) {
					if (this.gameMap.getNodeStatus(i, j).equals("E")) {
						map = this.gameLogicMeneger.ExecuteMove(i, j, color, map); //todo b?
						int tempVal = minMaxValuePerPoint(map, depth - 1, false, color);
						retVal = Math.max(bestVal, tempVal);
					}
				}
			}
			return retVal;
		} else {
			int bestVal = Integer.MAX_VALUE;
			int retVal = 0;
			String other = color.equals("B") ? "w" : "B";
			for (int i = 0; i < this.gameMap.getSize(); i++) {
				for (int j = 0; j < this.gameMap.getSize(); j++) {
					if ((this.gameMap.getNodeStatus(i, j).equals("E")) && (this.gameLogicMeneger.checkMove(this.gameMap, i, j))) {
						map = this.gameLogicMeneger.ExecuteMove(i, j, other, map);//todo w?
						int tempVal = minMaxValuePerPoint(map, depth - 1, true, color);
						retVal = Math.min(bestVal, tempVal);
					}
				}
			}
			return retVal;
		}
	}
}
