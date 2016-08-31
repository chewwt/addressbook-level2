package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's street in his address.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)} in the Address Object
 */
public class Street {
	
	public static final String EXAMPLE = "Clementi Ave 3";
	
    private final String street;
    
    /**
     * Trims the street name
     * 
     * Assumes: Street is valid since it passes {@link #isValidAddress(String)}
     */    
    public Street(String str) {
        this.street = str.trim(); 
    }
    
    @Override
    public String toString() {
        return street;
    }
	
}
