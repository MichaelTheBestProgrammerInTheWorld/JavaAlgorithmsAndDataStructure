package dataStructure;

public class StringUtil {

    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while (start < end){
            if (charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        StringUtil stringUtil = new StringUtil();
        String word = "madam";
        String word2 = "that";
        System.out.println("Is the word " + word + " palindrome? " + stringUtil.isPalindrome(word));
        System.out.println("Is the word " + word2 + " palindrome? " + stringUtil.isPalindrome(word2));
    }
}
