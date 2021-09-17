import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Battleships {

  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Let's play Battleships!\n");

    int rowCount = 6;
    ArrayList<ArrayList<String>> board = printBoard(rowCount);
    for (int i=0; i < rowCount; i++) {
      System.out.println(board.get(i));
    }

    int shipRow = randomRow(board);
    int shipCol = randomCol(board);
    System.out.println(shipRow);
    System.out.println(shipCol);

    int maxGuesses = 10;
    for (int turn = 1; turn < maxGuesses; turn++) {

      System.out.println("Turn " + turn);

      System.out.println("Guess row: ");
      int guessRow = Integer.valueOf(scanner.nextLine());
      System.out.println("Guess column: ");
      int guessCol = Integer.valueOf(scanner.nextLine());

      if ((guessRow == shipRow) && (guessCol == shipCol)) {
          System.out.println("Congratulations! You sunk my battleship!");
          break;
      } else {
        if ((guessRow < 0 || guessRow > 5) || (guessCol < 0 || guessCol > 5)) {
          System.out.println("Oops, that's not even in the ocean.");
        } else if (board.get(guessRow).get(guessCol) == "X") {
          System.out.println("You guessed that one already.");
        } else {
          System.out.println("You missed my battleship!");
          board.get(guessRow).set(guessCol,"X");
        }
      }
      if (turn == maxGuesses-1) {
        System.out.println("Game Over");
      }

      for (int i=0; i < rowCount; i++) {
        System.out.println(board.get(i));
      }

    }

  }

  public static ArrayList<ArrayList<String>> printBoard(int rowCount) {

    ArrayList<ArrayList<String>> board = new ArrayList<>(rowCount);

    for (int i=0; i < rowCount; i++) {
      board.add(new ArrayList());
    }

    int columnCount = rowCount;
    for (int i=0; i < rowCount; i++) {
      for (int j=0; j < columnCount; j++) {
        board.get(i).add("O");
      }
    }

    return board;

  }

  public static Integer randomRow(ArrayList<ArrayList<String>> board) {
    return ThreadLocalRandom.current().nextInt(0, board.size());
  }

  public static Integer randomCol(ArrayList<ArrayList<String>> board) {
    return ThreadLocalRandom.current().nextInt(0, board.get(0).size());
  }
}
