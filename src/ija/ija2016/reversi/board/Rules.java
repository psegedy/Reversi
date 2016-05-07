package ija.ija2016.reversi.board;

public interface Rules {
	Field createField(int row, int col);
	int getSize();
}
