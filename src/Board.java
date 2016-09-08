import java.util.List;

/**
 * A board in the game
 *
 */
public abstract class Board {
	/** The list of cells of the board*/
	protected  List<Cell> cells;
	/** The last cell of the board*/
	protected  Cell endCell;
	
	/**
	 * The constructor
	 * Initialize the board and set endCell
	 */
	public Board() {	
		this.cells = initBoard();
		this.endCell=this.cells.get(this.cells.size()-1);		
	}
	
	/**
	 * Initialize the board ; creates all the cells and puts them in a list
	 * @return a list filled of cells
	 */
	protected abstract List<Cell> initBoard();

	
	/**
	 * 
	 * @return the size of the board
	 */
	public int size() {
		return cells.size();
	}
	/**
	 * 
	 * @param i the index of the cell to return
	 * @return the cell at the specified position 
	 */
	public Cell getCell(int i) {
		return cells.get(i);
	}
	/**
	 * @return the first cell of the board
	 */
	public Cell getCellStart() {
		return cells.get(0);
	}
	
	/**
	 * @return the last cell of the board
	 */
	public Cell getCellEnd() {	
		return cells.get(cells.size()-1);
	}
	
	/**
	 * Play a turn of the "jeu de l'oie" game
	 * @param nextPlayer the player who plays
	 * @param sumDice the result of two dice throw
	 */
	public void playTurn(Player nextPlayer, int sumDice) {
		System.out.print(nextPlayer+" is in "+getCell(nextPlayer.getNCell())+", ");
		
		if(getCell(nextPlayer.getNCell()).canBeLeftNow()){
			Cell dest = computeTargetCell(nextPlayer, sumDice);
			System.out.print(nextPlayer + " throws " +sumDice+", ");
			
			if(dest.isBusy()) {
				System.out.println(nextPlayer + " reaches " +dest);
				swapPlayers(nextPlayer, dest.getPlayer());
				
			}else {
				Cell realDest = getCell(normalizeIndex(dest.handleMove(sumDice)));
				if(realDest.isBusy()) {
					System.out.println(nextPlayer + " reaches " +dest);
					swapPlayers(nextPlayer, realDest.getPlayer());
					
				}else {
					putPlayerOnCell(nextPlayer, realDest);
				}
				if(dest.equals(realDest))
					System.out.println(nextPlayer + " reaches " +realDest);
				else 
					System.out.println(nextPlayer + " reaches " +dest+" jumps to "+ realDest);
				
				if(realDest.equals(getCellEnd()))
					System.out.println(nextPlayer + " has won.");
			}
		}else{
			System.out.println(nextPlayer + " cannot play.");
		}
	}
	/**
	 * Put a player on a cell
	 * Changes the player of the old cell to null
	 * @param player the player who moves
	 * @param cell the destination
	 */
	protected void putPlayerOnCell( Player player, Cell cell){ 
		if(!(getCell(player.getNCell()) instanceof StartCell))
				getCell(player.getNCell()).welcome(null);
		player.moveTo(cell);
	}
	/**
	 * Put a player on the start of the board
	 * @param player the player who moves
	 */
	public void putPlayerOnStart(Player player) {
		putPlayerOnCell(player, getCellStart());
	}
	/**
	 *  Swap the positions of two players
	 * @param p1 the first player
	 * @param p2 the second play
	 */
	public void swapPlayers(Player p1, Player p2){
		Cell cell1 = getCell(p1.getNCell());
		Cell cell2 = getCell(p2.getNCell());
		p1.moveTo(cell2);
		p2.moveTo(cell1);
		System.out.println(p2+" is sent to "+ cell1);
	}
	/**
	 * Computes the cell really reaches by a player after a throw
	 * @param player the player who moves
	 * @param i the sum of the dice throw
	 * @return the cell really reaches by a player 
	 */
	protected Cell computeTargetCell(Player player, int i) {	
		return getCell(normalizeIndex(player.getNCell()+i));
	}
	/**
	 * Normalize an index which is beyond the size of the board
	 * @param index the index of the destination
	 * @return an index within the board
	 */
	private int normalizeIndex(int index) {
		int size=cells.size()-1;
		if (index > size){
			int d = index-size;
			return size-d;
		}
		return index;
		
	}
	/**@return the list which contains all the cells from the board*/
	public List<Cell> getCells() {
		return cells;
	}
	/**
	 * @return a string representing the board
	 */
	public String toString() {
		String str = "";
		for(Cell cell : cells) {
			if(cell instanceof StartCell)
				str+="|S ";
			else if(cell instanceof GooseCell)
				str+="|G ";
			else if(cell instanceof NormalCell)
				str+="|  ";
			else if(cell instanceof TeleportCell)
				str+="|T ";
			else if(cell instanceof TrapCell)
				str+="|t ";
			else if(cell instanceof WaitCell)
				str+="|W ";
		}
		str+="\n";
		for(int i = 0; i <cells.size(); i++) {
			if (i<10){
				str+="|";
				str+=i+" ";
			}else{
				str+="|";
				str+=i;
			}
		}
		str+="\n";
		return str;
	}
}
