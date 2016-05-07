/**
 * Class cell represents one cell/field at game board
 * 
 * @author Patrik Segedy 
 * @author Tibor Dudlák
 */

package ija.ija2016.reversi.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ija.ija2016.reversi.board.Board;
import ija.ija2016.reversi.board.Disk;
import ija.ija2016.reversi.board.Field;

import ija.ija2016.reversi.game.Game;
import ija.ija2016.reversi.game.Player;

public class Cell extends JPanel {

	private static final long serialVersionUID = 5199856827210931513L;
	private Game game;
	private Field field;
	private Disk disk;
	private int col;
	private int row;
	
	/**
	 * Constructor for cell takes game and position of actual field  
	 * @param game is actual game
	 * @param row of cell
	 * @param col of cell
	 */
	public Cell (Game game, int row, int col) {
		this.setPreferredSize(new Dimension(50,50));
		this.setBackground(new Color(0, 128, 0));
		this.game = game;
		this.row = row;
		this.col = col;
		this.field = game.getBoard().getField(row, col);
		this.disk = this.field.getDisk();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!isEmpty()) {
			if (disk.isWhite()) {
				g.setColor(Color.white);
				g.fillOval(5, 5, 40, 40);
			} else {
				g.setColor(Color.black);
				g.fillOval(5, 5, 40, 40);
			}
			if (disk.isFreezed()){
				g.setColor(new Color(51, 204, 255));
				g.fillOval(5, 5, 40, 40);
			}
		}
		if (game.currentPlayer().canPutDisk(field)) {
			g.setColor(new Color(0, 170, 0));
			g.drawOval(5, 5, 40, 40);
		}
	}

	/**
	 * Method actualizes entire game board 
	 * which is re-draw on frame's panel  
	 * @param game represent actual state of game
	 */
	public void actualize(Game game) {
		this.game = game;
		this.field = game.getBoard().getField(row, col);
		disk = field.getDisk();
		repaint();
	}
	
	/**
	 * Method to find out that field is empty
	 * @return <code>true</code> when actual field is empty;
     *         <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		if (this.disk == null)
			return true;
		else
			return false;
	}
	
	/**
	 * Method returns disk color
	 * @return <code>true</code> when actual disk is white;
     *         <code>false</code> otherwise.
	 */
	public boolean isWhite() {
		return disk.isWhite();
	}
	
	/**
	 * Method to put disk at actual position 
	 * at board defined with row and column.
	 * @param game represent actual state of game
	 * @return <code>true</code> when putting disk was successful;
     *         <code>false</code> otherwise.
	 */
	public boolean putDisk(Game game) {
		if (game.currentPlayer().putDisk(game.getBoard().getField(row, col))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method canPutDisk finds out that player can 
	 * put disk at position defined with row and column.
	 * @param game represent actual state of game
	 * @return <code>true</code> when player can put disk;
     *         <code>false</code> otherwise.
	 */
	public boolean canPutDisk(Game game) {
		if (game.currentPlayer().canPutDisk(game.getBoard().getField(row, col))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method to set disk if freezed to freeze
	 * @param game actual game
	 * @param isFreezed parameter to disk's method freezeDisk
	 */
	public void freeze(Game game, boolean isFreezed) {
		game.getBoard().getField(row, col).getDisk().freezeDisk(isFreezed);
		actualize(game);
	}
}
