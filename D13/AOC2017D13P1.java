import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D13P1 {
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
    int severity = 0;
    for (int i = 0; i < input.size(); i++) {
      int pathLength = input.get(i);
      int modulo = pathLength * 2 - 2;
      if (i % modulo == 0) {
        severity += i * input.get(i);
      }
    }
    System.out.println(severity);
  }
}
