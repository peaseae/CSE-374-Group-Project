import java.util.*;

class Main {
    static User u1 = new User(1, new ArrayList<Task>());
    static User u2 = new User(2, new ArrayList<Task>());
    static User u3 = new User(3, new ArrayList<Task>());
    static User[] users = {u1, u2, u3};
    
    // first 10 tasks (10 total)
    static Task d = new Task("d", 1, 60, 9, new Task[0]);
    static Task[] cArr = {d};
    static Task c = new Task("c", 2, 60, 3, cArr);
    static Task b = new Task("b", 3, 60, 5, new Task[0]);
    static Task[] aArr = {b, c};
    static Task a = new Task("a", 4, 60, 10, aArr);
    static Task e = new Task("e", 5, 60, 27, new Task[0]);
    static Task g = new Task("g", 6, 60, 2, new Task[0]);
    static Task[] fArr = {g};
    static Task f = new Task("f", 7, 60, 5, fArr);
    static Task h = new Task("h", 8, 60, 10, new Task[0]);
    static Task i = new Task("i", 9, 60, 3, new Task[0]);
    static Task j = new Task("j", 10, 60, 5, new Task[0]);
    // second set of tasks (add 10 so there are 20 total)
    static Task n = new Task("n", 11, 60, 9, new Task[0]);
    static Task[] mArr = {d};
    static Task m = new Task("m", 12, 60, 3, mArr);
    static Task l = new Task("l", 13, 60, 5, new Task[0]);
    static Task[] kArr = {b, c};
    static Task k = new Task("k", 14, 60, 10, kArr);
    static Task o = new Task("o", 15, 60, 27, new Task[0]);
    static Task q = new Task("q", 16, 60, 2, new Task[0]);
    static Task[] pArr = {h};
    static Task p = new Task("p", 17, 60, 5, pArr);
    static Task r = new Task("r", 18, 60, 10, new Task[0]);
    static Task s = new Task("s", 19, 60, 3, new Task[0]);
    static Task t = new Task("t", 20, 60, 5, new Task[0]);
    // third set of tasks (add 20 so there are 40 total)
    static Task dd = new Task("dd", 1, 90, 9, new Task[0]);
    static Task[] ccArr = {dd};
    static Task cc = new Task("cc", 2, 90, 3, ccArr);
    static Task bb = new Task("bb", 3, 90, 5, new Task[0]);
    static Task[] aaArr = {bb, cc};
    static Task aa = new Task("aa", 4, 90, 10, aaArr);
    static Task ee = new Task("ee", 5, 90, 27, new Task[0]);
    static Task gg = new Task("gg", 6, 90, 2, new Task[0]);
    static Task[] ffArr = {gg};
    static Task ff = new Task("ff", 7, 90, 5, ffArr);
    static Task hh = new Task("hh", 8, 90, 10, new Task[0]);
    static Task ii = new Task("ii", 9, 90, 3, new Task[0]);
    static Task jj = new Task("jj", 10, 90, 5, new Task[0]);
    static Task nn = new Task("nn", 11, 90, 9, new Task[0]);
    static Task[] mmArr = {dd};
    static Task mm = new Task("mm", 12, 90, 3, mmArr);
    static Task ll = new Task("ll", 13, 90, 5, new Task[0]);
    static Task[] kkArr = {bb, cc};
    static Task kk = new Task("kk", 14, 90, 10, kkArr);
    static Task oo = new Task("oo", 15, 90, 27, new Task[0]);
    static Task qq = new Task("qq", 16, 90, 2, new Task[0]);
    static Task[] ppArr = {hh};
    static Task pp = new Task("pp", 17, 90, 5, ppArr);
    static Task rr = new Task("rr", 18, 90, 10, new Task[0]);
    static Task ss = new Task("ss", 19, 90, 3, new Task[0]);
    static Task tt = new Task("tt", 20, 90, 5, new Task[0]);
    
    // Example 1: 10 tasks, 3 users, all due in 30 days
    static Task[] tasks = {a,b,c,d,e,f,g,h,i,j};
    // Example 2: 20 tasks, 3 users, all due in 60 days
    //static Task[] tasks = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t};
    // Example 3: 40 tasks, 3 users, all due in 90 days
    //static Task[] tasks = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm,nn,oo,pp,qq,rr,ss,tt};

    public static void main(String[] args) {
        
        // Run algorithm 1 and print result
        Task[] sortedTasks = Algorithm1.sortUrgency(tasks, users.length);
        System.out.println("Result of Algorithms 1 and 2");
        for (Task t : sortedTasks) {
            System.out.print(t.getName()+":"+t.getTotalEstimate() + "  ");
        }
        
        // Run algorithm 3 and print result
        sortedTasks = Algorithm3.sortTasks(sortedTasks);
        System.out.println("\n\nResult of Algorithm 3");
        for (Task t : sortedTasks) {
            System.out.print(t.getName()+":"+t.getTotalEstimate() + "  ");
        }
        
        // Run algorithm 4, which automatically prints assignments and days passed
        System.out.println("\n\nResult of Algorithm 4");
        Algorithm4.assignTasks(tasks, users);
    }
}
