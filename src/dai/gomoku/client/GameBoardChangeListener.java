package dai.gomoku.client;

/**
 * An interface that's to be implemented by all classes that create objects that
 * need to listen to changes in the state of an object of the {@link GameModel}
 * class
 * 
 * @author Muriithi Frederick Muriuki
 * 
 */
public interface GameBoardChangeListener {
	/**
	 * To be implemented by all methods listening for changes in the game board
	 */
	void updateBoard();
}
