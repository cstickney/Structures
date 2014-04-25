package Main;


import java.awt.Graphics;

import javax.swing.JFrame;

import Main.Arena.ButtonListener;
import Main.Arena.ButtonListener2;

public class Main{
	static Graphics g;

	public static void main(String[] args){
				
		Character p1 = new Character();
		Character p2 = new Character();
		System.out.println(p1.name);
		
		Arena menu = new Arena();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setTitle("Character Select");
        menu.setSize(1024, 400);
        menu.setVisible(true);
        ButtonListener listener = menu.Select(g);
        
        while( p1.name == "uninitialized" || p2.name =="uninitialized") {
        	System.out.println("ROCK AND ROLL");
        	
        
	        if(listener.variable == 1 && p1.name == "uninitialized"){
	        	System.out.println("P1 = RYU");
	        	listener.variable = 0;
	        	p1 = new Ryu();
	        }
	        else if(listener.variable == 2 && p1.name == "uninitialized"){
	        	System.out.println("P1 = ABEL");
	        	listener.variable = 0;
	        	p1 = new Abel();
	        }
	        else if(listener.variable == 3 && p1.name == "uninitialized"){
	        	System.out.println("P1 = FEI LONG");
	        	listener.variable = 0;
	        	p1 = new FeiLong();
	        }
	        else if(listener.variable == 4 && p1.name == "uninitialized"){
	        	System.out.println("P1 = KEN");
	        	listener.variable = 0;
	        	p1 = new Ken();
	        }
	        else if(listener.variable == 5 && p1.name == "uninitialized"){
	        	System.out.println("P1 = DHALSIM");
	        	listener.variable = 0;
	        	p1 = new Dhalsim();
	        }
	        else if(listener.variable == 6 && p1.name == "uninitialized"){
	        	System.out.println("P1 = CHUN LI");
	        	listener.variable = 0;
	        	p1 = new ChunLi();
	        }
	        else if(listener.variable == 7 && p1.name == "uninitialized"){
	        	System.out.println("P1 = ZANGIEF");
	        	listener.variable = 0;
	        	p1 = new Zangief();
	        }
        	else if(listener.variable == 8 && p1.name == "uninitialized"){
        		System.out.println("P1 = DUDLEY");
        		listener.variable = 0;
        		p1 = new Dudley();
        	}
        	else if(listener.variable == 9 && p1.name == "uninitialized"){
        		System.out.println("P1 = CAMMY");
        		listener.variable = 0;
        		p1 = new Cammy();
        	}
        	else if(listener.variable == 1 && p1.name != "uninitialized" && p2.name == "uninitialized"){
	        	System.out.println("p2 = RYU");
	        	listener.variable = 0;
	        	p2 = new Ryu();
	        }
	        else if(listener.variable == 2 && p1.name != "uninitialized" && p2.name == "uninitialized"){
	        	System.out.println("p2 = ABEL");
	        	listener.variable = 0;
	        	p2 = new Abel();
	        }
	        else if(listener.variable == 3 && p1.name != "uninitialized" && p2.name == "uninitialized"){
	        	System.out.println("p2 = FEI LONG");
	        	listener.variable = 0;
	        	p2 = new FeiLong();
	        }
	        else if(listener.variable == 4 && p1.name != "uninitialized" && p2.name == "uninitialized"){
	        	System.out.println("p2 = KEN");
	        	listener.variable = 0;
	        	p2 = new Ken();
	        }
	        else if(listener.variable == 5 && p1.name != "uninitialized" && p2.name == "uninitialized"){
	        	System.out.println("p2 = DHALSIM");
	        	listener.variable = 0;
	        	p2 = new Dhalsim();
	        }
	        else if(listener.variable == 6 && p1.name != "uninitialized" && p2.name == "uninitialized"){
	        	System.out.println("p2 = CHUN LI");
	        	listener.variable = 0;
	        	p2 = new ChunLi();
	        }
	        else if(listener.variable == 7 && p1.name != "uninitialized" && p2.name == "uninitialized"){
	        	System.out.println("p2 = ZANGIEF");
	        	listener.variable = 0;
	        	p2 = new Zangief();
	        }
        	else if(listener.variable == 8 && p1.name != "uninitialized" && p2.name == "uninitialized"){
        		System.out.println("p2 = DUDLEY");
        		listener.variable = 0;
        		p2 = new Dudley();
        	}
        	else if(listener.variable == 9 && p1.name != "uninitialized" && p2.name == "uninitialized"){
        		System.out.println("p2 = CAMMY");
        		listener.variable = 0;
        		p2 = new Cammy();
        	}
        }
        System.out.println(p1.name+ "vs" + p2.name);
        
        
		Arena arena = new Arena();
		arena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonListener2 listener2 = menu.init(g, p1, p2);
		System.out.println("listener.variable");
		System.out.println(arena.P1HP-1);
		arena.P1HP = p1.HP;
		arena.P1MaxHP = p1.MaxHP;
		arena.P1Name = p1.name;
		arena.P2HP = p2.HP;
		arena.P2MaxHP = p2.MaxHP;
		arena.P2Name = p2.name;
		arena.add(new GUI(arena, listener2, p1, p2));
		System.out.println(arena.P1HP-5);
		
		
        arena.setTitle("Training Stage");
        arena.setSize(1024, 300);
        arena.setVisible(true);
        menu.setTitle("Interface");
        menu.setSize(1024, 400);
        menu.setVisible(true);
        

    }	
	

	
}