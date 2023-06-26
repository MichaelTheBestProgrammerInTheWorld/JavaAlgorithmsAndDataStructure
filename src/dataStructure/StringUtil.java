package dataStructure;

import java.util.*;

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

    public boolean isSubseq(String str, String seq){
        int i=0;    //traverse str
        int j=0;    //traverse seq
        while (i<str.length() && j<seq.length()){
            if (str.charAt(i) == seq.charAt(j)){
                j++;
            }
            i++;
        }
        return j == seq.length();
    }

    public int firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        char[] chars = str.toCharArray(); // aba
        for (char ch : chars) {
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (characterFrequencyMap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }

    public String removeVowel(String str){
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')); //Set.of('a', 'e', 'i', 'o', 'u')  this will compile from java 9
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char c : arr){
            if (!vowel.contains(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        StringUtil stringUtil = new StringUtil();
        String word = "madam";
        String word2 = "that";
        System.out.println("Is the word " + word + " palindrome? " + stringUtil.isPalindrome(word));
        System.out.println("Is the word " + word2 + " palindrome? " + stringUtil.isPalindrome(word2));

        System.out.println("Is subsequence of string");
        System.out.println("abcde " + " ace " +stringUtil.isSubseq("abcde", "ace"));
        System.out.println("abcde " + " aec " +stringUtil.isSubseq("abcde", "aec"));

        System.out.println("First non repeated character");
        System.out.println(stringUtil.firstNonRepeatingCharacter("codeforcode"));

        System.out.println("Remove vowels");
        System.out.println(stringUtil.removeVowel("what is your name?"));
    }
}
