public class MyList {
    private House head = null;
    private int length;

    /**
     * Default Constructor of class MyList
     */
    public MyList(){
        this.head = null;
        this.length = 0;
    }

    /**
     * Copy Constructor
     * @param other creates a deepCopy of MyList in the parameter
     */
    public MyList(MyList other){
        //Checks if the MyList provided in the parameter is empty
        if(other.isEmpty()){
            this.head = null;
            this.length = 0;
        }
        //Creates a deepCopy of all instances of House in the MyList in the parameter
        else{
            House temp = other.getHead(); //House temp is used to traverse the MyList
            while(temp != null){
                this.add(temp.deepCopy());
                temp = temp.getNext();
            }
        }
    }

    /**
     * @return a deepCopy of the current MyList instance
     */
    public MyList deepCopy(){
        return new MyList(this);
    }

    /**
     * Adds the House instance from the parameter to the MyList
     * @param a the House instance to be added
     */
    public void add(House a) {
        length++; //length is incremented whenever a House is added
        House temp;
        if (head == null){ //If the list is empty, head becomes a
            head = a;
        }
        //adds House a to the front of the list and points it to the previous head
        else {
            temp = head;
            head = a;
            head.setNext(temp);
        }
    }

    /**
     * @return the length of the MyList
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the first House instance in the MyList
     */
    public House getHead(){
        return head;
    }

    /**
     * @return true if the MyList is logically empty, false if it is not
     */
    public boolean isEmpty() {
        return getLength() == 0;
    }

    /**
     * Iterates through the current MyList instance to find
     * the House with a corresponding owner provided in the parameter
     * @param owner the owner to be searched for
     * @return the House with the associated owner if found, null if not found
     */
    public House find(String owner){
        House temp = head; //temp used to iterate through the array
        for(int i = 0; i < length; i++){
            if(temp.getOwner().equals(owner)){
                return temp; //returns temp if corresponding owner is found
            }
            if(temp.getNext() != null){
                temp = temp.getNext();
            }
        }
        return null; //returns null if corresponding owner is not found
    }
}
