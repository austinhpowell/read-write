package finalsrc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Action {
	static int act=0;
	Action(){
		
		
	}
	static class Yell implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
		      	//system check          
		         // System.out.println("Yell");	
		          
		          //remove all keylisteners
		          Interface.yell.removeActionListener(Interface.yell2);
		          Interface.attack.removeActionListener(Interface.attack2);
		          Interface.run.removeActionListener(Interface.run2);
		          
		          
		          //write what you did
		          Interface.write.setText("You yelled at it.");
		          
		        //store what you did
		          act=3;
		          
		          //go to a post-action method
		          Main.acted(act);
		          
		          
		  }
		} 
	static class Run implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
		      		//Check          
		          //System.out.println("Run");	
		          
		          //remove all keylisteners
		          Interface.yell.removeActionListener(Interface.yell2);
		          Interface.attack.removeActionListener(Interface.attack2);
		          Interface.run.removeActionListener(Interface.run2);
		          
		          
		          //write what you did
		          Interface.write.setText("You attempt to run.");
		          
		          //store what you did
		          act=2;
		          
		          //go to a post-action method
		          Main.acted(act);
		  }
		} 
	static class Attack implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
		      		   //Check       
		          //System.out.println("Attack");
		          //remove all keylisteners
		          Interface.yell.removeActionListener(Interface.yell2);
		          Interface.attack.removeActionListener(Interface.attack2);
		          Interface.run.removeActionListener(Interface.run2);
		          
		          
		          //write what you did
		          Interface.write.setText("You attacked it.");
		          
		        //store what you did
		          act=1;
		          
		          //go to a post-action method
		          Main.acted(act);
		  }
		} 
	static class Defend implements ActionListener {        
		  public void actionPerformed (ActionEvent e) {     
		      		          
		          System.out.println("Defend");		          
		  }
		} 

}
