package codingInterviewProblem;

/*
The problem states that - given an integer array nums sorted in
non-decreasing order, remove the duplicates in-place such that
each unique element appears only once. The relative order of the
elements should be kept the same. Then return the number of unique
 elements in nums.
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums){
        int i = 1;
        for (int j=1; j< nums.length; j++){
            if (nums[j-1] != nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
        for (int k : nums){
            System.out.print(k + " ");
            System.out.println();
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5}));
    }
}
