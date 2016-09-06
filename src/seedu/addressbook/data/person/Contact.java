package seedu.addressbook.data.person;

public class Contact {
	
    protected String value;
    protected boolean isPrivate;
    
    public Contact(String value, boolean isPrivate) {
    	this.value = value;
    	this.isPrivate = isPrivate;
    }
    
    public Contact() {
    }
    
    public String getValue(){
    	return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }    
}
