package DFS.subset_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

class Restore_IP_Addresses_v2 {
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
            if (isValid(s.substring(startIndex))) {
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s.substring(startIndex, i + 1))) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1); //在str的后⾯插⼊⼀个逗点
                pointNum++;
                dfs(res, s, i + 2, pointNum); // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2); // 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.length() < 1) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) { // "01"
            return false;
        }
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}
