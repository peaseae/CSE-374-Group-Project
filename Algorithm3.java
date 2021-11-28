import java.util.ArrayList;
import java.util.Arrays;

public class Algorithm3 {
    public static Task[] sortTasks(Task[] tasks) {
        for (Task t : tasks) {
            if (t.hasDependencies()) {
                // Storing all the depended Task object into an ArrayList
                ArrayList<Task> depTask = new ArrayList<Task>();
                for (Task t2 : t.getDependencies()) {
                    depTask.add(t2);
                }
                // Calling switch position method
                tasks = addDepTask(tasks, t, depTask);
            }
        }
        return tasks;
    }
    
    /**
     * This method put all depended tasks in front of the Task t
     * @param tasks input Task[] array, this is the original array
     * @param t the Task object that is currently checking for dependency
     * @param depTask the ArrayList of Task objects which are depended with Task t
     * @return the modified input Task[] array, this is the original array
     */
    public static Task[] addDepTask (Task[] tasks, Task t, ArrayList<Task> depTask) {
        // Copying the Task[] tasks into an identical ArrayList tasksAL
        ArrayList<Task> tasksAL = new ArrayList<Task>(Arrays.asList(tasks));
        for (Task t1 : depTask) {
            tasksAL.add(tasksAL.indexOf(t), t1);
        }
        // Copying the ArrayList tasksAL back into the array Task[] tasks
        tasks = tasksAL.toArray(new Task[tasksAL.size()]);
        return tasks;
    }
    
}
