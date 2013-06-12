package dai.gomoku.client.swing.requests;

/**
 * This interface abstracts the responses that can be sent to the server. The
 * client implementer will generally use this interface in their controller to
 * interact with the server.
 * 
 * @author Muriithi Frederick Muriuki
 * 
 */
public interface Request {
	void request();
}
