package ija.ija2016.reversi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import ija.ija2016.reversi.ai.Ai;
import ija.ija2016.reversi.ai.AiEasy;
import ija.ija2016.reversi.ai.AiHard;
import ija.ija2016.reversi.board.Board;
import ija.ija2016.reversi.game.Game;
import ija.ija2016.reversi.game.Player;
import ija.ija2016.reversi.game.ReversiRules;
import ija.ija2016.reversi.gui.Cell;
import ija.ija2016.reversi.gui.ReversiMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.ComponentOrientation;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.Insets;
import java.util.Timer;

public class ReversiGame extends JFrame implements MouseListener, Runnable, ActionListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8291243908727050910L;
	private int size;
	private JPanel contentPane;
	private List<Cell> cells = new ArrayList<Cell>();
	private ReversiMenu menu;
	private ReversiRules rules;
	private Board board;
	private Game game;
	private Player p1;
	private Player p2;
	private int wCount;
	private int bCount;
	private boolean humanPlayer;
	private boolean easyDifficulty;
	private boolean isFreeze;
	private int nrFreezed;
	private int freezeFor;
	private int freezeAfter;
	private JLabel lblScoreWhite;
	private JLabel lblScoreBlack;
	private JLabel lblTurn;
	private JButton btnSaveGame;
	private JButton btnUndo;
	private JFileChooser fc;
	private String savedGamePath = "";
	private ReversiGame frame;
	private Ai computer;
	private Random r;
	private Timer timer;

	/**
	 * Launch the application.
	 */
	
	@Override
	public void run() {
		try {
			frame = new ReversiGame(menu);
			frame.setVisible(true);
			frame.pack();
			menu.setGameLoaded(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ReversiGame(ReversiMenu menu) {
		
		this.menu = menu;
		this.size = menu.getBoardSize();
		this.humanPlayer = menu.getVsPlayer();
		this.easyDifficulty = menu.getIsDifficultyEasy();
		this.isFreeze = menu.getFreezeEnable();
		this.nrFreezed = menu.getFreezeCount();
		this.freezeFor = menu.getFreezeFor();
		this.freezeAfter = menu.getFreezeAfter();
		
		rules = new ReversiRules(size);
		board = new Board(rules);
		game = new Game(board);
		
		p1 = new Player(true);
        p2 = new Player(false);
        
        game.addPlayer(p1);
        game.addPlayer(p2);
        
        fc = new JFileChooser();
        r = new Random();
        timer = new Timer();
        
        serialize(game, "game-undo.ser");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 460);
		contentPane = new JPanel();
		this.addMouseListener(this);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(true);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblTurn = new JLabel("Turn: White");
		contentPane.add(lblTurn, BorderLayout.SOUTH);
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel btnPanel = new JPanel();
		topPanel.add(btnPanel, BorderLayout.EAST);
		
		btnUndo = new JButton("Undo");
		btnUndo.addActionListener(this);
		btnUndo.setEnabled(false);
		btnPanel.add(btnUndo);
		
		btnSaveGame = new JButton("Save Game");
		btnSaveGame.addActionListener(this);
		btnPanel.add(btnSaveGame);
		
		JPanel scorePanel = new JPanel();
		topPanel.add(scorePanel, BorderLayout.CENTER);
		scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension(170, 60));
		splitPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scorePanel.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(75, 30));
		panel.setPreferredSize(new Dimension(80, 30));
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblWhite = new JLabel("White");
		GridBagConstraints gbc_lblWhite = new GridBagConstraints();
		gbc_lblWhite.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhite.gridx = 0;
		gbc_lblWhite.gridy = 0;
		panel.add(lblWhite, gbc_lblWhite);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		panel.add(separator, gbc_separator);
		
		lblScoreWhite = new JLabel("Score: 0");
		GridBagConstraints gbc_lblScoreWhite = new GridBagConstraints();
		gbc_lblScoreWhite.insets = new Insets(0, 0, 5, 0);
		gbc_lblScoreWhite.gridx = 0;
		gbc_lblScoreWhite.gridy = 2;
		panel.add(lblScoreWhite, gbc_lblScoreWhite);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(75, 30));
		panel_1.setPreferredSize(new Dimension(80, 30));
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[] {0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblBlack = new JLabel("Black");
		GridBagConstraints gbc_lblBlack = new GridBagConstraints();
		gbc_lblBlack.insets = new Insets(0, 0, 5, 0);
		gbc_lblBlack.gridx = 0;
		gbc_lblBlack.gridy = 0;
		panel_1.add(lblBlack, gbc_lblBlack);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 1;
		panel_1.add(separator_1, gbc_separator_1);
		
		lblScoreBlack = new JLabel("Score: 0");
		GridBagConstraints gbc_lblScoreBlack = new GridBagConstraints();
		gbc_lblScoreBlack.insets = new Insets(0, 0, 5, 0);
		gbc_lblScoreBlack.gridx = 0;
		gbc_lblScoreBlack.gridy = 2;
		panel_1.add(lblScoreBlack, gbc_lblScoreBlack);
		this.setResizable(false);
		this.setTitle("Reversi");
		
		if (menu.isGameLoaded()) {
			deserialize(menu.getFilepath());
		}
		
		if (! this.humanPlayer) {
			if(this.easyDifficulty){
				this.computer = new AiEasy();
			}else {
				this.computer = new AiHard(); 
			}
		}
		
		setGrid(game);
		printScore();

		if (isFreeze) {
			freeze();
		}
		
	}
	
	private void serialize(Object o, String filepath) {
        try
        {
           FileOutputStream fileOut =
           new FileOutputStream(filepath);
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(o);
           out.close();
           fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
	}
	/**
	 * Deserialize object from file
	 * @param filepath path to the file
	 */
	public void deserialize(String filepath) {
		try
	      {
	         FileInputStream fileIn = new FileInputStream(filepath);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         this.game = (Game) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Game class not found");
	         c.printStackTrace();
	         return;
	      }
	}
	
	private void setGrid(Game game) {
		JPanel panel = new JPanel();
		int count = 0;
	    panel.setBackground(Color.darkGray);
	    //panel.setSize(300,300);
	    GridLayout layout = new GridLayout(game.getBoard().getSize(),game.getBoard().getSize());
	    layout.setHgap(2);
	    layout.setVgap(2);
	    
	    panel.setLayout(layout);    

	    for (int i = 1; i <= game.getBoard().getSize(); i++) {
	  	  for (int j = 1; j <= game.getBoard().getSize(); j++) {
	    	  cells.add(new Cell(game, i, j));
	  		  panel.add(cells.get(count));
	    	  count++;
	  	  }
	    }
	    for (Cell cell : cells) {
			cell.addMouseListener(this);
		}
	    contentPane.add(panel);
	}
	
	public void printScore() {
		wCount = 0;
		bCount = 0;
		for (Cell cell : cells) {
			if (!cell.isEmpty()) {
				if (cell.isWhite()) {
					wCount++;
				} else {
					bCount++;
				}
			}
		}
		lblScoreWhite.setText("Score: " + wCount);
		lblScoreBlack.setText("Score: " + bCount);
		if (game.currentPlayer().isWhite()) {
			lblTurn.setText("Turn: White");
		} else 
			lblTurn.setText("Turn: Black");
	}
	
	public void freeze() {
		//nrFreezed
		//freezeFor
		List<Cell> occupiedCells = new ArrayList<Cell>();
		for (Cell cell : cells) {
			if (!cell.isEmpty()) {
				occupiedCells.add(cell);
			}
		}
		int diskCount = wCount + bCount;
		int index;
		if (diskCount/2 <= nrFreezed) {
			nrFreezed = r.nextInt(diskCount/2 + 1) - 1;
		}
		System.out.println("-----------");
		System.out.println(nrFreezed);
		System.out.println("-----------");
		for (int i = 0; i < nrFreezed; i++) {
			index = r.nextInt(occupiedCells.size());
			occupiedCells.get(index).freeze(game, true);
			occupiedCells.remove(index);
		}	
	}
	
	public boolean isGameOver() {
		if ((wCount + bCount) == (size*size))
			return true;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (p1.canPutDisk(game.getBoard().getField(i, j)))
					return false;
				else if (p2.canPutDisk(game.getBoard().getField(i, j)))
					return false;
			}
		}
		return true;	
	}
	
	public boolean switchPlayer(Player player) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (player.canPutDisk(game.getBoard().getField(i, j)))
					return false;
			}
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Cell cell : cells) {
			if (e.getSource() == cell) {
				if(cell.canPutDisk(game)) {
					serialize(game, "game-undo.ser");
					cell.putDisk(game);
					game.nextPlayer();
					btnUndo.setEnabled(true);
				}					
				for (Cell cell2 : cells) {
					cell2.actualize(game);
				}	
				break;
			}
		}
		if (!switchPlayer(game.currentPlayer())) {
			if (!humanPlayer && ! game.currentPlayer().isWhite()) {
				this.computer.makeMove(game);
				for (Cell cell : cells) {
					cell.actualize(game);
				}
			}
		}
		if (isGameOver()) {
			String message = "";
			if (wCount > bCount) {
				message = "Player WHITE won!";
			}
			else if (bCount > wCount)
				message = "Player BLACK won!";
			else
				message = "DRAW!";
			printScore();
			JOptionPane.showMessageDialog(contentPane, message, "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
			btnUndo.setEnabled(false);
			btnSaveGame.setEnabled(false);
		} else if (switchPlayer(game.currentPlayer())) {
			Player switchedPlayer = game.currentPlayer();
			game.nextPlayer();
				
			JOptionPane.showMessageDialog(contentPane,
				switchedPlayer.toString()+" have no legal move\n"
				+" Switched to player: " + game.currentPlayer().toString(),
				"Switched player", JOptionPane.WARNING_MESSAGE);
		}
		printScore();		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUndo) {
				System.out.println("UNDO");
				deserialize("game-undo.ser");
				btnUndo.setEnabled(false);
				for (Cell cell : cells) {
					cell.actualize(game);
				}
				printScore();
		}
		if (e.getSource() == btnSaveGame) {
			int returnVal = fc.showSaveDialog(ReversiGame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
            	File file = fc.getSelectedFile();
            	savedGamePath = file.getPath();
            }
            if (!savedGamePath.isEmpty()) {
            	serialize(game, savedGamePath);
			}  
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
