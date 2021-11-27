import java.security.InvalidParameterException;
import java.util.*;

public class Task {
    private String name;
    private int id, urgency, dueDate, estimate;
    private int totalEstimate;
    private boolean isFinished;
    private boolean isAssigned;
    private Task[] dependencies;

    // Constructors
    public Task(String input) {

    }

    public Task(String name, int[] input, boolean isFinished, Task[] dependencies) {
        setName(name);
        setId(input[0]);
        setUrgency(input[1]);
        setDueDate(input[2]);
        setEstimate(input[3]);
        setTotalEstimate(input[3]);
        setFinished(isFinished);
        setDependencies(dependencies);
    }

    public Task(String name, int id, int dueDate, int estimate, Task[] dependencies) {
        setName(name);
        setId(0);
        setDueDate(dueDate);
        setEstimate(estimate);
        setTotalEstimate(estimate);
        setFinished(false);
        setDependencies(dependencies);
    }

    public boolean hasDependencies() {
        if (dependencies == null || dependencies.length == 0) {
            return false;
        }
        return true;
    }
    
    public boolean hasUnfinishedDependencies() {
        if (dependencies == null || dependencies.length == 0) {
            return false;
        }
        for (Task d : dependencies) {
            if (!(d.isFinished))
                return true;
            if (d.hasDependencies()) {
                for (Task dd : d.getDependencies()) {
                    return dd.hasUnfinishedDependencies();
                }
            }
        }
        return false;
    }

    public void increaseEstimate(int estimate) {
        this.totalEstimate += estimate;
    }

    // Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public int getEstimate() {
        return estimate;
    }

    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }

    public int getTotalEstimate() {
        return totalEstimate;
    }

    public void setTotalEstimate(int totalEstimate) {
        this.totalEstimate = totalEstimate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    public Task[] getDependencies() {
        return this.dependencies;
    }

    public void setDependencies(Task[] dependencies) {
        this.dependencies = dependencies;
    }

}
