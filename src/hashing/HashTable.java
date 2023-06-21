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
        if (value == null){
            throw new IllegalArgumentException("Invalid input");
        }
        int bucketIndex = getBucketIndex(key);   // key % numOfBuckets;
        HashNode head = buckets[bucketIndex];
        while (head != null){
            if (head.key == key){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    //this is modular hash function
    private int getBucketIndex(int key){
        int index = key % numOfBuckets;
        if (numOfBuckets > index && index >= 0){
            return index;
        } else {
            throw new IllegalArgumentException("key is invalid exceeds capacity");
        }
    }

    //retrieve value of a certain hashnode using its key
    public String get(int key){
        int bucketIndex = getBucketIndex(key);   // key % numOfBuckets;
        HashNode head = buckets[bucketIndex];
        while (head != null){
            if (head.key == key){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    //remove a certain hashnode from hashtable using its key
    public String remove(int key){
        int bucketIndex = getBucketIndex(key);   // key % numOfBuckets;
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        while (head != null){
            if (head.key == key){
                break;           //current key equals to the desired key
            }
            previous = head;    //current key not equals to the desired key
            head = head.next;
        }
        if (head == null){
            return null;    //key not found in hashtable
        }
        size--;        //deleting the node after we found it
        if (previous != null){
            previous.next = head.next;     //deleted node has next
        } else {
            buckets[bucketIndex] = head.next;   //deleted node doesnt have next
        }
        return head.value;
    }

    //display keys and values of all nodes exist in the hashtable
    public void displayAllElements(){
        for (int i=0; i<numOfBuckets; i++){
            HashNode head = buckets[i];
            while (head != null){
                System.out.println("Key = " + head.key);
                System.out.println("Value = " + head.value);
                head = head.next;
            }
        }
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

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(105, "Michael");
        table.put(21, "Mary");
        table.put(25, "Tom");
        System.out.println("Number of elements in hash table = " + table.size());
        table.put(25, "keona");
        System.out.println("Number of elements in hash table = " + table.size());
        System.out.println("Value in key 25 is " + table.get(25));
        System.out.println("Value in key 28 is " + table.get(28));
        table.put(29, "Jack");
        System.out.println("Value in key 29 is " + table.get(29));
        System.out.println("Value in key 29 is removed successfully " + table.remove(29));
        System.out.println("Number of elements in hash table = " + table.size());
        System.out.println("Value in key 30 is removed successfully " + table.remove(30));
        table.displayAllElements();
    }
}
