package dynamicProgramming;

public class Fibonacci {

    //calculate direct fibonacci number using recursion
    public int fibRecursion(int index){

        if (index == 0){
            return 0;
        }
        if (index == 1){
            return 1;
        }
        int left = fibRecursion(index-1);
        int right = fibRecursion(index-2);
        return left + right;
    }

    //calculate direct fibonacci number using dynamic programming up-bottom approach
    public int fibDP(int index){

        int[] table = new int[index+1];  //0 -> n
        table[0] = 0;
        table[1] = 1;
        for (int i=2; i<=index; i++){
            table[i] = table[i-1] + table[i-2];
        }
        return table[index];
    }

    //calculate direct fibonacci number using dynamic programming top-down approach
    public int fibDP(int[] memo, int index){  //array size should be index + 1

        if (index < 0){
            throw new  IllegalArgumentException("Invalid input");
        }

        if (memo[index] == 0){
            if (index < 2){
                memo[index] = index;
            } else {
                int left = fibDP(memo, index-1);
                int right = fibDP(memo, index-2);
                memo[index] = left + right;
            }
        }
        return memo[index];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("The 6th fibonacci number is = " + fibonacci.fibDP(6));
        System.out.println("The 6th fibonacci number is = " + fibonacci.fibDP(new int[6+1],6));
    }
}
