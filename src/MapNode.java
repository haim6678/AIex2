/**
 * Created by haim on 24/11/2017.
 */
public class MapNode {


	private int x;
	private int y;
	private String nodeStatus;
	private MapNode parant = null;
	private MapNode[] kids;

	/**
	 * the constructor
	 */
	public MapNode(int x_loc, int y_loc, MapNode p) {

		this.x = x_loc;
		this.y = y_loc;
		this.parant = p;
		this.kids = new MapNode[8];
	}

	/**
	 * override equal function
	 */
	@Override
	public boolean equals(Object o) {

		return (((MapNode) o).getX() == this.x) && (((MapNode) o).getY() == this.y);
	}

	/* getters and setters*/


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public MapNode getParant() {
		return parant;
	}

	public void setParant(MapNode parant) {
		this.parant = parant;
	}

	public String getNodeStatus() {
		return nodeStatus;
	}

	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}

}
