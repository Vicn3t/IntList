
import java.util.Arrays;
/**
 * An object of this class stores an array of integers in elements. The client can access
 * to a copy of the array, add a value at the end of the array or delete its last value
 * 
 * @invar | getElements() != null
 */
public class IntList {
	
	/**
	 * @invar | elements != null
	 */
	private int[] elements;
	
	/**
	 * returns a copy of the elements array.
	 */
	int[] getElements() {
		return Arrays.copyOf(elements, elements.length);
	}
	
	/**
	 * Initializes the Intlist with a int[] array.
	 * 
	 * @pre | initialElements != null
	 * 
	 * @inspects | elements
	 * @post | GetElements() != null
	 * @post | GetElements().length == initialElements.length
	 * @post | Arrays.equals(GetElements(), initialElements)
	 */
	public IntList(int[] initialElements){
		elements = initialElements;
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
		int[] newArray = new int[elements.length+1];
		for (int i =0; i <elements.length; i++)
			newArray[i] = elements[i];
		newArray[elements.length] = value;
		elements = newArray;

		
		
	}
	
	/**
	 * Delete the last value of elements
	 * 
	 * @pre elements.length > 0
	 * 
	 * @mutates | elements
	 * 
	 * @post | elements.length = old(elements.length) -1
	 * | IntStreamRange(0;elements.length).allMatch(i  -> elements[i]== old(elements)[i]
	 * 
	 * 
	 */
	 public void supprValue() {
		 int[] newArray = new int[elements.length-1];
			for (int i =0; i <elements.length-1; i++)
				newArray[i] = elements[i];
			elements = newArray;
	}
}
