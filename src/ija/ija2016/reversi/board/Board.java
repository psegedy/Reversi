/**
 * Class 
 * @author Patrik Segedy 
 * @author Tibor Dudlák
 */
package ija.ija2016.reversi.board;

public class Board implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5130634704230000672L;
	public static int startDisks = 0;
	private int size;
	private Rules rules;
	protected Field[][] boardArr;

	public Board(Rules rules) {
		this.rules = rules;
		this.size = rules.getSize();
		boardArr = new Field[size+2][size+2];

		for (int i = 0; i < boardArr.length; i++) {
			for (int j = 0; j < boardArr.length; j++) {
				if ((i == 0 || i == boardArr.length) && (j == 0 || j == boardArr.length)) {
					boardArr[i][j] = new BorderField();
				}
				else {
					boardArr[i][j] = rules.createField(i, j);
				}
			}
		}
		for (int i = 1; i < boardArr.length-1; i++) {
			for (int j = 1; j < boardArr.length-1; j++) {
				boardArr[i][j].addNextField(Field.Direction.L, boardArr[i][j-1]);
				boardArr[i][j].addNextField(Field.Direction.R, boardArr[i][j+1]);
				boardArr[i][j].addNextField(Field.Direction.U, boardArr[i-1][j]);
				boardArr[i][j].addNextField(Field.Direction.D, boardArr[i+1][j]);
				boardArr[i][j].addNextField(Field.Direction.LU, boardArr[i-1][j-1]);
				boardArr[i][j].addNextField(Field.Direction.RD, boardArr[i+1][j+1]);
				boardArr[i][j].addNextField(Field.Direction.LD, boardArr[i+1][j-1]);
				boardArr[i][j].addNextField(Field.Direction.RU, boardArr[i-1][j+1]);
			}
		}
	}
	
	public Field getField(int row, int col) {
		return boardArr[row][col];
	}
	
	public int getSize() {
		return rules.getSize();
	}
	
	public Rules getRules() {
		return rules;
	}

}
