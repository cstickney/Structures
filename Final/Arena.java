package Main;


import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;





@SuppressWarnings("unused")
public class Arena extends JFrame{
	
	
	

	private static final long serialVersionUID = 1L;
	Container topPane;
	JButton[][] grid = new JButton[5][6];
	public int blankRow;
	public int blankCol;
	int row;
    int col;
    TextField DisplayText;
    int variable;
    int P1HP;
    int P1MaxHP;
    int P2HP;
    int P2MaxHP;
    int P1Super;
    int P2Super;
    int maxSuper;
    int maxUltra;
    int P1Ultra;
    int P2Ultra;
    int P1Air;
    int P2Air;
    String P1Name;
    String P2Name;
    
    int distance;
	static Graphics g;
	
	public Arena(){
		P1HP = 100*     10;//EDIT LATER
		P1MaxHP = P1HP;
		P2HP = 100*     10;
		P2MaxHP = P2HP;
		maxSuper = 1000;
		maxUltra = 500;
		P1Ultra = 0;
		P2Ultra = 0;
		P1Super = 0;
		P2Super = 0;
		distance = 2;
		P2Air = 0;
		P1Air = 0;
		P1Name = "Player ONE";
		P2Name = "Player TWO";
	}

	
//	public static void main(String[] args){
//				
//		Character p1 = new Character();
//		Character p2 = new Character();
//		System.out.println(p1.name);
//		
//		Arena menu = new Arena();
//		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		menu.setTitle("Character Select");
//        menu.setSize(1024, 400);
//        menu.setVisible(true);
//        ButtonListener listener = menu.Select(g);
//        
//        while( p1.name == "uninitialized" || p2.name =="uninitialized") {
//        	System.out.println("ROCK AND ROLL");
//        	
//        
//	        if(listener.variable == 1 && p1.name == "uninitialized"){
//	        	System.out.println("P1 = RYU");
//	        	listener.variable = 0;
//	        	p1 = new Ryu();
//	        }
//	        else if(listener.variable == 2 && p1.name == "uninitialized"){
//	        	System.out.println("P1 = ABEL");
//	        	listener.variable = 0;
//	        	p1 = new Abel();
//	        }
//	        else if(listener.variable == 3 && p1.name == "uninitialized"){
//	        	System.out.println("P1 = FEI LONG");
//	        	listener.variable = 0;
//	        	p1 = new FeiLong();
//	        }
//	        else if(listener.variable == 4 && p1.name == "uninitialized"){
//	        	System.out.println("P1 = KEN");
//	        	listener.variable = 0;
//	        	p1 = new Ken();
//	        }
//	        else if(listener.variable == 5 && p1.name == "uninitialized"){
//	        	System.out.println("P1 = DHALSIM");
//	        	listener.variable = 0;
//	        	p1 = new Dhalsim();
//	        }
//	        else if(listener.variable == 6 && p1.name == "uninitialized"){
//	        	System.out.println("P1 = CHUN LI");
//	        	listener.variable = 0;
//	        	p1 = new ChunLi();
//	        }
//	        else if(listener.variable == 7 && p1.name == "uninitialized"){
//	        	System.out.println("P1 = ZANGIEF");
//	        	listener.variable = 0;
//	        	p1 = new Zangief();
//	        }
//        	else if(listener.variable == 8 && p1.name == "uninitialized"){
//        		System.out.println("P1 = DUDLEY");
//        		listener.variable = 0;
//        		p1 = new Dudley();
//        	}
//        	else if(listener.variable == 9 && p1.name == "uninitialized"){
//        		System.out.println("P1 = CAMMY");
//        		listener.variable = 0;
//        		p1 = new Cammy();
//        	}
//        	else if(listener.variable == 1 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//	        	System.out.println("p2 = RYU");
//	        	listener.variable = 0;
//	        	p2 = new Ryu();
//	        }
//	        else if(listener.variable == 2 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//	        	System.out.println("p2 = ABEL");
//	        	listener.variable = 0;
//	        	p2 = new Abel();
//	        }
//	        else if(listener.variable == 3 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//	        	System.out.println("p2 = FEI LONG");
//	        	listener.variable = 0;
//	        	p2 = new FeiLong();
//	        }
//	        else if(listener.variable == 4 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//	        	System.out.println("p2 = KEN");
//	        	listener.variable = 0;
//	        	p2 = new Ken();
//	        }
//	        else if(listener.variable == 5 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//	        	System.out.println("p2 = DHALSIM");
//	        	listener.variable = 0;
//	        	p2 = new Dhalsim();
//	        }
//	        else if(listener.variable == 6 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//	        	System.out.println("p2 = CHUN LI");
//	        	listener.variable = 0;
//	        	p2 = new ChunLi();
//	        }
//	        else if(listener.variable == 7 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//	        	System.out.println("p2 = ZANGIEF");
//	        	listener.variable = 0;
//	        	p2 = new Zangief();
//	        }
//        	else if(listener.variable == 8 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//        		System.out.println("p2 = DUDLEY");
//        		listener.variable = 0;
//        		p2 = new Dudley();
//        	}
//        	else if(listener.variable == 9 && p1.name != "uninitialized" && p2.name == "uninitialized"){
//        		System.out.println("p2 = CAMMY");
//        		listener.variable = 0;
//        		p2 = new Cammy();
//        	}
//        }
//        System.out.println(p1.name+ "vs" + p2.name);
//        
//        
//        try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//        
//		Arena arena = new Arena();
//		arena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		ButtonListener2 listener2 = menu.init(g, p1, p2);
//		System.out.println("listener.variable");
//		System.out.println(arena.P1HP-1);
//		arena.P1HP = p1.HP;
//		arena.P1MaxHP = p1.MaxHP;
//		arena.P1Name = p1.name;
//		arena.P2HP = p2.HP;
//		arena.P2MaxHP = p2.MaxHP;
//		arena.P2Name = p2.name;
//		arena.add(new GUI(arena, listener2, p1, p2));
//		System.out.println(arena.P1HP-5);
//		
//		
//        arena.setTitle("Training Stage");
//        arena.setSize(1024, 300);
//        arena.setVisible(true);
//        menu.setTitle("Interface");
//        menu.setSize(1024, 400);
//        menu.setVisible(true);
//        
//
//    }	
	

