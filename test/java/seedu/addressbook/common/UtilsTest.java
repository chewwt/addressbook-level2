package seedu.addressbook.common;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class UtilsTest {

	@Test
	public void isAnyNull_noNull_returnsFalse() {
		final Object[] inputs = { "hello", new Integer(53) };
		assertFalse(Utils.isAnyNull(inputs));
	}

	@Test
	public void isAnyNull_singleNull_returnsTrue() {
		final Object[] inputs = { null };
		assertTrue(Utils.isAnyNull(inputs));
	}

	@Test
	public void isAnyNull_someNull_returnsTrue() {
		final Object[] inputs = { "hello", new Integer(53), null };
		assertTrue(Utils.isAnyNull(inputs));
	}

	@Test
	public void elementsAreUnique_allUnique_returnsTrue() {
		final ArrayList<Object> inputs = new ArrayList<Object>();
		inputs.add("hello");
		inputs.add(new Integer(234));
		inputs.add("a");
		assertTrue(Utils.elementsAreUnique(inputs));
	}

	@Test
	public void elementsAreUnique_oneRepeat_returnsFalse() {
		final ArrayList<Object> inputs = new ArrayList<Object>();
		inputs.add("hello");
		inputs.add(new Integer(234));
		inputs.add("hello");
		assertFalse(Utils.elementsAreUnique(inputs));
	}

	@Test
	public void elementsAreUnique_fewRepeats_returnsFalse() {
		final ArrayList<Object> inputs = new ArrayList<Object>();
		inputs.add("hello");
		inputs.add(new Integer(234));
		inputs.add("hello");
		inputs.add("a");
		inputs.add("hello");
		inputs.add("a");
		inputs.add("b");
		assertFalse(Utils.elementsAreUnique(inputs));
	}
}
