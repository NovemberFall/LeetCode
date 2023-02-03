package DFS._93_RestoreIpAddress;

import java.util.ArrayList;
import java.util.List;

class Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        dfs(res, s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

        }
    }
}
