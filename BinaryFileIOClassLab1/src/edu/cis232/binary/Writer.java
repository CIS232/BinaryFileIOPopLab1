package edu.cis232.binary;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Writer {

	public static void main(String[] args) throws IOException {
		DataOutputStream output = null;
		try {
			FileOutputStream fos = new FileOutputStream("file.dat");
			output = new DataOutputStream(fos);

			int[] numbers = getIntegersFromUser(5);
			for(int i = 0; i < numbers.length; i++){
				output.writeInt(numbers[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}

	private static int[] getIntegersFromUser(int numIntegers) {
		int[] numbers = new int[numIntegers];
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Enter %d integers, 1 at a time%n", numIntegers);
		for (int i = 0; i < numIntegers; i++) {
			System.out.printf("integer #%d:", i + 1);
			try {
				numbers[i] = keyboard.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid integer, try again.");
				i--;
			} finally{
				keyboard.nextLine();
			}
		}

		return numbers;
	}

}
