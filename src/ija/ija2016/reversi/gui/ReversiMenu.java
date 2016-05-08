package ija.ija2016.reversi.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import ija.ija2016.reversi.gui.ReversiGame;

import javax.swing.*;
/**
 * Class including method main
 * Extends JFrame
 * Draws main menu and options menu
 * Starting new and loaded game
 * @author Patrik Segedy 
 * @author Tibor Dudlak
 */
public class ReversiMenu extends JFrame{
    
    private static final long serialVersionUID = 6491712156407424473L;

    private static ReversiMenu menu;
    private static boolean gameLoaded = false;

    static String filepath = "";

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
    private JScrollBar scBarCount;  
    private JScrollBar scBarFor;    
    private JScrollBar scBarAfter;  
    
    /**
     * Method main.
     * Contains listeners on all main menu panel buttons.
     * @param args is not used
     */
    public static void main(String[] args) {
        
        menu = new ReversiMenu();
        
        menu.btnNewGameButton.addMouseListener(new MouseAdapter() {
            /* ON CLICK ON NEW GAME BUTTON */
            public void mouseClicked(MouseEvent e) {
                ReversiGame game = new ReversiGame(menu);
                Thread t = new Thread(game);
                t.start();
                
            }
        });
        
        menu.btnLoadGameButton.addMouseListener(new MouseAdapter() {
            private JFileChooser fc;
            

            public void mouseClicked(MouseEvent e) {
                /* ON CLICK ON LOAD GAME BUTTON */
                gameLoaded = true;
                fc = new JFileChooser();
                File workingDirectory = new File(System.getProperty("user.dir") + System.getProperty("file.separator")+ "examples");
                fc.setCurrentDirectory(workingDirectory);
                int returnVal = fc.showOpenDialog(menu);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = null;
                    try {
                        file = fc.getSelectedFile();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    if (file != null) {
                        filepath = file.getPath();
                        if(!filepath.isEmpty()){
                            ReversiGame game = new ReversiGame(menu);
                            Thread t = new Thread(game);
                            t.start();
                        }
                    }
                }
            }
        });
        
        menu.btnOptionsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                /* OPNENING OPTIONS */
                menu.OpenOptions();
            }
        });
        
        menu.btnExitGameButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                /* EXITING MENU */
                System.exit(0);
            }
        });
        
    }
    
    /**
     * Constructor of entire Frame of menu as reversiMenu
     */
    public ReversiMenu() {
        /* Constructor of JFrame */
        super("Reversi - Menu");
        this.pack();
        
        /* GAME LABEL REVERSI */    
        labelREVERSI = new JLabel("R E V E R S I");
        labelREVERSI.setForeground(new Color(255, 255, 255));
        labelREVERSI.setFont(new Font("Dialog", Font.BOLD, 29));
        labelREVERSI.setBounds(50, 25, 200, 30);
        
        /* SETTING UP MENU */           
        this.setResizable(false);
        this.setSize(300, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        /* AUTHORS LABEL */
        labelNAMES = new JLabel("by Patrik Segedy & Tibor Dudlak");
        labelNAMES.setForeground(Color.WHITE);
        labelNAMES.setFont(new Font("Dialog", Font.BOLD, 10));
        labelNAMES.setBounds(100, 270, 210, 15);
        
        /* INNITIALIZATION OF NEW GAME BUTTON */
        btnNewGameButton = new JButton("New Game");
        btnNewGameButton.setBounds(50, 60, 200, 50);
        
        /* INNITIALIZATION OF LOAD GAME BUTTON */
        btnLoadGameButton = new JButton("Load Game");
        btnLoadGameButton.setBounds(50, 130, 200, 50);
        
        /* INNITIALIZATION OF OPTIONS BUTTON */
        btnOptionsButton = new JButton("Options");
        btnOptionsButton.setBounds(50, 200, 99, 50);
        
        /* INNITIALIZATION OF LABEL OPTIONS */
        labelOPT = new JLabel("O P T I O N S");
        labelOPT.setForeground(new Color(255, 255, 255));
        labelOPT.setFont(new Font("Dialog", Font.BOLD, 27));
        labelOPT.setBounds(50, 25, 200, 30);
        
        /* INNITIALIZATION OF LABEL SIZE */
        lblBoardSize = new JLabel("Board size:");
        lblBoardSize.setForeground(Color.WHITE);
        lblBoardSize.setFont(new Font("Dialog", Font.ITALIC, 12));
        lblBoardSize.setBounds(30, 130, 100, 20);
        
        
        /* INITIALIZATION OF LABEL GAME MODE*/
        lblGame = new JLabel("Game mode PL vs:");
        lblGame.setForeground(Color.WHITE);
        lblGame.setFont(new Font("Dialog", Font.ITALIC, 12));
        lblGame.setBounds(30, 70, 150, 20);
        /* INITIALIZATION OF BUTTONS ASSOCIATED WITH AI CHOOSING */
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
        lblDiff.setFont(new Font("Dialog", Font.ITALIC, 12));
        lblDiff.setBounds(30, 100, 150, 20);
        /* INITIALIZATION OF BUTTONS ASSOCIATED WITH DIFFICULTY */
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
        lblFreezing.setFont(new Font("Dialog", Font.ITALIC, 11));
        lblFreezing.setBounds(130, 130, 150, 20);
        /* INITIALIZATION OF BUTTONS ASSOCIATED WITH FREEZE*/
        btnFreezOff = new JButton("OFF");
        btnFreezOff.setFont(new Font("Dialog", Font.BOLD, 7));
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
        lblCount.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblCount.setBounds(130, 155, 150, 20);
        lblCount.setVisible(false);     
        
        
        /* INITIALIZATION OF LABEL FOR  AND ITS SCROLLBAR*/
        /* SCROLLBAR FOR */ 
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
        lblFor.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblFor.setBounds(130, 180, 150, 20);
        lblFor.setVisible(false);
        
        
        /* INITIALIZATION OF LABEL AFTER AND ITS SCROLLBAR*/
        /* SCROLLBAR AFTER */
        scBarAfter = new JScrollBar(JScrollBar.HORIZONTAL, 2, 1, 2, 7);
        scBarAfter.setBounds(205, 205, 80, 17);
        scBarAfter.setVisible(false);
        scBarAfter.setMinimum(1);
        scBarAfter.setMaximum(11);
        scBarAfter.setBlockIncrement(1);
        scBarAfter.setValue(5);
        /* LABEL AFTER */
        lblAfter = new JLabel("After 0 ~ "+scBarAfter.getValue()+"s");
        lblAfter.setForeground(Color.WHITE);
        lblAfter.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblAfter.setBounds(130, 205, 150, 20);
        lblAfter.setVisible(false);
        
        /* INNITIALIZATION OF BUTTON IN OPTIONS */  
        btnSet = new JButton("SET !");
        btnSet.setBounds(100, 250, 100, 30);

        /* INITIALIZATION OF EXIT BUTTON */
        btnExitGameButton = new JButton("Exit");
        btnExitGameButton.setBounds(151, 200, 99, 50);
        
        /* ********************************************************** */
        
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
                
        /* OPTIONS EVENTS */
        /* ********************************************************* */
        /* SWITCHING PANELS OPTIONS */
        
        btnSet.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                /* CLOSING OPTIONS */
                ExitOptions();
            }

        });     
        
        /* ********************************************************* */ 
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
        
        /* ********************************************************* */
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
        
        /* ********************************************************* */
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
        
        /* ********************************************************* */
    }
    
    /**
     * Method for showing objects associated 
     * with option game mode on panel options.
     */
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
    
    /**
     * Method for hiding objects associated 
     * with option game mode on panel options.
     */
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
    
    /**
     * Method for showing objects associated 
     * with option freeze on panel options.
     */
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
    
    /**
     * Method for hiding objects associated 
     * with option freeze on panel options.
     */
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
    
    /**
     * Method for redrawing option panel in menu frame
     */
    private void OpenOptions(){
        
        this.getContentPane().removeAll();
        this.getContentPane().add(optPanel);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Method for redrawing menu frame and setting 
     * size of board selected in options 
     */
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
    
    /**
     * Method returning size of board selected in options.
     * @return size of board;
     *         Default value of size is 8.
     */
    public int getBoardSize(){
        return size;        
    }
    
    /**
     * Method returning player 2 opponent selected in options.
     * Default
     * @return <code>true</code> - when human is set;
     *         <code>false</code> - when simple AI is set;
     *         Default is <code>true</code>.
     */
    public boolean getVsPlayer(){
        return vsPlayer;
    }
    
    /**
     * Method returning AI difficulty selected in options.
     * @return <code>true</code> - when easy is set;
     *         <code>false</code> - when hard is set.
     *         Default is <code>true</code>.
     */
    public boolean getIsDifficultyEasy(){
        return easy;
    }
    
    /**
     * Method returning freezing option selected in options.
     * @return <code>true</code> - when freezing is enabled;
     *         <code>false</code> - when freezing is disabled;
     *         Default is <code>false</code>.
     */
    public boolean getFreezeEnable(){
        return freeze;
    }
    
    /**
     * Method returning upper border of interval. 
     * From this interval is generated random number,
     * which represents time in seconds for these disks 
     * to be freezed for.
     * @return size of board;
     *         Default is 10.
     */
    public int getFreezeFor(){
        return scBarFor.getValue();
    }
    
    /**
     * Method returning upper border of interval. 
     * From this interval is generated random number,
     * which represents time in seconds after  disks 
     * are about to freeze.
     * @return size of board;
     *         Default is 5.
     */
    public int getFreezeAfter(){
        return scBarAfter.getValue();
    }
    
    /**
     * Method returning desired count of disks to freeze. 
     * @return count of disks;
     *         Default is 2.
     */
    public int getFreezeCount(){
        return scBarCount.getValue();
    }
    
    /**
     * Method returning information that represent 
     * whether game was loaded or not.
     * @return <code>true</code> - when game was loaded;
     *         <code>false</code> - when game was not loaded;
     *         Default is <code>false</code>.
     */
    public boolean isGameLoaded() {
        return gameLoaded;
    }
    
    /**
     * Method returning file path to saved game. 
     * @return file path.
     */
    public String getFilepath() {
        return filepath;
    }
    
    /**
     * Method setting information that represent 
     * whether game was loaded or not.
     * @param gameLoaded represents information.
     */
    public static void setGameLoaded(boolean gameLoaded) {
        ReversiMenu.gameLoaded = gameLoaded;
    }
    
}