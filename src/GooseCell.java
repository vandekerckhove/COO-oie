
/**A goose cell, reach a goose cell double the throw of dice*/
public class GooseCell extends AbstractCell{
	/**
	 * The constructor
	 * @param board the board which contains the cell
	 * @param player the player occupying the cell, null if none
	 */
	public GooseCell(Board board, Player player) {
		super(board, player);

	}
	/**
	 * @return a string representing the cell
	 */
	public String toString() {
		return "goose " + getIndex();
	}
}
