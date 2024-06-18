package phone_OA_OnSite.TikTok;

class _856_ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int res = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
            } else {
                depth--;
                if (i > 0 && s.charAt(i - 1) == '(') {
                    res += Math.pow(2, depth);
                }
            }
        }
        return res;
    }
}
