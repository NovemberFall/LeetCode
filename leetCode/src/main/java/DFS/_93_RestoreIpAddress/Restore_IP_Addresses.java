package DFS._93_RestoreIpAddress;

import java.util.ArrayList;
import java.util.List;

class Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        dfs(res, s, new StringBuilder(), 3, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder curStr, int dotLeft, int startIndex) {
        if (dotLeft == 0) {
            if (isValid(s.substring(startIndex))) {
                curStr.append("." + s.substring(startIndex));
                res.add(curStr.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s.substring(startIndex, i + 1))) {
                int length = curStr.length();
                if (dotLeft == 3) {
                    curStr.append(s.substring(startIndex, i + 1));
                    dfs(res, s, curStr, dotLeft - 1, i + 1);
                    curStr.setLength(length);
                } else {
                    curStr.append("." + s.substring(startIndex, i + 1));
                    dfs(res, s, curStr, dotLeft - 1, i + 1);
                    curStr.setLength(length);
                }
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

    public static void main(String[] args) {
        Restore_IP_Addresses restore_ip_addresses = new Restore_IP_Addresses();
        List<String> res = restore_ip_addresses.restoreIpAddresses("25525511135");
        System.out.println(res);// [255.255.11.135, 255.255.111.35]
    }
}
