package ija.ija2016.reversi.board;
/**
 * Interface 
 * @author Patrik Segedy 
 * @author Tibor Dudlak
 */
public interface Rules {
	/**
	 * Method creates field on position defined by row and col
	 * @param row - coord row of field
	 * @param col - coord col of field
	 * @return field 
	 */
	Field createField(int row, int col);
	/**
	 * Method returns Size of board
	 * @return size 
	 */
	int getSize();
}
