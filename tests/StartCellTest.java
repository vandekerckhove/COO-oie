import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class StartCellTest {
	protected Board board;
	protected List<Player> listPlayers;
	protected Player p1,p2;
	@Before
	   public void setUp() throws Exception {
		board = new StandardBoard();
		listPlayers = new ArrayList<Player>();
		p1=new Player("toto");	
		p2 = new Player("tata");
		listPlayers.add(p1);
	}
	@Test
	public void testWelcome() {
		List<Player> players = new ArrayList<Player>();
		players.add(p1);
		StartCell cell = new StartCell(board,listPlayers);
		assertEquals(players,cell.getPlayers());
		cell.welcome(p2);
		players.add(p2);
		assertEquals(players,cell.getPlayers());
	}
}
