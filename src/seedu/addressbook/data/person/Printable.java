package seedu.addressbook.data.person;

public interface Printable {
	public static final String PRIVATE_PREFIX = "(private)";
	
	default String getPrintableString() {
		return this.toString();
	}

}
