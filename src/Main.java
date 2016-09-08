import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose the number of players");
			Board board;
			Game game;
			int nbPlayers = sc.nextInt();
			List<Player> listPlayers = new ArrayList<Player>();
			for(int i =0; i< nbPlayers;i++){
				listPlayers.add(new Player("player"+(i+1)));
			}
			System.out.println("Use a custom board ? (y/n)");
			sc.nextLine();
			String choice = sc.nextLine();
			char choiceChar = choice.charAt(0);
			if(choiceChar=='y') {
				int size, nbGoose, nbTrap, nbWait, nbTp;
				System.out.println("Size of the board ?");
				size = sc.nextInt();
				System.out.println("Number of goose cells ?");
				nbGoose = sc.nextInt();
				System.out.println("Number of trap cells ?");
				nbTrap = sc.nextInt();
				System.out.println("Number of wait cells ?");
				nbWait = sc.nextInt();
				System.out.println("Number of teleport cells ?");
				nbTp = sc.nextInt();
				board = new CustomBoard(size, nbGoose, nbTrap, nbWait, nbTp);
			}
			else if (choiceChar =='n') {
				board = new StandardBoard();
			}
			else{
				System.out.println("Please choose yes or no");
				return;
			}
			game = new Game(board, listPlayers);
			System.out.println(game.board.toString());
			game.play();
		}catch (Exception e) {
			System.out.println("Please enter a correct number");
		}
			
	}
}
