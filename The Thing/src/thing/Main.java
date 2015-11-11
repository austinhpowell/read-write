package thing;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;


public class Main {
static int humansize=0;
static String[] names={"Joe","Max","Stephanie","Austin","Megan","Delanie","Carl","Felicia","Isabelle","Tom","Teddy","James","Carlos","Levi", "Jay", "Bob","Yuri"};

//make list to store humans
static ArrayList<String[]> people=new ArrayList<String[]>();

//rooms
static ArrayList<Integer> lab=new ArrayList<Integer>();
static ArrayList<Integer> storeroom=new ArrayList<Integer>();
static ArrayList<Integer> outside=new ArrayList<Integer>();
static ArrayList<Integer> recroom=new ArrayList<Integer>();

	public static void main(String[] args) {
	
		
		//make random
		Random rand=new Random();
		
		//make humans
		for(int i=0;i<5;i++){
		//String name = JOptionPane.showInputDialog("What is his/her name?");
			
		//random names	
		String name=names[rand.nextInt(names.length)];
		
		//make a person, add to people
		Human person=new Human(name);
		String[] Joe ={person.getname(),person.geteyes(),person.getpersona(),person.getcrazy(),"human"};
		humansize=Joe.length;
		people.add(Joe);		
		}
		
		//print all humans
		for(int b=0; b<people.size();b++){ 
			for (int t=0; t< humansize; t++){
				System.out.println(people.get(b)[t]);
		
			}
		}
		
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
	
	//move people with a method
	static void movepeople(){
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
					//look for rooms with just one person in it first
					if(lab.size()==1){
						alienchoose[0]=1;
					}
					if(storeroom.size()==1){
						alienchoose[1]=1;
					}
					if(outside.size()==1){
						alienchoose[2]=1;
					}
					if(recroom.size()==1){
						alienchoose[3]=1;
					}
					while(choicemade==0){
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
						
					}
					
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
		
	}
	public void lab(){
		System.out.println(people);
		
	}
		
}

