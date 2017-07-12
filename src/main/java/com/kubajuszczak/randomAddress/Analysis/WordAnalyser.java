package com.kubajuszczak.randomAddress.Analysis;

import java.util.Arrays;

public class WordAnalyser {

	private int[][] freq = new int[26][26];

	public void getLetterFrequencies(String word) {
		if (word.length() < 2) {
			// no letter pairs to analyse
			return;
		}

		for (int i = 0; i < word.length() - 1; i++) {
			int letterFrom = word.substring(i, i + 1).charAt(0) - 97;
			int letterTo = word.substring(i + 1, i + 2).charAt(0) - 97;
			
			// handling for non-lowercase ascii
			if (letterFrom < 0 || letterTo < 0) {
				System.err.println(word);
				return;
			}
			freq[letterFrom][letterTo]++;
		}
	}

	public String getFinalCounts() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			//letter mapping for 0 => A, 1 => B etc.
			String currentLetter = String.valueOf((char) (i + 65));
			sb.append(currentLetter + ": ");
			
			String frequencies = Arrays.toString(freq[i]);
			sb.append(frequencies);

			sb.append("\n");
		}
		return sb.toString();
	}

}
