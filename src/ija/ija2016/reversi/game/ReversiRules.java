/**
 * Class ReversiRules stores size of board and creates it
 */
package ija.ija2016.reversi.game;

import ija.ija2016.reversi.board.BoardField;
import ija.ija2016.reversi.board.Field;
import ija.ija2016.reversi.board.Rules;

public class ReversiRules implements Rules, java.io.Serializable {
	
	private static final long serialVersionUID = -6722133764844754960L;
	private int size;
	
	/**
	 * Method to set size of board
	 * @param size is size of board
	 */
	public ReversiRules(int size) {
		this.size =  size;
	}
	
	@Override
	public Field createField(int row, int col) {
		BoardField bf = new BoardField(row, col);
		return bf;
	}

	@Override
	public int getSize() {
		return size;
	}

}
