package finalsrc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {
	//static vars
	static int battle=0;
	
	//random weapons
	static String[] weapons={"Sword", "Polearm", "Toothpick", "Gun", "Lightsaber", "Brass Knuckles", "Glitter", "Brick", "Sledgehammer", "Better Hands"
			,"Shoe", "Really Big Gun", "Atomic Bomb", "Baby Asprin"};
	//variables
	static String name;
	static int health;
	static int attack;
	static int defense;
	static int agility;
	static int endurance;
	static int intimidation;
	static int gold;
	static int level;
	static int xp;
	static String weapon;
	static int weaponstat;
	static int maxhealth;
	
	//static rand
	static Random rand=new Random();
	
	//main
	public static void main(String[] args) {
		
		
		//check if load character
		Object[] options2 = {"New Character",
	            "Load Character",
	            "Quit"};
		int load = JOptionPane.showOptionDialog(null,
				"START",						
						"",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options2,
						options2[2]);
		
		
		
		//load character and stats
		if(load==1){
			// The name of the file to open.
	        String fileName = "save/save";

	        // This will reference one line at a time
	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            
	            //Load Stats
	            name=bufferedReader.readLine();
	            health=Integer.parseInt(bufferedReader.readLine());
	            attack=Integer.parseInt(bufferedReader.readLine());
	            defense=Integer.parseInt(bufferedReader.readLine());
	            agility=Integer.parseInt(bufferedReader.readLine());
	            endurance=Integer.parseInt(bufferedReader.readLine());
	            intimidation=Integer.parseInt(bufferedReader.readLine());
	            gold=Integer.parseInt(bufferedReader.readLine());
	            level=Integer.parseInt(bufferedReader.readLine());
	            xp=Integer.parseInt(bufferedReader.readLine());
	            weapon=bufferedReader.readLine();
	            weaponstat=Integer.parseInt(bufferedReader.readLine());
	            
	            maxhealth=100+level*5;
	            //System.out.println(weapon);
	            
	            // Always close files.
	            bufferedReader.close(); 
			
				}
				catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                fileName + "'");                
		        }
				catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + fileName + "'");                  
		            // Or we could just do this: 
		            // ex.printStackTrace();
		        }
			
					}	
				
		//if no character loaded then make a new character.
		if(load==0){
			//check your name
			int good=0;
			while(good==0){
			name=JOptionPane.showInputDialog("What is your name, brave soul?");
			//get mad if they don't enter something
					if(name==null){
						System.exit(0);
					}
					if(name.equalsIgnoreCase("")){
						name=JOptionPane.showInputDialog(null,"That's not a name.");
						
					}
					else{
						good=1;
					}
			}
			//new stats
			health=100;
			attack=1;
			defense=1;
			agility=1;
			endurance=1;
			intimidation=1;
			xp=0;
			level=1;
			gold=100;
			weapon="n old sword";
			weaponstat=1;
			maxhealth=100;
			
			
			
		}
		
		//If quit then quit
		if(load==2){
			System.exit(0);
		}
		///////////////////////////////////////////////////////////////////////////////////////
		//display character		
		JOptionPane.showMessageDialog(null,"You are " +name+", a Level "+Integer.toString(level)+" fighter wielding a"+weapon+".\n Attack: " +Integer.toString(attack)
		+"\n Defense: "+Integer.toString(defense)+"\n Agility: "+Integer.toString(agility)+"\n Endurance: "+Integer.toString(endurance)
		+"\n Intimidation: "+Integer.toString(intimidation)+"\n Gold: "+Integer.toString(gold)+"\n Health: "+Integer.toString(health));
		
		//continue from here
		JOptionPane.showMessageDialog(null,"You begin your journey!");
		
		//go to downtime
		new Level(level,0);
		
		
			

	}	
	
	static void acted(int act){
		//System.out.println("Action Complete.");
		//vars		
		int kill=0;
		int damagedealt=0;
		int damage=0;
		int goldgain=0;
		int xpgain=0;
		int healthgain=0;
		int run=0;
		int scare=0;
		//attack
		if(act==1){
			//deal damage
			damagedealt=10+attack*5+weaponstat*20+(rand.nextInt(9)-5)*Interface.monsterdefend;
			Interface.monsterhealth=Interface.monsterhealth-damagedealt;
			//display
			Interface.write.setText("You dealt "+Integer.toString(damagedealt)+" damage.\n It has "+Integer.toString(Interface.monsterhealth)+" health left.");
			
			}
		//run
		if(act==2){
			int runchance=agility+30-Interface.monsterattack;
			if(runchance>90){
				runchance=90;
			}
			int chance=rand.nextInt(100)+1;
			if(runchance>chance){
				JOptionPane.showMessageDialog(null,"You got away.");
				//count as kill but you ran away
				kill=1;
				run=1;
				//give a little xp
				xp=xp+15;
			}
			if(runchance<=chance){
				JOptionPane.showMessageDialog(null,"You didn't escape.");
			}
		}
		//yell
		if(act==3){
			int yellchance=intimidation-Interface.monsterattack-Interface.monsterdefend*5;
			int yell=rand.nextInt(100)+1;
			if(yellchance>yell){
				JOptionPane.showMessageDialog(null,"You scared the monster away.");
				kill=1;
				scare=1;
			}
			if(yellchance<=yell){
				JOptionPane.showMessageDialog(null,"You made the monster angry.");
				Interface.monsterattack=Interface.monsterattack+1;
			}
			
		}
		//kill by damage
		if(Interface.monsterhealth<=0){
			kill=1;
			Interface.write.setText("You killed the "+Interface.monstername);
		}
		//wait for a bit
		if(kill==0){
		JOptionPane.showMessageDialog(null,"The monster attacks.");
		}
		
		//monster attacks if not dead
		if(kill==0){
			//deals damage
			damage=5*Interface.monsterattack-defense;
			if(damage<0){
				damage=0;
			}
			health=health-damage;
			//display
			Interface.write.setText("You take "+Integer.toString(damage)+" damage.\n You have "+Integer.toString(health)+" health left.");
			//die
			if(health<0){
				JOptionPane.showMessageDialog(null,"You died.");
				System.exit(0);
				
			}
		}
		
		//reset move unless monster is dead
		if(kill==0){
			Interface.yell.addActionListener(Interface.yell2);
	        Interface.attack.addActionListener(Interface.attack2);
	        Interface.run.addActionListener(Interface.run2);
		}
		if(kill==1 && run==0){
			
			//loot
			String levelup="";
			xpgain=10+10*Interface.monsterdefend+20*Interface.monsterattack;
			goldgain=rand.nextInt(51)*Interface.monsterdefend+rand.nextInt(51)*Interface.monsterattack;
			xp=xp+xpgain;
			gold=gold+goldgain;
			JOptionPane.showMessageDialog(null,"You gain "+Integer.toString(xpgain)+" experience. \n You found " +Integer.toString(goldgain)+" gold.");
				//probably level up here
			while(xp>100*level){
					//reduce xp
					xp=xp-100*level;				
					//increase level
					level=level+1;
					//increase max health
					maxhealth=maxhealth+5;
					//display
					JOptionPane.showMessageDialog(null,"You leveled up! \n You are at Level " +Integer.toString(level)+".");
					//increase stats
					for(int i=1;i<8;i++){
						//string for message
						levelup=String.format("You have %d skill points left to assign.",8-i);
						//choice
						Object[] options2 = {"Attack",
					            "Defense",
					            "Agility","Endurance", "Intimidation"};
						int choice = JOptionPane.showOptionDialog(null,
								levelup,						
										"",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE,
										null,
										options2,
										options2[2]);
						if(choice==0){
							attack=attack+1;
						}
						if(choice==1){
							defense=defense+1;
						}
						if(choice==2){
							agility=agility+1;
						}
						if(choice==3){
							endurance=endurance+1;
						}
						if(choice==4){
							intimidation=intimidation+1;
						}
						
					}
									
				}
				
			//regain health
			healthgain=endurance*5;
			health=health+healthgain;
			if(health>maxhealth){
				health=maxhealth;
			}
			JOptionPane.showMessageDialog(null,"You regain "+Integer.toString(healthgain)+" health. \n You have " +Integer.toString(health)+" health.");
			
			//choose what to do
			downtime();
			
		}
		if(kill==1 && run==1){
			//regain health
			healthgain=endurance*5;
			health=health+healthgain;
			if(health>maxhealth){
				health=maxhealth;
			}
			JOptionPane.showMessageDialog(null,"You regain "+Integer.toString(healthgain)+" health. \n You have " +Integer.toString(health)+" health.");
			
			//choose what to do
			downtime();
		}
	}
	static void downtime(){
		//close JFrame
		Interface.layout.removeAll();
		Interface.frame.dispose();
		Object[] options2 = {"Go to town",
	            "Battle",
	            "Save and Quit"};
		int choice = JOptionPane.showOptionDialog(null,
				"What do you want to do?",						
						"",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options2,
						options2[2]);
		
		if(choice==0){
			store();
			
		}
		if(choice==1){
			newmove();
		}
		if(choice==2){
			save();
		}
		
	}
	static void store(){
		String weapon=String.format("Buy a Better Weapon \n %d Gold",weaponstat*500);
		String healthy=String.format("Sleep at Inn \n %d Gold", 75);
		String stats=String.format("Upgrade a Stat \n %d Gold", 100);
		String shoptext=String.format("What do you want to buy? You have %d gold left.", gold);
		
		Object[] options2 = {weapon,
	            healthy,
	            stats,"Leave"};
		int shop = JOptionPane.showOptionDialog(null,
				shoptext,						
						"",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options2,
						options2[2]);
		if(shop==0){
			if(gold<500*weaponstat){
				JOptionPane.showMessageDialog(null,"INSUFFICIENT FUNDS");
			}
			if(gold>=500*weaponstat){
				//buy a better weapon
				gold=gold-500*weaponstat;
				weaponstat=weaponstat+1;
				//choose weapon
				int weap=rand.nextInt(weapons.length);
				weapon=weapons[weap];
				//display
				JOptionPane.showMessageDialog(null,"You bought a new, level "+Integer.toString(weaponstat)+", " +weapon+ ". \n You have " 
				+Integer.toString(gold)+" gold left.");
				
			}
			
			store();
		}
		if(shop==1){
			if(gold<75){
				JOptionPane.showMessageDialog(null,"INSUFFICIENT FUNDS");
			}
			if(gold>=75){
				//refill health
				health=maxhealth;
				//pay gold
				gold=gold-75;
				JOptionPane.showMessageDialog(null,"You now have full health.");
			}
			
			store();
		}
		if(shop==2){
			if(gold<100){
				JOptionPane.showMessageDialog(null,"INSUFFICIENT FUNDS");
			}
			if(gold>=100){
				//pay gold
				gold=gold-100;
				//increase a stat
				Object[] options3 = {"Attack",
			            "Defense",
			            "Agility","Endurance", "Intimidation"};
				int choice = JOptionPane.showOptionDialog(null,
						"Which stat will you upgrade?",						
								"",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,
								options3,
								options3[2]);
				if(choice==0){
					attack=attack+1;
				}
				if(choice==1){
					defense=defense+1;
				}
				if(choice==2){
					agility=agility+1;
				}
				if(choice==3){
					endurance=endurance+1;
				}
				if(choice==4){
					intimidation=intimidation+1;
				}
			}
			
			store();
			
		}
		if(shop==3){
			downtime();
		}
		
	}
	/////////////////////////////////////////////////////////////////////////////////////
	static void newmove(){
		//choose battle
		int battlerand=rand.nextInt(100)+1;
		if(battlerand<25){
			new Unique(level);
		}
		if(battlerand>=25){
			new Level(level,0);
		}
		
	}
	static void save(){
		String fileName = "save/save";
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            
            //name=bufferedReader.readLine();
            //health=Integer.parseInt(bufferedReader.readLine());
           // attack=Integer.parseInt(bufferedReader.readLine());
           // defense=Integer.parseInt(bufferedReader.readLine());
           // agility=Integer.parseInt(bufferedReader.readLine());
           // endurance=Integer.parseInt(bufferedReader.readLine());
           // intimidation=Integer.parseInt(bufferedReader.readLine());
           // gold=Integer.parseInt(bufferedReader.readLine());
           // level=Integer.parseInt(bufferedReader.readLine());
           // xp=Integer.parseInt(bufferedReader.readLine());
           // weapon=bufferedReader.readLine();
           // weaponstat=Integer.parseInt(bufferedReader.readLine());
            // Note that write() does not automatically
            // append a newline character.
            //name
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            //stats
            bufferedWriter.write(Integer.toString(health));
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(attack));
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(defense));
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(agility));
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(endurance));            
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(intimidation));
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(gold));
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(level));
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(xp));
            bufferedWriter.newLine();
            //weapon
            bufferedWriter.write(weapon);
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(weaponstat));            

            // Always close files.
            bufferedWriter.close();
            //close program after save
            System.exit(0);
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
	

}

