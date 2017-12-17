import java.util.ArrayList;

public class AOC2017D17P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed");
      return;
    }
    int input = Integer.parseInt(args[0]);
    int target = 2018;
    ArrayList<Integer> buffer = new ArrayList<>();
    buffer.add(0);
    int pos = 0;
    for (int i = 1; i < target; i++) {
      pos = ((pos + input) % buffer.size()) + 1;
      buffer.add(pos, i);
    }
    System.out.println(buffer.get(pos + 1));
  }
}
