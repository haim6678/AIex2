import java.util.Stack;

/**
 * the map class
 * we are not keeping a classic map of object,
 * we are just saving the parsed file input for better performance
 * we are creating the node on demand.
 */
public class Map {
	private String[][] map;
	private int size;

	/**
	 * the constructor
	 */
	public Map(int mapSize, String[][] arr) {
		this.map = arr;
		this.size = mapSize;
	}



	/**
	 * get node representation
	 */
	public String getNodeStatus(int x, int y) {
		return this.map[x][y];
	}

	public void setBlock(int x, int y, String color) {
		this.map[x][y] = color;
	}

	/**
	 * get map size given in file input
	 */
	public int getSize() {
		return size;
	}

}
