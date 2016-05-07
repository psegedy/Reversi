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
	
	/**
	 * Constructor of game
	 * @param board
	 */
	public Game (Board board) {
		this.board = board;
	}
	
	/**
	 * Method for adding player into game
	 * @param player Constructor of player
	 * @return <code>true</code> on success;
     *         <code>false</code> otherwise.
	 */
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
	
	/**
	 * Method for getting current player
	 * @return current player object
	 */
	public Player currentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * Method for switching current player
	 * @return next player
	 */
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
	/**
	 * Method for getting game board
	 * @return game board
	 */
	public Board getBoard() {
		return board;
	}
}
