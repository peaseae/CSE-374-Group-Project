import java.util.*;

class Main {
    static User u1 = new User(1, new ArrayList<Task>());
    static User u2 = new User(2, new ArrayList<Task>());
    static User u3 = new User(3, new ArrayList<Task>());
    static User[] users = {u1, u2, u3};
    
    static Task d = new Task("d", 1, 60, 9, new Task[0]);
    static Task[] cArr = {d};
    static Task c = new Task("c", 1, 60, 3, cArr);
    static Task b = new Task("b", 1, 60, 5, new Task[0]);
    static Task[] aArr = {b, c};
    static Task a = new Task("a", 1, 60, 10, aArr);
    static Task e = new Task("e", 1, 60, 27, new Task[0]);
    static Task g = new Task("g", 1, 60, 2, new Task[0]);
    static Task[] fArr = {g};
    static Task f = new Task("f", 1, 60, 5, fArr);
    static Task h = new Task("h", 1, 60, 10, new Task[0]);
    static Task i = new Task("i", 1, 60, 3, new Task[0]);
    static Task j = new Task("j", 1, 60, 5, new Task[0]);
    static Task n = new Task("n", 1, 60, 9, new Task[0]);
    static Task[] mArr = {d};
    static Task m = new Task("m", 1, 60, 3, mArr);
    static Task l = new Task("l", 1, 60, 5, new Task[0]);
    static Task[] kArr = {b, c};
    static Task k = new Task("k", 1, 60, 10, kArr);
    static Task o = new Task("o", 1, 60, 27, new Task[0]);
    static Task q = new Task("q", 1, 60, 2, new Task[0]);
    static Task[] pArr = {h};
    static Task p = new Task("p", 1, 60, 5, pArr);
    static Task r = new Task("r", 1, 60, 10, new Task[0]);
    static Task s = new Task("s", 1, 60, 3, new Task[0]);
    static Task t = new Task("t", 1, 60, 5, new Task[0]);
    
    //Example 1: 10 tasks, 3 users, all due in 30 days
    static Task[] tasks = {a,b,c,d,e,f,g,h,i,j};
    //static Task[] tasks = {e,d,c,b,a,h,g,f,j,i};
    //Example 2: 20 tasks, 3 users, all due in 60 days
    // static Task[] tasks = new Task[](Arrays.asList(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t));

    public static void main(String[] args) {
        
        Task[] sortedTasks = Algorithm1.sortUrgency(tasks, users.length);
        // Print result of algorithm 1
        for (Task t : sortedTasks) {
            System.out.print(t.getName()+":"+t.getTotalEstimate() + "  ");
        }
        // Algorithm4.assignTasks(tasks, users);
    }
}
