
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
		if ((x >= this.size) || (x < 0) || (y >= this.size) || (y < 0)) {
			return null; //todo what will apppend with equals to null
		}
		return this.map[x][y];
	}

	/**
	 * set a given block on the map
	 */
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