	public ButtonListener Select(Graphics g){
		
		
		ButtonListener aListener = new ButtonListener();
		
		grid[0][0]  = new JButton("Ryu");
		grid[0][0].setActionCommand(""+1);
		grid[0][0].setBackground(Color.white);
		grid[0][0].setMinimumSize(new Dimension(200, 50));
		grid[0][0].setMaximumSize(new Dimension(200, 50));
		grid[0][0].setPreferredSize(new Dimension(200, 50));
		grid[0][0].addActionListener(aListener);
		
		grid[0][1]  = new JButton("Ken");
		grid[0][1].setActionCommand(""+4);
		grid[0][1].setBackground(Color.white);
		grid[0][1].setMinimumSize(new Dimension(200, 50));
		grid[0][1].setMaximumSize(new Dimension(200, 50));
		grid[0][1].setPreferredSize(new Dimension(200, 50));
		grid[0][1].addActionListener(aListener);
		
		grid[0][2]  = new JButton("Zangief");
		grid[0][2].setActionCommand(""+7);
		grid[0][2].setBackground(Color.white);
		grid[0][2].setMinimumSize(new Dimension(200, 50));
		grid[0][2].setMaximumSize(new Dimension(200, 50));
		grid[0][2].setPreferredSize(new Dimension(200, 50));
		grid[0][2].addActionListener(aListener);
		
		grid[1][0]  = new JButton("Abel");
		grid[1][0].setActionCommand(""+2);
		grid[1][0].setBackground(Color.white);
		grid[1][0].setMinimumSize(new Dimension(200, 50));
		grid[1][0].setMaximumSize(new Dimension(200, 50));
		grid[1][0].setPreferredSize(new Dimension(200, 50));
		grid[1][0].addActionListener(aListener);
		
		grid[1][1]  = new JButton("Dhalsim");
		grid[1][1].setActionCommand(""+5);
		grid[1][1].setBackground(Color.white);
		grid[1][1].setMinimumSize(new Dimension(200, 50));
		grid[1][1].setMaximumSize(new Dimension(200, 50));
		grid[1][1].setPreferredSize(new Dimension(200, 50));
		grid[1][1].addActionListener(aListener);
		
		grid[1][2]  = new JButton("Dudley");
		grid[1][2].setActionCommand(""+8);
		grid[1][2].setBackground(Color.white);
		grid[1][2].setMinimumSize(new Dimension(200, 50));
		grid[1][2].setMaximumSize(new Dimension(200, 50));
		grid[1][2].setPreferredSize(new Dimension(200, 50));
		grid[1][2].addActionListener(aListener);
		
		grid[2][0]  = new JButton("Fei Long");
		grid[2][0].setActionCommand(""+3);
		grid[2][0].setBackground(Color.white);
		grid[2][0].setMinimumSize(new Dimension(200, 50));
		grid[2][0].setMaximumSize(new Dimension(200, 50));
		grid[2][0].setPreferredSize(new Dimension(200, 50));
		grid[2][0].addActionListener(aListener);
		
		grid[2][1]  = new JButton("Chun Li");
		grid[2][1].setActionCommand(""+6);
		grid[2][1].setBackground(Color.white);
		grid[2][1].setMinimumSize(new Dimension(200, 50));
		grid[2][1].setMaximumSize(new Dimension(200, 50));
		grid[2][1].setPreferredSize(new Dimension(200, 50));
		grid[2][1].addActionListener(aListener);
		
		grid[2][2]  = new JButton("Cammy");
		grid[2][2].setActionCommand(""+9);
		grid[2][2].setBackground(Color.white);
		grid[2][2].setMinimumSize(new Dimension(200, 50));
		grid[2][2].setMaximumSize(new Dimension(200, 50));
		grid[2][2].setPreferredSize(new Dimension(200, 50));
		grid[2][2].addActionListener(aListener);

		
		
        // create top boxes to force centering
        Box vBox = Box.createVerticalBox();
        Box row1 = Box.createHorizontalBox();
        Box row2 = Box.createHorizontalBox();
        Box row3 = Box.createHorizontalBox();
        
        DisplayText = new TextField("Choose your character.");
        DisplayText.setEditable(false);
        // Add top box to frame and set background color
        topPane = this.getContentPane();
        topPane.add(vBox);
        topPane.setBackground(Color.black);
        System.out.println("GO");
       
       //add the rows to the top box and add a 10 pixel space between each 
        vBox.add(DisplayText);
        System.out.println("GO");
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row1);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row2);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row3);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        // put buttons in boxes spaced 10 pixels apart
        // row 1
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[0][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[1][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[2][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        //row 2
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[0][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[1][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[2][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        
        // row 3
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[0][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[1][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[2][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(Box.createVerticalGlue());
        System.out.println("GO");
        return aListener;
	}

	
	
	public ButtonListener2 init(Graphics g, Character p1, Character p2){
		
		
		ButtonListener2 bListener = new ButtonListener2();
		int boxNum = 1;
		
		for (int r = 0; r < 6; r++)
        {
            for (int c = 0; c < 5; c++)
            {
                grid[c][r] = new JButton(p1.moves[boxNum - 1].name /*+ boxNum*/);
                grid[c][r].setActionCommand(""+boxNum);
                grid[c][r].setBackground(Color.white);
                grid[c][r].setMaximumSize(new Dimension(190, 25));
                grid[c][r].setMinimumSize(new Dimension(190, 25));
                grid[c][r].setPreferredSize(new Dimension(190, 25));
                grid[c][r].addActionListener(bListener);
                boxNum++;
            }
        }
		
		
        // create top boxes to force centering
        Box vBox = Box.createVerticalBox();
        Box row1 = Box.createHorizontalBox();
        Box row2 = Box.createHorizontalBox();
        Box row3 = Box.createHorizontalBox();
        Box row4 = Box.createHorizontalBox();
        Box row5 = Box.createHorizontalBox();
        Box row6 = Box.createHorizontalBox();
        
        DisplayText = new TextField("Choose An Attack. (And move this window down if you haven't already!)");
        DisplayText.setEditable(false);
        bListener.text= DisplayText;
        // Add top box to frame and set background color
        topPane.removeAll();
        topPane = this.getContentPane();
        
        topPane.add(vBox);
        topPane.setBackground(Color.black);
        
       
       //add the rows to the top box and add a 10 pixel space between each 
        vBox.add(DisplayText);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row1);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row2);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row3);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row4);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row5);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(row6);
        vBox.add(Box.createRigidArea(new Dimension(10, 10)));

        // put buttons in boxes spaced 10 pixels apart
        // row 1
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[0][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[1][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[2][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[3][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        row1.add(grid[4][0]);
        row1.add(Box.createRigidArea(new Dimension(10, 10)));
        //row 2
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[0][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[1][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[2][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[3][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        row2.add(grid[4][1]);
        row2.add(Box.createRigidArea(new Dimension(10, 10)));
        // row 3
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[0][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[1][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[2][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[3][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        row3.add(grid[4][2]);
        row3.add(Box.createRigidArea(new Dimension(10, 10)));
        // row 4
        row4.add(Box.createRigidArea(new Dimension(10, 10)));
        row4.add(grid[0][3]);
        row4.add(Box.createRigidArea(new Dimension(10, 10)));
        row4.add(grid[1][3]);
        row4.add(Box.createRigidArea(new Dimension(10, 10)));
        row4.add(grid[2][3]);
        row4.add(Box.createRigidArea(new Dimension(10, 10)));
        row4.add(grid[3][3]);
        row4.add(Box.createRigidArea(new Dimension(10, 10)));
        row4.add(grid[4][3]);
        row4.add(Box.createRigidArea(new Dimension(10, 10)));
        //row 5
        row5.add(Box.createRigidArea(new Dimension(10, 10)));
        row5.add(grid[0][4]);
        row5.add(Box.createRigidArea(new Dimension(10, 10)));
        row5.add(grid[1][4]);
        row5.add(Box.createRigidArea(new Dimension(10, 10)));
        row5.add(grid[2][4]);
        row5.add(Box.createRigidArea(new Dimension(10, 10)));
        row5.add(grid[3][4]);
        row5.add(Box.createRigidArea(new Dimension(10, 10)));
        row5.add(grid[4][4]);
        row5.add(Box.createRigidArea(new Dimension(10, 10)));
        //row 6
        row6.add(Box.createRigidArea(new Dimension(10, 10)));
        row6.add(grid[0][5]);
        row6.add(Box.createRigidArea(new Dimension(10, 10)));
        row6.add(grid[1][5]);
        row6.add(Box.createRigidArea(new Dimension(10, 10)));
        row6.add(grid[2][5]);
        row6.add(Box.createRigidArea(new Dimension(10, 10)));
        row6.add(grid[3][5]);
        row6.add(Box.createRigidArea(new Dimension(10, 10)));
        row6.add(grid[4][5]);
        row6.add(Box.createRigidArea(new Dimension(10, 10)));
        vBox.add(Box.createVerticalGlue());
        return bListener;
	}
	class ButtonListener implements ActionListener{
		
		int variable;
		
        public void actionPerformed(ActionEvent bpressed){
        	DisplayText.setText("Choose an opponent.");
        	
        	System.out.println(bpressed.getActionCommand()+ "was pressed");
        	
        	if(bpressed.getActionCommand().equals("1")){
        		variable = 1;	
        	}
        	if(bpressed.getActionCommand().equals("2")){
        		variable = 2;	
        	}
        	if(bpressed.getActionCommand().equals("3")){
        		variable = 3;	
        	}
        	if(bpressed.getActionCommand().equals("4")){
        		variable = 4;	
        	}
        	if(bpressed.getActionCommand().equals("5")){
        		variable = 5;	
        	}
        	if(bpressed.getActionCommand().equals("6")){
        		variable = 6;	
        	}
        	if(bpressed.getActionCommand().equals("7")){
        		variable = 7;	
        	}
        	if(bpressed.getActionCommand().equals("8")){
        		variable = 8;	
        	}
        	if(bpressed.getActionCommand().equals("9")){
        		variable = 9;	
        	}
        	if(bpressed.getActionCommand().equals("10")){
        		variable = 10;	
        	}
        	if(bpressed.getActionCommand().equals("11")){
        		variable = 11;	
        	}
        	if(bpressed.getActionCommand().equals("12")){
        		variable = 12;	
        	}
        	if(bpressed.getActionCommand().equals("13")){
        		variable = 13;	
        	}
        	if(bpressed.getActionCommand().equals("14")){
        		variable = 14;	
        	}
        	if(bpressed.getActionCommand().equals("15")){
        		variable = 15;	
        	}
        	if(bpressed.getActionCommand().equals("16")){
        		variable = 16;	
        	}
        	if(bpressed.getActionCommand().equals("17")){
        		variable = 17;	
        	}
        	if(bpressed.getActionCommand().equals("18")){
        		variable = 18;	
        	}
        	if(bpressed.getActionCommand().equals("19")){
        		variable = 19;	
        	}
        	if(bpressed.getActionCommand().equals("20")){
        		variable = 20;	
        	}
        	if(bpressed.getActionCommand().equals("21")){
        		variable = 21;	
        	}
        	if(bpressed.getActionCommand().equals("22")){
        		variable = 22;	
        	}
        	if(bpressed.getActionCommand().equals("23")){
        		variable = 23;	
        	}
        	if(bpressed.getActionCommand().equals("24")){
        		variable = 24;	
        	}
        	if(bpressed.getActionCommand().equals("25")){
        		variable = 25;	
        	}
        	if(bpressed.getActionCommand().equals("26")){
        		variable = 26;	
        	}
        	if(bpressed.getActionCommand().equals("27")){
        		variable = 27;	
        	}
        	if(bpressed.getActionCommand().equals("28")){
        		variable = 28;	
        	}
        	if(bpressed.getActionCommand().equals("29")){
        		variable = 29;	
        	}
        	if(bpressed.getActionCommand().equals("30")){
        		variable = 30;	
        	}
        	if(bpressed.getActionCommand().equals("31")){
        		variable = 31;	
        	}
        	if(bpressed.getActionCommand().equals("32")){
        		variable = 32;	
        	}
        	if(bpressed.getActionCommand().equals("33")){
        		variable = 33;	
        	}
        	if(bpressed.getActionCommand().equals("34")){
        		variable = 34;	
        	}
        	if(bpressed.getActionCommand().equals("35")){
        		variable = 35;	
        	}
        	if(bpressed.getActionCommand().equals("36")){
        		variable = 36;	
        	}
        	if(bpressed.getActionCommand().equals("37")){
        		variable = 37;	
        	}
        	if(bpressed.getActionCommand().equals("38")){
        		variable = 38;	
        	}
        	if(bpressed.getActionCommand().equals("39")){
        		variable = 39;	
        	}
        	if(bpressed.getActionCommand().equals("40")){
        		variable = 40;	
        	}
        	if(bpressed.getActionCommand().equals("41")){
        		variable = 41;	
        	}
        	if(bpressed.getActionCommand().equals("42")){
        		variable = 42;	
        	}
        	if(bpressed.getActionCommand().equals("43")){
        		variable = 43;	
        	}
        	if(bpressed.getActionCommand().equals("44")){
        		variable = 44;	
        	}
        	if(bpressed.getActionCommand().equals("45")){
        		variable = 45;	
        	}
        	if(bpressed.getActionCommand().equals("46")){
        		variable = 46;	
        	}
        	if(bpressed.getActionCommand().equals("47")){
        		variable = 47;	
        	}
        	if(bpressed.getActionCommand().equals("48")){
        		variable = 48;	
        	}
        	if(bpressed.getActionCommand().equals("49")){
        		variable = 49;	
        	}
        	if(bpressed.getActionCommand().equals("50")){
        		variable = 50;	
        	}
        	if(bpressed.getActionCommand().equals("51")){
        		variable = 51;	
        	}
        	if(bpressed.getActionCommand().equals("52")){
        		variable = 52;	
        	}
        	if(bpressed.getActionCommand().equals("53")){
        		variable = 53;	
        	}
        	if(bpressed.getActionCommand().equals("54")){
        		variable = 54;	
        	}
        	if(bpressed.getActionCommand().equals("55")){
        		variable = 55;	
        	}
        	if(bpressed.getActionCommand().equals("56")){
        		variable = 56;	
        	}
        	if(bpressed.getActionCommand().equals("57")){
        		variable = 57;	
        	}
        	if(bpressed.getActionCommand().equals("58")){
        		variable = 58;	
        	}
        	if(bpressed.getActionCommand().equals("59")){
        		variable = 59;	
        	}
        	if(bpressed.getActionCommand().equals("60")){
        		variable = 60;	
        	}
        	
        	
        }
          
	}
	class ButtonListener2 implements ActionListener{
  		
  		int variable;
  		TextField text;
  		
        public void actionPerformed(ActionEvent bpressed){
          	
          	
          	System.out.println(bpressed.getActionCommand()+ "was pressed");
          	
          	if(bpressed.getActionCommand().equals("1")){
          		variable = 1;	
          	}
          	if(bpressed.getActionCommand().equals("2")){
          		variable = 2;	
          	}
          	if(bpressed.getActionCommand().equals("3")){
          		variable = 3;	
          	}
          	if(bpressed.getActionCommand().equals("4")){
          		variable = 4;	
          	}
          	if(bpressed.getActionCommand().equals("5")){
          		variable = 5;	
          	}
          	if(bpressed.getActionCommand().equals("6")){
          		variable = 6;	
          	}
          	if(bpressed.getActionCommand().equals("7")){
          		variable = 7;	
          	}
          	if(bpressed.getActionCommand().equals("8")){
          		variable = 8;	
          	}
          	if(bpressed.getActionCommand().equals("9")){
          		variable = 9;	
          	}
          	if(bpressed.getActionCommand().equals("10")){
          		variable = 10;	
          	}
          	if(bpressed.getActionCommand().equals("11")){
          		variable = 11;	
          	}
          	if(bpressed.getActionCommand().equals("12")){
          		variable = 12;	
          	}
          	if(bpressed.getActionCommand().equals("13")){
          		variable = 13;	
          	}
          	if(bpressed.getActionCommand().equals("14")){
          		variable = 14;	
          	}
          	if(bpressed.getActionCommand().equals("15")){
          		variable = 15;	
          	}
          	if(bpressed.getActionCommand().equals("16")){
          		variable = 16;	
          	}
          	if(bpressed.getActionCommand().equals("17")){
          		variable = 17;	
          	}
          	if(bpressed.getActionCommand().equals("18")){
          		variable = 18;	
          	}
          	if(bpressed.getActionCommand().equals("19")){
          		variable = 19;	
          	}
          	if(bpressed.getActionCommand().equals("20")){
          		variable = 20;	
          	}
          	if(bpressed.getActionCommand().equals("21")){
          		variable = 21;	
          	}
          	if(bpressed.getActionCommand().equals("22")){
          		variable = 22;	
          	}
          	if(bpressed.getActionCommand().equals("23")){
          		variable = 23;	
          	}
          	if(bpressed.getActionCommand().equals("24")){
          		variable = 24;	
          	}
          	if(bpressed.getActionCommand().equals("25")){
          		variable = 25;	
          	}
          	if(bpressed.getActionCommand().equals("26")){
          		variable = 26;	
          	}
          	if(bpressed.getActionCommand().equals("27")){
          		variable = 27;	
          	}
          	if(bpressed.getActionCommand().equals("28")){
          		variable = 28;	
          	}
          	if(bpressed.getActionCommand().equals("29")){
          		variable = 29;	
          	}
          	if(bpressed.getActionCommand().equals("30")){
          		variable = 30;	
          	}
          	if(bpressed.getActionCommand().equals("31")){
          		variable = 31;	
          	}
          	if(bpressed.getActionCommand().equals("32")){
          		variable = 32;	
          	}
          	if(bpressed.getActionCommand().equals("33")){
          		variable = 33;	
          	}
          	if(bpressed.getActionCommand().equals("34")){
          		variable = 34;	
          	}
          	if(bpressed.getActionCommand().equals("35")){
          		variable = 35;	
          	}
          	if(bpressed.getActionCommand().equals("36")){
          		variable = 36;	
          	}
          	if(bpressed.getActionCommand().equals("37")){
          		variable = 37;	
          	}
          	if(bpressed.getActionCommand().equals("38")){
          		variable = 38;	
          	}
          	if(bpressed.getActionCommand().equals("39")){
          		variable = 39;	
          	}
          	if(bpressed.getActionCommand().equals("40")){
          		variable = 40;	
          	}
          	if(bpressed.getActionCommand().equals("41")){
          		variable = 41;	
          	}
          	if(bpressed.getActionCommand().equals("42")){
          		variable = 42;	
          	}
          	if(bpressed.getActionCommand().equals("43")){
          		variable = 43;	
          	}
          	if(bpressed.getActionCommand().equals("44")){
          		variable = 44;	
          	}
          	if(bpressed.getActionCommand().equals("45")){
          		variable = 45;	
          	}
          	if(bpressed.getActionCommand().equals("46")){
          		variable = 46;	
          	}
          	if(bpressed.getActionCommand().equals("47")){
          		variable = 47;	
          	}
          	if(bpressed.getActionCommand().equals("48")){
          		variable = 48;	
          	}
          	if(bpressed.getActionCommand().equals("49")){
          		variable = 49;	
          	}
          	if(bpressed.getActionCommand().equals("50")){
          		variable = 50;	
          	}
          	if(bpressed.getActionCommand().equals("51")){
          		variable = 51;	
          	}
          	if(bpressed.getActionCommand().equals("52")){
          		variable = 52;	
          	}
          	if(bpressed.getActionCommand().equals("53")){
          		variable = 53;	
          	}
          	if(bpressed.getActionCommand().equals("54")){
          		variable = 54;	
          	}
          	if(bpressed.getActionCommand().equals("55")){
          		variable = 55;	
          	}
          	if(bpressed.getActionCommand().equals("56")){
          		variable = 56;	
          	}
          	if(bpressed.getActionCommand().equals("57")){
          		variable = 57;	
          	}
          	if(bpressed.getActionCommand().equals("58")){
          		variable = 58;	
          	}
          	if(bpressed.getActionCommand().equals("59")){
          		variable = 59;	
          	}
          	if(bpressed.getActionCommand().equals("60")){
          		variable = 60;	
          	}
          	
          	
        }
        public int random(){
    		SecureRandom randomGenerator = new SecureRandom();
    		
    		int random = randomGenerator.nextInt();
    		random = Math.abs( random);
    		random = random%30;
    		return random;
    	}
	}
}