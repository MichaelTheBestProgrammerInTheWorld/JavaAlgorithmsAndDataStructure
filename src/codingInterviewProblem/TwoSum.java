package codingInterviewProblem;

import array.ArrayUtil;
import sort.BubbleSort;

import java.util.HashMap;
import java.util.Map;

/*
In this problem you'll be given an int target and arr of int, you
should return the 2 indices of two numbers that their sum equals
to the target

 */
public class TwoSum {

    //instructor's answer
    public static int[] twoSum(int[] numbers, int target){
        int[] result = new int[2];
        Map map = new HashMap();
        for (int i=0; i< numbers.length; i++){
            if (!map.containsKey(target - numbers[i])){
                map.put(numbers[i], i);
            } else {
                result[1] = i;
                result[0] = (int) map.get(target - numbers[i]);
                return result;
            }
        }
        return result;
    }

    //My answer
    public static int[] twoSum2(int[] numbers, int target){
        int[] result = new int[2];
        for (int i=0; i< numbers.length; i++){
            for (int j=i+1; j< numbers.length; j++){
                if (numbers[i] + numbers[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    //instructor's second answer
    //this method returns the actual numbers not indices
    public static int[] twoSum3(int[] numbers, int target){
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
        int left = 0;
        int right = numbers.length-1;
        int[] result = new int[2];
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                result[0] = numbers[left];
                result[1] = numbers[right];
                return result;
            } else if (sum > target){
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        System.out.println("instructor's answer");
        arrayUtil.printArray(twoSum(new int[]{2, 11, 5, 10, 7, 8}, 9));
        System.out.println("My answer");
        arrayUtil.printArray(twoSum2(new int[]{2, 11, 5, 10, 7, 8}, 9));
        System.out.println("instructor's second answer");
        arrayUtil.printArray(twoSum3(new int[]{2, 11, 5, 10, 7, 8}, 9));
    }
}
