import java.util.Scanner;  ////Evgeny Vasylev 336550686 | Maxim Sirotenko 328663547

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