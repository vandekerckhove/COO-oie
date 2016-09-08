import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GameTest {
	protected Board board;
	protected List<Player> listPlayers;
	protected Game game;
	@Before
	   public void setUp() throws Exception {
		board = new StandardBoard();
		listPlayers = new ArrayList<Player>();
		listPlayers.add(new Player("toto"));
		listPlayers.add(new Player("tata"));
		game = new Game(board, listPlayers);
	   }
	
	@Test
	public void testAllPlayersAreStuck() throws Exception{
		
		assertFalse(game.allPlayersAreStuck());
		board.putPlayerOnCell(listPlayers.get(0), board.getCell(31));
		board.putPlayerOnCell(listPlayers.get(1), board.getCell(52));
		assertTrue(game.allPlayersAreStuck());
	}
	@Test
	public void gameWithPlayerAtEndIsFinished() throws Exception {
	  assertFalse(game.isFinished());
	  game.getPlayers().get(0).moveTo(board.getCellEnd());
	  assertTrue(game.isFinished());
	}
	@Test
	public void testGameIsFinished(){
		assertFalse(game.isFinished());
		game.getPlayers().get(0).moveTo(board.getCellEnd());
		assertTrue(game.isFinished());
		game.getPlayers().get(0).moveTo(board.getCellStart());
		assertFalse(game.isFinished());
		board.putPlayerOnCell(listPlayers.get(0), board.getCell(31));
		board.putPlayerOnCell(listPlayers.get(1), board.getCell(52));
		assertTrue(game.isFinished());
	}
	@Test
	public void testThrowDie(){
		int throwDie = game.throwDie();
		assertTrue(throwDie>= 1 && throwDie <=6);
	}
	@Test
	public void testGetPlayers() {
		assertEquals(listPlayers, game.getPlayers());
	}
	@Test
	public void testGetBoard() {
		assertEquals(board, game.getBoard());
	}

}
