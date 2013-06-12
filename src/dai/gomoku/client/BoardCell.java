package dai.gomoku.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dai.gomoku.client.swing.requests.MakeMoveRequest;

/**
 * This class abstracts a board cell. It was created to provide a means to refer
 * to each cell within the board
 * 
 * @author Muriithi Frederick Muriuki
 * 
 */
public class BoardCell extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7103871303242888625L;
	private GameModel gameModel;
	private int row;
	private int col;
	private String owner = null;

	private ClientController controller;

	/**
	 * The constructor
	 * 
	 * @param controller An object of a class implementing the {@link ClientController} interface
	 * @param row The cell's row
	 * @param col The cell's column
	 */
	public BoardCell(ClientController controller, int row, int col) {
		this.controller = controller;
		this.row = row;
		this.col = col;
		this.addActionListener(this);
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col
	 *            the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the {@link GameModel} object
	 */
	public GameModel getGameModel() {
		return gameModel;
	}

	/**
	 * @param gameModel
	 *            the gameModel to set
	 */
	public void setGameModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (owner == null) {
			if (gameModel.isGameOver()) {
				controller.displayGameOverMessage(gameModel.getWinner());
			} else {
				MakeMoveRequest mm = new MakeMoveRequest(controller);
				mm.setGameID(gameModel.getGameID());
				mm.setRow(row);
				mm.setCol(col);
				mm.setUsername(controller.getUsername());
				mm.request();
			}
		} else {
			JOptionPane.showMessageDialog(this.getParent(),
					"You cannot play there.", "Invalid Move",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
