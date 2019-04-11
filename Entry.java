/**
 * 
 */

/**
 * @author Luisandinojr1
 *
 */
public class Entry {
	/**<NEWLINE>
	 * feilds for the node
	 */
	private GraphNode node;
	private int kVal;
	/**<NEWLINE>
	 * constructor of the node with two variables
	 * @param node
	 * @param kVal
	 */
	public Entry(GraphNode node, int kVal) {
		this.node = node;
		this.kVal = kVal;
		
	}
	/**<NEWLINE>
	 * gets the node 
	 * @return
	 */
	public GraphNode getNode() {
		return node;
	}
	/**<NEWLINE>
	 * gets the value 
	 * @return
	 */
	public int getKVal() {
		return kVal;
	}
	/**<NEWLINE>
	 * sets the value 
	 * @param num
	 */
	public void setKVal(int num) {
		kVal = num;
	}
	/**<NEWLINE>
	 * to String method 
	 */
	public String toString() {
		return "["+ getNode() + " , " + getKVal() + "]";
	}
}
