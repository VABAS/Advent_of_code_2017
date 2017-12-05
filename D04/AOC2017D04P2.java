import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D04P2 {
  // Checks wether the two words are anagrams.
  private static boolean isAnagram(String w1, String w2) {
    if (w1.length() != w2.length()) {
      return false;
    }
    ArrayList<Integer> blacklist = new ArrayList<>();
    for (int i = 0; i < w1.length(); i++) {
      for (int i2 = 0; i2 < w2.length(); i2++) {
        if (blacklist.contains(i2)) {
          continue;
        }
        if (w1.charAt(i) == w2.charAt(i2)) {
          blacklist.add(i2);
        }
      }
    }
    if (w2.length() == blacklist.size()) {
      return true;
    }
    return false;
  }

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
        if (isAnagram(pwA[i], pwA[i2])) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed...");
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
