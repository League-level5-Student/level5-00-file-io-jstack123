package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Type a message in the space below.");
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			String result = "";
			for (int i = 0; i < message.length(); i++) {
				result += (char) (message.charAt(i) + 3);
			}
			fw.write(result);

			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
