import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AOC2017D06P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    String[] input;
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      input = file.readLine().split("\t");
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    int[] banks = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      banks[i] = Integer.parseInt(input[i]);
    }
    ArrayList<int[]> history = new ArrayList<>();
    history.add(banks.clone());

    while (true) {
      // Finding out the bank with largest stack.
      int largest = 0;
      for (int i = 1; i < banks.length; i++) {
        if (banks[i] > banks[largest]) {
          largest = i;
        }
      }
      // Doing the redistribution.
      int realloc = banks[largest];
      banks[largest] = 0;
      int cur = largest;
      for (int i = 0; i < realloc; i++) {
        cur = (cur + 1) % banks.length;
        banks[cur]++;
      }
      for (int[] prev : history) {
        int sames = 0;
        for (int i = 0; i < prev.length; i++) {
          sames += (prev[i] == banks[i]) ? 1 : 0;
        }
        if (sames >= prev.length) {
          System.out.println(history.size());
          return;
        }
      }
      history.add(banks.clone());
    }
  }
}
