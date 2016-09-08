
import java.util.List;

/**
 * This class provides an implementation of the Cell interface.
 * 
 *
 */
public abstract class AbstractCell implements Cell{
	/** The board which contains the cell*/
	protected Board board;
	/** The player occupying the cell*/
	protected Player player;
	/**
	 * The constructor
	 * @param board the board which contains the cell
	 * @param player the player occupying the cell, null if none
	 */
	public AbstractCell(Board board, Player player) {
		super();
		this.board=board;
		this.player=player;
	}
	
	@Override
	public boolean canBeLeftNow() {
		if(this instanceof WaitCell)
			return this.canBeLeftNow();
		else
			return !this.isRetaining();
	}

	@Override
	public boolean isRetaining() {
		return (this instanceof TrapCell);
	}

	@Override
	public int getIndex() {
		return board.getCells().indexOf(this);
	}

	@Override
	public int handleMove(int diceThrow) {
		if(this instanceof GooseCell)
			return getIndex()+diceThrow;
		if(this instanceof TeleportCell)
			return this.handleMove(diceThrow);
		
	return getIndex();
	}

	@Override
	public boolean isBusy() {
		if(getPlayer() == null)
			return false;
		return true;
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public void welcome(Player player) {
		this.player=player;		
	}
	/**
	 * @return a string representing the cell
	 */
	public String toString(){
		return "cell " + getIndex();
	}

}
