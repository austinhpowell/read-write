package thing;

import java.util.Random;

public class Alien {
	String[] alien;
 Alien(String[] in){
	 Random rand=new Random();
	 Human fakehuman=new Human(in[0]);
	 
	 int change=rand.nextInt(99);
	 if(change>24){
		 in[1]=fakehuman.geteyes();
		 in[2]=fakehuman.getpersona();
		 
	 }
	 alien=new String[in.length];
		
	 //set attributes to new attributes
	 alien[0]=in[0];
	 alien[1]=in[1];
	 alien[2]=in[2];
	 
	 
	 //make alien not crazy
	 alien[3]="0";
	 
	 //label as alien
	 alien[4]="alien";
	 
	 //other qualities
	 alien[5]="not turning";
	 alien[6]="alive";
 }
 public String[] getalien(){
	 return(alien);
	 
 }
}
