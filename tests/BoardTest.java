import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	protected Board board;
	protected List<Player> listPlayers;
	@Before
	   public void setUp() throws Exception {
		board = new StandardBoard();
		listPlayers = new ArrayList<Player>();
		listPlayers.add(new Player("toto"));
		listPlayers.add(new Player("tata"));
	   }
	@Test
	public void testSize() {
		assertEquals(64, board.size());
	}
	@Test
	public void testGetCellStart() {
		assertEquals(board.cells.get(0), board.getCellStart());
	}
	@Test
	public void testGetCellEnd() {
		assertEquals(board.cells.get(63), board.getCellEnd());
	}
//	@Test
//	public void testPlayTurn() {
//		
//	}
	@Test
	public void testPutPlayerOnCell() {
		assertFalse(listPlayers.get(0).getNCell() == 50);
		assertFalse(listPlayers.get(0).equals(board.getCell(50).getPlayer()));
		board.putPlayerOnCell(listPlayers.get(0), board.getCell(10));
		assertEquals(10, listPlayers.get(0).getNCell());
	}
	@Test
	public void testputPlayerOnStart() {
		assertFalse(listPlayers.get(0).getNCell() == 50);
		assertFalse(listPlayers.get(0).equals(board.getCell(50).getPlayer()));
		board.putPlayerOnStart(listPlayers.get(0));
		assertEquals(0, listPlayers.get(0).getNCell());
	}
	@Test
	public void testSwapPlayers() {
		board.putPlayerOnCell(listPlayers.get(0), board.getCell(10));
		board.putPlayerOnCell(listPlayers.get(1), board.getCell(20));
		board.swapPlayers(listPlayers.get(0), listPlayers.get(1));
		assertEquals(20, listPlayers.get(0).getNCell());
		assertEquals(listPlayers.get(0),board.getCell(20).getPlayer());
		assertEquals(10, listPlayers.get(1).getNCell());
		assertEquals(listPlayers.get(1),board.getCell(10).getPlayer());
	}
	@Test
	public void testComputeTargetCellAndNormalizeIndex() {
		board.putPlayerOnStart(listPlayers.get(0));
		assertEquals(board.getCell(10),board.computeTargetCell(listPlayers.get(0),10));
		board.putPlayerOnStart(listPlayers.get(0));
		assertEquals(board.getCell(56),board.computeTargetCell(listPlayers.get(0),70));
		
	}
	

}
