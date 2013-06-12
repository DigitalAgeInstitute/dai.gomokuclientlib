package dai.gomoku.client;

import java.util.ArrayList;
import java.util.List;

/**
 * The UI game model
 * 
 * @author Muriithi Frederick Muriuki
 * 
 */
public class GameModel {
	private String gameID;
	private String playerO;
	private String playerX;

	private final int BOARD_SIZE = 15;
	private char[][] gameBoard;
	private boolean gameOver = false;
	private List<GameBoardChangeListener> gameBoardChangeListeners;

	private String winner;

	/**
	 * The constructor
	 * 
	 * @param gameID The id for this game model, that relates it to the game on the server
	 * @param playerO The username for the player playing as O
	 * @param playerX The username for the player playing as X
	 */
	public GameModel(String gameID, String playerO, String playerX) {
		this.gameID = gameID;
		this.playerO = playerO;
		this.playerX = playerX;
		initCells();
		gameBoardChangeListeners = new ArrayList<GameBoardChangeListener>();
	}

	/**
	 * @return the gameID
	 */
	public String getGameID() {
		return gameID;
	}

	/**
	 * @return the playerX
	 */
	public String getPlayerX() {
		return playerX;
	}

	/**
	 * @return the playerO
	 */
	public String getPlayerO() {
		return playerO;
	}

	/**
	 * @return the gameBoard
	 */
	public char[][] getGameBoard() {
		return gameBoard;
	}

	/**
	 * @return the bOARD_SIZE
	 */
	public int getBoardSize() {
		return BOARD_SIZE;
	}

	/**
	 * Registers a listener for changes in this model
	 * 
	 * @param listener An object implementing the {@link GameBoardChangeListener} interface
	 */
	public void addGameBoardChangeListener(GameBoardChangeListener listener) {
		gameBoardChangeListeners.add(listener);
	}

	/**
	 * Deregisters a listener for changes in this model
	 * 
	 * @param listener An object implementing the {@link GameBoardChangeListener} interface
	 */
	public void removeGameBoardChangeListener(GameBoardChangeListener listener) {
		if (gameBoardChangeListeners.contains(listener)) {
			gameBoardChangeListeners.remove(listener);
		}
	}

	/**
	 * Updates the model by marking the cell with either an X or an O
	 * 
	 * @param row The row of the cell to update
	 * @param col The column of the cell to update
	 * @param username The user who made the change
	 */
	public void markCell(int row, int col, String username) {
		if (username.equals(playerO)) {
			gameBoard[row][col] = 'O';
		} else {
			gameBoard[row][col] = 'X';
		}
		notifyGameBoardChangeListeners();
	}

	/**
	 * @return the gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * @param gameOver
	 *            the gameOver to set
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * @param winner
	 *            the winner to set
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

	private void initCells() {
		gameBoard = new char[BOARD_SIZE][BOARD_SIZE];
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				gameBoard[row][col] = ' ';
			}
		}
	}

	private void notifyGameBoardChangeListeners() {
		for (int i = 0; i < gameBoardChangeListeners.size(); i++) {
			gameBoardChangeListeners.get(i).updateBoard();
		}
	}

}
