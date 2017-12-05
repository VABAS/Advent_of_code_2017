import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D05P2 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    ArrayList<Integer> instructions = new ArrayList<>();
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        instructions.add(Integer.parseInt(row));
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
    }
    int steps = 0;
    int i = 0;
    while (i < instructions.size()) {
      int prev = i;
      i += instructions.get(prev);
      if (instructions.get(prev) >= 3) {
        instructions.set(prev, instructions.get(prev) - 1);
      }
      else {
        instructions.set(prev, instructions.get(prev) + 1);
      }
      steps++;
    }
    System.out.println(steps);
  }
}
