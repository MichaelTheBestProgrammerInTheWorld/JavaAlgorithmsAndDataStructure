package codingInterviewProblem;

import sort.BubbleSort;

import java.util.HashSet;
import java.util.Set;

/*
Contains Duplicate. The problem states that - given an integer
array nums, return true if any value appears at least twice in
the array, and return false if every element is distinct.
if all array elements are unique -> return false
if there's one or more element duplicated -> return true
 */
public class ContainsDuplicate {

    //best approach time complexity O(n) space complexity O(n)
    public static boolean containsDuplicate(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++){
            if (set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    //second approach time complexity O(n log n)
    public static boolean containsDuplicate2(int[] arr){
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        for (int i=1; i< arr.length; i++){
            if (arr[i] == arr[i-1]){
                return true;
            }
        }
        return false;
    }

    //third approach time complexity O(n2)
    public static boolean containsDuplicate3(int[] arr){
        for (int i=0; i< arr.length; i++){
            for (int j=i+1; j< arr.length; j++){
                if (arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Best Approach");
        System.out.println(containsDuplicate(new int[]{7, 3, 1, 5, 1}));
        System.out.println(containsDuplicate(new int[]{7, 3, 1, 5, 6}));

        System.out.println("Second Approach");
        System.out.println(containsDuplicate2(new int[]{7, 3, 1, 5, 1}));
        System.out.println(containsDuplicate2(new int[]{7, 3, 1, 5, 6}));

        System.out.println("Third Approach");
        System.out.println(containsDuplicate3(new int[]{7, 3, 1, 5, 1}));
        System.out.println(containsDuplicate3(new int[]{7, 3, 1, 5, 6}));
    }
}
