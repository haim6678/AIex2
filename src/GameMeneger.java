public class GameMeneger {

	private Map map;
	private MinMaxAlgo minMaxAlgo;
	private GameLogicMeneger gameLogicMeneger;

	/**
	 * the constructor
	 */
	public GameMeneger(Map m, MinMaxAlgo algo, GameLogicMeneger l) {
		this.map = m;
		this.minMaxAlgo = algo;
		this.gameLogicMeneger = l;
	}

	/**
	 * run the game until we finish
	 */
	public String play() {

		int i = 0;
		while (!this.gameLogicMeneger.checkEnd(this.map)) {
			Point newMove;
			Map m = this.map.clone();
			if ((i % 2) == 0) {
				newMove = this.minMaxAlgo.getBestMove(m, this.gameLogicMeneger, "B");
				this.map = this.gameLogicMeneger.ExecuteMove(newMove.getX(), newMove.getY(), "B", this.map);
			} else {
				newMove = this.minMaxAlgo.getBestMove(m, this.gameLogicMeneger, "W");
				this.map = this.gameLogicMeneger.ExecuteMove(newMove.getX(), newMove.getY(), "W", this.map);
			}
			i++;
			System.out.println();
			System.out.print(newMove.getX()+" "+newMove.getY());
			System.out.println();
			this.map.print();
		}
		return this.gameLogicMeneger.CheckWinn("B") ? "B" : "W";
	}
}
