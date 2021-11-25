import java.util.*;

class Main {
    static User u1 = new User(1, new ArrayList<Task>());
    static User u2 = new User(2, new ArrayList<Task>());
    static User u3 = new User(3, new ArrayList<Task>());
    static User[] users = {u1, u2, u3};
    static Task d = new Task("d", 1, 60, 9, new ArrayList<Task>());
    static Task c = new Task("c", 1, 60, 3, new ArrayList<Task>(Arrays.asList(d)));
    static Task b = new Task("b", 1, 60, 5, new ArrayList<Task>());
    static Task a = new Task("a", 1, 60, 10, new ArrayList<Task>(Arrays.asList(b, c)));
    static Task e = new Task("e", 1, 60, 27, new ArrayList<Task>());
    static Task g = new Task("g", 1, 60, 2, new ArrayList<Task>());
    static Task h = new Task("h", 1, 60, 10, new ArrayList<Task>());
    static Task f = new Task("f", 1, 60, 5, new ArrayList<Task>(Arrays.asList(h)));
    static Task i = new Task("i", 1, 60, 3, new ArrayList<Task>());
    static Task j = new Task("j", 1, 60, 5, new ArrayList<Task>());
    static Task n = new Task("n", 1, 60, 9, new ArrayList<Task>());
    static Task m = new Task("m", 1, 60, 3, new ArrayList<Task>(Arrays.asList(d)));
    static Task l = new Task("l", 1, 60, 5, new ArrayList<Task>());
    static Task k = new Task("k", 1, 60, 10, new ArrayList<Task>(Arrays.asList(b, c)));
    static Task o = new Task("o", 1, 60, 27, new ArrayList<Task>());
    static Task q = new Task("q", 1, 60, 2, new ArrayList<Task>());
    static Task p = new Task("p", 1, 60, 5, new ArrayList<Task>(Arrays.asList(h)));
    static Task r = new Task("r", 1, 60, 10, new ArrayList<Task>());
    static Task s = new Task("s", 1, 60, 3, new ArrayList<Task>());
    static Task t = new Task("t", 1, 60, 5, new ArrayList<Task>());
    //Example 1: 10 tasks, 3 users, all due in 30 days
    //static ArrayList<Task> tasks = new ArrayList<Task>(Arrays.asList(a,b,c,d,e,f,g,h,i,j));
    static Task[] tasks = {e,d,c,b,a,h,g,f,j,i};
    //Example 2: 20 tasks, 3 users, all due in 60 days
    // static ArrayList<Task> tasks = new ArrayList<Task>(Arrays.asList(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t));

    public static void main(String[] args) {
        Algorithm4.assignTasks(tasks, users);

    }
}