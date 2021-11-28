
public class Algorithm1 {
    public static Task[] sortUrgency(Task[] data, int numUsers) {
        Task[] tasks = new Task[data.length];
        for (Task i : data) {
            if (i.hasDependencies() && i.getEstimate()==i.getTotalEstimate()) {
                i.increaseEstimate(Algorithm2.CalculateTime(i, numUsers));
            }
            int urgency = i.getDueDate() - i.getTotalEstimate();
            i.setUrgency(urgency);
        }
        return sort(data);
    }

    public static int partition(Task[] list, int low, int high, boolean isRev) {
        int pivot = list[high].getUrgency();
        int small = low - 1;
        if (!isRev) {
            for (int i = low; i < high; i++) {
                if (list[i].getUrgency() > pivot) {
                    small++;
                    Task tmp = list[i];
                    list[i] = list[small];
                    list[small] = tmp;
                }
            }
        } else {
            for (int i = low; i < high; i++) {
                if (list[i].getUrgency() < pivot) {
                    small++;
                    Task tmp = list[i];
                    list[i] = list[small];
                    list[small] = tmp;
                }
            }
        }
        Task tmp = list[high];
        list[high] = list[small + 1];
        list[small + 1] = tmp;
        return small + 1;
    }

    public static void quick(Task[] list, int low, int high, boolean isRev) {
        if (low < high) {
            int pivot = partition(list, low, high, isRev);
            quick(list, low, pivot - 1, isRev);
            quick(list, pivot + 1, high, isRev);
        }
    }

    public static Task[] sort(Task[] list) {
        //      int[][] result = new int[2][list.length];
        quick(list, 0, list.length - 1, true);
        //      for (int i = 0; i < list.length; i++) {
        //          result[0][i] = list[i].getUrgency();
        //      }
        //      quick(list, 0, list.length - 1, true);
        //      for (int i = 0; i < list.length; i++) {
        //          result[1][i] = list[i].getUrgency();
        //      }
        return list;
    }

    // main method used for testing
    public static void main(String[] args) {
                Task[] tasks = new Task[10];
                for (int i = 0; i < 10; i++) {
                    Task t = new Task("" + i);
                    tasks[i] = t;
                    tasks[i].setDueDate(10);
                    tasks[i].setEstimate(i);
                    System.out.print("(" + t.getDueDate() + " " + t.getEstimate() + "), ");
                }
                System.out.println();
                // numUsers hard coded to 3 for testing purposes
                Task[] sortedTasks = sortUrgency(tasks, 3);
                for (Task t : sortedTasks) {
                    System.out.print(t.getUrgency() + " ");
                }
    }

}