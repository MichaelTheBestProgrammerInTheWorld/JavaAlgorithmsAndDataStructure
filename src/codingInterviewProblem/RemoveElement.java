package codingInterviewProblem;

public class RemoveElement {

    public static int remove(int[] nums, int val){
        int i=0;
        for (int j=0; j< nums.length; j++){
            if (nums[j] != val){
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
        System.out.println(remove(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
