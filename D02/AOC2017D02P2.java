import java.io.BufferedReader;
import java.io.FileReader;

public class AOC2017D02P2 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      int checksum = 0;
      String row;
      while ((row = file.readLine()) != null) {
        String[] rowA = row.split("\t");
        for (int i = 0; i < rowA.length; i++) {
          outer:
          for (int i2 = i + 1; i2 < rowA.length; i2++) {
            int num1 = Integer.parseInt(rowA[i]);
            int num2 = Integer.parseInt(rowA[i2]);
            // If numbers are at wrong order, lets swap them. Otherwise division
            // returns incorrect values.
            if (num1 < num2) {
              num1 ^= num2;
              num2 ^= num1;
              num1 ^= num2;
            }
            if (num1 % num2 == 0) {
              checksum += num1 / num2;
              break outer;
            }
          }
        }
      }
      System.out.println(checksum);
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
    }
  }
}
