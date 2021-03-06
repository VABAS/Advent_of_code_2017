import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D09P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    String input = "";
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        input += row;
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    boolean garbage = false;
    int currentValue = 0;
    int total = 0;
    for (int i = 0; i < input.length(); i++) {
      switch (input.charAt(i)) {
        case '!':
          i++;
          continue;
        case '<':
          garbage = true;
          break;
        case '>':
          garbage = false;
          break;
        case '{':
          if (!garbage){
            currentValue++;
          }
          break;
        case '}':
          if (!garbage) {
            total += currentValue;
            currentValue--;
          }
          break;
      }
    }
    System.out.println(total);
  }
}
