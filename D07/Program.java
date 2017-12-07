import java.util.ArrayList;

public class Program {
  private String name;
  private int weight;
  private Program parent;
  private ArrayList<Program> childrens;

  public Program (String n, int w) {
    this.name = n;
    this.weight = w;
    this.childrens = new ArrayList<>();
  }

  public String getName () {
    return this.name;
  }
  public int getWeight () {
    return this.weight;
  }
  public void addParent (Program p) {
    this.parent = p;
  }
  public Program getParent () {
    return this.parent;
  }
  public void addChildren (Program p) {
    this.childrens.add(p);
  }
  public ArrayList<Program> getChildrens () {
    return this.childrens;
  }

}
