import java.io.BufferedReader;
import java.io.FileReader;

public class AOC2017D02P1 {
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
        int largest = Integer.parseInt(rowA[0]);
        int smallest = Integer.parseInt(rowA[0]);
        for (int i = 1; i < rowA.length; i++) {
          int thisValue = Integer.parseInt(rowA[i]);
          if (thisValue < smallest) {
            smallest = thisValue;
          }
          else if (thisValue > largest) {
            largest = thisValue;
          }
        }
        checksum += largest - smallest;
      }
      System.out.println(checksum);
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
    }
  }
}
