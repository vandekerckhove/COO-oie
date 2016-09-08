import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class AbstractCellTest {
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
	public void testCanBeLeftNow() {
		assertTrue(board.getCell(10).canBeLeftNow());
		
		assertFalse(board.getCell(31).canBeLeftNow());
		
		assertFalse(board.getCell(19).canBeLeftNow());
		assertFalse(board.getCell(19).canBeLeftNow());
		assertFalse(board.getCell(19).canBeLeftNow());
		assertTrue(board.getCell(19).canBeLeftNow());
	}
	@Test
	public void testIsRetaining() {
		assertFalse(board.getCell(10).isRetaining());
		assertTrue(board.getCell(31).isRetaining());
	}
	@Test
	public void testGetIndex() {
		assertEquals(10, board.getCell(10).getIndex());
	}
	@Test
	public void testHandleMove() {
		assertEquals(18, board.getCell(9).handleMove(9));
		assertEquals(5, board.getCell(5).handleMove(9));
		assertEquals(30, board.getCell(42).handleMove(9));
	}
	@Test
	public void testIsBusy() {
		assertFalse(board.getCell(10).isBusy());
		board.putPlayerOnCell(p1, board.getCell(10));
		assertTrue(board.getCell(10).isBusy());
	}
	@Test
	public void testGetPlayer() {
		board.putPlayerOnCell(p1, board.getCell(10));
		assertEquals(p1, board.getCell(10).getPlayer());
	}
	@Test
	public void testWelcome() {
		board.getCell(10).welcome(p1);
		assertEquals(p1, board.getCell(10).getPlayer());
	}
	@Test
	public void testToString() {
		assertEquals("cell 0",board.getCell(0).toString());
	}
}
