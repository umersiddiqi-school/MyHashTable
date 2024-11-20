import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 * Tests other classes
 * @author Umer Siddiqi
 */
public class Main {
    /**
     * Create a MyHashTable and populate it with data from house.txt
     * Test all methods from other classes
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        MyHashTable mht = new MyHashTable();
        //Scans each line of the house.txt file to add data to mht
        File file = new File("src/houses.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            String owner = scan.nextLine();
            int value = Integer.parseInt(scan.nextLine());
            House house = new House(owner, value);
            mht.add(house); //Add the House created from house.txt data to hash table
        }
        scan.close();
        fis.close();

        mht.show();

        //Testing copy constructor and deepcopy
        House test1 = new House("Umer", 1);
        House test2 = new House("Jeff", 2);
        House test3 = new House("Anthony", 3);
        House test4 = new House("Sam", 4);
        House test5 = new House("Max", 5);
        MyHashTable mht2 = new MyHashTable();
        mht2.add(test1);
        mht2.add(test2);
        mht2.add(test3);
        mht2.add(test4);
        mht2.add(test5);
        System.out.println("\nOriginal HashTable:");
        mht2.show();
        System.out.println("\nCopy Constructor:");
        MyHashTable mht3 = new MyHashTable(mht2);
        mht3.show();
        System.out.println("\ndeepCopy() method:");
        MyHashTable mht4 = mht2.deepCopy();
        mht4.show();

        //Find method test
        System.out.println("\nTesting find method:");
        if(mht2.find("Umer")==null){
            System.out.println("Owner Umer is not found");
        }
        else{
            System.out.println("Owner Umer is found");
        }
        if(mht2.find("Bob")==null){
            System.out.println("Owner Bob is not found");
        }
        else{
            System.out.println("Owner Bob is found");
        }
    }
}