package Main;

import javax.imageio.ImageIO;
import javax.swing.*; // For JPanel, etc.

import Main.Arena.ButtonListener;
import Main.Arena.ButtonListener2;

import java.awt.*;           // For Graphics, etc.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;      // For Ellipse2D, etc.
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Math.*;
import java.security.SecureRandom;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class GUI extends JPanel{
	
	
	

	private static final long serialVersionUID = -6156045315207494156L;
	Arena arena = null;
	ButtonListener2 listen = null;
	public boolean firstRun;
	Character p1 = null;
	Character p2 = null;
	
	public GUI (Arena arena, ButtonListener2 listener2, Character p1, Character p2) {
		this.arena = arena;
		this.listen = listener2;
		this.firstRun = true;
		this.p1 = p1;
		this.p2 = p2;
	}
	

	public void drawing(Graphics g)  {
		repaint();
	}
	

	
	public void paintComponent(Graphics g) {
		
		if(listen.variable != 0){
			int a = listen.variable - 1;
			int b = 0;
			if(p1.moves[a].name == "null"){
				listen.text.setText("That isn't a move. Choose a different move.");
			}
			else if(arena.P1Super + p1.moves[a].superGainUse < 0){
				listen.text.setText("Your super is too low to use this move. Choose a different move.");
			}
			else if(a == 9 && arena.P1Ultra < 500){
				listen.text.setText("Your ultra is too low to use this move. Choose a different move.");
			}
			else{
				
				while(b == 0){
					int random = random();
					
					if(arena.P2Super + p2.moves[random].superGainUse >=0){
						if(random == 9){
							if(arena.P2Ultra == 500){
								b = random;
							}
						}
						else{
							b = random;
						}
					}
				}
			
				listen.text.setText("You used: " +p1.moves[a].name+"    CPU used: " + p2.moves[b].name );
				if(a == 9 ){
					arena.P1Ultra = 0;
				}
				if(b == 9){
					arena.P2Ultra = 0;
				}
				
				
				
				
				
				if( p1.moves[a].startup < p2.moves[b].startup){
					if(Priority(p1.moves[a], p2.moves[b], arena.distance) == 1){
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Super = arena.P1Super + (p2.moves[b].superGainHit / 2);
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P1HP = arena.P1HP - p2.moves[b].damage;

						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement + p2.moves[b].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						System.out.println("CASE 1");
					}
					
					else if(Priority(p1.moves[a], p2.moves[b], arena.distance) == 2){
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}

						System.out.println("CASE 2");
					}
					
					else if(Priority(p1.moves[a], p2.moves[b], arena.distance) == 3){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}

						System.out.println("CASE 3");
						if (Defender(p1.moves[a], p2.moves[b], arena.distance) ==1){
							arena.P2Super = arena.P2Super + p2.moves[b].superGainUse;
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}
							
							arena.distance = arena.distance - p2.moves[b].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE A");
						}
						else if (Defender(p1.moves[a], p2.moves[b], arena.distance) ==2){
							arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}
							arena.P1Super = arena.P1Super + (p2.moves[b].superGainHit / 2);
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.P1HP = arena.P1HP - p2.moves[b].damage;

							arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
							if(arena.P1Ultra > 500){
								arena.P1Ultra = 500;
							}

							arena.distance = arena.distance - p2.moves[b].userMovement + p2.moves[b].enemyMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE B");
						}
						else if (Defender(p1.moves[a], p2.moves[b], arena.distance) ==3){
							arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}
							arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
							if(arena.P1Ultra > 500){
								arena.P1Ultra = 500;
							}
							arena.distance = arena.distance - p2.moves[b].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE C");
						}
					}
					else if(Priority(p1.moves[a], p2.moves[b], arena.distance) == 4){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Super = arena.P2Super + (p1.moves[a].superGainHit / 2);
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P2HP = arena.P2HP - p1.moves[a].damage;

						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}

						arena.distance = arena.distance - p1.moves[a].userMovement + p1.moves[a].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						System.out.println("CASE 4");
					}
					else if(Priority(p1.moves[a], p2.moves[b], arena.distance) == 5){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						System.out.println("CASE 5");
						if (Defender(p1.moves[a], p2.moves[b], arena.distance) ==1){
							arena.P2Super = arena.P2Super + p2.moves[b].superGainUse;
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}

							arena.distance = arena.distance - p2.moves[b].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE A");
						}
						else if (Defender(p1.moves[a], p2.moves[b], arena.distance) ==2){
							arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}
							arena.P1Super = arena.P1Super + (p2.moves[b].superGainHit / 2);
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.P1HP = arena.P1HP - p2.moves[b].damage;

							arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
							if(arena.P1Ultra > 500){
								arena.P1Ultra = 500;
							}

							arena.distance = arena.distance - p2.moves[b].userMovement + p2.moves[b].enemyMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE B");
						}
						else if (Defender(p1.moves[a], p2.moves[b], arena.distance) ==3){
							arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}
							arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
							if(arena.P1Ultra > 500){
								arena.P1Ultra = 500;
							}
							arena.distance = arena.distance - p2.moves[b].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE C");
						}
					}
				}
				
				
				
				
			
				else if( p1.moves[a].startup > p2.moves[b].startup){
					if(Priority(p2.moves[b], p1.moves[a], arena.distance) == 1){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Super = arena.P2Super + (p1.moves[a].superGainHit / 2);
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P2HP = arena.P2HP - p1.moves[a].damage;

						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}

						arena.distance = arena.distance - p1.moves[a].userMovement + p1.moves[a].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						System.out.println("CASE 6");
					}
					
					else if(Priority(p2.moves[b], p1.moves[a], arena.distance) == 2){
							arena.P1Super = arena.P1Super + p1.moves[a].superGainUse;
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.distance = arena.distance - p1.moves[a].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
						System.out.println("CASE 7");
					}
					
					else if(Priority(p2.moves[b], p1.moves[a], arena.distance) == 3){
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						System.out.println("CASE 8");
						if (Defender(p2.moves[b], p1.moves[a], arena.distance) ==1){
							arena.P1Super = arena.P1Super + p1.moves[a].superGainUse;
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.distance = arena.distance - p1.moves[a].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE A");
						}
						else if (Defender(p2.moves[b], p1.moves[a], arena.distance) ==2){
							arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.P2Super = arena.P2Super + (p1.moves[a].superGainHit / 2);
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}
							arena.P2HP = arena.P2HP - p1.moves[a].damage;
							
							arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
							if(arena.P2Ultra > 500){
								arena.P2Ultra = 500;
							}
							
							arena.distance = arena.distance - p1.moves[a].userMovement + p1.moves[a].enemyMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE B");
						}
						else if (Defender(p2.moves[b], p1.moves[a], arena.distance) ==3){
							arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
							if(arena.P2Ultra > 500){
								arena.P2Ultra = 500;
							}
							arena.distance = arena.distance - p1.moves[a].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE C");
						}
					}
					else if(Priority(p2.moves[b], p1.moves[a], arena.distance) == 4){
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Super = arena.P1Super + (p2.moves[b].superGainHit / 2);
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P1HP = arena.P1HP - p2.moves[b].damage;

						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement + p2.moves[b].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						System.out.println("CASE 9");
					}
					else if(Priority(p2.moves[b], p1.moves[a], arena.distance) == 5){
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}
						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						System.out.println("CASE 10");
						if (Defender(p2.moves[b], p1.moves[a], arena.distance) ==1){
							arena.P1Super = arena.P1Super + p1.moves[a].superGainUse;
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.distance = arena.distance - p1.moves[a].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE A");
						}
						else if (Defender(p2.moves[b], p1.moves[a], arena.distance) ==2){
							arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.P2Super = arena.P2Super + (p1.moves[a].superGainHit / 2);
							if(arena.P2Super > 1000){
								arena.P2Super = 1000;
							}
							arena.P2HP = arena.P2HP - p1.moves[a].damage;

							arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
							if(arena.P2Ultra > 500){
								arena.P2Ultra = 500;
							}

							arena.distance = arena.distance - p1.moves[a].userMovement + p1.moves[a].enemyMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE B");
						}
						else if (Defender(p2.moves[b], p1.moves[a], arena.distance) ==3){
							arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
							if(arena.P1Super > 1000){
								arena.P1Super = 1000;
							}
							arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
							if(arena.P2Ultra > 500){
								arena.P2Ultra = 500;
							}
							arena.distance = arena.distance - p1.moves[a].userMovement;
							if(arena.distance < 0){
								arena.distance = arena.distance * (-1);
							}
							if(arena.distance > 3){
								arena.distance = 3;
							}
							System.out.println("CASE C");
						}
					}

				}
				
				else{ //if startups are equal
					if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 1){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 2){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Super = arena.P2Super + (p1.moves[a].superGainHit / 2);
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P2HP = arena.P2HP - p1.moves[a].damage;

						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}

						arena.distance = arena.distance - p1.moves[a].userMovement + p1.moves[a].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 3){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 4){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Super = arena.P1Super + (p2.moves[b].superGainHit / 2);
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P1HP = arena.P1HP - p2.moves[b].damage;

						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement + p2.moves[b].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 5){
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}
						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 6){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Super = arena.P2Super + (p1.moves[a].superGainHit / 2);
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P2HP = arena.P2HP - p1.moves[a].damage;

						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}

						arena.distance = arena.distance - p1.moves[a].userMovement + p1.moves[a].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Super = arena.P1Super + (p2.moves[b].superGainHit / 2);
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P1HP = arena.P1HP - p2.moves[b].damage;

						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement + p2.moves[b].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 7){
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}
						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Super = arena.P2Super + (p1.moves[a].superGainHit / 2);
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P2HP = arena.P2HP - p1.moves[a].damage;

						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}

						arena.distance = arena.distance - p1.moves[a].userMovement + p1.moves[a].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 8){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Super = arena.P1Super + (p2.moves[b].superGainHit / 2);
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P1HP = arena.P1HP - p2.moves[b].damage;

						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}

						arena.distance = arena.distance - p2.moves[b].userMovement + p2.moves[b].enemyMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
					else if (Trade(p1.moves[a], p2.moves[b], arena.distance) == 9){
						arena.P1Super = arena.P1Super + p1.moves[a].superGainUse + p1.moves[a].superGainHit;
						if(arena.P1Super > 1000){
							arena.P1Super = 1000;
						}
						arena.P2Ultra = arena.P2Ultra +p1.moves[a].damage;
						if(arena.P2Ultra > 500){
							arena.P2Ultra = 500;
						}
						arena.distance = arena.distance - p1.moves[a].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
						arena.P2Super = arena.P2Super + p2.moves[b].superGainUse + p2.moves[b].superGainHit;
						if(arena.P2Super > 1000){
							arena.P2Super = 1000;
						}
						arena.P1Ultra = arena.P1Ultra +p2.moves[b].damage;
						if(arena.P1Ultra > 500){
							arena.P1Ultra = 500;
						}
						arena.distance = arena.distance - p2.moves[b].userMovement;
						if(arena.distance < 0){
							arena.distance = arena.distance * (-1);
						}
						if(arena.distance > 3){
							arena.distance = 3;
						}
					}
				}
	
			}
			if(arena.P1HP <=0 && arena.P2HP <=0){
				listen.text.setText("DRAW GAME!     Closing in 3.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listen.text.setText("DRAW GAME!     Closing in 2.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listen.text.setText("DRAW GAME!     Closing in 1.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			else if(arena.P1HP <=0){
				listen.text.setText("YOU LOSE!     Closing in 3.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listen.text.setText("YOU LOSE!     Closing in 2.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listen.text.setText("YOU LOSE!     Closing in 1.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			else if(arena.P2HP <=0){
				listen.text.setText("YOU WIN!     Closing in 3.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listen.text.setText("YOU WIN!     Closing in 2.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listen.text.setText("YOU WIN!     Closing in 1.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			
			b = 0;
			a = 0;
			listen.variable = 0;
		}
			
			
			
			
		g.setColor(Color.white);
		g.fillRect(0,0,1024, 768);
		
		g.setColor(Color.black);
		g.drawString("Distance = "+ arena.distance, 470,180);
		g.drawString("Super", 410 ,210);
		g.drawString("Super", 567 ,210);
		g.drawString("Ultra", 573 ,235);
		g.drawString("Ultra", 410 ,235);
	    g.drawString(arena.P1Name, 410, 20);
	    g.drawString(arena.P2Name, 533, 20);
	    g.drawString("(YOU)", 410, 35);
	    
	    g.fillRect(0,0,406,26);
	    g.fillRect(602,0,406,26);
	    g.fillRect(0,198,406,19);
	    g.fillRect(602,198,406,19);
	    g.fillRect(0,223,406,19);
	    g.fillRect(602,223,406,19);
	    
	    g.setColor(Color.gray.brighter());
		g.fillRect(3,3,400,20); 
		g.fillRect(605, 3, 400, 20);
		g.fillRect(3, 200, 400, 15);
		g.fillRect(605, 200, 400, 15);
		g.fillRect(3, 225, 400, 15);
		g.fillRect(605, 225, 400, 15);
		

		
	    g.setColor(Color.red.darker());
		g.fillRect(3,3,(int) (400*arena.P1HP/arena.P1MaxHP),20); 
		g.fillRect(605+ (400-(int) (400*arena.P2HP/arena.P2MaxHP)), 3, (int) (400*arena.P2HP/arena.P2MaxHP), 20);
		
		g.setColor(Color.blue.brighter().brighter());
		g.fillRect(3, 200, (int) (400*arena.P1Super/arena.maxSuper), 15);
		g.fillRect(605+ (400-(int) (400*arena.P2Super/arena.maxSuper)), 200, (int) (400*arena.P2Super/arena.maxSuper), 15);
		
		g.setColor(Color.green);
		g.fillRect(3, 225, (int) (400*arena.P1Ultra/arena.maxUltra), 15);
		g.fillRect(605+ (400-(int) (400*arena.P2Ultra/arena.maxUltra)), 225, (int) (400*arena.P2Ultra/arena.maxUltra), 15);
		
		g.setColor(Color.yellow.darker().darker().darker());
		g.fillRect(0, 160, 1024, 5);
		
		g.setColor(Color.black);
		g.fillRect(102,198,1,15);
		g.fillRect(202,198,1,15);
		g.fillRect(302,198,1,15);
		g.fillRect(705,198,1,15);
		g.fillRect(805,198,1,15);
		g.fillRect(905,198,1,15);
		
		g.setColor(Color.red);
		g.fillRect(488+(arena.distance*100),130-(50*arena.P1Air),15,30);
		
		g.setColor(Color.blue);
		g.fillRect(507-(arena.distance*100),130-(50*arena.P1Air),15,30);
		drawing(g);
	}
	
	public int random(){
		SecureRandom randomGenerator = new SecureRandom();
		
		int random = randomGenerator.nextInt();
		random = Math.abs( random);
		random = random % p2.movesno;
		return random;
	}
	
	public int Trade(Move p1, Move p2, int distance){
		if(p1.isAir == false && p2.isAir == false){
			if(p1.range >= distance && p2.range >= distance){
				if(p1.hitsGround && p2.hitsGround){
					return Case1(p1,p2,distance);
				}
				else if(p1.hitsGround){
					return Case2(p1,p2,distance);
				}
				else if(p2.hitsGround){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p1.range >= distance){
				if(p1.hitsGround){
					return Case2(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p2.range >= distance){
				if(p2.hitsGround){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else{
				return 1;
			}
			
			
		}
		else if(p1.isAir && p2.isAir == false){
			if(p1.range >= distance && p2.range >= distance){
				if(p1.hitsGround && p2.hitsGround){
					return Case1(p1,p2,distance);
				}
				else if(p1.hitsGround){
					return Case2(p1,p2,distance);
				}
				else if(p2.hitsAir){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p1.range >= distance){
				if(p1.hitsGround){
					return Case2(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p2.range >= distance){
				if(p2.hitsAir){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else{
				return 1;
			}
		}
		else if(p1.isAir == false && p2.isAir){
			if(p1.range >= distance && p2.range >= distance){
				if(p1.hitsGround && p2.hitsGround){
					return Case1(p1,p2,distance);
				}
				else if(p1.hitsAir){
					return Case2(p1,p2,distance);
				}
				else if(p2.hitsGround){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p1.range >= distance){
				if(p1.hitsAir){
					return Case2(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p2.range >= distance){
				if(p2.hitsGround){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else{
				return 1;
			}
		}
		else{
			if(p1.range >= distance && p2.range >= distance){
				if(p1.hitsAir && p2.hitsAir){
					return Case1(p1,p2,distance);
				}
				else if(p1.hitsAir){
					return Case2(p1,p2,distance);
				}
				else if(p2.hitsAir){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p1.range >= distance){
				if(p1.hitsAir){
					return Case2(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else if(p2.range >= distance){
				if(p2.hitsAir){
					return Case3(p1,p2,distance);
				}
				else{
					return 1;
				}
			}
			else{
				return 1;
			}
		}
	}
	
	public int Case1(Move p1, Move p2, int distance){
		if(p1.isProjectile&& p2.isProjectile){
			if(p1.projectileImmune && p2.projectileImmune){
				return 1;
			}
			else if(p1.projectileImmune){
				if(p2.armored){
					if(p1.armorBreak){
						return 2;
					}
					else{
						return 3;
					}
				}
				else{
					return 2;
				}
			}
			else if(p2.projectileImmune){
				if(p1.armored){
					if(p2.armorBreak){
						return 4;
					}
					else{
						return 5;
					}
				}
				else{
					return 4;
				}
			}
			else{
				if(p1.armored && p2.armored){
					if(p1.armorBreak && p2.armorBreak){
						return 6;
					}
					else if(p1.armorBreak){
						return 7;
					}
					else if(p2.armorBreak){
						return 8;
					}
					else{
						return 9;
					}
				}
				else if(p1.armored){
					if(p2.armorBreak){
						return 6;
					}
					else{
						return 7;
					}
				}
				else if(p2.armored){
					if(p1.armorBreak){
						return 6;
					}
					else{
						return 8;
					}
				}
				else{
					return 6;
				}
			}
		}
		else{
			if(p1.isProjectile){
				if(p2.projectileImmune){
					if(p1.armored){
						if(p2.armorBreak){
							return 4;
						}
						else{
							return 5;
						}
					}
					else{
						return 4;
					}
				}
				else{
					if(p1.armored && p2.armored){
						if(p1.armorBreak && p2.armorBreak){
							return 6;
						}
						else if(p1.armorBreak){
							return 7;
						}
						else if(p2.armorBreak){
							return 8;
						}
						else{
							return 9;
						}
					}
					else if(p1.armored){
						if(p2.armorBreak){
							return 6;
						}
						else{
							return 7;
						}
					}
					else if(p2.armored){
						if(p1.armorBreak){
							return 6;
						}
						else{
							return 8;
						}
					}
					else{
						return 6;
					}
				}
			}
			else if(p2.isProjectile){
				if(p1.projectileImmune){
					if(p2.armored){
						if(p1.armorBreak){
							return 2;
						}
						else{
							return 3;
						}
					}
					else{
						return 2;
					}
				}
				else{
					if(p1.armored && p2.armored){
						if(p1.armorBreak && p2.armorBreak){
							return 6;
						}
						else if(p1.armorBreak){
							return 7;
						}
						else if(p2.armorBreak){
							return 8;
						}
						else{
							return 9;
						}
					}
					else if(p1.armored){
						if(p2.armorBreak){
							return 6;
						}
						else{
							return 7;
						}
					}
					else if(p2.armored){
						if(p1.armorBreak){
							return 6;
						}
						else{
							return 8;
						}
					}
					else{
						return 6;
					}
				}
			}
			else{
				if(p1.armored && p2.armored){
					if(p1.armorBreak && p2.armorBreak){
						return 6;
					}
					else if (p1.armorBreak){
						return 7;
					}
					else if(p2.armorBreak){
						return 8;
					}
					else{
						return 9;
					}
				}
				else if(p1.armored){
					if(p2.armorBreak){
						return 6;
					}
					else{
						return 7;
					}
				}
				else if(p2.armored){
					if(p1.armorBreak){
						return 6;
					}
					else{
						return 8;
					}
				}
				else{
					return 6;
				}
			}
			
		}
	}
	
	public int Case2(Move p1, Move p2, int distance){
		if(p1.isProjectile){
			if(p2.projectileImmune){
				return 1;
			}
			else{
				if(p2.armored){
					if(p1.armorBreak){
						return 2;
					}
					else{
						return 3;
					}
				}
				else{
					return 2;
				}
			}
		}
		else{
				if(p2.armored){
					if(p1.armorBreak){
						return 2;
					}
					else{
						return 3;
					}
				}
				else{
					return 2;
				}
		}
	}
	
	public int Case3(Move p1, Move p2, int distance){
		if(p2.isProjectile){
			if(p1.projectileImmune){
				return 1;
			}
			else{
				if(p1.armored){
					if(p2.armorBreak){
						return 4;
					}
					else{
						return 5;
					}
				}
				else{
					return 4;
				}
			}
		}
		else{
			if(p1.armored){
				if(p2.armorBreak){
					return 4;
				}
				else{
					return 5;
				}
			}
			else{
				return 4;
			}
		}
	}

	public int Priority(Move attacker, Move defender, int distance){
		if(attacker.name == "Block"){
			if(defender.range >= distance){
				if(defender.hitsGround){
					if(defender.isThrow){
						return 1;
					}
					else{
						return 2;
					}
				}
				else{
					return 2;
				}
			}
			else{
				return 2;
			}
		}
		else if (attacker.range >=distance){
			if(defender.isAir){
				if(attacker.hitsAir){
					if(attacker.isProjectile){
						if(defender.projectileImmune){
							return 3;
						}
						else{
							if(defender.armored){
								if(attacker.armorBreak){
									return 4;
								}
								else{
									return 5;
								}
							}
							else{
								return 4;
							}
						}
					}
					else{
						if(defender.armored){
							if(attacker.armorBreak){
								return 4;
							}
							else{
								return 5;
							}
						}
						else{
							return 4;
						}
					}
				}
				else{
					return 3;
				}
			}
			else{
				if(attacker.hitsGround){
					if(defender.name == "Block"){
						if(attacker.isThrow){
							return 4;
						}
						else{
							return 3;
						}
					}
					else {
						if(attacker.isProjectile) {
							if(defender.projectileImmune){
								return 3;
							}
							else{
								if(defender.armored){
									if(attacker.armorBreak){
										return 4;
									}
									else{
										return 5;
									}
								}
								else{
									return 4;
								}
							}
						}
						else{
							if(defender.armored){
								if(attacker.armorBreak){
									return 4;
								}
								else{
									return 5;
								}
							}
							else{
								return 4;
							}
						}
					}
				}
				else{
					return 3;
				}
			}
		}
		else{
			return 3;
		}
	}
	
	public int Defender(Move attacker, Move defender, int distance){
		if(defender.range>= distance){
			if(attacker.isAir){
				if(defender.hitsAir){
					if(defender.isProjectile){
						if(attacker.projectileImmune){
							return 1;
						}
						else {
							if(attacker.armored){
								if(defender.armorBreak){
									return 2;
								}
								else{
									return 3;
								}
							}
							else{
								return 2;
							}
						}
					}
					else{
						if(attacker.armored){
							if(defender.armorBreak){
								return 2;
							}
							else{
								return 3;
							}
						}
						else{
							return 2;
						}
					}
				}
				else{
					return 1;
				}
			}
			else{
				if(defender.hitsGround){
					if(defender.isProjectile){
						if(attacker.projectileImmune){
							return 1;
						}
						else{
							if(attacker.armored){
								if(defender.armorBreak){
									return 2;
								}
								else{
									return 3;
								}
							}
							else{
								return 2;
							}
						}
					}
					else{
						if(attacker.armored){
							if(defender.armorBreak){
								return 2;
							}
							else{
								return 3;
							}
						}
						else{
							return 2;
						}
					}
				}
				else{
					return 1;
				}
			}
		}
		else{
			return 1;
		}
	}

}


