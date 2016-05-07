package ija.ija2016.reversi.game;

import ija.ija2016.reversi.board.Board;
import ija.ija2016.reversi.board.Field;
import ija.ija2016.reversi.board.Disk;

public class Player implements java.io.Serializable {

	private static final long serialVersionUID = 3145485149475518508L;
	private boolean isWhite;
	
	public Player(boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	public boolean isWhite() {
		return isWhite;
	}
	
	public boolean canPutDisk(Field field) {
		return field.canPutDisk(new Disk(isWhite));
	}
	
	public boolean putDisk(Field field) {
		return field.putDisk(new Disk(isWhite));
	}
	
	public void init(Board board) {
		int size = board.getSize();
		if (isWhite) {
			//je biely, vlozim biely disk
			board.getField(size/2, size/2).putStartDisk(new Disk(isWhite));
			board.getField(size/2 + 1, size/2 + 1).putStartDisk(new Disk(isWhite));
		}
		else {
			board.getField(size/2 + 1, size/2).putStartDisk(new Disk(isWhite));
			board.getField(size/2, size/2 + 1).putStartDisk(new Disk(isWhite));
		}
	}

	@Override
	public String toString() {
		if (isWhite) {
			return "white";
		}
		else
			return "black";
	}
}
