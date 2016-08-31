package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's unit in his address.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {
	
    public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person unit must be like " + EXAMPLE;	
    public static final String UNIT_VALIDATION_REGEX = "#\\d{1,3}?-\\d{1,4}?";
    
    private final String unit;
   	
    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */    
    public Unit(String str) throws IllegalValueException {
    	str = str.trim();
    	
        if (!isValidUnit(str)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.unit = str; 
    }

    /**
     * Returns true if a given string is a valid unit.
     */
    public static boolean isValidUnit(String test) {
    	 return test.matches(UNIT_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return unit;
    }
	
}
