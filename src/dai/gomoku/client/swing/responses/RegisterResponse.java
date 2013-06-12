package dai.gomoku.client.swing.responses;

import dai.gomoku.client.ClientController;
import dai.gomoku.client.Response;

public class RegisterResponse implements Response {
	private String status;
	private String message;

	private ClientController controller;

	public RegisterResponse(String status, String message, ClientController controller) {
		this.status = status;
		this.message = message;
		this.controller = controller;
	}

	@Override
	public void process() {
		if (status.equals("OK")) {
			controller.displayRegisterSuccessMessage();
			controller.hideRegisterScreen();
			controller.displayLoginScreen();
		} else {
			controller.displayRegisterFailMessage(message);
			controller.displayRegisterScreen();
		}

	}

}
