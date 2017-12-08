import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D08P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    ArrayList<String> input = new ArrayList<>();
    Register reg = new Register();
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        String[] rowA = row.split(" ");
        String index = rowA[0];
        String operation = rowA[1];
        int amount = Integer.parseInt(rowA[2]);
        String conditionIndex = rowA[4];
        String conditionString = rowA[5];
        int condition = Integer.parseInt(rowA[6]);
        reg.doOperation(index, condition, conditionString, conditionIndex, operation, amount);
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    System.out.println(reg.greatestValue());
  }
}
