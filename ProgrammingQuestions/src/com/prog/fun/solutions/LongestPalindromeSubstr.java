package com.prog.fun.solutions;

import java.util.Stack;

public class LongestPalindromeSubstr {

	public static void main(String[] args) {

		testLongestPalindrome("", "");
		testLongestPalindrome("abcbd", "bcb");
		testLongestPalindrome("abaa", "aba");
		testLongestPalindrome("aaba", "aba");
		testLongestPalindrome("abaabaab", "baabaab");
		testPalindrome("a", true);
		testPalindrome("aa", true);
		testPalindrome("aabbb", false);
		testPalindrome("bcb", true);
		testPalindrome("1234321", true);
		testPalindrome("aab", false);

	}

	public static void testLongestPalindrome(String s, String exp) {
		LongestPalindromeSubstr lps = new LongestPalindromeSubstr();
		String actual = lps.longestPalindrome(s);
		if (exp.equals(actual)) {
			System.out.println(s + " -->" + exp + "-->" + actual);
		} else {
			System.err.println(s + " -->" + exp + "-->" + actual);
		}
	}

	public static void testPalindrome(String s, boolean exp) {
		LongestPalindromeSubstr lps = new LongestPalindromeSubstr();
		if (lps.isPalindrome(s) == exp) {
			System.out.println(s + " Passed");
		} else {
			System.err.println(s + " Failed");
		}
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int start = 0;
		int end = 0;
		int longestPalindromeLength = 0;

		for (int i = 0; i < s.length(); i++) {
			// Try until currentStr is lesser than longestPalindromeLength
			for (int currentStart = 0; (i - currentStart + 1) > longestPalindromeLength; currentStart++) {
				// Java does End index - 1
				String currentStr = s.substring(currentStart, (i + 1));
				if (isPalindrome(currentStr) && longestPalindromeLength < currentStr.length()) {
					longestPalindromeLength = currentStr.length();
					start = currentStart;
					end = i;
				}
			}
		}

		return s.substring(start, end + 1);
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		int midElementIdx = (s.length() / 2) - 1;
		boolean isOddLength = s.length() % 2 == 1;
		midElementIdx += 1;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char value = s.charAt(i);
			Character currTop = null;

			if (!stack.isEmpty())
				currTop = stack.peek();

			if (i < midElementIdx) {
				// Push
				stack.push(value);
			} else if (isOddLength && i == midElementIdx) {
				// Skip
			} else if (currTop != null && value == currTop) {
				// Pop
				stack.pop();
			} else {
				return false;
			}
		}

		return true;
	}
}
