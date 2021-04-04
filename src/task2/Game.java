package task2;

import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    private int n;
    private final int k;
    ArrayList<Player> players = new ArrayList<Player>(n);

    Game(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public void play() {
        Player winner = new Player();
        int indexOfWinner = 0;
        winner.setCount(0);
        for (int i = 0; i < 7; i++) {
            System.out.println("Round " + (i + 1));
            int maxCount = 0;
            int indexOfPlayer=0;
            for (int l = 0; l < players.size(); l++) {
                int countForDices = 0;
                for (int f = 0; f < k-1; f++) {
                    countForDices += (int) (Math.random() * 6) + 1;
                }
                if (maxCount < countForDices) {
                    indexOfPlayer = l;
                    maxCount = countForDices;
                }
            }
            System.out.println(indexOfPlayer);
            players.get(indexOfPlayer).upCount();
            System.out.println("Player " + (indexOfPlayer + 1) + "win the round");
        }
        for (int j = 0; j < players.size(); j++) {
            if (winner.getCount() > players.get(j).getCount()) {
                winner.setCount(players.get(j).getCount());
                indexOfWinner = j;
            }
        }
        if (indexOfWinner == 0) {
            System.out.println("You win the game!");
        } else if (indexOfWinner == (n - 1)) {
            System.out.println("Computer win the game");
        } else {
            System.out.println("Player number " + (indexOfWinner + 1) + " win the game!");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        int n = scanner.nextInt();
        System.out.println("Enter number of dices: ");
        int k = scanner.nextInt();
        Game game = new Game(n, k);
        game.play();
    }
}
