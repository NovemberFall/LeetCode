package String;

/**
 How does "ablmy" stand true to "a*b.*y"?

     a* ---> a
     b ---> b
     .* ----> . . ----> lm
     y ----> y

     In regular expression, single * has no meaning. It has to be *
     Examples:
     a*
     b*
     .*
 */
class _10_RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {// second char is *
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p);
            }
            return false;
        } else {                                    // second char is not *
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "ablmy", s2 = "a*b.*y";
        boolean res = isMatch(s1, s2);
        System.out.println(res);
    }
}


