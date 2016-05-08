package ija.ija2016.reversi.ai;

import java.util.ArrayList;
import java.util.Random;

import ija.ija2016.reversi.board.Disk;
import ija.ija2016.reversi.board.Field;
import ija.ija2016.reversi.game.Game;

/**
 * Class AiEasy implements Interface Ai
 * @author Patrik Segedy 
 * @author Tibor Dudlák
 */

public class AiEasy implements Ai{
	
	/**
	 * Method makeMove take parameter game and changes 
	 * it by putting disk on random boardField
	 * @param game - actual game
	 * @return changed game
	 */
	public Game makeMove(Game game) {
		
		boolean color = game.currentPlayer().isWhite();
		Disk disk = new Disk(color);
		int size = game.getBoard().getSize();
		
		ArrayList<Field> fields = new ArrayList<Field>();
		
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				if (game.getBoard().getField(row, col).canPutDisk(disk)) {
					fields.add(game.getBoard().getField(row, col));
				}
			}
		}
		Random number = new Random();
		
		if (fields.size()!=0) {
			fields.get(number.nextInt(fields.size())).putDisk(disk);
		}
		game.nextPlayer();
		return game;
	}
	
}
