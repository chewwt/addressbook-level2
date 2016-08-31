package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {

    public static final String EXAMPLE = "231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person postal code must be a number";	
    public static final String POSTAL_VALIDATION_REGEX = "\\d+";

    private final String postal;
    
    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code is invalid.
     */    
    public PostalCode(String str) throws IllegalValueException {
    	str = str.trim();
    	
        if (!isValidPostal(str)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.postal = str; 
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    public static boolean isValidPostal(String test) {
    	 return test.matches(POSTAL_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return postal;
    }
	
}
