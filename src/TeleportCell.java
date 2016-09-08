
/**A teleport cell, reached a teleport cell moves the player to the cell of index dest*/
public class TeleportCell extends AbstractCell{
	/**The index of the new cell when you reach the teleport cell*/
	protected int dest;
	/**
	 * The constructor 
	 * @param board the board which contains the cell
	 * @param player the player occupying the cell, null if none
	 * @param dest the destination of the teleportation
	 */
	public TeleportCell(Board board, Player player, int dest) {
		super(board, player);
		this.dest=dest;
	}
	/**
	 * @return the destination of the teleportation
	 */
	public int getDest() {
		return dest;
	}
	@Override
	public int handleMove(int diceThrow) {
		return getDest();
	}

}
