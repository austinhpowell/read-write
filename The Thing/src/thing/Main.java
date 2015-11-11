package thing;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;


public class Main {
static int humansize=0;
static String[] names={"Joe","Max","Stephanie","Austin","Megan","Delanie","Carl","Felicia","Isabelle","Tom","Teddy","James","Carlos","Levi", "Jay", "Bob","Yuri"};
static String[] action={"working","sitting", "pacing", "biding time", "staring off into space"};
//make list to store humans
static ArrayList<String[]> people=new ArrayList<String[]>();

//rooms
static ArrayList<Integer> lab=new ArrayList<Integer>();
static ArrayList<Integer> storeroom=new ArrayList<Integer>();
static ArrayList<Integer> outside=new ArrayList<Integer>();
static ArrayList<Integer> recroom=new ArrayList<Integer>();

//room visits
static int labvisit=0;
static int storeroomvisit=0;
static int outsidevisit=0;
static int recroomvisit=0;

	public static void main(String[] args) {
	
		
		//make random
		Random rand=new Random();
		
		//make humans
		for(int i=0;i<8;i++){
		//String name = JOptionPane.showInputDialog("What is his/her name?");
			
		//random names	
		String name=names[rand.nextInt(names.length)];
		
		//make a person, add to people
		Human person=new Human(name);
		String[] Joe ={person.getname(),person.geteyes(),person.getpersona(),person.getcrazy(),"human","not turning","alive"};
		humansize=Joe.length;
		people.add(Joe);		
		}
		
		//print all humans
		//for(int b=0; b<people.size();b++){ 
		//	for (int t=0; t< humansize; t++){
		//		System.out.println(people.get(b)[t]);
		
		//	}
		//}
		
		//make one random person an alien
		int takeover = rand.nextInt(people.size());
		Alien alien=new Alien(people.get(takeover));
		people.set(takeover,alien.getalien());
		
				
		//Print new people including alien
		for(int b=0; b<people.size();b++){ 
			for (int t=0; t< humansize; t++){
				System.out.println(people.get(b)[t]);
		
			}
		}
		
		//move people to rooms
		movepeople();
		//clear lab
		//lab.removeAll(lab);
		//System.out.println(lab);
		
		
	}
	
	static private void newturn(){
		//clear all variables
		lab.removeAll(lab);
		storeroom.removeAll(storeroom);
		outside.removeAll(outside);
		recroom.removeAll(recroom);
		labvisit=0;
		storeroomvisit=0;
		outsidevisit=0;
		recroomvisit=0;
		
		movepeople();
		
		
	}
	
