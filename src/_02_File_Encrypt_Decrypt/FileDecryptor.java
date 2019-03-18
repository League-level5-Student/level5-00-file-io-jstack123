package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader( "src/_02_File_Encrypt_Decrypt/file.txt"));
			String line = br.readLine();
//			while(line != null){
//				System.out.println(line);
//				line = br.readLine();
//			}
			String message = "";
			for (int i = 0; i < line.length(); i++) {
				message  += (char) (line.charAt(i) - 3);
			}
			JOptionPane.showMessageDialog(null, "Original Message: " + line + "\nNew Message: " + message);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
