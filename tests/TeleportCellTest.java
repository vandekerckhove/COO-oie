import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class TeleportCellTest {
	protected Board board;
	protected List<Player> listPlayers;
	protected Player p1;
	@Before
	   public void setUp() throws Exception {
		board = new StandardBoard();
		listPlayers = new ArrayList<Player>();
		p1=new Player("toto");	
		listPlayers.add(p1);
	}
	@Test
	public void testGetDest() {
		assertEquals(30, ((TeleportCell) board.getCell(42)).getDest());
	}
	
	@Test
	public void testHandleMove() {
		assertEquals(30, board.getCell(42).handleMove(9));
	}
}
