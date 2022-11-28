package DFS._93_RestoreIpAddress;

import java.util.ArrayList;
import java.util.List;

class RecursiveSolution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(res, s, "", 0);
        return res;
    }

    // input: "25525511135"
    //@str 当前剩下的可以取的 String, 假如 已经取了 255，剩余： 25511135
    //@sub 当前取到的数字, 比如 '2',  '25', '255'
    private void dfs(List<String> res, String str, String sub, int index) {
        //str.length() == 0, 所有数字都已经读完
        if (index == 4 && str.length() == 0) {
            res.add(sub.substring(1));
            // 只取到 '1'往后的数值，每一次都给最前面 + '.', 比如： .111.111.111.111
        }

        //与前面不能对调
        if (index == 4 || str.length() == 0) {
            return;
        }
        //1) 一位数
        dfs(res, str.substring(1), sub + "." + str.substring(0, 1), index + 1);

        //2) 两位数 （第一个数字不能为 0， 剩余string长度大于1，两位数
        if (str.charAt(0) != '0' && str.length() > 1) {
            dfs(res, str.substring(2), sub + "." + str.substring(0, 2), index + 1);

            //3) 三位数 (第一个数不能为0 + 剩余string长度大于2 + ‘xxx’ <= 255)
            if (str.length() > 2 && Integer.parseInt(str.substring(0, 3)) <= 255) {
                dfs(res, str.substring(3), sub + "." + str.substring(0, 3), index + 1);
            }
        }
    }
}
