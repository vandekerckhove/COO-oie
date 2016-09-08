import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GooseCellTest {
	protected Board board;
	protected List<Player> listPlayers;
	@Before
	   public void setUp() throws Exception {
		board = new StandardBoard();
		listPlayers = new ArrayList<Player>();
	}
	@Test
	public void testToString() {
		assertEquals("goose 9", board.getCell(9).toString());
	}

}
