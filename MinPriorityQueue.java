
import java.util.Arrays;

import java.util.Arrays;

import javax.naming.NameNotFoundException;

@SuppressWarnings("hiding")
/**<NEWLINE>
 *
 * @author luisandinojr1
 *
 */
public class MinPriorityQueue {
	public GraphNode[] heap ;
	public HashMap map;
	public int size;

	/**<NEWLINE>
	 * the constructor of the minQueue with no params
	 */
	public MinPriorityQueue() {
		map = new HashMap();
		heap = (GraphNode[]) new GraphNode[1024]; // creates heap array
		size = 0;
	}
	/**<NEWLINE>
	 *  inserts an element in the priority queue
	 * @param g
	 */
	public void insert(GraphNode key) {
		heap[size] = key;
		key.priority = Integer.MAX_VALUE;
		heapifyUp(size); //starts at the size spot in the array

		map.set(key, size-1);
		this.size++;
		if (this.size == heap.length) { // if the heap if full duplicate and populate it
			GraphNode[] duplicate= new GraphNode[heap.length*2];
			for (int i = 0; i < heap.length; i++) {
				if (heap[i] == null) {
					return;
				}
				duplicate[i] = this.heap[i];
			}
			heap = duplicate;
		}
	}

	/**<NEWLINE>
	 *  gets the  lowest priority on the queue and returns it
	 *  O(1)
	 * @return the min value
	 */
	public GraphNode pullHighestPriorityElement() {
		GraphNode min = heap[0]; // gets the first element in a list
		heap[0] = null;
		heap[0] = heap[this.size-1];
		size = size -1;
		heapifyDown(0);
		//map.getEntry(min).setKVal(-1);
		heap[size] = null;
		return min;
	}

	/**<NEWLINE>
	 * rebalances based on a given node
	 * log N
	 * @param key
	 */
	public void rebalance(GraphNode key) {

		int index = map.getValue(key);
		System.out.println(index);
	//	heapifyDown(index);
	//	heapifyUp(index);
		heapify(key);
	}

	@SuppressWarnings("unlikely-arg-type")
	/**<NEWLINE>
	 * heapify the queue again
	 * @param key
	 */
	public void heapify(GraphNode key ) {
		int i = 0;
		for( int j = 0; j < size; j++) {

			if(heap[j].equals(key.getId())) {
				i = j;
				j = heap.length;
			}
		}
		heapifyUp(i);
	}

	/**<NEWLINE>
	 *  heapify ups the queue(based on the slides)
	 * @param index
	 */
	public void heapifyUp(int index) {

		while ((size >= 0) && (heap[index].priority < heap[parent(index)].priority)) {

			GraphNode temp = heap[this.parent(index)];
			System.out.println(temp);
			heap[this.parent(index)] = heap[index];

			heap[index] = temp;

			index = this.parent(index);
		}

	}
	/**<NEWLINE>
	 * heapify downs the queue(based on the slides)
	 * @param index
	 * @return
	 */
	public int heapifyDown(int index) {

		int min = 0;
		int l = left(index);
		int r = right(index);

		if ((l <= size) && (heap[l].priority < heap[index].priority)) {
			min = l;
		} else {
			min = index;
		}

		if ((r <= size) && (heap[r].priority < heap[min].priority)) {
			min = r;
		}
		if (min != index) {
			GraphNode temp = heap[min];
			heap[min] = heap[index];
			heap[index] = temp;
			System.out.println();
			heapifyDown(min);

		}

		return min;

	}

	/**<NEWLINE>
	 * if empty returns true
	 * @return true or false based on weather or not it is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**<NEWLINE>
	 * if the map has the node
	 * @param g
	 * @return
	 */
	public boolean hasNode(GraphNode key) {
		return map.hasKey(key);
	}

	/**<NEWLINE>
	 * gets the parent of a node
	 * @param index
	 * @return
	 */
	public int parent(int index) {
		return (index)/2;
	}

	/**<NEWLINE>
	 * gets the left child
	 * @param index
	 * @return
	 */
	public int left(int index) {
		return (index*2 + 1);
	}

	/**<NEWLINE>
	 * gets the right child
	 * @param index
	 * @return
	 */
	public int right(int index) {
		return (index*2 + 2);
	}
}
