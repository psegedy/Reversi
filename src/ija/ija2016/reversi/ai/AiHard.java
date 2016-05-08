package ija.ija2016.reversi.ai;

import java.util.ArrayList;
import java.util.Random;

import ija.ija2016.reversi.board.Disk;
import ija.ija2016.reversi.board.Field;
import ija.ija2016.reversi.game.Game;

/**
 * Class AiHard implements Interface Ai
 * @author Patrik Segedy 
 * @author Tibor Dudlák
 */
public class AiHard implements Ai{
	
	/**
	 * Method makeMove take parameter game and changes 
	 * it by putting disk on random boardField by field 
	 * priorities and with actual player color
	 * @param game - actual game
	 * @return changed game
	 */
	public Game makeMove(Game game) {
		
		boolean color = game.currentPlayer().isWhite();
		Disk disk = new Disk(color);
		
		int size = game.getBoard().getSize();
		int allPriorities[][] = new int[size][size];
		allPriorities = setPriorities(size);
		
		ArrayList<Field> fields = new ArrayList<Field>();
		ArrayList<Field> result = new ArrayList<Field>();
		ArrayList<Integer> weight = new ArrayList<Integer>();
		
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				if (game.getBoard().getField(row, col).canPutDisk(disk)) {
					fields.add(game.getBoard().getField(row, col));
					weight.add(allPriorities[row-1][col-1]);
				}
			}
		}

		if (fields.size()!=0) {
			
			int index = 0;
			int prio = 0;
			for(int w : weight){
				System.out.println(w);
				if (w>prio) {
					prio = w;
					result.clear();
					result.add(fields.get(index) );
				} else if (w==prio) {
					result.add(fields.get(index) );
				} 
				index ++;
			}
			Random number = new Random();
			System.out.println((result.size()));
			
			result.get(number.nextInt(result.size())).putDisk(disk);
		}
		
		game.nextPlayer();
		return game;
	}

	/**
	 * Method setPriorities take parameter size and 
	 * create array with field priorities  for each 
	 * field on board 
	 * @param size - board size
	 * @return priorities
	 */
	public int[][] setPriorities(int size) {
		
		int Priorities[][] = new int[size][size];
		size--;	
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= size; j++) {
				Priorities[i][j] = 4;
				if ( (i == 0 || j == 0 || i == size || j == size) ) {
					Priorities[i][j] = 5;
				} else if ((i == 1 || j == 1 || i == size-1 || j == size-1)){
					Priorities[i][j] = 3;
				} else {
					Priorities[i][j] = 4;
				}
			}			
		}
		
		Priorities[0][1] = 2;
		Priorities[1][0] = 2;
		Priorities[0][size-1] = 2;
		Priorities[1][size] = 2;
		Priorities[size-1][0] = 2;
		Priorities[size][1] = 2;
		Priorities[size][size-1] = 2;
		Priorities[size-1][size] = 2;
		
		Priorities[1][1] = 1;
		Priorities[1][size-1] = 1;
		Priorities[size-1][1] = 1;
		Priorities[size-1][size-1] = 1;
		
		Priorities[0][0] = 6;
		Priorities[0][size] = 6;
		Priorities[size][0] = 6;
		Priorities[size][size] = 6;

		return Priorities;
	}
	
}
