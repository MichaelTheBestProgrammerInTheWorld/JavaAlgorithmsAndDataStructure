package dataStructure;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    public DoublyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    private static class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }

    //check if list is empty
    private boolean isEmpty(){
        return length == 0;
    }

    //get list length
    private int length(){
        return length;
    }

    //display list nodes forward
    private void displayForward(){
        if (head == null){
            return;
        }
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //display list nodes backward
    private void displayBackward(){
        if (tail == null){
            return;
        }
        ListNode temp = tail;
        while (temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    //insert a new node at the beginning of the list
    private void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if (isEmpty()){
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    //insert a new node at the end of the list
    private void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if (isEmpty()){
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    //delete first node in the list
    private ListNode deleteFirst(){
        if (isEmpty()){
            return null;
        }
        ListNode temp = head;
        if (head == tail){
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    //delete last node in the list
    private ListNode deleteLast(){
        if (isEmpty()){
            return null;
        }
        ListNode temp = head;
        if (head == tail){
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    //delete a certain node in the list
    private boolean deleteNode(int data){
        if (isEmpty()){
            return false;
        }
        ListNode temp = head;
        while (temp != null){
            if (temp.data == data){
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                length--;
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        //create doubly linked list and link its nodes
        DoublyLinkedList dll = new DoublyLinkedList();
        /*
        dll.head = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(11);
        dll.tail = new ListNode(8);
        dll.head.previous = null;
        dll.head.next = second;
        second.previous = dll.head;
        second.next = third;
        third.previous = second;
        third.next = fourth;
        fourth.previous = third;
        fourth.next = dll.tail;
        dll.tail.previous = fourth;
        dll.tail.next = null;
        //display doubly linked list forward and backward
        dll.displayForward();
        dll.displayBackward();
        //System.out.println(dll.length());


        //insert a new node at the beginning of the list
        dll.insertFirst(1);
        dll.insertFirst(3);
        dll.insertFirst(5);
        dll.insertFirst(99);
        dll.insertFirst(8);
        dll.displayForward();
        dll.displayBackward();
        dll.insertLast(88);
        dll.displayForward();
        dll.displayBackward();

         */
        //insert a new node at the end of the list
        dll.insertLast(1);
        dll.insertLast(5);
        dll.insertLast(3);
        dll.insertLast(99);
        dll.insertLast(8);
        dll.displayForward();
        dll.displayBackward();

        /*
        //delete first node in the list
        if (dll.deleteFirst() == null){
            System.out.println("list is empty");
        } else {
            dll.displayForward();
        }
        if (dll.deleteFirst() == null){
            System.out.println("list is empty");
        } else {
            dll.displayForward();
        }
        if (dll.deleteFirst() == null){
            System.out.println("list is empty");
        } else {
            dll.displayForward();
        }
        if (dll.deleteFirst() == null){
            System.out.println("list is empty");
        } else {
            dll.displayForward();
        }
        if (dll.deleteFirst() == null){
            System.out.println("list is empty");
        } else {
            dll.displayForward();
        }
        if (dll.deleteFirst() == null){
            System.out.println("list is empty");
        } else {
            dll.displayForward();
        }

         */

        //delete last node in the list
//        if (dll.deleteLast() == null){
//            System.out.println("list is empty");
//        } else {
//            dll.displayForward();
//        }
//        if (dll.deleteLast() == null){
//            System.out.println("list is empty");
//        } else {
//            dll.displayForward();
//        }
//        if (dll.deleteLast() == null){
//            System.out.println("list is empty");
//        } else {
//            dll.displayForward();
//        }
//        if (dll.deleteLast() == null){
//            System.out.println("list is empty");
//        } else {
//            dll.displayForward();
//        }
//        if (dll.deleteLast() == null){
//            System.out.println("list is empty");
//        } else {
//            dll.displayForward();
//        }
//        if (dll.deleteLast() == null){
//            System.out.println("list is empty");
//        } else {
//            dll.displayForward();
//        }

        //delete a certain node in the list
        if (dll.deleteNode(99)){
            System.out.println("deleted successfully");
            dll.displayForward();
        } else {
            System.out.println("node not found");
        }
        if (dll.deleteNode(999)){
            System.out.println("deleted successfully");
            dll.displayForward();
        } else {
            System.out.println("node not found");
        }
    }
}
