package queue;
import listnode.ListNode;

import java.util.NoSuchElementException;

public class Queue {

    private ListNode front, rear;
    private int length;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void print(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        ListNode current = front;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void enqueue(int data){
        ListNode temp = new ListNode(data);
        if (isEmpty()){
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        int result = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        length--;
        return result;
    }

    public int first(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        return front.data;
    }

    public int last(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        return rear.data;
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        System.out.println(queue.first());
        System.out.println(queue.last());
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
    }
}
