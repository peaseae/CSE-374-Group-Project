//Accumulate all dependent tasks end to end in the map.

public class Algorithm3{	
    public static Task[] moveDependencies(Task[] tasks){ 
        Task[] result = new Task[tasks.length];
        int i = 0;
        recursive(tasks, result, i);
        return result;
    }    	   
    
    public static void recursive(Task[] tasks, Task[] result, int i) {
        for(Task task : tasks) {
            if (!task.hasDependencies()) {
                result[i] = task;
            } else {
                Task[] dependencies = task.getDependencies();
                recursive(dependencies, result, i);
            }
        }  
    }
}
