import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose game: \n1 = Threads play\n2 - Play with user ");
        int choice = scanner.nextInt();

        Game game;
        if (choice == 1) {
            game = new SelfGame();
        } else {
            game = new UserGame();
        }
        game.playGame();
    

    }
}