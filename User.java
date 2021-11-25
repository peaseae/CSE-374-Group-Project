import java.util.ArrayList;

public class User {

    // unique ID for each user
    private int userID;

    // Tasks that a user responses.
    ArrayList<Task> tasks = new ArrayList<>();
    
    // constructor
    public User(int userID, ArrayList<Task> tasks) {
        this.userID = userID;
        this.tasks = tasks;
    }
    
    public boolean isBusy(int daysPassed) {
        int busyUntil = 0;
        ArrayList<Task> tasks = this.getTasks();
        for (Task t : tasks) {
            busyUntil += t.getEstimate();
        }
        if (busyUntil > daysPassed)
            return true;
        return false;
    }
    
    public void finishLastTask() {
        if (!tasks.isEmpty()) {
            tasks.get(tasks.size()-1).setFinished(true);
        }
    }

    public void addTask(Task t) {
        tasks.add(t);
    }
    
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}