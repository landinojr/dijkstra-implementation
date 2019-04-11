/**<NEWLINE>
 * hashmap that uses linear probing.
 * @author luisandinojr1
 *
 */
public class HashMap{
	/**<NEWLINE>
	 * feilds to use for the the Hashmap
	 */
	public Entry [] HashArr; // array Hashmap 
	public int hashSize; // int size 
	public int entries; // num of entreis
	
	/**<NEWLINE>
	 *  constructor that takes in nothing 
	 */
	public HashMap() {
		hashSize = 100000;
		HashArr = new Entry[hashSize];	
		entries = 0;
	}
	/**<NEWLINE>
	 * this method adds the hashed object in the array using the hash-number to determine the index
	 * @param key
	 * @param value
	 */
	public void set(GraphNode key, int value) {
		int numCol = 0;
		boolean checkInsert = false;
		int num = turnNum(key);
		while(!checkInsert) {
			int newHash = hashFucntion(num, numCol);
			if(!collision(newHash)) {
				Entry entry = new Entry(key, value);
				HashArr[newHash] = entry;
				checkInsert = true;
			}else {
				numCol++;
				if(numCol == hashSize*.85) {
					rehash();
				}
				
			}
		
		}
		entries++;
		if(entries == hashSize/2 ) {
			rehash();
		}
		
	}
	/**<NEWLINE>
	 * removes the object form the hashMap
	 */
	public void remove() {
		for(int i = 0; i < HashArr.length; i++) {
			if(HashArr[i] != null) {
				if(HashArr[i].getKVal() == -1) {
					HashArr[i] = null;
				}
			}
			
		}
	}
	

	/**<NEWLINE>
	 * this method serves to rehash the entire array
	 */
	private void rehash() {
		Entry [] clone = HashArr;
		HashArr = new Entry[hashSize*2];
		hashSize = hashSize*2;
		for(int i = 0; i < clone.length; i++) {
			if(clone[i] == null) {
				
			}else {
				set(clone[i].getNode(), clone[i].getKVal());
			}
		}
		
	}
	/**<NEWLINE>
	 * turns the a string into a number 
	 * @param key
	 * @return a number that represents the 
	 */
	public int turnNum(GraphNode key) {
		
		int traverse = key.getId().length();
		int hashNum = 0;
		for(int i = 0; i < traverse; i++) {
			if(Character.isDigit(key.getId().charAt(i))) {
				hashNum = hashNum + Character.getNumericValue(key.getId().charAt(i));
			}else {
				hashNum = hashNum + Character.getNumericValue(key.getId().charAt(i));
				
			}
		}
		return hashNum;
	}
	/**<NEWLINE>
	 *  the actual hash function
	 * @param hashNumber
	 * @param coll
	 * @return
	 */
	public int hashFucntion(int hashNumber, int coll) {
	
		return ((hashNumber % hashSize )+ coll)% hashSize;
		
	}
	/**<NEWLINE>
	 * removes the item from the hashArray
	 * @param key
	 */
	public void remove(GraphNode key ) {
		boolean find = false;
		int num = turnNum(key);
		int numCol = 0;
		int count = 0;
		while(!find && count!=hashSize) {
			int newHash = hashFucntion(num, numCol);
			if(HashArr[newHash] != null &&HashArr[newHash].getNode().getId().equals(key.getId())) {
				find = true;
				 HashArr[newHash] = null;
			}else {
				numCol++;
				count++;
			}
		}
	}
	/**<NEWLINE>
	 * test if there is an element in the array in the same spot
	 * @param hashSpot
	 * @return
	 */
	public boolean collision(int hashSpot) {
		if (HashArr[hashSpot] != null) {
			return true;
		}else {
			return false;
		}
	}
	/**<NEWLINE>
	 * gets the actual node in the hashmap
	 * @param key
	 * @return
	 */
	public GraphNode getNode(GraphNode key ) {
		boolean find = false;
		int num = turnNum(key);
		int numCol = 0;
		int count = 0;
		while(!find && count!=hashSize) {
			int newHash = hashFucntion(num, numCol);
			if(HashArr[newHash] != null &&HashArr[newHash].getNode().getId().equals(key.getId())) {
				find = true;
				return HashArr[newHash].getNode();
			}else {
				numCol++;
				count++;
			}
		}
		return null;
	}
	/**<NEWLINE>
	 * gets the actual value
	 * @param key
	 * @return
	 */
	public int getValue(GraphNode key) {
		System.out.println(key);
		boolean find = false;
		int num = turnNum(key);
		int numCol = 0;
		int count = 0;
		while(!find && count!=hashSize) {
			int newHash = hashFucntion(num, numCol);
			if(HashArr[newHash] != null &&HashArr[newHash].getNode().getId().equals(key.getId())) {
				find = true;
				return HashArr[newHash].getKVal();
			}else {
				numCol++;
				count++;
			}
		}
		return -1;
	}
	/**<NEWLINE>
	 * gets the enty node of the hashmap
	 * @param key
	 * @return
	 */
	public Entry getEntry(GraphNode key) {
		boolean find = false;
		int num = turnNum(key);
		int numCol = 0;
		int count = 0;
		while(!find && count!=hashSize) {
			int newHash = hashFucntion(num, numCol);
			if(HashArr[newHash] != null &&HashArr[newHash].getNode().getId().equals(key.getId())) {
				find = true;
				return HashArr[newHash];
			}else {
				numCol++;
				count++;
			}
		}
		return null;
	}
	/**<NEWLINE>
	 * if something is in the hashMap
	 * @param key
	 * @return
	 */
	public boolean hasKey(GraphNode key) {
		boolean find = false;
		int num = turnNum(key);
		int numCol = 0;
		int count = 0;
		while(!find && count!=hashSize ) {
			int newHash = hashFucntion(num, numCol);
			if(HashArr[newHash] != null &&HashArr[newHash].getNode().getId().equals(key.getId())) {
				find = true;
				return true;
			}else {
				numCol++;
				count++;
			}
		}
		return false;
		
	}

	
		
		
}


	
