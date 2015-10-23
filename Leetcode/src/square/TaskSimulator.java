package square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TaskSimulator {
	public static class Task {
		String name;
		int priority;
		List<Task> dependencies;
		public Task(String name, int priority) {
			this.name = name;
			this.priority = priority;
			this.dependencies = new ArrayList<Task>();
		}
	}
	
	public static class TaskComparator implements Comparator<Task> {
		public int compare(Task t1, Task t2) {
			return t2.priority - t1.priority;
		}
	}
	
	public static List<Task> simulate(List<Task> tasks) {
		Map<Task, Integer> map = new HashMap<Task, Integer>();
		for(Task task : tasks) {
			for(Task dependency : task.dependencies) {
				if(!map.containsKey(dependency)) {
					map.put(dependency, 1);
				} else {
					map.put(dependency, map.get(dependency) + 1);
				}
			}
		}
		
		Queue<Task> queue = new LinkedList<Task>();
		List<Task> result = new ArrayList<Task>();
		for(Task task : tasks) {
			if(!map.containsKey(task)) {
				result.add(task);
			}
		}
		
		Collections.sort(result, new TaskComparator());
		for(Task task : result) {
			queue.offer(task);
		}
		
		while(!queue.isEmpty()) {
			Task task = queue.poll();
			List<Task> list = new ArrayList<Task>();
			for(Task dependency : task.dependencies) {
				map.put(dependency, map.get(dependency) - 1);
				if(map.get(dependency) == 0) {
					list.add(dependency);
				}
			}
			Collections.sort(list, new TaskComparator());
			for(Task t : list) {
				queue.offer(t);
				result.add(t);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Task t1 = new Task("t1", 1);
		Task t2 = new Task("t2", 2);
		Task t3 = new Task("t3", 3);
		Task t4 = new Task("t4", 4);
		Task t5 = new Task("t5", 5);
		t5.dependencies.add(t2);
		t5.dependencies.add(t4);
		t2.dependencies.add(t1);
		t4.dependencies.add(t1);
		t4.dependencies.add(t3);
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(t1);
		tasks.add(t2);
		tasks.add(t3);
		tasks.add(t4);
		tasks.add(t5);
		List<Task> res = simulate(tasks);
		for(Task task : res) {
			System.out.println(task.name + " " + task.priority);
		}
	}
}
