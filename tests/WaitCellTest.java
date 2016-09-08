import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class WaitCellTest {
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
		assertFalse(board.getCell(19).canBeLeftNow());
		assertFalse(board.getCell(19).canBeLeftNow());
		assertFalse(board.getCell(19).canBeLeftNow());
		assertTrue(board.getCell(19).canBeLeftNow());
	}

}
