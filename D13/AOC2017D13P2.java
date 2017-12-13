import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D13P2 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    ArrayList<Integer> input = new ArrayList<>();
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        String[] rowA = row.split(": ");
        int index = Integer.parseInt(rowA[0]);
        int value = Integer.parseInt(rowA[1]);
        while (input.size() < index) {
          input.add(0);
        }
        input.add(index, value);
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    int delay = 0;
    while (true) {
      boolean caught = false;
      for (int i = delay; i < input.size() + delay; i++) {
        int repairedI = i - delay;
        int pathLength = input.get(repairedI);
        int modulo = pathLength * 2 - 2;
        if (i % modulo == 0 && input.get(repairedI) > 0) {
          caught = true;
          break;
        }
      }
      if (!caught && delay >= 10) {
        break;
      }
      delay++;
    }
    System.out.println(delay);
  }
}
