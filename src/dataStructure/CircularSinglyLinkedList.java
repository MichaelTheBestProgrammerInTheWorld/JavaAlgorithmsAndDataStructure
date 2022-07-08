package dataStructure;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;
        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularSinglyLinkedList(){
        last = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void create(){
        ListNode first = new ListNode(5);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(15);
        first.next = second;
        second.next = third;
        third.next = first;
        last = third;
        length = 3;
    }

    public void display(){
        if (last == null){
            return;
        }
        ListNode first = last.next;
        while (first != last){
            System.out.print(first.data + " -> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void insertAtBeginning(int data){
        ListNode temp = new ListNode(data);
        if (last == null){
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void insertAtEnd(int data){
        ListNode temp = new ListNode(data);
        if (last == null){
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    //How to remove first node from a Circular Singly Linked List in Java
    public ListNode removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("Circular Singly Linked List is empty");
        }
        ListNode temp = last.next;
        if (last.next == last){
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException("Circular Singly Linked List is empty");
        }
        ListNode temp = last.next;
        if (last.next == last){
            last = null;
            temp.next = null;
        } else {
            while (temp.next != last){
                temp = temp.next;
            }
            //last.next = temp.next;
            temp.next = last.next;
            last = temp;
        }

        length--;
        return temp;
    }

    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.create();
        csll.display();
        csll.insertAtBeginning(25);
        csll.display();
        System.out.println(csll.length);
        csll.insertAtEnd(30);
        csll.display();
        System.out.println(csll.length);
        csll.removeFirst();
        csll.display();
        csll.removeLast();
        csll.display();
    }
}
