package dai.gomoku.client;

import java.util.List;

import dai.gomoku.client.swing.requests.ChallengeRequest;
import dai.gomoku.client.swing.requests.LoginRequest;
import dai.gomoku.client.swing.requests.RegisterRequest;
import dai.gomoku.client.swing.requests.Request;

/**
 * Implement this interface on your client's controller.
 * 
 * @author Muriithi Frederick Muriuki
 * 
 */
public interface ClientController {

	/**
	 * This method is meant to initialise the required {@link GameModel}
	 * object(s) and initialise the UI representing the game board. Also can be
	 * used to set up the {@link GameBoardChangeListener} objects
	 * 
	 * @param gameID
	 *            The game identifier from the server
	 * @param challengerUsername
	 *            The one who initiated the game
	 * @param challengeeUsername
	 *            The one who accepted the challenge
	 */
	public void startNewGame(String gameID, String challengerUsername,
			String challengeeUsername);

	/**
	 * Displays the main client window (in the case of multiple internal
	 * windows)
	 */
	public void displayGameWindow();

	/**
	 * Displays the log-in prompt
	 */
	public void displayLoginScreen();

	/**
	 * Implemented to release the resources held by the logi-in screen, once the
	 * log-in process is successful
	 */
	public void destroyLoginScreen();

	/**
	 * Displays the registration screen to allow registration of a new user
	 */
	public void displayRegisterScreen();

	/**
	 * This only needs be displayed to the human users. For AI machines, the
	 * controller can have this as an empty method.
	 */
	public void displayRegisterSuccessMessage();

	/**
	 * Displayed to the user in case of failure in registration.
	 * 
	 * @param message
	 *            The failure message from the server to display to the user
	 */
	public void displayRegisterFailMessage(String message);

	/**
	 * This method is supposed to hide the register screen once the user clicks
	 * the 'Register' button
	 */
	public void hideRegisterScreen();

	/**
	 * This displays a message in case there is a problem creating the game on
	 * the server
	 */
	public void displayGameCreationFailMessage();

	/**
	 * Displays the challenge made by a player
	 * 
	 * @param username
	 *            The player that made a challenge...
	 * 
	 * @return A integer value indicating whether the respondent accepted or
	 *         rejected the challenge
	 */
	public int displayChallengeMessage(String username);

	/**
	 * Should infor the user that the challenge they made was rejected
	 * 
	 * @param challengeeUsername
	 *            The player that rejected the challenge
	 */
	public void displayRejectMessage(String challengeeUsername);

	/**
	 * Displays the 'Game Over' message plus the winner of the game
	 * 
	 * @param winner
	 *            The username of the player who won the game
	 */
	public void displayGameOverMessage(String winner);

	/**
	 * Retrieves the {@link GameModel} object by given id
	 * 
	 * @param gameID
	 *            The {@link GameModel} object that corresponds to the game with
	 *            the id provided
	 * 
	 * @return A {@link GameModel} object or null
	 */
	public GameModel getGameByID(String gameID);

	/**
	 * Retrieves the username of the player that is connected via the current
	 * client.
	 * 
	 * @return The username of the player using the client
	 */
	public String getUsername();

	/**
	 * Updates the {@link GameModel} with the given ID and marks the user
	 * according to the provided username
	 * 
	 * @param gameID
	 *            The id of the game being played
	 * @param row
	 *            The row of the cell to mark
	 * @param col
	 *            The column of the cell to mark
	 * @param username
	 *            The username - determines if the cell is marked X or O
	 */
	public void markCell(String gameID, int row, int col, String username);

	/**
	 * Informs a player in case they make a move before their turn, or try to
	 * mark an already marked cell
	 */
	public void displayMoveFailedMessage();

	/**
	 * Updates the list of available players
	 * 
	 * @param players
	 *            A list of players
	 */
	public void populateList(List<Player> players);

	/**
	 * A utility method that sends data to the server
	 * 
	 * @param toSend
	 *            data to send to the server
	 */
	public void sendToServer(String toSend);
	
	/**
	 * Used to register a new user with the server
	 * 
	 * @param regReq The {@link Request} object containing the registration details
	 */
	public void registerUser(RegisterRequest regReq);
	
	/**
	 * Used to sign in to the server in order to play
	 * 
	 * @param req The {@link Request} object containing the login credentials
	 */
	public void signIn(LoginRequest req);
	
	/**
	 * Enable one user to send a different user a challenge to a game.
	 * 
	 * @param req The {@link Request} object containing the challenge details
	 */
	public void challengeUser(ChallengeRequest req);
}
