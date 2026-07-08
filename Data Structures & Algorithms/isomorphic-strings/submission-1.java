class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length())
            return false;

        int n = s.length();

        for(int i=0; i<n; i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            for (int j=i; j<n; j++) {

                if(s.charAt(j) == c1 && t.charAt(j) != c2) {
                    return false;
                }

                if(t.charAt(j) == c2 && s.charAt(j) != c1)
                    return false;
            }
        }
        return true;
    }
}