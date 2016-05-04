package ija.ija2016.reversi.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ija.ija2016.reversi.board.Disk;
import ija.ija2016.reversi.board.Field;
import ija.ija2016.reversi.game.Game;
import ija.ija2016.reversi.game.Player;

public class Cell extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
	private Field field;
	private Disk disk;
	private int col;
	private int row;
	
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
		}
		if (game.currentPlayer().canPutDisk(field)) {
			g.setColor(new Color(0, 170, 0));
			g.drawOval(5, 5, 40, 40);
		}
	}

	public void actualize(Game game) {
		this.game = game;
		this.field = game.getBoard().getField(row, col);
		disk = field.getDisk();
		repaint();
	}
	
	public boolean isEmpty() {
		if (this.disk == null)
			return true;
		else
			return false;
	}
	
	public boolean isWhite() {
		return disk.isWhite();
	}
	
	public boolean putDisk(Game game) {
		if (game.currentPlayer().isWhite()) {
			if (game.currentPlayer().putDisk(game.getBoard().getField(row, col))) {
				System.out.println("Row " + row + "Col " + col);
				System.out.println("put white");
				return true;
			}
		} else {
			if (game.currentPlayer().putDisk(game.getBoard().getField(row, col))) {
				System.out.println("Row " + row + "Col " + col);
				System.out.println("put black");
				return true;
			}
		}
		return false;
	}
}
