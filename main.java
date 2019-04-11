
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

import javax.naming.NameNotFoundException;
/**<NEWLINE>
 * This is the client code for the the shortest path algorithm in a graph. 
 * @author luisandinojr1
 *
 */

public class main {
	/**<NEWLINE>
	 * main driver method and creates the necessary structures. 
	 * @param args
	 * @throws NameNotFoundException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws NameNotFoundException, FileNotFoundException  {
		MinPriorityQueue minQueue = new MinPriorityQueue();
		GraphWrapper start = new GraphWrapper(true);
		GraphNode home = start.getHome();
		GraphNode track = home;
		
		minQueue.insert(home);
		minQueue.heap[0].priority = 0;
		
		
		GraphNode path = findpath(home,minQueue);
		printpath(path, track);
	}
	/**<NEWLINE>
	 * This method prints the paths of the files.
	 * @param curr
	 * @param track
	 * @throws FileNotFoundException
	 */
	private static void printpath(GraphNode curr, GraphNode track) throws FileNotFoundException {
		System.out.println("hey");
		Stack<String> s = new Stack();
		GraphNode temp = curr;
		
		while(temp != track) {
			s.push(temp.previousDirection);
			temp = temp.previousNode;
		}
		System.out.println(s.size());
		PrintWriter writer = new PrintWriter("answer.txt");
		while(!s.isEmpty()) {
			writer.println(s.pop());
		}
		
		
		writer.close();
		
		
	}
	/**<NEWLINE>
	 * This method is the main algorithm to find the shortest path using a priority queue. 
	 * @param curr
	 * @param track
	 * @throws FileNotFoundException
	 */
	
	public static GraphNode findpath(GraphNode home, MinPriorityQueue minQueue) {
		GraphNode curr = home;
		while (!minQueue.isEmpty() && !curr.isGoalNode() && curr != null && minQueue.size != 10000000) {
			System.out.println("darn");
			
			curr = minQueue.pullHighestPriorityElement();
			
			System.out.println (" this is the size" + minQueue.size);
			
			System.out.println(curr.getId());
			System.out.println(curr.isGoalNode());
			if (curr.isGoalNode()) {
					
					System.out.println("we have made it to your destination");
					return curr;
					
			}else {
				int tempNodeIndex ;
				if (curr.hasNorth()) {
					tempNodeIndex = curr.priority + curr.getNorthWeight();
					System.out.println(curr.getNorth().getId());
				
					System.out.println(curr.getNorth().isGoalNode());
					
					if (!minQueue.hasNode(curr.getNorth())) {
						
						curr.getNorth().priority = tempNodeIndex;
						curr.getNorth().previousNode = curr;
						curr.getNorth().previousDirection = "North";
						
						minQueue.insert(curr.getNorth());
						
					}
					if (minQueue.hasNode(curr.getNorth()) && tempNodeIndex < curr.getNorth().priority) {
						
						System.out.println(curr.getNorth().getId());
						System.out.println(curr.getNorth().isGoalNode());
						curr.getNorth().priority = tempNodeIndex;
						minQueue.rebalance(curr.getNorth());
						curr.getNorth().previousNode = curr;
						curr.getNorth().previousDirection = "North";
					}
				}if (curr.hasSouth()) {
					tempNodeIndex = curr.priority + curr.getSouthWeight();
					System.out.println(curr.getSouth().getId());
					
					System.out.println(curr.getSouth().isGoalNode());
					if (!minQueue.hasNode(curr.getSouth())) {
						curr.getSouth().priority = tempNodeIndex;
						curr.getSouth().previousNode = curr;
						curr.getSouth().previousDirection = "South";
						
						minQueue.insert(curr.getSouth());
					}
					if (minQueue.hasNode(curr.getSouth()) && tempNodeIndex < curr.getSouth().priority) {
						//System.out.println(curr.getSouth().getId());
						System.out.println(curr.getSouth().isGoalNode());
						curr.getSouth().priority = tempNodeIndex;
						minQueue.rebalance(curr.getSouth());
						curr.getSouth().previousNode = curr;
						curr.getSouth().previousDirection = "South";
					}
				}
				if (curr.hasEast()) {
					tempNodeIndex = curr.priority + curr.getEastWeight();
					System.out.println(curr.getEast().getId());
					
					System.out.println(curr.getEast().isGoalNode());
					if (!minQueue.hasNode(curr.getEast())) {
						curr.getEast().priority = tempNodeIndex;
						curr.getEast().previousNode = curr;
						curr.getEast().previousDirection = "East";
						
						minQueue.insert(curr.getEast());
					}
					if (minQueue.hasNode(curr.getEast()) && tempNodeIndex < curr.getEast().priority) {
						System.out.println(curr.getEast().getId());
						System.out.println(curr.getEast().isGoalNode());
						curr.getEast().priority = tempNodeIndex;
						minQueue.rebalance(curr.getEast());
						curr.getEast().previousNode = curr;
						curr.getEast().previousDirection = "East";
					}
				}
				if (curr.hasWest()) {
					tempNodeIndex = curr.priority + curr.getWestWeight();
					System.out.println(minQueue.hasNode(curr.getWest()));
					System.out.println(curr.getWest().isGoalNode());
				
					if (!minQueue.hasNode(curr.getWest())) {
						curr.getWest().priority = tempNodeIndex;
						curr.getWest().previousNode = curr;
						curr.getWest().previousDirection = "West";
						
						minQueue.insert(curr.getWest());
					} 
					if (minQueue.hasNode(curr.getWest()) && tempNodeIndex < curr.getWest().priority) {
						System.out.println(curr.getWest().getId());
						System.out.println(curr.getWest().isGoalNode());
						curr.getWest().priority = tempNodeIndex;
						minQueue.rebalance(curr.getWest());
						curr.getWest().previousNode = curr;
						curr.getWest().previousDirection = "West";
					}
				}
			}
			
		}
		return curr;
		
	}
	

}
