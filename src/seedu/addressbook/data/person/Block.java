package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's block in his address.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person block must be a number";	
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";
    
    private final String block;
    
    /**
     * Validates given block.
     *
     * @throws IllegalValueException if given block string is invalid.
     */    
    public Block(String str) throws IllegalValueException {
    	str = str.trim();
    	
        if (!isValidBlock(str)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = str; 
    }

    /**
     * Returns true if a given string is a valid block.
     */
    public static boolean isValidBlock(String test) {
    	 return test.matches(BLOCK_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return block;
    }
	
}
