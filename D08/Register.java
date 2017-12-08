import java.util.ArrayList;

public class Register {
  private ArrayList<String> indexes;
  private ArrayList<Integer> values;
  private Integer highest;

  public Register () {
    indexes = new ArrayList<>();
    values = new ArrayList<>();
  }

  public void addValue (String i, int v) {
    indexes.add(i);
    values.add(v);
  }

  public void doOperation (String index, int cond, String conds, String condi, String op, int amount) throws Exception {
    if (!indexes.contains(index)) {
      addValue(index, 0);
    }
    if (!indexes.contains(condi)) {
      addValue(condi, 0);
    }
    int i = indexes.indexOf(index);
    int ci = indexes.indexOf(condi);
    boolean isDoable;
    switch (conds) {
      case "==":
        isDoable = values.get(ci) == cond;
        break;
      case "<=":
        isDoable = values.get(ci) <= cond;
        break;
      case ">=":
        isDoable = values.get(ci) >= cond;
        break;
      case "<":
        isDoable = values.get(ci) < cond;
        break;
      case ">":
        isDoable = values.get(ci) > cond;
        break;
      case "!=":
        isDoable = values.get(ci) != cond;
        break;
      default:
        throw new Exception ("Illegal condition string \"" + conds + "\"");
    }
    if (isDoable) {
      switch (op) {
        case "inc":
          values.set(i, values.get(i) + amount);
          break;
        case "dec":
          values.set(i, values.get(i) - amount);
          break;
        default:
          throw new Exception ("Illegal operation string \"" + op + "\"");
      }
    }
    if (highest == null) {
      highest = values.get(i);
    }
    else if (values.get(i) > highest) {
      highest = values.get(i);
    }
  }
  public int greatestValue () {
    int greatestValue = values.get(0);
    for (int i = 1; i < values.size(); i++) {
      if (values.get(i) > greatestValue) {
        greatestValue = values.get(i);
      }
    }
    return greatestValue;
  }

  public int getHighest () {
    return highest;
  }
}
