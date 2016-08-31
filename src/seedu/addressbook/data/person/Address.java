package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format 'BLOCK, STREET, UNIT, POSTAL_CODE'";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postal;   
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        extractAddressInfo(address);
    }

    /**
     * Tries to extract individual information from address
     *
     * @throws IllegalValueException if unable to extract from given address
     */
	private void extractAddressInfo(String address) throws IllegalValueException {
		String[] parts = address.split(",");
        if (parts.length != 4) {
        	throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
    	
    	this.block = new Block(parts[0]);
    	this.street = new Street(parts[1]);
    	this.unit = new Unit(parts[2]);
    	this.postal = new PostalCode(parts[3]);
    	
//    	catch (IllegalValueException e) {
//    	}
	}

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
    	 return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
    	return this.block + ", " + this.street + ", " + this.unit + ", " + this.postal;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    /**
     * Returns the person's block number
     */    
    public String getBlock(){
    	return this.block.toString();
    }
    
    /**
     * Returns the person's street address
     */    
    public String getStreet(){
    	return this.street.toString();
    }
    
    /**
     * Returns the person's unit number
     */    
    public String getUnit(){
    	return this.unit.toString();
    }    
    
    /**
     * Returns the person's postal code
     */    
    public String getPostalCode(){
    	return this.postal.toString();
    }    
    
}