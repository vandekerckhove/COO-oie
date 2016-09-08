import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** A customize board of the game*/
public class CustomBoard extends Board{
	private final Random random = new Random();
	/**The size of the board*/
	private int size;
	/**The number of goose cells*/
	private int nbGoose;
	/**The number of trap cells*/
	private int nbTrap;
	/**The number of wait cells*/
	private int nbWait;
	/**The number of teleport cells*/
	private int nbTp;

	/**
	 * The constructor
	 * @param size the size of the board
	 * @param nbGoose the number of goose cells
	 * @param nbTrap the number of trap cells
	 * @param nbWait the number of wait cells
	 * @param nbTp the number of teleport cells
	 */
	public CustomBoard(int size, int nbGoose, int nbTrap, int nbWait, int nbTp){
		super();
		this.size=size;
		this.nbGoose=nbGoose;
		this.nbTrap=nbTrap;
		this.nbWait=nbWait;
		this.nbTp=nbTp;
		this.cells=initBoard();
	}
	@Override
	protected List<Cell> initBoard() {
		List<Cell> cells = new ArrayList<Cell>();
		if(size <= (nbGoose+nbTrap+nbWait+nbTp)){
			for(int i=0; i < 64; i++) {
				if(i == 0)
					cells.add(new StartCell(this, new ArrayList<Player>()));
				else
					cells.add(new NormalCell(this,null));
			}
		} else {
			List<Integer> numbers = new  ArrayList<Integer>();
			int rand;
			while(numbers.size()<nbGoose+nbTrap+nbWait+nbTp){
				rand=random.nextInt(size-2)+1;
				if(!numbers.contains(rand))
					numbers.add(rand);
			}
			List<Integer> gooses = numbers.subList(0, nbGoose);
			List<Integer> traps = numbers.subList(nbGoose, nbGoose+nbTrap);
			List<Integer> wait = numbers.subList(nbGoose+nbTrap, nbGoose+nbTrap+nbWait);
			List<Integer> tp = numbers.subList(nbGoose+nbTrap+nbWait, nbGoose+nbTrap+nbWait+nbTp);
				
			for(Integer i=0; i < size; i++) {
				if(i == 0)
					cells.add(new StartCell(this, new ArrayList<Player>()));
				
				else if(gooses.contains(i))
					cells.add(new GooseCell(this, null));
				else if(traps.contains(i)){
					cells.add(new TrapCell(this,null));
				}
				else if(wait.contains(i))
					cells.add(new WaitCell(this,null,random.nextInt(3)+1));
				else if(tp.contains(i)) {
					cells.add(new TeleportCell(this,null, random.nextInt(size-2)+1));
					
				}
					
				else 
					cells.add(new NormalCell(this, null));
			}
		}
		return cells;
	}
	

}
