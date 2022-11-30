package String;

class _44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sp = 0, pp = 0, match = 0, starIdx = -1;
        while (sp < s.length()){
            // advancing both pointers
            if (pp < p.length()  && (p.charAt(pp) == '?' || s.charAt(sp) == p.charAt(pp))){
                sp++;
                pp++;
            }
            // * found, only advancing pattern pointer
            else if (pp < p.length() && p.charAt(pp) == '*'){
                starIdx = pp;
                match = sp;
                pp++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                pp = starIdx + 1;
                match++;
                sp = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else {
                return false;
            }
        }

        //check for remaining characters in pattern
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }

        return pp == p.length();
    }

    public static void main(String[] args) {
        _44_WildcardMatching wm = new _44_WildcardMatching();
        String s = "acdcb", p = "a*c?b";
        boolean res = wm.isMatch(s, p);
        System.out.println(res);
    }
}
