package medium;

public class Q277_Find_the_Celebrity {
    public static int findCelebrity(int n) {
        // Step 1. find candidate
        // 1. the people before candidate should not be celebrity, because they know someone before candidate
        // 2. the people after candidate should not be known to candidate, otherwise they will be the candidate
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Step 2. check the people before the candidate is known to him or not
        for (int i = 0; i < candidate; i++) {
            if (knows(candidate, i)) {
                return -1;
            }
        }

        // Step 3. check the people after the candidate all knows him or not
        for (int i = candidate + 1; i < n; i++) {
            if (!knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;

        // Map<Integer, Integer> fans = new HashMap<>();
        // Map<Integer, Integer> idols = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == j) {
        //             continue;
        //         }
        //         if (knows(j, i)) {
        //             fans.put(i, fans.getOrDefault(i, 0) + 1);
        //             idols.put(j, idols.getOrDefault(j, 0) + 1);
        //         }
        //     }
        // }
        // for (Map.Entry entry : fans.entrySet()) {
        //     int id = (Integer) entry.getKey();
        //     int numOfFans = (Integer) entry.getValue();
        //     int numOfIdols = idols.containsKey(id) ? idols.get(id) : 0;
        //     if (numOfFans == n - 1 && numOfIdols == 0) {
        //         return id;
        //     }
        // }
        // return -1;
    }

    private static boolean knows(int a, int b) {
        return true;
    }

    public static void main(String[] args) {

    }
}
