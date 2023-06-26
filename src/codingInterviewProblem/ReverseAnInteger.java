package codingInterviewProblem;

public class ReverseAnInteger {

    //instructor's answer
    public long reverse(int number){
        boolean isNegative = number < 0;
        if (isNegative){
            number *= -1;
        }
        long reverse = 0;
        int lastDigit;
        while (number > 0){
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number /= 10;
        }
        return isNegative ? reverse*-1 : reverse;
    }

    //My answer
    public long reverse2(int number){
        String numStr = String.valueOf(number);
        char[] charArr = numStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i= charArr.length-1; i>=0; i--){
            sb.append(charArr[i]);
        }
        return Long.parseLong(sb.toString());
    }

    //not working
    public long reverse3(int number){
        return Integer.reverse(number);
    }

    public static void main(String[] args) {
        ReverseAnInteger rInteger = new ReverseAnInteger();
        System.out.println(rInteger.reverse(12345));
        System.out.println(rInteger.reverse2(12345));
        System.out.println(rInteger.reverse3(12345));
    }
}
