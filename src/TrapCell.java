
/**A trap cell, when you reach a trap you cannot play until another player reach this cell*/
public class TrapCell extends AbstractCell{
	/**
	 * The constructor
	 * @param board the board which contains the cell
	 * @param player the player occupying the cell, null if none
	 */
	public TrapCell(Board board, Player player) {
		super(board, player);
	}

}
