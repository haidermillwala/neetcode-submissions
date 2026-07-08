class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int hash[] = new int[264];
        int result = 0;
        Arrays.fill(hash, -1);
        int left=0, right=0;
        while(right<n) {

            if(hash[s.charAt(right)] >= left) {
                left = hash[s.charAt(right)] + 1;
            }

            int len = right - left + 1;
            result  = Math.max(len, result);
            hash[s.charAt(right)] = right;
            right++;
            
        }
        return result;
    }
}
