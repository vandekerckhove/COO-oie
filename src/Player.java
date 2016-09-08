/**
 * A player in the game
 *
 */
public class Player {
	/** Index of the current cell of the player*/
	private int nCell;
	/**Name of the player*/
	private String name;
	/**
	 * The constructor
	 * Set the cell of this player at StartCell
	 * @param name the name of this player
	 * */
	public Player(String name){
		this.nCell=0;
		this.name=name;
	}
	/**
	 * 
	 * @return the index of the current cell of the player
	 */
	public int getNCell() {
		return nCell;
	}
	/**
	 * Changes the index of the cell of the player
	 * @param nbCell the new index of the cell
	 */
	public void setNCell(int nbCell) {
		this.nCell = nbCell;
	}

	/**
	 * Move the player to the Cell cell
	 * changes nCell from the player and player from the cell
	 * @param cell the new cell of this player
	 */
	public void moveTo(Cell cell) {
		nCell = cell.getIndex();
		cell.welcome(this);
	}
	/**
	 * @return a string representing the player
	 */
	public String toString() {
		return name;
	}
}
