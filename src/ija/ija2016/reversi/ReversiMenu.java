package ija.ija2016.reversi;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ReversiMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int size = 8;
	
	/* false is simple AI */
	private boolean vsPlayer = false;
	
	/* Difficulty */
	private boolean easy = true;
	
	/* Freezing */
	private boolean freeze = false;

	/* Panels for redrawing main window */
	private JPanel optPanel;
	private JPanel menuPanel;
	
	/* Object used in main menu */
	private JLabel labelNAMES;
	private JLabel labelREVERSI;
	public JButton btnNewGameButton;
	public JButton btnLoadGameButton;
	private JButton btnOptionsButton;
	private JButton btnExitGameButton;
	
	/* Object used in options menu */
	private JButton btnSet;
	private JLabel labelOPT;
	private JLabel lblGame;
	private JButton btnAiOn;
	private JButton btnAiOff;
	private JLabel lblDiff;
	private JButton btnEasy;
	private JButton btnHard;
	private JLabel lblBoardSize;
	private JLabel lblFreezing;
	private JButton btnFreezOn;
	private JButton btnFreezOff;
	private JLabel lblCount;
	private JLabel lblFor;
	private JLabel lblAfter;
	private JRadioButton rdbtn6x6;
	private JRadioButton rdbtn8x8;
	private JRadioButton rdbtn10x10;
	private JRadioButton rdbtn12x12;
	
	
	JScrollBar scBarCount;	
	JScrollBar scBarFor;	
	JScrollBar scBarAfter;	
	
	public static void main(String[] args) {
		
		ReversiMenu menu = new ReversiMenu();
		
		menu.btnNewGameButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ReversiGame game = new ReversiGame(menu);
				Thread t = new Thread(game);
				t.start();
				/* ON CLICK ON NEW GAME BUTTON */
				/* ***********************************************************	
				 *  int BoardSize()	returns size;		
				 *	boolean VsPlayer()returns vsPlayer;
				 *  boolean IsDifficultyEasy()	returns true(easy) false(hard);
				 *  FreezeEnable() returns freeze;
				 *	int FreezeFor() returns Value(seconds);
				 *	int FreezeAfter() returns Value(seconds);
				 *	int FreezeCount() returns getValue(count of disks);
				 **************************************************************/
				// TODO
			}
		});
	}
	
	public ReversiMenu() {
		/* Constructor of JFrame */
		super("Reversi - Menu");
		this.pack();
		
		/* GAME LABEL REVERSI */	
		labelREVERSI = new JLabel("R E V E R S I");
		labelREVERSI.setForeground(new Color(255, 255, 255));
		labelREVERSI.setFont(new Font("Dialog", Font.BOLD, 33));
		labelREVERSI.setBounds(50, 25, 200, 30);
		
		/* SETTING UP MENU */			
		this.setResizable(false);
		this.setSize(300, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		/* AUTHORS LABEL */
		labelNAMES = new JLabel("by Patrik Segedy & Tibor Dudl�k");
		labelNAMES.setForeground(Color.WHITE);
		labelNAMES.setFont(new Font("Dialog", Font.BOLD, 11));
		labelNAMES.setBounds(110, 270, 210, 15);
		
		/* INNITIALIZATION OF NEW GAME BUTTON */
		btnNewGameButton = new JButton("New Game");
		btnNewGameButton.setBounds(50, 60, 200, 50);

		
		/* INNITIALIZATION OF LOAD GAME BUTTON */
		btnLoadGameButton = new JButton("Load Game");
		btnLoadGameButton.setBounds(50, 130, 200, 50);
		
		
		/* INNITIALIZATION OF OPTIONS BUTTON */
		btnOptionsButton = new JButton("Options");
		btnOptionsButton.setBounds(50, 200, 99, 50);

		labelOPT = new JLabel("O P T I O N S");
		labelOPT.setForeground(new Color(255, 255, 255));
		labelOPT.setFont(new Font("Dialog", Font.BOLD, 33));
		labelOPT.setBounds(50, 25, 200, 30);
		
		/* INNITIALIZATION OF LABEL SIZE */
		lblBoardSize = new JLabel("Board size:");
		lblBoardSize.setForeground(Color.WHITE);
		lblBoardSize.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblBoardSize.setBounds(30, 130, 100, 20);
				
		
		
		/* INITIALIZATION OF LABEL GAME MODE*/
		lblGame = new JLabel("Game mode PL vs:");
		lblGame.setForeground(Color.WHITE);
		lblGame.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblGame.setBounds(30, 70, 150, 20);
		
		btnAiOn = new JButton("PC");
		btnAiOn.setFont(new Font("Dialog", Font.BOLD, 8));
		btnAiOn.setBackground(Color.CYAN);
		btnAiOn.setEnabled(false);
		btnAiOn.setBounds(150, 70, 50, 20);
		btnAiOff = new JButton("PL");
		btnAiOff.setBackground(Color.WHITE);
		btnAiOff.setFont(new Font("Dialog", Font.BOLD, 8));
		btnAiOff.setBounds(200, 70, 50, 20);
		
		
		/* INITIALIZATION OF LABEL DIFFICULTY*/
		lblDiff = new JLabel("Difficulty:");
		lblDiff.setForeground(Color.WHITE);
		lblDiff.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblDiff.setBounds(30, 100, 150, 20);
		
		btnEasy = new JButton("EASY");
		btnEasy.setFont(new Font("Dialog", Font.PLAIN, 8));
		btnEasy.setBackground(Color.CYAN);
		btnEasy.setEnabled(false);
		btnEasy.setBounds(140, 100, 60, 20);
		btnHard = new JButton("HARD");
		btnHard.setBackground(Color.WHITE);
		btnHard.setFont(new Font("Dialog", Font.BOLD, 8));
		btnHard.setBounds(200, 100, 60, 20);
		
		
		/* INITIALIZATION OF LABEL FREEZE*/
		
		lblFreezing = new JLabel("Freezing:");
		lblFreezing.setForeground(Color.WHITE);
		lblFreezing.setFont(new Font("Dialog", Font.ITALIC, 13));
		lblFreezing.setBounds(130, 130, 150, 20);
		
		
		btnFreezOff = new JButton("OFF");
		btnFreezOff.setFont(new Font("Dialog", Font.BOLD, 8));
		btnFreezOff.setBackground(Color.CYAN);
		btnFreezOff.setEnabled(false);
		btnFreezOff.setBounds(235, 130, 50, 20);
		btnFreezOn = new JButton("ON");
		btnFreezOn.setBackground(Color.WHITE);
		btnFreezOn.setFont(new Font("Dialog", Font.BOLD, 8));
		btnFreezOn.setBounds(185, 130, 50, 20);
		
		
		
		/* INITIALIZATION OF LABEL COUNT AND ITS SCROLLBAR*/
		
		/* SCROLL BAR FOR COUNT OF DISKS TO FREEZE */
		scBarCount = new JScrollBar(JScrollBar.HORIZONTAL, 2, 1, 2, 7);
		scBarCount.setBounds(205, 155, 80, 17);
		scBarCount.setVisible(false);
		scBarCount.setMinimum(2);
		scBarCount.setMaximum(7);
		scBarCount.setBlockIncrement(1);
		scBarCount.setValue(2);
		
		
		/* LABEL COUNT */
		lblCount = new JLabel("Disks: "+scBarCount.getValue());
		lblCount.setForeground(Color.WHITE);
		lblCount.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblCount.setBounds(130, 155, 150, 20);
		lblCount.setVisible(false);
		
		
		/* INITIALIZATION OF LABEL FOR  AND ITS SCROLLBAR*/
		
		scBarFor = new JScrollBar(JScrollBar.HORIZONTAL, 2, 1, 2, 7);
		scBarFor.setBounds(205, 180, 80, 17);
		scBarFor.setVisible(false);
		scBarFor.setMinimum(1);
		scBarFor.setMaximum(121);
		scBarFor.setBlockIncrement(1);
		scBarFor.setValue(10);

		
		/* LABEL COUNT */
		
		lblFor = new JLabel("For 0 ~ "+scBarFor.getValue()+"s");
		lblFor.setForeground(Color.WHITE);
		lblFor.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblFor.setBounds(130, 180, 150, 20);
		lblFor.setVisible(false);
		
		
		/* INITIALIZATION OF LABEL AFTER AND ITS SCROLLBAR*/
		
		scBarAfter = new JScrollBar(JScrollBar.HORIZONTAL, 2, 1, 2, 7);
		scBarAfter.setBounds(205, 205, 80, 17);
		scBarAfter.setVisible(false);
		scBarAfter.setMinimum(1);
		scBarAfter.setMaximum(11);
		scBarAfter.setBlockIncrement(1);
		scBarAfter.setValue(5);
		
		lblAfter = new JLabel("After 0 ~ "+scBarAfter.getValue()+"s");
		lblAfter.setForeground(Color.WHITE);
		lblAfter.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblAfter.setBounds(130, 205, 150, 20);
		lblAfter.setVisible(false);
		
		
		/* INNITIALIZATION OF BUTTON IN OPTIONS */	
		btnSet = new JButton("SET !");
		btnSet.setBounds(100, 250, 100, 30);
		

		/* INITIALIZATION OF EXIT BUTTON */
		btnExitGameButton = new JButton("Exit");
		btnExitGameButton.setBounds(151, 200, 99, 50);
		
		
		/*************************************************************/

		/* INITIALIZATION OF RADIO BUTTONS */
		rdbtn6x6 = new JRadioButton("6x6");
		rdbtn6x6.setBackground(new Color(0, 128, 0));
		rdbtn6x6.setForeground(Color.WHITE);
		rdbtn6x6.setBounds(30, 150, 65, 20);
		/* INITIALIZATION OF RADIO BUTTONS */
		rdbtn8x8 = new JRadioButton("8x8");
		rdbtn8x8.setSelected(true); // default is size of board is 8
		rdbtn8x8.setBackground(new Color(0, 128, 0));
		rdbtn8x8.setForeground(Color.WHITE);
		rdbtn8x8.setBounds(30, 170, 65, 20);
		/* INITIALIZATION OF RADIO BUTTONS */
		rdbtn10x10 = new JRadioButton("10x10");
		rdbtn10x10.setBackground(new Color(0, 128, 0));
		rdbtn10x10.setForeground(Color.WHITE);
		rdbtn10x10.setBounds(30, 190, 65, 20);
		/* INITIALIZATION OF RADIO BUTTONS */
		rdbtn12x12 = new JRadioButton("12x12");
		rdbtn12x12.setBackground(new Color(0, 128, 0));
		rdbtn12x12.setForeground(Color.WHITE);
		rdbtn12x12.setBounds(30, 210, 65, 20);
		
		
		/* GETTING RADIO BUTTONS INTO ONE GROUP */
		ButtonGroup OptButtonGroup = new ButtonGroup(); 
		OptButtonGroup.add(rdbtn6x6);
		OptButtonGroup.add(rdbtn8x8);
		OptButtonGroup.add(rdbtn10x10);
		OptButtonGroup.add(rdbtn12x12);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBackground(new Color(0, 128, 0));
		menuPanel.setSize(300, 320);
		menuPanel.add(labelREVERSI);
		menuPanel.add(labelNAMES);
		menuPanel.add(btnNewGameButton);
		menuPanel.add(btnLoadGameButton);
		menuPanel.add(btnOptionsButton);
		menuPanel.add(btnExitGameButton);
		
		
		optPanel = new JPanel();
		optPanel.setLayout(null);
		optPanel.setBackground(new Color(0, 128, 0));
		optPanel.setSize(300, 320);
		optPanel.add(btnSet);
		optPanel.add(labelOPT);
		optPanel.add(lblGame);
		optPanel.add(btnAiOn);
		optPanel.add(btnAiOff);
		optPanel.add(lblDiff);
		optPanel.add(btnEasy);
		optPanel.add(btnHard);
		optPanel.add(lblBoardSize);
		optPanel.add(rdbtn6x6);
		optPanel.add(rdbtn8x8);
		optPanel.add(rdbtn10x10);
		optPanel.add(rdbtn12x12);
		optPanel.add(lblFreezing);
		optPanel.add(btnFreezOn);
		optPanel.add(btnFreezOff);
		optPanel.add(lblCount);
		optPanel.add(scBarCount);
		optPanel.add(lblFor);
		optPanel.add(scBarFor);
		optPanel.add(lblAfter);
		optPanel.add(scBarAfter);	
		
		
		this.getContentPane().add(menuPanel);
		this.repaint();
		
		
		
		
		this.btnLoadGameButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* ON CLICK ON LOAD GAME BUTTON */
				// TODO
			}
		});
		
		
		this.btnOptionsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/* OPNENING OPTIONS */
				OpenOptions();
			}
		});
		
		
		this.btnExitGameButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* EXITING MENU */
				System.exit(0);
			}
		});
		
		/* OPTIONS EVENTS */
		/*************************************************************/
		/* SWITCHING PANELS OPTIONS */
		
		btnSet.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* CLOSING OPTIONS */
				ExitOptions();
			}

		});		
		
		/*************************************************************/
		/* SWITCH GAME MODE */
		
		btnAiOn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* SHOW DIFFICULTY */
				ShowDiffic();
				
			}
		});
		
		btnAiOff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* HIDE DIFFICULTY */
				HideDiffic();
			}
		});
		
		/*************************************************************/
		/* SWITCHING GAME DIFFICULTY IF AI IS SET AS OPONENT */
		
		btnEasy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* EXITING MENU */
				btnEasy.setBackground(Color.CYAN);
				btnEasy.setEnabled(false);
				easy = true;
				btnHard.setEnabled(true);
				btnHard.setBackground(Color.WHITE);
			}
		});
		
		btnHard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* EXITING MENU */
				btnHard.setBackground(Color.CYAN);
				btnHard.setEnabled(false);
				easy = false;
				btnEasy.setEnabled(true);
				btnEasy.setBackground(Color.WHITE);
				
			}
		});
		
		/*************************************************************/
		/* SWITCHING FREEZING OPTIONS */
		
		btnFreezOn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* SHOW FREEZE OPTIONS */
				ShowFreeze();
				
			}
		});
		
		btnFreezOff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/* HIDE FREEZE OPTIONS */
				HideFreeze();
			}
		});
		
		/* SCROLL BARS TO SET COUNT OF DISKS TO FREEZE AFTER x SECONDS for y SECONDS */
		
		scBarCount.addAdjustmentListener(new AdjustmentListener() {

	         public void adjustmentValueChanged(AdjustmentEvent e) {
	        	 lblCount.setText("Disks: "+scBarCount.getValue());
	            }
	      });
		
		scBarFor.addAdjustmentListener(new AdjustmentListener() {

	         public void adjustmentValueChanged(AdjustmentEvent e) {
	        	 lblFor.setText("For 0 ~ "+scBarFor.getValue()+"s");
	            }
	      });
		
		scBarAfter.addAdjustmentListener(new AdjustmentListener() {

	         public void adjustmentValueChanged(AdjustmentEvent e) {
	        	 lblAfter.setText("After 0 ~ "+scBarAfter.getValue()+"s");
	            }
	      });
		
		/*************************************************************/
	}
	
	private void ShowDiffic(){
		
		btnAiOn.setBackground(Color.CYAN);
		btnAiOn.setEnabled(false);
		vsPlayer = false;
		lblDiff.setVisible(true);
		btnEasy.setVisible(true);
		btnHard.setVisible(true);
		btnAiOff.setEnabled(true);
		btnAiOff.setBackground(Color.WHITE);
	}
	
	
	
	private void HideDiffic(){
		
		btnAiOff.setBackground(Color.CYAN);
		btnAiOff.setEnabled(false);
		vsPlayer = true;
		lblDiff.setVisible(false);
		btnEasy.setVisible(false);
		btnHard.setVisible(false);
		btnAiOn.setEnabled(true);
		btnAiOn.setBackground(Color.WHITE);
	}
	
	private void ShowFreeze(){
		
		btnFreezOn.setBackground(Color.CYAN);
		btnFreezOn.setEnabled(false);
		freeze = true;
		btnFreezOff.setEnabled(true);
		btnFreezOff.setBackground(Color.WHITE);
		lblCount.setVisible(true);
		lblFor.setVisible(true);
		lblAfter.setVisible(true);
		scBarCount.setVisible(true);
		scBarFor.setVisible(true);
		scBarAfter.setVisible(true);
	}
	
	private void HideFreeze(){
		
		btnFreezOff.setBackground(Color.CYAN);
		btnFreezOff.setEnabled(false);
		freeze = false;
		btnFreezOn.setEnabled(true);
		btnFreezOn.setBackground(Color.WHITE);
		lblCount.setVisible(false);
		lblFor.setVisible(false);
		lblAfter.setVisible(false);
		scBarCount.setVisible(false);
		scBarFor.setVisible(false);
		scBarAfter.setVisible(false);
	}
	
	private void OpenOptions(){
		
		this.getContentPane().removeAll();
		this.getContentPane().add(optPanel);
		this.revalidate();
		this.repaint();
	}
	
	private void ExitOptions(){
		
		this.getContentPane().removeAll();
		this.getContentPane().add(menuPanel);
		this.revalidate();
		this.repaint();
		/* SETTING SIZE OF BOARD */
		if (rdbtn12x12.isSelected()) this.size = 12;
		if (rdbtn10x10.isSelected()) this.size = 10;
		if (rdbtn8x8.isSelected()) this.size = 8;
		if (rdbtn6x6.isSelected()) this.size = 6;

	}


	
	/* GETTERS FOR BOARD TO INITIALIZE GAME */
	
	public int getBoardSize(){
		return size;		
	}
	
	public boolean getVsPlayer(){
		return vsPlayer;
	}

	public boolean getIsDifficultyEasy(){
		return easy;
	}
	
	public boolean getFreezeEnable(){
		return freeze;
	}
	
	public int getFreezeFor(){
		return scBarFor.getValue();
	}
	
	public int getFreezeAfter(){
		return scBarAfter.getValue();
	}
	
	public int getFreezeCount(){
		return scBarCount.getValue();
	}
	
}