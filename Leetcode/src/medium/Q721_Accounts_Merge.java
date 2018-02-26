package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Q721_Accounts_Merge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return result;
        }

        Map<String, String> owner = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                owner.put(email, name);
                parent.put(email, email);
            }
        }

        // construct parent for each account
        for (List<String> account : accounts) {
            String p = find(account.get(1), parent);
            for (int i = 2; i < account.size(); i++) {
                parent.put(find(account.get(i), parent), p);
            }
        }

        // union (parent -> the email list) for different accounts
        Map<String, Set<String>> union = new HashMap<>();
        for (List<String> account : accounts) {
            String p = find(account.get(1), parent);
            if (!union.containsKey(p)) {
                union.put(p, new TreeSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                union.get(p).add(email);
            }
        }

        // output to result
        for (String p : union.keySet()) {
            List<String> emails = new ArrayList<>(union.get(p));
            emails.add(0, owner.get(p));
            result.add(emails);
        }
        return result;
    }

    private static String find(String email, Map<String, String> parent) {
        return parent.get(email).equals(email) ? email : find(parent.get(email), parent);
    }

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList(new String[] {"John", "johnsmith@mail.com", "john00@mail.com"}),
                Arrays.asList(new String[] {"John", "johnnybravo@mail.com"}),
                Arrays.asList(new String[] {"John", "johnsmith@mail.com", "john_newyork@mail.com"}),
                Arrays.asList(new String[] {"Mary", "mary@mail.com"}));

        List<List<String>> accountsMerged = accountsMerge(accounts);
        for (List<String> account : accountsMerged) {
            System.out.println(account);
        }
    }
}
