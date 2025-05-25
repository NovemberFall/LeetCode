package DFS.subset_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

class Restore_IP_Addresses_Final {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        dfs(s, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(String s, List<String> res, List<String> path, int startIndex) {
        if (path.size() > 4) {
            return;
        }
        if (path.size() == 4 && startIndex == s.length()) {
            res.add(String.join(".", path));
            return;
        }

        for (int j = startIndex; j < Math.min(startIndex + 3, s.length()); j++) {
            String segment = s.substring(startIndex, j + 1);
            if (isValid(segment)) {
                path.add(segment);
                dfs(s, res, path, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String substr) {
        if (substr.length() == 0 || substr.length() > 3) {
            return false;
        }
        if (substr.charAt(0) == '0' && substr.length() > 1) { // "01"
            return false;
        }
        if (Integer.parseInt(substr) > 255) {
            return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        Restore_IP_Addresses_Final restore_ip_addresses = new Restore_IP_Addresses_Final();
//        List<String> res = restore_ip_addresses.restoreIpAddresses("25525511135");
//        System.out.println(res);// [255.255.11.135, 255.255.111.35]
//    }
}
