package heap;

public class MaxPriorityQueue {

    private int[] heap;
    private int n;    //size of max heap

    public MaxPriorityQueue(int capacity){
        heap = new int[capacity+1];   //index 0 is kept empty
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(int value){
        if (n == heap.length-1){
            resize(2 * heap.length);
        }
        n++;
        heap[n] = value;
        swim(n);
    }

    //bottom up reheapify to maintain heap rules after insert new node
    private void swim(int k) {

        while (k > 1 && heap[k/2] < heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;  //to continue shifting up until we reach the correct position
        }
    }

    private void resize(int newCapacity) {
        int[] temp = new int[newCapacity];
        for (int i=0; i< heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void printMaxHeap(){
        //we use this one because the first index is kept empty
        for (int i=1; i<=n; i++){
            System.out.print(heap[i] + " --> ");
        }
        System.out.println("End");
//        for (int i : heap){
//            System.out.print(i + " --> ");
//        }
//        System.out.println("End");
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n+1] = 0;
        if (n > 0 && (n == (heap.length - 1) / 4 )){
            resize(heap.length / 2);
        }
        return max;
    }

    //top down reheapify to maintain heap rules after deleting root node
    private void sink(int k) {
        while (2*k <= n){
            int j = 2*k;
            if (j < n && heap[j] < heap[j+1]){
                j++;
            }
            if (heap[k] >= heap[j]){
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        MaxPriorityQueue maxPQ = new MaxPriorityQueue(5);
        System.out.println(maxPQ.isEmpty());
        System.out.println(maxPQ.size());
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.insert(2);
        maxPQ.insert(6);
        maxPQ.insert(1);
        maxPQ.insert(3);
        maxPQ.printMaxHeap();
        maxPQ.deleteMax();
        maxPQ.printMaxHeap();
    }
}
