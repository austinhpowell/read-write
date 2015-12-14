package finalsrc;

import java.util.ArrayList;
import java.util.Random;

public class Level {
	static ArrayList<String[]> monsters= new ArrayList<String[]>();
	String[] zombie={"Zombie", "res/zombie.jpg", "100", "1", "0"};
	String[] hovercat={"Hover Cat", "res/hovercat.jpg", "150", "4", "0"};
	String[] minotaur={"Minotaur", "res/minotaur.png", "300", "2", "3"};
	String[] buisness={"Business Man", "res/businessman.png", "100", "2", "0"};
	String[] alien={"Alien", "res/alien.png", "500", "5", "0"};
	String[] test={"Failed Test", "res/test.jpg", "100", "10", "0"};
	String[] shadow={"Shadow", "res/shadow.jpg", "1", "1", "20"};
	static String[] monster;
	Level(int level, int special){
		//add all monsters to arraylist
		monsters.add(zombie);
		monsters.add(hovercat);
		monsters.add(minotaur);
		monsters.add(buisness);
		monsters.add(alien);
		monsters.add(test);
		monsters.add(shadow);
		//make random
		Random rand=new Random();
		//pick monster var
		int pickmonster=rand.nextInt(monsters.size());
		//set attack difficulty
		int diff1=rand.nextInt(level);
		diff1=diff1/2;
		//set defense difficulty
		int diff2=rand.nextInt(level);
		diff2=diff2/2;
		//pick monster
		monster=monsters.get(pickmonster);
		//make monster harder
		int attack=Integer.parseInt(monster[3]);
		int defend=Integer.parseInt(monster[4]);
		
		attack=attack+diff1;
		defend=defend+diff2;
		
		monster[3]=Integer.toString(attack);
		monster[4]=Integer.toString(defend);
		//make monster special if necessary
		if(special==1){
		monster[0]="Super "+monster[0];
		}
		if(special==0){			
		send();
		}
		
	}
	static void send(){
		new Interface(monster);
	}
}
