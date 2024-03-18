
/**
 * An object of this class allows to store an array of integer by linking differents objects as a set of nods. 
 * Each object stores its value and the link another object, in elements. The client can access
 * to a copy of the array, add a value at the end of the array or delete its last value
 * 
 * @invar | getElements() != null
 */
public class IntList {
	
	/**
	 * @invar | value != null
	 */
	private int value;
	private IntList next;
	

	/**
	 * Initializes the Intlist with a int[] array. 
	 * You will need to create as much nodes as the number of values there is
	 * 
	 * @pre | initialElements != null
	 * 
	 * @inspects | 
	 * @post | GetElements() != null
	 * @post | GetElements().length == initialElements.length
	 * @post | Arrays.equals(GetElements(), initialElements)
	 */
	public IntList(int[] initialElements){
		this.value  = initialElements[0];
		IntList current = this;
		for (int i= 1; i < initialElements.length; i++) {
			current.next = new IntList(initialElements[i]);
			current = current.next;}
	}
			
	/**
	 * adds a node to an existing node
	 */
	private IntList(int value){
		this.value = value;
		this.next = null;
				}

	/**
	 * return the size of the integer array linked to the Intlist.
	 * @post | 0<= c
	 */
	
	int arraySize() {
		if (this.next == null)
		    return 0;
		  else
		    return 1 + this.next.arraySize();
	}

	/**
	 * returns a copy of the integer array linked to the Intlist .
	 * @post | Array != null 
	 */
	
	int[] getElements() {
	    int[] array = new int[this.arraySize() + 1]; 
	    int c = 0;
	    IntList current = this;
	    while (current != null) { 
	        array[c] = current.value; 
	        c += 1;
	        current = current.next;
	    }
	    return array;
	}

			
		
	/**
	 * Add a value at the end of the array elements
	 * 
	 * @mutates | elements
	 * 
	 * @post return a copy of the array elements with the value added at its end
	 * | elements.length = old(elements.length) + 1 
	 * |IntStreamRange(0;old(elements.length).allMatch(i  -> elements[i]== old(elements)[i]| elements[elements.length] == value)
	 *
	 */
	public void addValue(int value) {
		IntList current = this;
		while (current.next != null){
			current = current.next;}
		current.next = new IntList(value);
	}


	/**
	 * Delete the last value of elements
	 * 
	 * @pre elements.length > 0
	 * 
	 * @mutates | one IntList.next
	 * 
	 * @post | elements.length = old(elements.length) -1
	 * | IntStreamRange(0;elements.length).allMatch(i  -> elements[i]== old(elements)[i]
	 * 
	 * 
	 */
	 public void supprValue() {
		 IntList current = this;
			while (current.next != null && current.next.next != null){
				current = current.next;
			}
		current.next = null;
				
			
	}
}
