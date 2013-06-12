package dai.gomoku.client.swing.responses;

import dai.gomoku.client.ClientController;
import dai.gomoku.client.Response;

public class GameOverResponse implements Response {
	private String type = "GAMEOVER";
	private String gameID;
	private String winner;

	private ClientController controller;

	public GameOverResponse(ClientController controller) {
		this.controller = controller;
	}

	/**
	 * @return the gameID
	 */
	public String getGameID() {
		return gameID;
	}

	/**
	 * @param gameID
	 *            the gameID to set
	 */
	public void setGameID(String gameID) {
		this.gameID = gameID;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	@Override
	public void process() {
		controller.displayGameOverMessage(winner);
		controller.getGameByID(gameID).setGameOver(true);
		controller.getGameByID(gameID).setGameOver(true);
		controller.getGameByID(gameID).setWinner(winner);
	}

}
