// Last updated: 1/19/2026, 9:57:27 PM
import java.util.*;

class TaskManager {

    private static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int u, int t, int p) {
            userId = u;
            taskId = t;
            priority = p;
        }
    }

    // Order: priority DESC, taskId DESC
    private TreeSet<Task> set;
    private Map<Integer, Task> map;

    public TaskManager(List<List<Integer>> tasks) {
        set = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority)
                return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId);
        });

        map = new HashMap<>();

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        set.add(task);
        map.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task task = map.get(taskId);
        set.remove(task);          // MUST remove first
        task.priority = newPriority;
        set.add(task);             // reinsert
    }

    public void rmv(int taskId) {
        Task task = map.get(taskId);
        set.remove(task);
        map.remove(taskId);
    }

    public int execTop() {
        if (set.isEmpty()) return -1;

        Task task = set.first();   // highest priority
        set.remove(task);
        map.remove(task.taskId);
        return task.userId;
    }
}


/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */