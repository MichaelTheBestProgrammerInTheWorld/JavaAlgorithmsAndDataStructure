package hashing;

public class HashTable {

    //Implement a HashTable | Separate Chaining Collision Resolution Technique | Part 2 | Implementation
    private HashNode[] buckets;
    private int numOfBuckets;     //which is the length of buckets array buckets.length  //also called capacity
    private int size;            //refers to number of hashnodes stored in buckets array

    public HashTable(){
        this(10);
    }

    public HashTable(int capacity){
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[capacity];
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    //all put get remove operations are of time complexity O(1)
    //put a new hashnode to the hashtable
    public void put(int key, String value){

    }

    //retrieve value of a certain hashnode using its key
    public String get(int key){
        return null;
    }

    //remove a certain hashnode from hashtable using its key
    public String remove(int key){
        return null;
    }

    private class HashNode {

        private int key;   //can be generic type
        private String value;   //can be generic type
        private HashNode next;  //reference to next hashnode

        public HashNode(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
