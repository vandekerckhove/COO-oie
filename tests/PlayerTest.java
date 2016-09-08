import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest {
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
	public void testGetNCell() {
		board.putPlayerOnCell(p1, board.getCell(10));
		assertEquals(10,p1.getNCell());
	}
	@Test
	public void testSetNCell() {
		assertFalse(p1.getNCell()==10);
		p1.setNCell(10);
		assertTrue(p1.getNCell()==10);
	}
	@Test
	public void testMoveTo() {
		p1.moveTo(board.getCell(10));
		assertEquals(10, p1.getNCell());
		assertEquals(p1,board.getCell(10).getPlayer());
	}
	@Test
	public void testToString() {
		assertEquals("toto", p1.toString());
	}

}
