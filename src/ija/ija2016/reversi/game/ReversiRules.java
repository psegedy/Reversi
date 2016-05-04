package ija.ija2016.reversi.game;

import ija.ija2016.reversi.board.BoardField;
import ija.ija2016.reversi.board.Field;
import ija.ija2016.reversi.board.Rules;

public class ReversiRules implements Rules {
	private int size;
	//private int disksNum;
	
	public ReversiRules(int size) {
		this.size =  size;
		//disksNum = (this.size * this.size)/2;
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

	//@Override
	//public int numberDisks() {
	//	return disksNum;
	//}

}
