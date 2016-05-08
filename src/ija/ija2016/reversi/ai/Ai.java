package ija.ija2016.reversi.ai;

import ija.ija2016.reversi.game.Game;

/**
 * Interface Ai for changing game with method makeMove
 * make Move has to implement some algorithm eg.: random.
 * @author Patrik Segedy 
 * @author Tibor Dudlák
 */
public interface Ai {
	/**
	 * Method makeMove take parameter game and changes 
	 * it by putting disk on one of board's field
	 * @param game - actual game
	 * @return changed game
	 */
	public Game makeMove(Game Game);
}
