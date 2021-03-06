package dai.gomoku.client.swing.responses;

import java.util.List;

import dai.gomoku.client.ClientController;
import dai.gomoku.client.Player;
import dai.gomoku.client.Response;

public class SendPlayerResponse implements Response {
	private List<Player> players;
	private ClientController controller;

	public SendPlayerResponse(List<Player> players, ClientController controller) {
		this.players = players;
		this.controller = controller;
	}

	@Override
	public void process() {
		controller.populateList(players);
	}

}