	//move people with a method
	static private void movepeople(){
		Random moverand=new Random();
		int room;
		//cycle through all people
		for(int i=0;i<people.size();i++){
			//move humans first
			if(people.get(i)[4].equals("human")){
				
				//choose a  random room
				room=moverand.nextInt(4);
				
				switch(room){
					case 0:{ lab.add(i);
					break;}
					case 1:{ storeroom.add(i);
					break;}					
					case 2:{ outside.add(i);
					break;}					
					case 3:{ recroom.add(i);
					break;}
					
				}
				
				
			}
			
		}
		//cycle through all people again
		for(int i=0;i<people.size();i++){
			if(people.get(i)[4].equals("alien")){
				
				if(storeroom.size()==1 || storeroom.size()==1 || outside.size()==1 || recroom.size()==1){
					//var for all rooms that alien could choose
					int[] alienchoose={0,0,0,0};
					int choicemade=0;
					//look for rooms with just one person in it first, specifically human
					if(lab.size()==1 && people.get(lab.get(0))[4].equals("human")){
						alienchoose[0]=1;
					}
					if(storeroom.size()==1 && people.get(storeroom.get(0))[4].equals("human")){
						alienchoose[1]=1;
					}
					if(outside.size()==1 && people.get(outside.get(0))[4].equals("human")){
						alienchoose[2]=1;
					}
					if(recroom.size()==1 && people.get(recroom.get(0))[4].equals("human")){
						alienchoose[3]=1;
					}
					do{
						room=moverand.nextInt(4);
						if(alienchoose[room]==1){
							switch(room){
								case 0:{ lab.add(i);
								break;}
								case 1:{ storeroom.add(i);
								break;}					
								case 2:{ outside.add(i);
								break;}					
								case 3:{ recroom.add(i);
								break;}
							
							}
							choicemade=1;
						}
						
					}while(choicemade==0);
					
				}
				
				
				// if no rooms have only one person, move to a random room
				if(storeroom.size()!=1 && storeroom.size()!=1 && outside.size()!=1 && recroom.size()!=1){
					room=moverand.nextInt(4);
					
					switch(room){
						case 0:{ lab.add(i);
						break;}						
						case 1:{ storeroom.add(i);
						break;}
						case 2: {outside.add(i);
						break;}
						case 3: {recroom.add(i);
						break;}
						
					}
					
				}
				
				
			}
			
		}
		
		//print out all the rooms to make sure this works
		System.out.println(lab);
		System.out.println(storeroom);
		System.out.println(outside);
		System.out.println(recroom);
		
		//go to your move
		yourmove();
		
	}
	static private void yourmove(){
		 String[] options = new String[] {"Lab", "Storeroom", "Outside", "Recreational Room"};
		    int response = JOptionPane.showOptionDialog(null, "Where do you want to investigate?", "Your Move",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);

		    // Where response == 0 for Yes, 1 for No, 2 for Maybe and -1 or 3 for Escape/Cancel.
		    if(response==0){
		    	lab();
		    }
		    if(response==1){
		    	storeroom();
		    }
		    if(response==2){
		    	outside();
		    }
		    if(response==3){
		    	recroom();
		    }
	}
	static private void lab(){
		// you arrive
		JOptionPane.showMessageDialog(null,"You went to the Lab.");
		//method vars
		int attack=0;
		String object="lab chair";
		int counter=0;
		
		//count the number of humans in the room
		for(int i=0;i<lab.size();i++){
			if(people.get(lab.get(i))[4].equals("human")){
				counter=counter+1;
			}
		}
		System.out.println("There are "+counter+" humans in here.");
		//if there is one person and its an alien, they attack and you run
		if(lab.size()==1){
			if(people.get(lab.get(0))[4].equals("alien")){
				JOptionPane.showMessageDialog(null,"You enter to find " + people.get(lab.get(0))[0]+" standing ominously.\n"+
						people.get(lab.get(0))[0]+" turns around, its face splitting into rows \n of razor sharp teeth. You slam the door and run.");
				attack=1;
				
			}
		}
		//if there are two people and one is an alien, you walk in on the alien turning the person
		if(lab.size()>1 && counter==1){
			if(people.get(lab.get(0))[4].equals("alien") && people.get(lab.get(1))[4].equals("human")){
				JOptionPane.showMessageDialog(null,"You enter to find " + people.get(lab.get(0))[0] + " attacking "+people.get(lab.get(1))[0]
						+ " with new limbs sprouting  from "+people.get(lab.get(1))[0]+ "'s back. You throw a " + object + " at the alien and stumble it.\n You hold the door for "
						+ people.get(lab.get(1))[0] + " and you both run from the room.");
				attack=1;
			}
			if(people.get(lab.get(1))[4].equals("alien") && people.get(lab.get(0))[4].equals("human")){
				JOptionPane.showMessageDialog(null,"You enter to find " + people.get(lab.get(1))[0] + " attacking "+people.get(lab.get(0))[0]
						+ " with new limbs sprouting \n from "+people.get(lab.get(1))[0]+ "'s back. You throw a " + object + " at the alien and stumble it.\n You hold the door for "
						+ people.get(lab.get(0))[0] + " and you both run from the room.");
				attack=1;
			}
		}
		//if no attack, you just learn the attributes of the people there
		if(attack==0){		
			for(int i=0;i<lab.size();i++){
				//variables for people
				Random randverb=new Random();
				int randaction=randverb.nextInt(action.length);
				String verb=action[randaction];
				//string for crazy
				String crazyphrase="";
				int crazy=Integer.parseInt(people.get(lab.get(i))[3]);
				if(crazy<11){
					crazyphrase="extreme calm in the face of what is going on.";
				}
				if(10<crazy && crazy<31){
					crazyphrase="someone under stress.";
				}
				if(30<crazy && crazy<71){
					crazyphrase="someone on the verge of breaking.";
				}
				if(70<crazy && crazy<96){
					crazyphrase="insanity setting in.";
				}
				if(95<crazy && crazy<101){
					crazyphrase="bat-shit craziness.";
				}
				//display some investigative text
				JOptionPane.showMessageDialog(null,"You see "+ people.get(lab.get(i))[0]+" " +verb + " "+ people.get(lab.get(i))[2] +". "+ 
				"He/she looks at you with " +	people.get(lab.get(i))[1] + " eyes that show " + crazyphrase);
				System.out.println(people.get(lab.get(i))[0]);
				System.out.println(people.get(lab.get(i))[4]);
			}
		}
		
		//store that you visited
		labvisit=1;
		elsewhere();
		
	}
	static private void storeroom(){
		//you arrive
		JOptionPane.showMessageDialog(null,"You went to the Store Room.");
		//method vars
		int attack=0;
		String object="small crate";
		//if there are two people and one is an alien, you walk in on the alien turning the person
				if(storeroom.size()==2){
					if(people.get(storeroom.get(0))[4].equals("alien") && people.get(storeroom.get(1))[4].equals("human")){
						JOptionPane.showMessageDialog(null,"You enter to find " + people.get(storeroom.get(0))[0] + " attacking "+people.get(storeroom.get(1))[0]
								+ " with new limbs sprouting  from "+people.get(storeroom.get(1))[0]+ "'s back. You throw a " + object + " at the alien and stumble it.\n You hold the door for "
								+ people.get(storeroom.get(1))[0] + " and you both run from the room.");
						attack=1;
					}
					if(people.get(storeroom.get(1))[4].equals("alien") && people.get(storeroom.get(0))[4].equals("human")){
						JOptionPane.showMessageDialog(null,"You enter to find " + people.get(storeroom.get(1))[0] + " attacking "+people.get(storeroom.get(0))[0]
								+ " with new limbs sprouting \n from "+people.get(storeroom.get(1))[0]+ "'s back. You throw a " + object + " at the alien and stumble it.\n You hold the door for "
								+ people.get(storeroom.get(0))[0] + " and you both run from the room.");
						attack=1;
					}
				}
		if(attack==0){		
			for(int i=0;i<storeroom.size();i++){
				//variables for people
				Random randverb=new Random();
				int randaction=randverb.nextInt(action.length);
				String verb=action[randaction];
				//string for crazy
				String crazyphrase="";
				int crazy=Integer.parseInt(people.get(storeroom.get(i))[3]);
				if(crazy<11){
					crazyphrase="extreme calm in the face of what is going on.";
				}
				if(10<crazy && crazy<31){
					crazyphrase="someone under stress.";
				}
				if(30<crazy && crazy<71){
					crazyphrase="someone on the verge of breaking.";
				}
				if(70<crazy && crazy<96){
					crazyphrase="insanity setting in.";
				}
				if(95<crazy && crazy<101){
					crazyphrase="bat-shit craziness.";
				}
				//display some investigative text
				JOptionPane.showMessageDialog(null,"You see "+ people.get(storeroom.get(i))[0]+" " +verb + " "+ people.get(storeroom.get(i))[2] +". "+ 
				"He/she looks at you with " +	people.get(storeroom.get(i))[1] + " eyes that show " + crazyphrase);
				System.out.println(people.get(storeroom.get(i))[0]);
				System.out.println(people.get(storeroom.get(i))[4]);
			}
		}
		//store that you visited
		storeroomvisit=1;
		elsewhere();
	}
	static private void outside(){
		//you arrive
		JOptionPane.showMessageDialog(null,"You went outside.");
		//method vars
		int attack=0;
		String object="shovel";
		
		
		if(attack==0){		
			for(int i=0;i<outside.size();i++){
				//variables for people
				Random randverb=new Random();
				int randaction=randverb.nextInt(action.length);
				String verb=action[randaction];
				//string for crazy
				String crazyphrase="";
				int crazy=Integer.parseInt(people.get(outside.get(i))[3]);
				if(crazy<11){
					crazyphrase="extreme calm in the face of what is going on.";
				}
				if(10<crazy && crazy<31){
					crazyphrase="someone under stress.";
				}
				if(30<crazy && crazy<71){
					crazyphrase="someone on the verge of breaking.";
				}
				if(70<crazy && crazy<96){
					crazyphrase="insanity setting in.";
				}
				if(95<crazy && crazy<101){
					crazyphrase="bat-shit craziness.";
				}
				//display some investigative text
				JOptionPane.showMessageDialog(null,"You see "+ people.get(outside.get(i))[0]+" " +verb + " "+ people.get(outside.get(i))[2] +". "+ 
				"He/she looks at you with " +	people.get(outside.get(i))[1] + " eyes that show " + crazyphrase);
				System.out.println(people.get(outside.get(i))[0]);
				System.out.println(people.get(outside.get(i))[4]);
				
			}
		}
		//store that you visited
		outsidevisit=1;
		elsewhere();
		
	}
	static private void recroom(){
		//you arrive
		JOptionPane.showMessageDialog(null,"You went to the Recreational Room.");
		//method vars
		int attack=0;
		String object="small crate";
				
		if(attack==0){		
			for(int i=0;i<recroom.size();i++){
				//variables for people
				Random randverb=new Random();
				int randaction=randverb.nextInt(action.length);
				String verb=action[randaction];
				//string for crazy
				String crazyphrase="";
				int crazy=Integer.parseInt(people.get(recroom.get(i))[3]);
				if(crazy<11){
					crazyphrase="extreme calm in the face of what is going on.";
				}
				if(10<crazy && crazy<31){
					crazyphrase="someone under stress.";
				}
				if(30<crazy && crazy<71){
					crazyphrase="someone on the verge of breaking.";
				}
				if(70<crazy && crazy<96){
					crazyphrase="insanity setting in.";
				}
				if(95<crazy && crazy<101){
					crazyphrase="bat-shit craziness.";
				}
				//display some investigative text
				JOptionPane.showMessageDialog(null,"You see "+ people.get(recroom.get(i))[0]+" " +verb + " "+ people.get(recroom.get(i))[2] +". "+ 
				"He/she looks at you with " +	people.get(recroom.get(i))[1] + " eyes that show " + crazyphrase);
				System.out.println(people.get(recroom.get(i))[0]);
				System.out.println(people.get(recroom.get(i))[4]);
				
			}
		}
		//store that you visited
		recroomvisit=1;
		elsewhere();
		
	}
	
