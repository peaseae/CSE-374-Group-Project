import java.util.*;

public class Algorithm2 {

    public static int CalculateTime(Task t, int numUsers) {
        return CalculateTime(t, 0, numUsers);
    }

    public static int CalculateTime(Task t, int time, int numUsers) {

        int completionTime = time;

        // if there are no dependencies
        if (t.getDependencies().length == 0)
            return t.getTotalEstimate();

        // if there are dependencies
        Task[] dependencies = t.getDependencies();
        ArrayList<Task[]> subgroups = new ArrayList<Task[]>();

        // break dependencies into subgroups of size numUsers
        int start = 0;
        while(dependencies.length > numUsers) {
            Task[] subgroup = new Task[numUsers];
            subgroup = Arrays.copyOfRange(t.getDependencies(), start, start+numUsers);
            subgroups.add(subgroup);
            dependencies = Arrays.copyOfRange(dependencies, start+numUsers, dependencies.length);
            start+=numUsers;
        }
        subgroups.add(dependencies);

        // find total completion time by adding up max completion time in each subgroup
        for (Task[] subgroup : subgroups) {
            int maxTime = Integer.MIN_VALUE;
            for (int i = 0; i<subgroup.length; i++) {
                if (subgroup[i].getDependencies().length > 0)
                    subgroup[i].increaseEstimate(CalculateTime(subgroup[i], time, numUsers));
                if (subgroup[i].getTotalEstimate() > maxTime) {
                    maxTime = subgroup[i].getTotalEstimate();
                }
            }
            completionTime += maxTime;
        }
        return completionTime;
    }
}