import java.util.Iterator;
import java.util.List;
import java.util.Random;

/** This class provides a representation of the game "jeu de l'oie"*/
public class Game {
	/**The list of players*/
	protected List<Player> players;
	/**The board*/
	protected Board board;
	protected Iterator<Player> currentPlayer;
	private final Random random = new Random();
	
	/**
	 * The constructor
	 * @param board the board of the game
	 * @param list the list of players
	 */
	public Game(Board board, List<Player> list) {
		this.board = board;
		this.players = list;
		currentPlayer = players.iterator();
	}
	
	
	/**
	 * Play a game of "jeu de l'oie"
	 */
	public void play() {
		while (!isFinished()) {
		board.playTurn(nextPlayer(), throwDie() + throwDie());
		}
		if(allPlayersAreStuck())
			System.out.println("Game over ; all players are stuck");
	}
	/**
	 * @return the next player who plays
	 */
	private Player nextPlayer() {
		Player next;
		if(currentPlayer.hasNext()) {
			next = currentPlayer.next();
			
		}else {
			currentPlayer = players.iterator();
			next = currentPlayer.next();
		}
		
		return next;
	}
	
	/**
	 * Simulates rolling a D6
	 * @return an int between 1 and 6
	 */
	protected int throwDie() {
		return random.nextInt(6)+1;
	}
	
	/**
	 * Indicates if the game is finished.
	 * @return true if a player reaches the last cell or if all the players are stuck.
	 */
	public boolean isFinished() {
		return (allPlayersAreStuck() | onePlayerAtEnd());
		
	}
	/**
	 * Indicates if all the players are stuck
	 * @return true if all the players are stuck in a trap cell
	 */
	public boolean allPlayersAreStuck() {
		boolean b = true;
		for(Player p : players){
			b = b && (board.getCell(p.getNCell()) instanceof TrapCell);
		}
		return b;
	}
	/**
	 * Indicates if a player reached the last cell
	 * @return true if a player reached the last cell of the board
	 */
	public boolean onePlayerAtEnd() {
		for(Player p : players) {
			if((board.getCell(p.getNCell())).equals(board.getCellEnd()))
				return true;
		}
		return false;
	}
	/**
	 * @return the list of the players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	/**
	 * @return the board of the game
	 */
	public Board getBoard() {
		return board;
	}


}
