//Accumulate all dependent tasks end to end in the map.
// Task[] tasks = {Task a, Task b, Task c};
// a.getDependencies(); = {Task b, Task c};
// ...
// tasks = {Task b, Task c, Task a};

// public Task[] demo(Task[] tasks) {

// }
// for (Task t : task) {
//    int[] a = new int[10];
//    Task[] tmp = new Task[task.size()];
//    tmp = t.getDependencies()
//    for (Task i : tmp) {
//        把Task-i插到Task-t之前的位置
//    }
// }
//
//

public class Algorithm3{	
    public static Task[] isdepend(Task[] tasks){ 
        for(int i = 0; i < tasks.length; i++) {
            Task[] temp = new Task[tasks.length];
            temp = tasks[i].getDependencies().toArray(tasks);
            for(Task j : temp) {
                for(int k= tasks.length-1; k>0; k--) {
                    tasks[k] = tasks[k-1];
                }
                //tasks[0] = temp;

            }     
        }
        return tasks;
    }    	   
}
