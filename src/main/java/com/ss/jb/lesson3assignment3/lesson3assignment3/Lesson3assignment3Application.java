package com.ss.jb.lesson3assignment3.lesson3assignment3;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Lesson3assignment3Application {

	public static void main(String[] args) {
		System.out.println("Please input the file path.");
		Scanner pathInput = new Scanner(System.in);
		String userPath = pathInput.nextLine();
		System.out.println("Please input the character you'd like to search for.");
		Scanner charInput = new Scanner(System.in);
		char userChar = charInput.next().charAt(0);
		pathInput.close();
		charInput.close();
		long lineCount;
		try {
			lineCount = Files.lines(Paths.get(userPath)).count();
			FileReader f = new FileReader(userPath);
			BufferedReader br = new BufferedReader(f);
			int charCount = 0;
			for (int a = 0; a < lineCount; a++) {
				String line = br.readLine();
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == userChar) {
						charCount++;
					};
				}
			};
			br.close();
			System.out.println("The character " + userChar + " occurs " + charCount + " times in the file.");
		} catch (IOException e){
			e.printStackTrace();
		};
	};

}
