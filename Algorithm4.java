  public class Algorithm4 {
    public static void assignTasks(Task[] tasks, User[] users){
        int daysPassed = 0;
        int taskNum = 0;
        
        // until all tasks have been delegated, continuously cycle through users
        while (taskNum < tasks.length) {
            for (int i = 0; i<users.length && taskNum < tasks.length; i++) {
                // if a user is available, try to assign them a task
                if (!(users[i].isBusy(daysPassed))) {
                    users[i].finishLastTask();
                    
                    // if the current task has no unfinished dependencies and hasn't been assigned yet, assign it
                    if (!(tasks[taskNum].hasUnfinishedDependencies()) && !(tasks[taskNum].isAssigned())) {
                        users[i].addTask(tasks[taskNum]);
                        tasks[taskNum].setAssigned(true);
                        taskNum++;
                        // skip over any tasks that are already assigned
                        while (taskNum < tasks.length && tasks[taskNum].isAssigned()) {
                            taskNum++;
                        }
                        
                    // if the task you want to assign has an unfinished dependency,
                    // try to keep moving through to find the next unassigned task that can be completed
                    } else {
                        int tempCount = 1;
                        while (taskNum+tempCount < tasks.length) {
                            if (!(tasks[taskNum+tempCount].hasUnfinishedDependencies()) && !(tasks[taskNum+tempCount].isAssigned())) {
                                users[i].addTask(tasks[taskNum+tempCount]);
                                tasks[taskNum+tempCount].setAssigned(true);
                                break;
                            }
                            tempCount++;
                        }
                    }
                    
                }
            }
            // after cycling through all users, increment days passed
            daysPassed++;
        }
        
        // after assigning the last task, increase days passed until all users are finished
        for (int i = 0; i<users.length; i++) {
            while (users[i].isBusy(daysPassed)) {
                daysPassed++;
            }
            // print resulting assignments
            System.out.print("User "+users[i].getUserID()+": ");
            for (Task t : users[i].getTasks()) {
                System.out.print(t.getName()+" ");
            }
            System.out.println();
        }
        // print days to completion
        System.out.println("\nTime to complete project: "+daysPassed+" days");
    }
  }
