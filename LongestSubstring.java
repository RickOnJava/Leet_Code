// Longest Substring Without Repeating Characters in JAVA

import java.util.Scanner;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] charIndex = new int[128]; // Assuming ASCII characters

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            left = Math.max(left, charIndex[c]);   // Use to prevent the repeatation  
            maxLength = Math.max(maxLength, right - left + 1);
            charIndex[c] = right + 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String input =sc.next();

        sc.close();

        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring: " + result);
    }
}