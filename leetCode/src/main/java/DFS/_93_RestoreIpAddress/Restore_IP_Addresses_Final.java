package DFS._93_RestoreIpAddress;

import java.util.ArrayList;
import java.util.List;

class Restore_IP_Addresses_Final {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        StringBuilder sb = new StringBuilder(s);
        dfs(res, sb, 0, 0);
        return res;
    }

    //优化：使用stringBuilder，故优化时间、空间复杂度，因为向字符串插入字符时无需复制整个字符串，从而减少了操作的时间复杂度，
    // 也不用开新空间存subString，从而减少了空间复杂度。
    private void dfs(List<String> res, StringBuilder sb, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(sb.substring(startIndex))) {
                res.add(sb.toString());
            }
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb.substring(startIndex, i + 1))) {
                sb.insert(i + 1, '.'); //在str的后⾯插⼊⼀个逗点
                pointNum++;
                dfs(res, sb, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为 i+2
                pointNum--;
                sb.deleteCharAt(i + 1); // 回溯删掉逗点
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
