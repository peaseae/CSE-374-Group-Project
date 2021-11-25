import java.util.*;

public class Algorithm2 {
  public static int CalculateTime(Task t, int numUsers) {
    return CalculateTime(t, 0);
  }

  public static int CalculateTime(Task t, int time, int numUsers) {

    int completionTime = time;

    // if there are no dependencies
    if (t.getDependencies().size() == 0)
      return t.getEstimate();

    // if there are dependencies
    ArrayList<Task> dependencies = t.getDependencies();
    ArrayList<ArrayList<Task>> subgroups = new ArrayList<ArrayList<Task>>();

    // break dependencies into subgroups of size numUsers
    int start = 0;
    while(dependencies.size() > numUsers) {
      ArrayList<Task> subgroup = new ArrayList<Task>();
      subgroup.addAll(t.getDependencies().subList(start, start+numUsers));
      subgroups.add(subgroup);
      ArrayList<Task> temp = new ArrayList<Task>();
      temp.addAll(dependencies.subList(start+numUsers, dependencies.size()));
      dependencies = temp;
      System.out.println(dependencies.size());
      start+=numUsers;
    }
    subgroups.add(dependencies);
    
    // find total completion time by adding up max completion time in each subgroup
    for (ArrayList<Task> subgroup : subgroups) {
      int maxTime = Integer.MIN_VALUE;
      for (int i = 0; i<subgroup.size(); i++) {
        if (subgroup.get(i).getDependencies().size() > 0)
          subgroup.get(i).increaseEstimate(CalculateTime(subgroup.get(i), time));
        if (subgroup.get(i).getEstimate() > maxTime) {
          maxTime = subgroup.get(i).getEstimate();
        }
      }
      completionTime += maxTime;
    }
    return completionTime;
  }
}