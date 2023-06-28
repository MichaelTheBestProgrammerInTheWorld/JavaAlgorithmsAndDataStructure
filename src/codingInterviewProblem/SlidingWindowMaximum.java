package codingInterviewProblem;

import array.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
In this problem we are given an array of integers nums, there is a
sliding window of size k which is moving from the very left of the
array to the very right. You can only see the k numbers in the
window. Each time the sliding window moves right by one position.
Return the max sliding window.
 */
public class SlidingWindowMaximum {

    //My solution
    public static List<Integer> maxSlidingWindow(int[] arr, int k){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< arr.length; i++){
            int max = 0;
            int window = i;
            int index = 0;
            while (i+index < arr.length && index < k){
                if (arr[window] > max){
                    max = arr[window];
                }
                window++;
                index++;
            }
            if (index == k){
                result.add(max);
            }
        }
        return result;
    }

    //My solution
    public static List<Integer> maxSlidingWindow2(int[] arr, int k){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< arr.length; i++){
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<k; j++){
                if (i+j < arr.length){
                    temp.add(arr[i+j]);
                }
            }
            if (temp.size() == k){
                result.add(Collections.max(temp));
            }
        }
        return result;
    }

    //instructor's solution
    public static List<Integer> maxSlidingWindow3(int[] arr, int k){
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] ngeArr = arrayUtil.nextGreaterElement(arr);
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<= arr.length-k; i++){
            int j=i;
            while (ngeArr[j] < i+k){
                j = ngeArr[j];
            }
            result.add(arr[j]);
        }

        return result;
    }


    /*
    //My solution for returning max sum of all items in window
    Maximum Sum Subarray of Size K problem - Given an array of integers arr, there is a
    sliding window of size k which is moving from the very left of the array to the very
    right. Find the maximum sum of any contiguous subarray of size k.
Example –
     Input: arr = {2, 7, 3, 5, 8, 1} , k = 3
     Output: arr = 16
     */
    public static int maxSlidingWindowSum(int[] arr, int k){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< arr.length; i++){
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<k; j++){
                if (i+j < arr.length){
                    temp.add(arr[i+j]);
                }
            }
            if (temp.size() == k){
                int sum = 0;
                for (int l : temp){
                    sum += l;
                }
                result.add(sum);
            }
        }
        return Collections.max(result);
    }

    //instructor's solution
    public static int maxSlidingWindowSum2(int[] arr, int k){
        int maxSum = 0;
        int windowSum = 0;
        int start = 0;
        for (int end=0; end<arr.length; end++){
            windowSum += arr[end];
            if (end >= k-1){
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{44, 77, 33, 44, 88, 11}, 3));
        System.out.println(maxSlidingWindow2(new int[]{44, 77, 33, 44, 88, 11}, 3));
        System.out.println(maxSlidingWindow3(new int[]{44, 77, 33, 44, 88, 11}, 3));
        System.out.println("Maximum Sum Subarray of Size K");
        System.out.println(maxSlidingWindowSum(new int[]{2, 7, 3, 5, 8, 1}, 3));
        System.out.println(maxSlidingWindowSum2(new int[]{2, 7, 3, 5, 8, 1}, 3));
    }
}
