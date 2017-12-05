import java.io.BufferedReader;
import java.io.FileReader;

public class AOC2017D04P1 {
  // Checks that passphrase doesn't contain duplicate words.
  private static boolean isValid(String pw) {
    String[] pwA = pw.split(" ");
    for (int i = 0; i < pwA.length; i++) {
      for (int i2 = 0; i2 < pwA.length; i2++) {
        if (i == i2) {
          continue;
        }
        if (pwA[i].equals(pwA[i2])) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      int numValid = 0;
      String row;
      while ((row = file.readLine()) != null) {
        if (row.length() <= 0) {
          continue;
        }
        numValid += isValid(row) ? 1 : 0;
      }
      System.out.println(numValid);
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
    }
  }
}
