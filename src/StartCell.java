
import java.util.List;

/**The starting cell of the game, contains a list of players instead of a single player*/
public class StartCell extends AbstractCell{
	/**The list of players*/
	protected List<Player> players;
	/**
	 * The constructor
	 * @param board the board which contains the cell
	 * @param players the list of players occupying the cell
	 */
	public StartCell(Board board, List<Player> players) {
		super(board,null);
		this.players=players;
	}
	@Override
	public void welcome(Player player){
		players.add(player);
	}
	/**
	 * @return the list of players in this cell
	 */
	public List<Player> getPlayers() {
		return players;
	}
}
