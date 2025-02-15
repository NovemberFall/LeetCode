package DynamicProgramming._10_RegularExpressionMatching;

//class memorization_dfs {
//    public boolean isMatch(String s, String p) {
//        return dfs(s, p, 0, 0, new HashMap<>());
//    }
//
//    private boolean dfs(String s, String p, int si, int pi, HashMap<String, Boolean> dp) {
//        String key = si + "," + pi;
//        if (dp.containsKey(key)) {
//            return dp.get(key);
//        }
//
//        if (pi == p.length()) {
//            return si == s.length();
//        }
//    }
//}
