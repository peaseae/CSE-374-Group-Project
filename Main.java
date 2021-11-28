import java.util.*;

class Main {
    
    static User u1 = new User(1, new ArrayList<Task>());
    static User u2 = new User(2, new ArrayList<Task>());
    static User u3 = new User(3, new ArrayList<Task>());
    static User[] users = {u1, u2, u3};
    
    // first 10 tasks (10 total)
    static Task d = new Task("d", 1, 120, 9, new Task[0]);
    static Task[] cArr = {d};
    static Task c = new Task("c", 2, 120, 3, cArr); // complex
    static Task b = new Task("b", 3, 120, 5, new Task[0]);
    static Task[] aArr = {b, c}; // complex
    static Task a = new Task("a", 4, 120, 10, aArr);
    static Task e = new Task("e", 5, 120, 27, new Task[0]);
    static Task g = new Task("g", 6, 120, 2, new Task[0]);
    static Task[] fArr = {g};
    static Task f = new Task("f", 7, 120, 5, fArr);
    static Task h = new Task("h", 8, 120, 10, new Task[0]);
    static Task i = new Task("i", 9, 120, 3, new Task[0]);
    static Task j = new Task("j", 10, 120, 5, new Task[0]);
    // second set of tasks (add 10 so there are 20 total)
    static Task n = new Task("n", 11, 120, 9, new Task[0]);
    static Task[] mArr = {d};
    static Task m = new Task("m", 12, 120, 3, mArr);
    static Task l = new Task("l", 13, 120, 5, new Task[0]);
    static Task[] kArr = {b, c};
    static Task k = new Task("k", 14, 120, 10, kArr);
    static Task o = new Task("o", 15, 120, 27, new Task[0]);
    static Task q = new Task("q", 16, 120, 2, new Task[0]);
    static Task[] pArr = {h};
    static Task p = new Task("p", 17, 120, 5, pArr);
    static Task r = new Task("r", 18, 120, 10, new Task[0]);
    static Task s = new Task("s", 19, 120, 3, new Task[0]);
    static Task t = new Task("t", 20, 120, 5, new Task[0]);
    // third set of tasks (add 20 so there are 40 total)
    static Task dd = new Task("dd", 1, 120, 9, new Task[0]);
    static Task[] ccArr = {dd};
    static Task cc = new Task("cc", 2, 120, 3, ccArr);
    static Task bb = new Task("bb", 3, 120, 5, new Task[0]);
    static Task[] aaArr = {bb, cc};
    static Task aa = new Task("aa", 4, 120, 10, aaArr);
    static Task ee = new Task("ee", 5, 120, 27, new Task[0]);
    static Task gg = new Task("gg", 6, 120, 2, new Task[0]);
    static Task[] ffArr = {gg};
    static Task ff = new Task("ff", 7, 120, 5, ffArr);
    static Task hh = new Task("hh", 8, 120, 10, new Task[0]);
    static Task ii = new Task("ii", 9, 120, 3, new Task[0]);
    static Task jj = new Task("jj", 10, 120, 5, new Task[0]);
    static Task nn = new Task("nn", 11, 120, 9, new Task[0]);
    static Task[] mmArr = {dd};
    static Task mm = new Task("mm", 12, 120, 3, mmArr);
    static Task ll = new Task("ll", 13, 120, 5, new Task[0]);
    static Task[] kkArr = {bb, cc};
    static Task kk = new Task("kk", 14, 120, 10, kkArr);
    static Task oo = new Task("oo", 15, 120, 27, new Task[0]);
    static Task qq = new Task("qq", 16, 120, 2, new Task[0]);
    static Task[] ppArr = {hh};
    static Task pp = new Task("pp", 17, 120, 5, ppArr);
    static Task rr = new Task("rr", 18, 120, 10, new Task[0]);
    static Task ss = new Task("ss", 19, 120, 3, new Task[0]);
    static Task tt = new Task("tt", 20, 120, 5, new Task[0]);
    
    // Example 1: 10 tasks, 3 users
//    static Task[] unsortedTasks = {a,b,c,d,e,f,g,h,i,j};
//    static Task[] tasks = {e,d,c,b,a,g,h,f,j,i};
    // Example 2: 20 tasks, 3 users
//    static Task[] unsortedTasks = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t};
//    static Task[] tasks = {o,e,n,m,l,k,d,c,b,a,p,r,h,f,t,j,i,s,q,g};
//    // Example 3: 40 tasks, 3 users
    static Task[] unsortedTasks = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm,nn,oo,pp,qq,rr,ss,tt};
    static Task[] tasks = {o,e,oo,ee,n,m,l,k,nn,mm,ll,kk,d,c,b,a,dd,cc,bb,aa,pp,p,rr,r,h,hh,ff,f,tt,j,jj,t,ss,s,i,ii,g,qq,gg,q};
    
    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        
        // Run algorithm 1 and print result
        Task[] sortedTasks = Algorithm1.sortUrgency(unsortedTasks, users.length);
        System.out.println("Result of Algorithms 1 and 2");
        for (Task t : sortedTasks) {
            System.out.print(t.getName()+":"+t.getTotalEstimate() + "  ");
        }
        
        // Run algorithm 3 and print result
        sortedTasks = Algorithm3.sortTasks(sortedTasks);
        System.out.println("\n\nResult of Algorithm 3");
        for (Task t : tasks) {
            System.out.print(t.getName()+":"+t.getTotalEstimate() + "  ");
        }
        
        // Run algorithm 4, which automatically prints assignments and days passed
        System.out.println("\n\nResult of Algorithm 4");
        Algorithm4.assignTasks(tasks, users);
        
        long endTime = System.nanoTime();
        
        System.out.println("Time to run program: "+ (endTime-startTime) + " ns");
    }
}
