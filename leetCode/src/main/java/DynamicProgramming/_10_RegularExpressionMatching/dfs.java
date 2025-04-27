package DynamicProgramming._10_RegularExpressionMatching;

class dfs {
    private String s, p;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        //Note: "*b" is invalid!!!
        if (j == p.length()) {
            return i == s.length();
        }
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {// second char is *
            if (dfs(i, j + 2)) {
                return true;
            }
            if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                return dfs(i + 1, j);
            }
            return false;
        } else { // second char is not *
            if (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                return dfs(i + 1, j + 1);
            }
            return false;
        }
    }
}
