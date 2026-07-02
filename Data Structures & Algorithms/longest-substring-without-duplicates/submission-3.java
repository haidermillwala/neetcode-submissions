class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        
        for (int i=0; i<s.length(); i++) {

            int[] hash = new int[256]; // For extended ASCII
            Arrays.fill(hash, 0);

            for(int j=i; j<s.length(); j++) {

                if(hash[s.charAt(j)] == 1)
                    break;
                
                else {
                    res = Math.max(res, j-i+1);
                    hash[s.charAt(j)] = 1;
                }
            }
        }
        return res;
    }
}
