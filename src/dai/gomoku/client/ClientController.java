package dai.gomoku.client;

import java.util.List;

public interface ClientController {
	public void startNewGame(String gameID, String challengerUsername,
			String challengeeUsername);
	
	public void displayGameWindow();
	
	public void displayLoginScreen();
	
	public void destroyLoginScreen();
	
	public void displayRegisterScreen();
	
	public void displayRegisterSuccessMessage();
	
	public void displayRegisterFailMessage(String message);
	
	public void hideRegisterScreen();

	public void displayGameCreationFailMessage();

	public int displayChallengeMessage(String username);

	public void displayRejectMessage(String challengeeUsername);

	public void displayGameOverMessage(String winner);

	public GameModel getGameByID(String gameID);
	
	public String getUsername();
	
	public void markCell(String gameID, int row, int col, String username);
	
	public void displayMoveFailedMessage();
	
	public void populateList(List<Player> players);

	public void sendToServer(String toSend);
}
