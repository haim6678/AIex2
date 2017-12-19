public class GameLogicMeneger {

	private Map map;
	private int currCheckingI;
	private int currCheckingJ;
	private boolean somthingToMOve = false;


	public GameLogicMeneger() {

	}

	/**
	 * input - a point,a flag to indicate if the move was good,the player board number
	 * and a flag if it's my input
	 * operation - runs the given point and try to change the board
	 */
	public Map ExecuteMove(int x, int y, String color, Map m) {

		this.currCheckingI = x;
		this.currCheckingJ = y;
		this.map = m;
		//check all possible directions
		CheckConvertToRight(color, true);
		CheckConvertToLeft(color, true);
		CheckConvertToUp(color, true);
		CheckConvertToDown(color, true);
		CheckConvertToLeftAndUp(color, true);
		CheckConvertToLeftAndDown(color, true);
		CheckConvertToRightAndUp(color, true);
		CheckConvertToRightAndDown(color, true);

		return this.map;
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to the right there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToRight(String color, boolean act) {
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
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while (startY < endY) {
					this.map.setBlock(startX, startY, color);
					startY++;
				}
			}
		}
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to the left there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToLeft(String color, boolean act) {
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

		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while (startY > endY) {
					this.map.setBlock(startX, startY, color);
					startY--;
				}
			}
		}
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to upward there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToUp(String color, boolean act) {
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

		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while (startX > endX) {
					this.map.setBlock(startX, startY, color);
					startX--;
				}
			}
		}
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to down there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToDown(String color, boolean act) {
		int endX = -1;
		int endY = -1;
		int startX = this.currCheckingI;
		int startY = this.currCheckingJ;
		//check if below from the given move there is an empty space or my piece
		//check if the place is empty

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

		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while (startX < endX) {
					this.map.setBlock(startX, startY, color);
					startX++;
				}
			}
		}
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to the left and up there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToLeftAndUp(String color, boolean act) {
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

		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while ((startX > endX) && (startY > endY)) {
					this.map.setBlock(startX, startY, color);
					startX--;
					startY--;
				}
			}
		}
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to the left and down there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToLeftAndDown(String color, boolean act) {
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

		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while ((startX < endX) && (startY > endY)) {
					this.map.getNodeStatus(startX, startY).equals(color);
					startX++;
					startY--;
				}
			}
		}
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to the right and up there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToRightAndUp(String color, boolean act) {
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
		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while ((startX > endX) && (startY < endY)) {
					this.map.setBlock(startX, startY, color);
					startX--;
					startY++;
				}
			}
		}
	}

	/**
	 * input- get the point where thw player locate is new piece,a flag to update if we change
	 * something,and a flag to say what's my number on board
	 * operation- checking if from the piece position to the right and down there is a legal move
	 * (that in the end there a second piece of my kind) if there is - update the
	 * move flag/
	 */
	void CheckConvertToRightAndDown(String color, boolean act) {
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

		//if we found the move legal the change the board and update the flag to 1
		if ((endX != -1) && (endY != -1)) {
			this.somthingToMOve = true;
			if (act) {
				startX = this.currCheckingI;
				startY = this.currCheckingJ;
				while ((startX < endX) && (startY < endY)) {
					this.map.setBlock(startX, startY, color);
					startX++;
					startY++;
				}
			}
		}
	}


	/**
	 * input - a flag that indicate the sort of check we conduct
	 * operation - check if the board is full, or there is only one color
	 */
	private boolean CheckWinn(String color) {
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
		//todo empty??
		// איפה ניתן להניח
		// איך נקבע ניצחון

		return (empty == 0) && ((black > white) && (color.equals("B")) || ((white > black) && (color.equals("W"))));
	}

	private int calcHuristicNum(Map m) {
		int numberOfBlack = 0;
		int numberOfWhite = 0;
		int hur = 0;
		for (int i = 0; i < m.getSize(); i++) {
			for (int j = 0; j < m.getSize(); j++) {
				if (m.getNodeStatus(i, j).equals("W")) {
					numberOfWhite++;
				} else {
					numberOfBlack++;
				}
				if ((i == m.getSize() - 1) || (j == m.getSize()) || (i == 0) | (j == 0)) {
					hur++;
				}
			}
		}
		hur += (numberOfBlack - numberOfWhite);
		return hur;
	}

	public int calcHuristic(Map m) {
		if (this.CheckWinn("B")) {
			return Integer.MAX_VALUE;
		}
		String other =  "W" ;
		if (this.CheckWinn(other)) {
			return Integer.MIN_VALUE;
		}
		return this.calcHuristicNum(m);
	}

	public boolean checkEnd(Map m){

		return false;
	}
}
