package seedu.addressbook.common;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;

public class UtilsTest {
    private Object[] list_noNull, list_oneNull, list_someNull;
    private ArrayList<Object> arrayList_noDuplicate = new ArrayList<Object>();
    private ArrayList<Object> arrayList_oneDuplicate = new ArrayList<Object>();
    private ArrayList<Object> arrayList_someDuplicates = new ArrayList<Object>();
    
    @Before
    public void setupLists() {
        this.list_noNull = new Object[]{"hello", "world"};
        this.list_oneNull = new Object[]{"hello",null};
        this.list_someNull = new Object[]{"hello", "world", null, null};
        
        this.arrayList_noDuplicate.add("hello");
        this.arrayList_noDuplicate.add("hi");
        this.arrayList_noDuplicate.add("apple");
        
        this.arrayList_oneDuplicate.add("hello");
        this.arrayList_oneDuplicate.add("hi");
        this.arrayList_oneDuplicate.add("hello");
        
        this.arrayList_someDuplicates.add("hello");
        this.arrayList_someDuplicates.add("hi");
        this.arrayList_someDuplicates.add("hello");
        this.arrayList_someDuplicates.add("apple");
        this.arrayList_someDuplicates.add("apple");
        this.arrayList_someDuplicates.add("banana");
        this.arrayList_someDuplicates.add("coconut");
    }    

	@Test
	public void isAnyNull_noNull_returnsFalse() {
		assertFalse(Utils.isAnyNull(list_noNull));
	}

	@Test
	public void isAnyNull_singleNull_returnsTrue() {
		assertTrue(Utils.isAnyNull(list_oneNull));
	}

	@Test
	public void isAnyNull_someNull_returnsTrue() {
		assertTrue(Utils.isAnyNull(list_someNull));
	}

	@Test
	public void elementsAreUnique_allUnique_returnsTrue() {
		assertTrue(Utils.elementsAreUnique(arrayList_noDuplicate));
	}

	@Test
	public void elementsAreUnique_oneRepeat_returnsFalse() {
		assertFalse(Utils.elementsAreUnique(arrayList_oneDuplicate));
	}

	@Test
	public void elementsAreUnique_fewRepeats_returnsFalse() {
		assertFalse(Utils.elementsAreUnique(arrayList_someDuplicates));
	}
}
