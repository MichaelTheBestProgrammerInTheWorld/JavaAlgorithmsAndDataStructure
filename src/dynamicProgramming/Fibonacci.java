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

    //calculate direct fibonacci number using dynamic programming
    public int fibDP(int index){

        int[] table = new int[index+1];  //0 -> n
        table[0] = 0;
        table[1] = 1;
        for (int i=2; i<=index; i++){
            table[i] = table[i-1] + table[i-2];
        }
        return table[index];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("The 6th fibonacci number is = " + fibonacci.fibDP(6));
    }
}
