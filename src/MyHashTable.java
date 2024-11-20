import java.util.Objects;

/**
 * Creates a HashTable storing House owners as a key
 * Creates of an array of MyList to store buckets
 * @author Umer Siddiqi
 */
public class MyHashTable {
    private MyList[] buckets;
    private int numElements;

    /**
     * Default constructor
     * Initial bucket length is set to 4
     * Initializes every MyList in the MyList array
     */
    public MyHashTable() {
        buckets = new MyList[4];
        numElements = 0;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyList();
        }
    }

    /**
     * Copy Constructor
     * @param other creates a deep copy of the MyHashTable in the parameter
     */
    public MyHashTable(MyHashTable other) {
        buckets = new MyList[other.getNumBuckets()];
        numElements = 0;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyList();
        }
        for(int i = 0; i< buckets.length; i++) {
            House temp = other.getBuckets()[i].getHead();
            for(int j = 0; j < other.getBuckets()[i].getLength(); j++) {
                this.add(temp.deepCopy());
                if(temp.getNext() != null){
                    temp = temp.getNext();
                }
            }
        }
    }

    /**
     * @return a deep copy of the current MyHashTable instance
     */
    public MyHashTable deepCopy(){
        return new MyHashTable(this);
    }

    /**
     * Computes the hash value for a given House
     * @param key the House object for which a hash value is computed
     * @return the hash value
     */
    private int hash(House key) {
        return key.hashCode() % buckets.length;
    }

    /**
     * Adds the House instance in the parameter to the MyHashTable
     * Resizes the MyList array if load factor exceeds 0.75
     * @param a the House to be added
     */
    public void add(House a){
        if(loadFactor() > 0.75){ //If load factor exceeds 0.75, then resizes
            resize();
        }
        int hash = hash(a); //Calculates hash value for House in parameter
        buckets[hash].add(a); //Adds to the corresponding MyList in the buckets array
        numElements++; //Increments numElements
    }

    /**
     * Doubles the size of the MyList array
     */
    public void resize(){
        MyList[] temp = buckets; //Temp MyList array to store current MyList Array
        buckets = new MyList[2 * buckets.length]; //Create a new buckets array with double size
        numElements = 0;
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new MyList(); //Initialize each new MyList in the buckets array
        }
        //Add each element in temp (old buckets array) to the new buckets array and rehashes each element
        for(int i = 0; i < temp.length; i++){
            if(!temp[i].isEmpty()){
                House tempHouse = temp[i].getHead();
                for(int j = 0; j < temp[i].getLength(); j++){
                    this.add(tempHouse.deepCopy());
                    tempHouse = tempHouse.getNext();
                }
            }
        }
    }

    /**
     * Searches for a House object associated with the owner name in the parameter
     * Calculates hash value for String in parameter and searches
     * in the corresponding MyList for a match.
     * @param owner the owner to be searched for
     * @return corresponding House if found, null if House is not found
     */
    public House find(String owner){
        int key = Objects.hash(owner) % buckets.length; //Calculating hash value
        //Iterate through the corresponding MyList
        MyList myList = buckets[key];
        return myList.find(owner);
    }

    /**
     * Prints all the data from the current MyHashTable
     */
    public void show(){
        for(int i = 0; i < buckets.length; i++){
            System.out.println("House(s) in Bucket " + i + ": ");
            House temp = buckets[i].getHead();
            for(int j = 0; j < buckets[i].getLength(); j++){
                System.out.println("    Owner: " + temp.getOwner() + " - Value: " + temp.getValue());
                if(temp.getNext() != null){
                    temp = temp.getNext();
                }
            }
        }
    }

    /**
     * @return number of buckets in the MyHashTable
     */
    public int getNumBuckets() {
        return buckets.length;
    }

    /**
     * @return the bucket array consisting of MyLists
     */
    public MyList[] getBuckets() {
        return buckets;
    }

    /**
     * @return the number of elements in the MyHashTable
     */
    public int getNumElements() {
        return numElements;
    }

    /**
     * @return the load factor of the MyHashTable
     */
    public double loadFactor(){
        return numElements / (double) buckets.length;
    }

}
