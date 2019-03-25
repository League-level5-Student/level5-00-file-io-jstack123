package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Task");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");
	ArrayList<String> list = new ArrayList<String>();
	public ToDoList() {
		
		
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.setVisible(true);
		frame.pack();
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}
	
	public static void main(String[] args) {
		ToDoList todo = new ToDoList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	
		if (e.getSource().equals(add)) {
			String task = JOptionPane.showInputDialog("Enter a task in the space below.");
			list.add(task);
			
		}
		if (e.getSource().equals(view)) {
			String s = "";
			for (int i = 0; i < list.size(); i++) {
				s += "\n" + list.get(i);
			}
			JOptionPane.showMessageDialog(null, "List of tasks:"+ s);
		}
		if (e.getSource().equals(remove)) {
			String s = "";
	
		for (int i = 0; i < list.size(); i++) {
			s += "\n" + i + ": " + list.get(i);
		}
		String input = 	JOptionPane.showInputDialog("Which task do you want to remove? Enter the corresponding index." + "\n" + s);
		int index = Integer.parseInt(input);
		list.remove(index);
		}
		if (e.getSource().equals(save)) {
			String s = "";
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/Tasks.txt");
				for (int i = 0; i < list.size(); i++) {
					s +=  list.get(i)  + "\n";
				}
			
				fw.write(s);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(load)) {
			list.clear();
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String line = br.readLine();
					while(line != null){
						System.out.println(line);
			
						list.add(line);
						line = br.readLine();
						
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println(fileName);
			}
		}
//		if(e.getSource().equals(remove)) {
//			JOptionPane.showInputDialog("Which tasks do you want to remove")
//			list.remove(list.indexOf())
//		}
		
	}
}
