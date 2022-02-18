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
        System.out.print("null");
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

    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        //creating list nodes
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        //linking list nodes together
        sll.head.next = second;   //10 --> 1 --> null
        second.next = third;      //10 --> 1 --> 8 --> null
        third.next = fourth;   //10 --> 1 --> 8 --> 11 --> null

        //printing list nodes data on the screen
        sll.displayNodes();

        //display list length
        System.out.println("\n Length is = " + sll.length());
    }
}
