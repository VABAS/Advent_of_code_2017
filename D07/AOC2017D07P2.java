import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AOC2017D07P2 {
  public static int calculateWeight (Program p) {
    int combined = 0;
    if (p.getChildrens().size() > 0) {
      for (Program c : p.getChildrens()) {
        combined += calculateWeight(c);
      }
    }
    return combined + p.getWeight();
  }
  public static int findIncorrectWeight (Program p) {
    ArrayList<Program> childrens = p.getChildrens();
    if (childrens.size() == 0) {
      return 0;
    }
    int same;
    if (calculateWeight(childrens.get(1)) == calculateWeight(childrens.get(0))) {
      same = calculateWeight(childrens.get(1));
    }
    else {
      same = calculateWeight(childrens.get(2));
    }
    for (Program c : childrens) {
      if (calculateWeight(c) != same) {
        return findIncorrectWeight(c);
      }
    }
    ArrayList<Program> siblings = p.getParent().getChildrens();
    int correct;
    if (calculateWeight(siblings.get(0)) != calculateWeight(p)) {
      correct = calculateWeight(siblings.get(0));
    }
    else {
      correct = calculateWeight(siblings.get(1));
    }
    return correct - calculateWeight(p) + p.getWeight();
  }
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments! Input string is needed (file name)");
      return;
    }
    ArrayList<String> input = new ArrayList<>();
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      String row;
      while ((row = file.readLine()) != null) {
        input.add(row.replace("(", "").replace(")", ""));
      }
    }
    catch (Exception e) {
      System.out.println("Exception occured:");
      e.printStackTrace();
      return;
    }
    ArrayList<Program> programs = new ArrayList<>();
    // Finding out all the programs.
    for (String row : input) {
      String name = row.split(" ")[0];
      int weight = Integer.parseInt(row.split(" ")[1]);
      programs.add(new Program(name, weight));
    }
    // Next finding out the parents.
    for (String row : input) {
      String[] rowA = row.split(" -> ");
      if (rowA.length > 1) {
        String name = rowA[0].split(" ")[0];
        Program current = null;
        for (Program p : programs) {
          if (name.equals(p.getName())) {
            current = p;
            break;
          }
        }
        if (current == null) {
          continue;
        }
        for (String child : rowA[1].split(", ")) {
          for (Program p : programs) {
            if (child.equals(p.getName())) {
              p.addParent(current);
              current.addChildren(p);
            }
          }
        }
      }
    }
    Program root = null;
    // Finding out the root node.
    for (Program p : programs) {
      if (p.getParent() == null) {
        root = p;
        break;
      }
    }
    if (root == null) {
      System.out.println("ERROR: No root node found!");
      return;
    }
    //System.out.println("Root node is \"" + root.getName() + "\"");
    System.out.println(findIncorrectWeight(root));
  }
}
