package com.prog.fun.solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {

		 System.out.println(lengthOfLongestSubstring(""));
		 System.out.println(lengthOfLongestSubstring("abcabcbb"));
		 System.out.println(lengthOfLongestSubstring("abbcadbcbb"));
		 System.out.println(lengthOfLongestSubstring("bb"));
		 System.out.println(lengthOfLongestSubstring("b"));
		 System.out.println(lengthOfLongestSubstring("aab"));
		 System.out.println(lengthOfLongestSubstring("dvdf"));
		 System.out.println(lengthOfLongestSubstring("abcaaaabcdeaaa"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if( s == null || s.length() == 0 ){
			return 0;
		}
		Map<Character, Integer> seen = new HashMap<>();
		// Max String start index
		int mStartIdx = 0;
		// Max String end index
		int mEndIdx = 0;
		// Longest length
		int longestLen = 0;
		// Current length
		int currLen = 0;
		// Current start
		int currStart = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (seen.containsKey(ch)) {
				int newStart = seen.get(ch) + 1;
				// We should not go before currStart
				if(newStart > currStart)
				  currStart = seen.get(ch) + 1;
			}
			seen.put(ch, i);
			currLen = i - currStart + 1;
			if (longestLen < currLen) {
				mStartIdx = currStart;
				mEndIdx = i;
				longestLen = currLen;
				System.out.println(s.substring(0, mStartIdx)+"["+s.substring(mStartIdx, mEndIdx+1)+"]"+s.substring(mEndIdx + 1));
			}
		}
		//System.out.println(s + "-->" + mStartIdx+","+mEndIdx  + "-->" + longestLen);
		System.out.println(s.substring(0, mStartIdx)+"["+s.substring(mStartIdx, mEndIdx+1)+"]"+s.substring(mEndIdx + 1) + "-->" + longestLen);
		return longestLen;
	}

}
