package Arrays;

import java.util.HashSet;
import java.util.Set;

class _929_UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            String[] strs = email.split("@");
            String local = strs[0];
            String domain = strs[1];
            for (int i = 0; i < local.length(); i++) {
                if (local.charAt(i) == '.') {
                    continue;
                }
                if (local.charAt(i) == '+') {
                    break;
                }
                sb.append(local.charAt(i));
            }
            sb.append("@" + domain);
            String key = sb.toString();
            set.add(key);
        }
        return set.size();
    }

    public static void main(String[] args) {
        _929_UniqueEmailAddresses uniqueEmailAddresses = new _929_UniqueEmailAddresses();
        String[] emails = new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"};
        int res = uniqueEmailAddresses.numUniqueEmails(emails);
        System.out.println(res);
    }
}
