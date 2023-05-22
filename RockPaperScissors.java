import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {

		boolean playingFlag = true;

		while (playingFlag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("How many rounds would you like to play (1-10)");
			String[] plays = new String[] { "Rock", "Paper", "Scissors" };
			int tieCounter = 0;
			int userWCounter = 0;
			int computerWCounter = 0;

			try {
				int rounds = Integer.parseInt(sc.nextLine());

				if (rounds < 1 || rounds > 10) {
					System.out.println("Error: Invalid Input");
					sc.close();
					return;
				}
				while (rounds != 0) {
					boolean validFlag = false;
					do {
						System.out.println("Select: Rock(1) | Paper(2) | Scissors(3)");
						try {
							int choice = Integer.parseInt(sc.nextLine());
							if (choice > 3 || choice < 1) {
								throw new Exception();
							}
							Random rand = new Random();
							int computerChoice = rand.nextInt(3) + 1;

							if (choice == computerChoice) {
								System.out.println("Its a tie! Both selected " + plays[computerChoice - 1]);
								tieCounter++;
								validFlag = true;
							} else if ((computerChoice - choice) == 1 || (computerChoice - choice) == -2) {
								System.out.println("Computer Wins");
								System.out.println(plays[computerChoice - 1] + " beats " + plays[choice - 1]);
								computerWCounter++;
								validFlag = true;

							} else {
								System.out.println("Player Wins");
								System.out.println(plays[choice - 1] + " beats " + plays[computerChoice - 1]);
								userWCounter++;
								validFlag = true;
							}

							rounds--;
						} catch (Exception e) {
							System.out.println("Invalid input, try again.");
						}

						System.out.println();

					} while (!validFlag);
				}

			} catch (Exception e) {
				sc.close();
				return;
			}

			System.out.println("Ties: " + tieCounter);
			System.out.println("Computer Wins: " + computerWCounter);
			System.out.println("Player Wins: " + userWCounter);

			if (userWCounter > computerWCounter) {
				System.out.println("\nPlayer Wins!");
			} else if (userWCounter < computerWCounter) {
				System.out.println("\nComputer Wins!");
			} else {
				System.out.println("\nAn Overall Tie");
			}

			System.out.println("\nIf you would like to play again press Y otherwise enter any key to exit");

			String input = sc.nextLine().toLowerCase();

			if (!input.equals("y")) {
				playingFlag = false;
				System.out.println("Thanks for playing!");
			}

			sc.close();
		}

	}

}
