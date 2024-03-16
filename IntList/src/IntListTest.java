import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntListTest {

	private IntList myIntList;
	
	@BeforeEach
	void initIntList() {
	myIntList = new IntList(new int[]{10, 30, -10, -30});
	}
	
	@Test
	void testGetLElements() {
		myIntList.addValue(100);
		assertArrayEquals(new int[] {10, 30, -10, -30, 100}, myIntList.getElements());
	}
	
	@Test
	void testAddValue() {
		myIntList.addValue(100);
	assertArrayEquals(new int[]{10, 30, -10,-30, 100},myIntList.getElements());
	}
	@Test
	void testSupprValue() {
		myIntList.supprValue();
	assertArrayEquals(new int[]{10, 30, -10},myIntList.getElements());
	}
}
