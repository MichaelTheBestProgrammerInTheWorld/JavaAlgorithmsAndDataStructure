package codingInterviewProblem;

import array.ArrayUtil;

/*
Given an array of integers arr[], return an array result[] such
that result[i] is equal to the product of all the elements of arr
except arr[i]. The product fits in 32-bit integer. The algorithm
should run in O(n) time and without using division operator.
Example –
     Input: arr = {1, 2, 3, 4}
     Output: result = {24, 12, 8, 6}
     Input: arr = {-1, 1, 0, -3, 3}
     Output: result = {0, 0, 9, 0, 0}

 */
public class ProductOfArrayExceptSelf {

    //instructor's solution time complexity O(n)
    public static int[] findProduct(int[] arr){
        int temp = 1;
        int[] result = new int[arr.length];
        for (int i=0; i< arr.length; i++){
            result[i] = temp;
            temp *= arr[i];
        }
        temp = 1;
        for (int i=arr.length-1; i>=0; i--){
            result[i] *= temp;
            temp *= arr[i];
        }
        return result;
    }

    //My solution time complexity O(n2)
    public static int[] findProduct2(int[] arr){
        int[] result = new int[arr.length];
        for (int i=0; i< arr.length; i++){
            int product = 1;
            for (int j=0; j< arr.length; j++){
                if (j != i){
                    product *= arr[j];
                    result[i] = product;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.printArray(findProduct(new int[]{1, 2, 3, 4}));
        arrayUtil.printArray(findProduct2(new int[]{1, 2, 3, 4}));
    }
}
