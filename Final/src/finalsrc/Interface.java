package finalsrc;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Interface {
	//make Jframe
	static JFrame frame = new JFrame("Battle");
	
	//JPanel main layout
	static JPanel layout=new JPanel(new GridLayout(0,1));
	
	//Jpanel for buttons
	static JPanel buttons=new JPanel(new GridLayout(0,2));
	//buttons
	static JButton attack=new JButton("Attack");
	static JButton defend=new JButton("Defend");
	static JButton run=new JButton("Run");
	static JButton yell=new JButton("Yell at it");
	
	//Jpanel text
	static JPanel text=new JPanel();	
	//text for Jpanel
	static JLabel write = new JLabel("");	
	
	
	
	//instance of listeners
	static Action.Yell yell2=new Action.Yell();
	static Action.Attack attack2=new Action.Attack();
	static Action.Defend defend2=new Action.Defend();
	static Action.Run run2=new Action.Run();
	
	
	//monsterhealth
	static int monsterhealth;
	static int monsterattack;
	static int monsterdefend;
	static String monstername;
	
	//picture
			
			
	
	
	Interface(String[] monster){
		//setup monster
		//picture	
		ImageIcon enemy = new ImageIcon(monster[1]);	
		JLabel enemypic=new JLabel(enemy);
		//name
		monstername=monster[0];
		write.setText("You encounter a "+monstername+".");
		
		//setup health
		monsterhealth=Integer.parseInt(monster[2]);
		//setup variance in damage
		monsterattack=Integer.parseInt(monster[3]);
		//setup variance in attack
		monsterdefend=Integer.parseInt(monster[4]);
	
		
		//add text to text label
		write.setFont (write.getFont ().deriveFont (20.0f));
		text.add(write);
		
		//Add action listeners to all the buttons but not in the dupe frame
		yell.addActionListener (yell2);
		run.addActionListener (run2);
		attack.addActionListener (attack2);
		defend.addActionListener (defend2);
		
		//add buttons to the buttons panel
		buttons.add(attack);
		//buttons.add(defend);
		buttons.add(run);
		buttons.add(yell);
		
		//add 3 fields to the overall JPanel
		layout.add(enemypic);
		layout.add(text);
		layout.add(buttons);
		
		//make us a frame
		frame.setVisible(true);
		frame.setSize(500,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		
		//add panel to frame
		frame.add(layout);
		frame.setVisible(true);
		

		}
	

	

}
