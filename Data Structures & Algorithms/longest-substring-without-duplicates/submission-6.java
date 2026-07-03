class Solution {
    public int lengthOfLongestSubstring(String s) {
        

        int n = s.length();
        int[] hash = new int[264];
        Arrays.fill(hash, -1);

        int left=0, right=0, maxLen=0;

        while(right<n) {
            if(hash[s.charAt(right)] >= left) {
                left = Math.max(hash[s.charAt(right)] + 1, 1);
            }

            int len = right - left + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}
