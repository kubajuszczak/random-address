package com.kubajuszczak.randomAddress.Analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppDictionaryReader {
	public static void main(String[] args) throws IOException {

		WordAnalyser wa = new WordAnalyser();

		FileInputStream fis = new FileInputStream(new File("words_alpha.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;

		int i = 0;
		while ((line = br.readLine()) != null) {
			wa.getLetterFrequencies(line);
			i++;
			if (i % 10000 == 0) {
				//To have some measure of progress
				System.out.println(i);
			}
		}
		br.close();
		System.out.println(wa.getFinalCounts());
	}
}
