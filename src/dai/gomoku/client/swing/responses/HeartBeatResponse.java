package dai.gomoku.client.swing.responses;

import dai.gomoku.client.ClientController;
import dai.gomoku.client.Response;

public class HeartBeatResponse implements Response {
	private String type = "HEARTBEAT";

	private ClientController controller;

	public HeartBeatResponse(ClientController controller) {
		this.controller = controller;
	}

	@Override
	public void process() {
		String heartJSON = String.format("{ \"type\":\"%s\" }", type);
		controller.sendToServer(heartJSON);
	}

}
