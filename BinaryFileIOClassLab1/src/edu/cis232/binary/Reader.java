package edu.cis232.binary;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader {

	public static void main(String[] args) throws IOException {
		DataInputStream input = null;
		try{
			FileInputStream fis = new FileInputStream("file.dat");
			input = new DataInputStream(fis);
			
			try {
				while(true){
					System.out.println(input.readInt());
				}
			} catch (EOFException e) {
				System.out.println("all out of data!");
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			if (input != null){
				input.close();
			}
		}

	}

}
