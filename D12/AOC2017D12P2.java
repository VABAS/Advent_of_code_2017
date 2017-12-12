import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D12P2 {
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
    ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
    // Going through the input multiple times to catch routes from later
    // programs also. Going through the input until no new routes are added.
    // Only one group can be added on each round so duplicates doesn't occur.
    boolean changed = true;
    boolean oneAdded = false;
    for (int l = 0; ; l++) {
      int index = l % input.size();
      if (index == 0) {
        if (!changed) {
          break;
        }
        changed = false;
        oneAdded = false;
      }
      boolean matchFound = false;
      for (ArrayList<Integer> group : groups) {
        if (group.contains(input.get(index).get(0))) {
          for (int i = 0; i < input.get(index).size(); i++) {
            // Merging arrays with same programs associated.
            for (int j = groups.size() - 1; j >= 0; j--) {
              if (groups.get(j).contains(input.get(index).get(i)) && group != groups.get(j)) {
                group.addAll(groups.get(j));
                groups.remove(groups.get(j));
              }
            }
            if (!group.contains(input.get(index).get(i))) {
              group.add(input.get(index).get(i));
              changed = true;
            }
          }
          matchFound = true;
          break;
        }
        for (int i = 0; i < input.get(index).size(); i++) {
          if (group.contains(input.get(index).get(i))) {
            for (int j = 0; j < input.get(index).size(); j++) {
              if(!group.contains(input.get(index).get(j))) {
                group.add(input.get(index).get(j));
              }
            }
            changed = true;
            matchFound = true;
            break;
          }
        }
      }
      if (!matchFound && !oneAdded) {
        groups.add(new ArrayList<Integer>());
        for (int i : input.get(index)){
          if (groups.get(groups.size() - 1).contains(i)) {
            continue;
          }
          groups.get(groups.size() - 1).add(i);
        }
        changed = true;
        oneAdded = true;
      }
    }
    System.out.println(groups.size());
  }
}
