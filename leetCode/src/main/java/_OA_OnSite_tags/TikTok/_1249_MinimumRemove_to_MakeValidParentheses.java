package _OA_OnSite_tags.TikTok;

class _1249_MinimumRemove_to_MakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        if (s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                sb.append(c);
                cnt++;
            } else if (c == ')' && cnt > 0) {
                sb.append(c);
                cnt--;
            } else if (c != ')') {
                sb.append(c);
            }
        }

        System.out.println(sb.toString()); // le(e(t(co)de)

        StringBuilder filtered = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && cnt > 0) {
                cnt--;
            } else {
                filtered.append(c);
            }
        }

        return filtered.reverse().toString();
    }

    public static void main(String[] args) {
        _1249_MinimumRemove_to_MakeValidParentheses minimumRemoveToMakeValidParentheses = new _1249_MinimumRemove_to_MakeValidParentheses();
        String s = "le(e(t(co)de)";
        minimumRemoveToMakeValidParentheses.minRemoveToMakeValid(s);
    }
}
