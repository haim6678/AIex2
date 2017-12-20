public class GameLogicMeneger {

	private Map map;
	private int currCheckingI;
	private int currCheckingJ;


	/**
	 * check if a move is legal
	 */
	public boolean checkMove(Map m, int x, int y) {

		if (!m.getNodeStatus(x - 1, y).equals("E")
				|| (!m.getNodeStatus(x, y - 1).equals("E"))
				|| (!m.getNodeStatus(x + 1, y).equals("E"))
				|| (!m.getNodeStatus(x, y + 1).equals("E"))
				|| (!m.getNodeStatus(x - 1, y - 1).equals("E"))
				|| (!m.getNodeStatus(x - 1, y + 1).equals("E"))
				|| (!m.getNodeStatus(x + 1, y - 1).equals("E"))
				|| (!m.getNodeStatus(x + 1, y + 1).equals("E"))) {
			return true;
		}

		return false;
	}

	/**
	 * execure a given move for a given player
	 */
	public Map ExecuteMove(int x, int y, String color, Map m) {

		this.currCheckingI = x;
		this.currCheckingJ = y;
		this.map = m;
		//check all possible directions
		CheckConvertToRight(color);
		CheckConvertToLeft(color);
		CheckConvertToUp(color);
		CheckConvertToDown(color);
		CheckConvertToLeftAndUp(color);
		CheckConvertToLeftAndDown(color);
		CheckConvertToRightAndUp(color);
		CheckConvertToRightAndDown(color);

		return this.map;
	}

	/**
	 * execute the move to right
	 */
	void CheckConvertToRight(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;


		startY++;
		while ((endX == -1) && (endY == -1) && (startY < map.getSize())) {

			//if there is'nt my piece in the other side from the right
			if (map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if (map.getNodeStatus(startX, startY).equals(color)) {
				endX = startX;
				endY = startY;
			}
			startY++;
		}


		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while (startY < endY) {
				this.map.setBlock(startX, startY, color);
				startY++;
			}
		}
	}

	/**
	 * execute move to left
	 */
	void CheckConvertToLeft(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;

		startY--;
		while ((endX == -1) && (endY == -1) && (startY >= 0)) {

			//if there is'nt my piece in the other side from the left
			if (this.map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if ((this.map.getNodeStatus(startX, startY).equals(color))) {
				endX = startX;
				endY = startY;
			}
			startY--;
		}

		//if we found the move legal the change the board
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while (startY > endY) {
				this.map.setBlock(startX, startY, color);
				startY--;
			}
		}
	}

	/**
	 * execute move to up
	 */
	void CheckConvertToUp(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;

		startX--;
		while ((endX == -1) && (endY == -1) && (startX >= 0)) {

			//if there is'nt my piece in the other side from the above
			if (this.map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if ((this.map.getNodeStatus(startX, startY).equals(color))) {
				endX = startX;
				endY = startY;
			}
			startX--;
		}

		//if we found the move legal the change the board
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while (startX > endX) {
				this.map.setBlock(startX, startY, color);
				startX--;
			}
		}
	}

	/**
	 * execute novr to down
	 */
	void CheckConvertToDown(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;

		startX++;
		while ((endX == -1) && (endY == -1) && (startX < this.map.getSize())) {

			//if there is'nt my piece in the other side from the bottom
			if (this.map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if ((this.map.getNodeStatus(startX, startY).equals(color))) {
				endX = startX;
				endY = startY;
			}
			startX++;
		}

		//if we found the move legal the change the board
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while (startX < endX) {
				this.map.setBlock(startX, startY, color);
				startX++;
			}
		}
	}

	/**
	 * execute move to left and up
	 */
	void CheckConvertToLeftAndUp(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;

		startX--;
		startY--;
		while ((endX == -1) && (endY == -1) && (startX >= 0) && (startY >= 0)) {

			//if there is'nt my piece in the other side from the left and up
			if (this.map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if ((this.map.getNodeStatus(startX, startY).equals(color))) {
				endX = startX;
				endY = startY;
			}
			startX--;
			startY--;
		}

		//if we found the move legal the change the board
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while ((startX > endX) && (startY > endY)) {
				this.map.setBlock(startX, startY, color);
				startX--;
				startY--;
			}
		}
	}

	/**
	 * execute move to left and down
	 */
	void CheckConvertToLeftAndDown(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;

		startX++;
		startY--;
		while ((endX == -1) && (endY == -1) && (startX < this.map.getSize()) && (startY >= 0)) {

			//if there is'nt my piece in the other side from the left and down
			if (this.map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if ((this.map.getNodeStatus(startX, startY).equals(color))) {
				endX = startX;
				endY = startY;
			}
			startX++;
			startY--;
		}

		//if we found the move legal the change the board
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while ((startX < endX) && (startY > endY)) {
				this.map.getNodeStatus(startX, startY).equals(color);
				startX++;
				startY--;
			}
		}
	}

	/**
	 * execute move to right and up
	 */
	void CheckConvertToRightAndUp(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;


		startX--;
		startY++;
		while ((endX == -1) && (endY == -1) && (startX >= 0) && (startY < this.map.getSize())) {

			//if there is'nt my piece in the other side from the right and up
			if (this.map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if ((this.map.getNodeStatus(startX, startY).equals(color))) {
				endX = startX;
				endY = startY;
			}
			startX--;
			startY++;

		}
		//if we found the move legal the change the board
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while ((startX > endX) && (startY < endY)) {
				this.map.setBlock(startX, startY, color);
				startX--;
				startY++;
			}
		}
	}

	/**
	 * execute move to right and down
	 */
	void CheckConvertToRightAndDown(String color) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;

		startX++;
		startY++;
		while ((endX == -1) && (endY == -1) && (startX < this.map.getSize()) && (startY < this.map.getSize())) {

			//if there is'nt my piece in the other side from the right and down
			if (this.map.getNodeStatus(startX, startY).equals("E")) {
				break;
			}
			if ((this.map.getNodeStatus(startX, startY).equals(color))) {
				endX = startX;
				endY = startY;
			}
			startX++;
			startY++;
		}

		//if we found the move legal the change the board
		if ((endX != -1) && (endY != -1)) {

			startX = this.currCheckingI;
			startY = this.currCheckingJ;
			while ((startX < endX) && (startY < endY)) {
				this.map.setBlock(startX, startY, color);
				startX++;
				startY++;
			}
		}
	}

	/**
	 * check if the board is full, or there is only one color or more from one color
	 */
	public boolean CheckWinn(String color) {
		int white = 0;
		int black = 0;
		int empty = 0;
		for (int i = 0; i < this.map.getSize(); i++) {
			for (int j = 0; j < this.map.getSize(); j++) {
				if (this.map.getNodeStatus(i, j).equals("W")) {
					white++;
				} else if (this.map.getNodeStatus(i, j).equals("B")) {
					black++;
				} else {
					empty++;
				}
			}
		}
		return (empty == 0) && ((black > white) && (color.equals("B")) || ((white > black) && (color.equals("W"))));
	}

	/**
	 * get the heuristic evaluation in case we are in the middle of the play
	 */
	private int calcHuristicNum(Map m) {
		int numberOfBlack = 0;
		int numberOfWhite = 0;
		int hurb = 0;
		int hurw = 0;
		for (int i = 0; i < m.getSize(); i++) {
			for (int j = 0; j < m.getSize(); j++) {
				if (m.getNodeStatus(i, j).equals("W")) {
					numberOfWhite++;
				} else {
					numberOfBlack++;
				}
				if ((i == m.getSize() - 1) || (j == m.getSize()) || (i == 0) | (j == 0)) {
					if (m.getNodeStatus(i, j).equals("B")) {
						hurb++;
					} else {
						hurw++;
					}
				}
			}
		}
		return (numberOfBlack - numberOfWhite) + (hurb - hurw);
	}


	/**
	 *get the heuristic number
	 */
	public int calcHuristic(Map m) {
		if (this.CheckWinn("B")) {
			return Integer.MAX_VALUE;
		}
		String other = "W";
		if (this.CheckWinn(other)) {
			return Integer.MIN_VALUE;
		}
		return this.calcHuristicNum(m);
	}

	/**
	 *
	 * check if the game is finished
	 */
	public boolean checkEnd(Map m) {

		for (int i = 0; i < m.getSize(); i++) {
			for (int j = 0; j < m.getSize(); j++) {
				if (m.getNodeStatus(i, j).equals("E")) {
					return false;
				}
			}
		}
		return true;
	}
}
