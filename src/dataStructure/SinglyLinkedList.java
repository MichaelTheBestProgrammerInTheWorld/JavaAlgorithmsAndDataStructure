package dataStructure;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {

        private int data;
        private ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    //display nodes on the screen
    private void displayNodes(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null\n");
    }

    //get length of list (get nodes count)
    private int length(){
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    //insert a new node in the beginning of the list
    private void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //insert a new node at the end of the list
    private void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }


    //note that position is counted starting from 1 not 0
    private void insertAtPosition(int value, int position, SinglyLinkedList singlyLinkedList){

        ListNode node = new ListNode(value);
        if (position == 0 || position > singlyLinkedList.length()+1){
            System.out.println("Error, Invalid Position");
            return;
        }
        if (position == 1){
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    private ListNode deleteFirstNode(){
        if (head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    private ListNode deleteLastNode(){
        if (head == null){
            return head;
        }
        else if (head.next == null){
            ListNode previous = head;
            head = null;
            return previous;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    private void deleteAtPosition(int position){
        //assume that position is valid and starting from 1
        //3 -> 4 -> 7 -> 8 -> 9 -> null
        if (position == 1){
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    //search if a linked list has a certain value
    private boolean hasValue(int searchKey){
        if (head == null){
            return false;
        }
        ListNode current = head;
        while (current != null){
            if (current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //reverser a singly linked list
    private ListNode reverse(){
        if (head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        //creating list nodes
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        ListNode fifth = new ListNode(5);


        //linking list nodes together
        sll.head.next = second;   //10 --> 1 --> null
        second.next = third;      //10 --> 1 --> 8 --> null
        third.next = fourth;   //10 --> 1 --> 8 --> 11 --> null
        fourth.next = fifth;   //10 --> 1 --> 8 --> 11 --> 5 --> null


        //printing list nodes data on the screen
        sll.displayNodes();
/*
        //display list length
        System.out.println("\n Length is = " + sll.length());

        System.out.println("insert a new node in the beginning of the list");
        sll.insertFirst(5);
        sll.insertFirst(3);
        sll.displayNodes();

        System.out.println("insert a new node at the end of the list");
        sll.insertLast(3);
        sll.insertLast(5);
        sll.displayNodes();

        System.out.println("insert a new node at third position of the list");
        sll.insertAtPosition(9, 1, sll);
        sll.insertAtPosition(9, 3, sll);
        sll.insertAtPosition(9, 11, sll);
        sll.insertAtPosition(9, 17, sll);
        sll.insertAtPosition(9, 0, sll);
        sll.displayNodes();



        sll.displayNodes();
        System.out.println(sll.deleteFirstNode().data);
        sll.displayNodes();



        sll.displayNodes();
        System.out.println(sll.deleteLastNode().data);
        sll.displayNodes();
        System.out.println(sll.deleteLastNode().data);
        sll.displayNodes();
        System.out.println(sll.deleteLastNode().data);
        sll.displayNodes();
        System.out.println(sll.deleteLastNode().data);
        sll.displayNodes();
        if (sll.deleteLastNode() != null){
            System.out.println(sll.deleteLastNode().data);
        }

        sll.displayNodes();
        sll.deleteAtPosition(4);
        sll.displayNodes();
        sll.deleteAtPosition(2);
        sll.displayNodes();

         */

        System.out.println(sll.hasValue(1));
        System.out.println(sll.hasValue(99));
        System.out.println(sll.hasValue(5));

        sll.head = sll.reverse();
        sll.displayNodes();
    }
}
