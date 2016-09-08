
/**A wait cell, when you reach a wait cell you must wait a nbTurn of turns before playing*/
public class WaitCell extends AbstractCell{
	/** The initial number of turns to wait*/
	protected final int nbTurn;
	/**The number of turns remaining to wait*/
	protected int timeLeft;
	/**
	 * The constructor
	 * @param board the board which contains the cell
	 * @param player the player occupying the cell, null if none
	 * @param n the number of turns to wait when you reach this cell
	 */
	public WaitCell(Board board, Player player, int n) {
		super(board, player);
		this.nbTurn=n;
		this.timeLeft=this.nbTurn;
	}
	
	@Override
	public void welcome(Player player) {
		this.player=player;
		this.timeLeft=this.nbTurn;
	}
	@Override
	public boolean canBeLeftNow(){
		this.timeLeft--;
		return this.timeLeft<0;
	}
}
