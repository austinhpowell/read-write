package thing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Meeting extends JFrame {
	static String[] person;
	static int choice=0;
	static JFrame frame = new JFrame("Results");
	Meeting(ArrayList<String[]> people, double accuracy){
		//read in the person
		
		
		
		//make JFrame
		
		frame.setVisible(true);
		frame.setSize(500,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200, 0);
		JPanel panel = new JPanel();
		frame.add(panel);
		
		for(int i=0;i<people.size();i++){
		JLabel label = new JLabel(people.get(i)[0]+": "+people.get(i)[4]);
		panel.add(label);
		}
		//format number
		DecimalFormat formatter = new DecimalFormat("#,###");
		
		//replace array list element
		String paccuracy=formatter.format(accuracy);
		JLabel label = new JLabel("Your accuracy: "+ paccuracy +"\n");
		panel.add(label);
		
		//close JFrame
		  JButton button = new JButton("Close");
		  panel.add(button);
		  button.addActionListener (new Action1());
		  
		  frame.setSize(150,400);
			frame.add(panel);
			frame.setVisible(true);
		
		  
		
		  
					
		}
	

	
	public String[] getresult(){
		return(person);
		  
	}
//kill jframe
	static class Action1 implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
		      		          
		          frame.dispose();		          
		  }
		} 


	

}
