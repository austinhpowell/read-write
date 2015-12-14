package finalsrc;

import java.util.ArrayList;
import java.util.Random;

public class Unique extends Level {
	static ArrayList<String[]> special= new ArrayList<String[]>();
	static String[] slender={"Slender Man", "res/slender.jpg", "500", "5", "8"};
	static String[] gumby={"Gumby", "res/gumby.jpg", "1000", "5", "15"};
	static String[] c={"Cthulhu", "res/c.png", "10000", "25", "15"};
	static String[] telle={"Teletubbies", "res/telle.jpg", "4000", "16", "8"};
	static String[] ufo={"UFO", "res/ufo.jpg", "6000", "10", "20"};
	Unique(int level) {
		super(level+20,1);
		//add special monsters
		special.add(slender);
		special.add(gumby);
		special.add(telle);
		special.add(c);
		special.add(ufo);
		
		Random rand=new Random();
		int choose=rand.nextInt(100)+1;
		if(choose<=50){
			int pickmonster=rand.nextInt(special.size());
			super.monster=special.get(pickmonster);
			
			//up difficulty of specials
			//set attack difficulty
			int diff1=rand.nextInt(level);
			diff1=diff1/2;
			//set defense difficulty
			int diff2=rand.nextInt(level);
			diff2=diff2/2;
			//make monster harder
			int attack=Integer.parseInt(super.monster[3]);
			int defend=Integer.parseInt(super.monster[4]);
			
			attack=attack+diff1;
			defend=defend+diff2;
			
			super.monster[3]=Integer.toString(attack);
			super.monster[4]=Integer.toString(defend);
			
		}
		super.send();
		
	}
	

}
