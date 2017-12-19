import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D19P2 {
  private static enum Direction {UP, RIGHT, DOWN, LEFT};
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    ArrayList<ArrayList<Character>> input = new ArrayList<>();
    int startIndex = -1;
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        input.add(new ArrayList<Character>());
        for (int i = 0; i < row.length(); i++) {
          if (startIndex < 0 && row.charAt(i) == '|') {
            startIndex = input.get(0).size();
          }
          input.get(input.size() - 1).add(row.charAt(i));
        }
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
    }
    int x = startIndex;
    int y = 0;
    Direction dir = Direction.DOWN;
    int numSteps = 0;
    while (true) {
      if (dir == Direction.DOWN){
        y++;
      }
      else if (dir == Direction.UP) {
        y--;
      }
      if (dir == Direction.RIGHT){
        x++;
      }
      else if (dir == Direction.LEFT) {
        x--;
      }
      numSteps++;
      char cur;
      try {
        cur = input.get(y).get(x);
      }
      catch (IndexOutOfBoundsException e) {
        break;
      }
      if (cur == ' ') {
        break;
      }
      else if (cur == '+') {
        if (dir == Direction.UP || dir == Direction.DOWN) {
          if (x > 0) {
            if (input.get(y).get(x - 1) != ' ' && input.get(y).get(x - 1) != '|') {
              dir = Direction.LEFT;
              continue;
            }
          }
          if (x < input.get(y).size() - 1) {
            if (input.get(y).get(x + 1) != ' ' && input.get(y).get(x + 1) != '|') {
              dir = Direction.RIGHT;
              continue;
            }
          }
        }
        if (dir == Direction.RIGHT || dir == Direction.LEFT) {
          if (y > 0) {
            if (input.get(y - 1).get(x) != ' ' && input.get(y - 1).get(x) != '-') {
              dir = Direction.UP;
              continue;
            }
          }
          if (y < input.size() - 1) {
            if (input.get(y + 1).get(x) != ' ' && input.get(y + 1).get(x) != '-') {
              dir = Direction.DOWN;
              continue;
            }
          }
        }
      }
    }
    System.out.println(numSteps);
  }
}
