import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D12P1 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        String[] rowA = row.split(" <-> ");
        input.add(new ArrayList<Integer>());
        input.get(input.size() - 1).add(Integer.parseInt(rowA[0]));
        for (String s : rowA[1].split(", ")) {
          input.get(input.size() - 1).add(Integer.parseInt(s));
        }
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    ArrayList<Integer> canCommunicate = new ArrayList<>();
    // Adding program zero as a starting point.
    canCommunicate.add(0);
    // Going through the input multiple times to catch routes from later
    // programs also. Going through the input until no new routes are added.
    int previousSize = -1;
    for (int l = 0; ; l++) {
      int index = l % input.size();
      if (index == 0) {
        if (previousSize == canCommunicate.size()) {
          break;
        }
        previousSize = canCommunicate.size();
      }
      if (!canCommunicate.contains(input.get(index).get(0))) {
        continue;
      }
      for (int i = 1; i < input.get(index).size(); i++) {
        if (canCommunicate.contains(input.get(index).get(i))) {
          continue;
        }
        canCommunicate.add(input.get(index).get(i));
      }
    }
    System.out.println(canCommunicate.size());
  }
}
