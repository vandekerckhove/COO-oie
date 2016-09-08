import java.util.ArrayList;
import java.util.List;

/** A standard board of the game*/
public class StandardBoard extends Board{
	/**
	 * The constructor
	 */
	public StandardBoard() {
		super();
	}
	@Override
	protected List<Cell> initBoard() {
		List<Cell> cells = new ArrayList<Cell>(64);
		for(int i=0; i < 64; i++) {
			if(i == 0)
				cells.add(new StartCell(this, new ArrayList<Player>()));
			//event cells
			else if(i == 9 |i == 18 |i == 27 |i == 36 |i == 45 |i == 54 )
				cells.add(new GooseCell(this, null));
			else if(i == 31 || i == 52)
				cells.add(new TrapCell(this,null));
			else if(i == 19)
				cells.add(new WaitCell(this,null,3));
			else if(i == 6 || i == 42 || i == 58) {
				if(i==6) cells.add(new TeleportCell(this,null, 12));
				if(i==42) cells.add(new TeleportCell(this,null, 30));
				if(i==58) cells.add(new TeleportCell(this,null, 1));
				
			}
				
			else 
				cells.add(new NormalCell(this, null));
		}
		return cells;
	}
	
}
