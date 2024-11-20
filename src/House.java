import java.util.Objects;

/**
 * Used to create instances of a House
 * Stores data of the House's owner and its value
 * @author Umer Siddiqi
 */
public class House {

    private String owner;
    private int value;
    private House next; //Used to track Houses in LinkedList

    /**
     * Default constructor
     * Sets House owner to null and House value to 0
     */
    public House() {
        this.owner = null;
        this.value = 0;
        this.next = null;
    }

    /**
     * Creates an instance of House using the parameter
     * @param owner to set House owner
     * @param value to set House value
     */
    public House(String owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    /**
     * Copy constructor to create a deepCopy of parameter
     * @param other to Copy
     */
    public House(House other){
        owner = new String(other.getOwner());
        value = other.getValue();
        this.next = null;
    }

    /**
     * Getter method returning owner
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Getter method returning value
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter method returning next House
     * @return House
     */
    public House getNext(){
        return next;
    }

    /**
     * Setter method to set the next House
     * @param next to set next House
     */
    public void setNext(House next){
        this.next = next;
    }

    /**
     * Setter method to set the value for the current instance of House
     * @param value to set value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Setter method to set the owner for the current instance of House
     * @param owner to set owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Creates a new deepCopy of the current instance of House
     * @return a deepCopy of the current instance of House
     */
    public House deepCopy(){
        return new House(new String(this.getOwner()), this.getValue());
    }

    /**
     * Overrides default equals method
     * Compares the owner and value of the current instance to the owner and value of the House in the parameter
     * @param other to compare current instance
     * @return true if the owner and value are the same, false otherwise
     */
    public boolean equals(House other){
        return (this.getOwner().equals(other.getOwner()));
    }

    /**
     * Calculates and returns a hash code value based on the owner's name using Objects.hash().
     * Ensures that the hash code value can not be negative.
     * @return a non-negative hash code value based on the owner's name.
     */
    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(owner));
    }
}

