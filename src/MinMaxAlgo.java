import java.util.ArrayList;

public class MinMaxAlgo {


	private Map gameMap;
	private Map minMaxTempMap;
	private GameLogicMeneger gameLogicMeneger;

	public Point getBestMove(Map m, GameLogicMeneger g) {

		Point point = null;
		this.gameMap = m;
		this.gameLogicMeneger = g;
		this.minMaxTempMap = m;
		ArrayList<Point> pointOptions = new ArrayList<>();

		for (int i = 0; i < this.gameMap.getSize(); i++) {
			for (int j = 0; j < this.gameMap.getSize(); j++) {
				if (this.gameMap.getNodeStatus(i, j).equals("E")) {
					this.minMaxTempMap = this.gameMap;
					this.minMaxTempMap = this.gameLogicMeneger.ExecuteMove(i, j, "B", this.minMaxTempMap);
					int val = (this.minMaxValuePerPoint(this.minMaxTempMap, 2, true));
					pointOptions.add(new Point(i, j, val));
				}
			}
		}

		point = pointOptions.remove(0);
		for (Point p : pointOptions) {
			if (p.getHuristic() < point.getHuristic()) {
				point = p;
			}
		}
		return point;
	}

	private int minMaxValuePerPoint(Map map, int depth, boolean maxPlayer) {
		if ((depth == 0) || (this.gameLogicMeneger.checkEnd(this.minMaxTempMap))) {
			return this.gameLogicMeneger.calcHuristic(this.minMaxTempMap);
		}
		if (maxPlayer) {
			int bestVal = Integer.MIN_VALUE;
			int retVal = 0;
			for (int i = 0; i < this.gameMap.getSize(); i++) {
				for (int j = 0; j < this.gameMap.getSize(); j++) {
					if (this.gameMap.getNodeStatus(i, j).equals("E")) {
						map = this.gameLogicMeneger.ExecuteMove(i, j, "B", map); //todo b?
						int tempVal = minMaxValuePerPoint(map, depth - 1, false);
						retVal = Math.max(bestVal, tempVal);
					}
				}
			}
			return retVal;
		} else {
			int bestVal = Integer.MAX_VALUE;
			int retVal = 0;
			for (int i = 0; i < this.gameMap.getSize(); i++) {
				for (int j = 0; j < this.gameMap.getSize(); j++) {
					if (this.gameMap.getNodeStatus(i, j).equals("E")) {
						map = this.gameLogicMeneger.ExecuteMove(i, j, "W", map); //todo w?
						int tempVal = minMaxValuePerPoint(map, depth - 1, true);
						retVal = Math.min(bestVal, tempVal);
					}
				}
			}
			return retVal;
		}

	}


}
