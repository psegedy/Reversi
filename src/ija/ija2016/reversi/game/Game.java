/**
 * Class 
 * @author Patrik Segedy 
 * @author Tibor Dudlák
 */
package ija.ija2016.reversi.game;

import ija.ija2016.reversi.board.Board;

public class Game implements java.io.Serializable{

	private static final long serialVersionUID = 4225826126034520444L;
	private Board board;
	private Player currentPlayer, blackPlayer, whitePlayer;
	
	public Game (Board board) {
		this.board = board;
	}
	
	public boolean addPlayer(Player player) {
		if (player.isWhite()) {	
			player.init(board);
			whitePlayer = player;
			currentPlayer = whitePlayer;
			return true;
		}
		else if (!player.isWhite()) {
			player.init(board);
			blackPlayer = player;
			return true;
		}
		return false;
	}
	
	public Player currentPlayer() {
		return currentPlayer;
	}
	
	public Player nextPlayer() {
		if (currentPlayer.isWhite()) {
			currentPlayer = blackPlayer;
			return currentPlayer;
		}
		else {
			currentPlayer = whitePlayer;
			return currentPlayer;
		}
	}
	
	public Board getBoard() {
		return board;
	}
}
