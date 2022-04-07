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

    private ListNode getMiddleNode(){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    //getting the node at n position counting from the end of the list
    // and assuming that the position is valid
    private ListNode getnNodeFromEnd(int positionFromEnd){
        if (head == null){
            return null;
        }
        if (positionFromEnd <= 0){
            throw new IllegalArgumentException("Position is greater than list length" + positionFromEnd);
        }
        ListNode mainPointer = head;
        ListNode refPointer = head;
        int counter = 0;
        while (counter < positionFromEnd){
            if (refPointer == null){
                throw new IllegalArgumentException("Invalid value " + positionFromEnd);
            }
            refPointer = refPointer.next;
            counter++;
        }
        while (refPointer != null){
            mainPointer = mainPointer.next;
            refPointer = refPointer.next;
        }
        return mainPointer;
    }

    //doing my own algorithm for the same achievement
    private ListNode getnNodeFromEnd2(int positionFromEnd){
        //check if position is valid
        if (positionFromEnd > length()){
            return null;
        }
        ListNode mainPointer = head;
        int counter = length() - positionFromEnd;
        for (int i=1; i<=counter; i++){
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }

    //remove duplicate from sorted Singly Linked List
    private void removeDuplicateFromSorted(){
        if (head == null){
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    //insert a node in a sorted Singly Linked List
    private ListNode insertInSorted(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
            return head;
        }
        ListNode current = head;
        ListNode temp = null;
        if (current.data > newNode.data){
            newNode.next = current;
            head = newNode;
        } else {
            while (current != null && current.data < newNode.data){
                temp = current;
                current = current.next;
            }
            newNode.next = current;
            temp.next = newNode;
        }
        return head;
    }

    //doing my own algorithm for the same achievement
    private void insertInSorted2(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
        }
        ListNode current = head;
        if (current.data > newNode.data){
            newNode.next = current;
            head = newNode;
            return;
        }
        while (current != null && current.data < newNode.data){
            if (current.next == null){
                current.next = newNode;
                return;
            }
            if (current.next.data > newNode.data){
                newNode.next = current.next;
                current.next = newNode;
                return;
            } else {
                current = current.next;
            }
        }
    }

    //remove a given key from Singly Linked List
    private void deleteNode(int nodeValue){
        if (head == null){
            return;
        }
        if (head.data == nodeValue){
            head = head.next;
            return;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current != null && current.data != nodeValue){
            previous = current;
            current = current.next;
        }
        if (current == null){
            return;
        }
        previous.next = current.next;
    }

    //Detect a loop in a Singly Linked List
    private boolean hasLoop(){
        if (head == null || head.next == null){
            return false;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                return true;
            }
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    private void createLoopedLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    //find start of a loop in a Singly Linked List using floyd cycle detection algorithm
    private ListNode getStartingNodeInLoop(){
        if (head == null || head.next == null){
            return null;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            //this part of code is not compatible with floyd algorithm
//            if (slowPtr == fastPtr){
//                ListNode temp = head;
//                while (temp != slowPtr){
//                    temp = temp.next;
//                    slowPtr = slowPtr.next;
//                }
//                return slowPtr;
//            }
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr){
                ListNode temp = head;
                while (temp != slowPtr){
                    temp = temp.next;
                    slowPtr = slowPtr.next;
                }
                return slowPtr;
            }
        }
        return null;
    }

    //remove loop from a Singly Linked
    private void removeLoop(){
        if (head == null || head.next == null){
            return ;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr){
                ListNode temp = head;
                while (temp.next != slowPtr.next){
                    temp = temp.next;
                    slowPtr = slowPtr.next;
                }
                slowPtr.next = null;
                return;
            }
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        //creating list nodes
        sll.head = new ListNode(1);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(16);
        ListNode fifth = new ListNode(20);


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



        //searching a value
        System.out.println(sll.hasValue(1));
        System.out.println(sll.hasValue(99));
        System.out.println(sll.hasValue(5));

        //reverse the linked list
        sll.head = sll.reverse();
        sll.displayNodes();


        //get the middle node and display its value
        System.out.println(sll.getMiddleNode().data);

        System.out.println(sll.getnNodeFromEnd(2).data);
        System.out.println(sll.getnNodeFromEnd2(2).data);


        //remove duplicate from sorted Singly Linked List
        sll.removeDuplicateFromSorted();
        sll.displayNodes();



        //insert a node in a sorted Singly Linked List
//        sll.insertInSorted(11);
//        sll.displayNodes();
//        sll.insertInSorted(20);
//        sll.displayNodes();
//        sll.insertInSorted(0);
//        sll.displayNodes();
        sll.insertInSorted2(11);
        sll.displayNodes();
        sll.insertInSorted2(20);
        sll.displayNodes();
        sll.insertInSorted2(0);
        sll.displayNodes();


        //remove a given key from Singly Linked List
        sll.deleteNode(16);
        sll.displayNodes();
        sll.deleteNode(1);
        sll.displayNodes();
        sll.deleteNode(20);
        sll.displayNodes();
        sll.deleteNode(25);
        sll.displayNodes();

 */

        //loop in a singly linked list
        sll.createLoopedLinkedList();
        //sll.displayNodes();  can't call this method with looped linked list
        System.out.println(sll.hasLoop());
        if (sll.hasLoop()){
            System.out.println(sll.getStartingNodeInLoop().data);
        }
        sll.removeLoop();
        System.out.println(sll.hasLoop());
        if (!sll.hasLoop()){
            sll.displayNodes();
        }
    }
}
