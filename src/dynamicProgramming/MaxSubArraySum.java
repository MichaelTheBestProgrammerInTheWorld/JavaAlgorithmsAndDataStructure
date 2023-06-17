package dynamicProgramming;

public class MaxSubArraySum {

    public int maxSubArraySum(int[] arr){
        int currentMax = arr[0];
        int maxSoFar = arr[0];
        for (int i=1; i<arr.length; i++){
            currentMax += arr[i];      // Q1 - element becomes part of current subarray
            if (currentMax < arr[i]){
                currentMax = arr[i];   // Q2 - element decides to start its own subarray
            }
            if (maxSoFar < currentMax){
                maxSoFar = currentMax;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSubArraySum msas = new MaxSubArraySum();
        System.out.println(msas.maxSubArraySum(new int[]{4, 3, -2, 6, -12, 7, -1, 6}));
    }
}