	static private void elsewhere(){
		String[] options = new String[] {"Continue Invsetigating", "Call Meeting","Just Leave"};
		    int response = JOptionPane.showOptionDialog(null, "What do you do?", "",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, options[0]);
		    if(response==0){
		    	//events in other rooms play out
		    	JOptionPane.showMessageDialog(null,"Things happen in the other rooms.");
		    	
		    	//vars
		    	int counter=0;
		    	//lab plays out
		    	//count the number of humans in the room
		    	counter=0;
				for(int i=0;i<lab.size();i++){
					if(people.get(lab.get(i))[4].equals("human")){
						counter=counter+1;
					}
				}
				if(lab.size()>1 && counter==1 && labvisit==0){
					Alien alien=new Alien(people.get(lab.get(0)));
					people.set(lab.get(0),alien.getalien());
					
				}
		    	//storeroom plays out
				counter=0;
				for(int i=0;i<storeroom.size();i++){
					if(people.get(storeroom.get(i))[4].equals("human")){
						counter=counter+1;
					}
				}
				if(storeroom.size()>1 && counter==1 && storeroomvisit==0){
					Alien alien=new Alien(people.get(storeroom.get(0)));
					people.set(storeroom.get(0),alien.getalien());
					
				}
		    	//outside plays out
				counter=0;
				for(int i=0;i<outside.size();i++){
					if(people.get(outside.get(i))[4].equals("human")){
						counter=counter+1;
					}
				}
				if(outside.size()>1 && counter==1 && outsidevisit==0){
					Alien alien=new Alien(people.get(outside.get(0)));
					people.set(outside.get(0),alien.getalien());
					
				}
		    	//rec room plays out
				counter=0;
				for(int i=0;i<recroom.size();i++){
					if(people.get(recroom.get(i))[4].equals("human")){
						counter=counter+1;
					}
				}
				if(recroom.size()>1 && counter==1 && recroomvisit==0){
					Alien alien=new Alien(people.get(recroom.get(0)));
					people.set(recroom.get(0),alien.getalien());
					
				}
		    	//print the number of humans left
		    	int humancounter=0;
		    	//count the number of humans in the room
		    	
				for(int i=0;i<lab.size();i++){
					if(people.get(lab.get(i))[4].equals("human")){
						humancounter=humancounter+1;
					}
				}
				
				
				
				for(int i=0;i<storeroom.size();i++){
					if(people.get(storeroom.get(i))[4].equals("human")){
						humancounter=humancounter+1;
					}
				}
				
				
				
				for(int i=0;i<outside.size();i++){
					if(people.get(outside.get(i))[4].equals("human")){
						humancounter=humancounter+1;
					}
				}
				
				
				
				for(int i=0;i<recroom.size();i++){
					if(people.get(recroom.get(i))[4].equals("human")){
						humancounter=humancounter+1;
					}
				}
				System.out.println("There are "+humancounter+" humans left.");
				
				//status
				for(int i=0;i<people.size();i++){
		    		System.out.println(people.get(i)[0]+": "+people.get(i)[4]);
		    	}
		    	//reset move
		    	newturn();
		    	
		    }
		    
		    
	}
		
}

