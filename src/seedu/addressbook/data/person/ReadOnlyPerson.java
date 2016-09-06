package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyPerson {

    Name getName();
    Phone getPhone();
    Email getEmail();
    Address getAddress();

    /**
     * The returned TagList is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if the values inside this object is same as those of the other (Note: interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getName().equals(this.getName()) // state checks here onwards
                && other.getPhone().equals(this.getPhone())
                && other.getEmail().equals(this.getEmail())
                && other.getAddress().equals(this.getAddress()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsTextShowAll() {
        final StringBuilder builder = new StringBuilder();
    	String str = getPrintableString(getName(), getPhone(), getEmail(), getAddress());
    	builder.append(str);
        builder.append("Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }

    /**
     * Formats a person as text, showing only non-private contact details.
     */
    default String getAsTextHidePrivate() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName().getPrintableString()).append(" ");
        if (!getPhone().isPrivate()) {
            builder.append(getPhone().getPrintableString()).append(" ");
        }
        if (!getEmail().isPrivate()) {
            builder.append(getEmail().getPrintableString()).append(" ");
        }
        if (!getAddress().isPrivate()) {
            builder.append(getAddress().getPrintableString()).append(" ");
        }
        builder.append("Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }
    
    /**
     * Returns a concatenated version of the printable strings of each object.
     */
    default String getPrintableString(Printable... printables){
    	String str = "";
        for (Printable p : printables) {
        	str += p.getPrintableString() + " ";
        }
        return str;
    }    
}
