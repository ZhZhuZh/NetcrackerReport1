package task2;

import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    private final int n;
    private final int k;
    ArrayList<Player> players = new ArrayList<>();

    Game(int n, int k) {
        this.n = n;
        this.k = k;
        for (int i=0; i<n; i++) {
            Player player = new Player(0);
            players.add(player);
        }
    }

    public boolean someoneWon() {
        for(Player player : players){
            if (player.getCount()==7) {
                return true;
            }
        }
        return false;
    }

    public int whoWon() {
        int index = -1;
        for(int i = 0; i < n; i++){
            if (players.get(i).getCount()==7) {
                index = i;
            }
        }
        return index;
    }

    public void play() {
        int i=0;
        while (!someoneWon()) {
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
            ++i;
            players.get(indexOfPlayer).upCount();
            System.out.println("Player " + (indexOfPlayer + 1) + " win the round " + i);
        }
        int indexOfWinner = whoWon();
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
