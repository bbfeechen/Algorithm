package linkedin;

import java.util.HashSet;
import java.util.Set;

public class Find_the_Celebrity {
	static int knows[][];

	public static int findCelebrity(Set<Integer> group) {
		return isCelebrity(group, 0);
	}

	public static int isCelebrity(Set<Integer> group, int personInKRow) {
		if (personInKRow >= group.size()) {
			return -1;
		}

		if (!knows(personInKRow, personInKRow)) {
			return isCelebrity(group, personInKRow + 1);

		}
		for (int j = personInKRow + 1; j < group.size(); j++) {
			if (knows(personInKRow, j)) {
				return isCelebrity(group, j);
			} else {
				// personInKRow does not know j -j is not the celebrity
			}
		}
		return checkCandidate(personInKRow,group.size());
	}
	
	private static int checkCandidate(int candidate, int size) {
		int count = 0;
		for(int i = 0;i < size; i++){
			if(i != candidate && knows(i, candidate) && !knows(candidate, i))
				count++;
		}
		if(count == (size-1))
			return candidate;
		else
			return -1;
	}

	private static boolean knows(int i, int j) {
		return (knows[i][j] == 1);
	}

	public static void main(String[] args) {
		knows = new int[][] { 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0 }, 
				{ 0, 0, 0, 1, 0 }, 
				{ 0, 0, 0, 0, 1 } };
		
		Set<Integer> people = new HashSet<Integer>();
		for (int i = 0; i < 5; i++) {
			people.add(i);
		}
		System.out.println(findCelebrity(people));
	}
}
