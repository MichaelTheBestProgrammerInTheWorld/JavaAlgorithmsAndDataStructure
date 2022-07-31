package dataStructure;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {

    private ListNode top;
    private int length;

    private class ListNode {

        private int data;
        private ListNode next;

        ListNode(int data){
            this.data = data;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public String reverseString(String str) {
        java.util.Stack<Character> stack = new java.util.Stack();
        char[] chars = str.toCharArray();

        for(char c : chars) {
            stack.push(c);
        }

        for(int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        String str = "ABCDE";
        System.out.println(str);
        System.out.println(stack.reverseString(str));


    }
}
