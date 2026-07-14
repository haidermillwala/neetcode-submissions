class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] prefixProd = new int[n];
        int [] suffixProd = new int[n];

        int[] result = new int[n];

        prefixProd[0] = 1;
        for(int i=1; i<n; i++) {
            prefixProd[i] = nums[i-1] * prefixProd[i-1];
        }

        suffixProd[n-1] = 1;
        for(int j=n-2; j>=0; j--) {
            suffixProd[j] = nums[j+1] * suffixProd[j+1];
        }

        for(int k=0; k<n; k++) {
            result[k] = prefixProd[k] * suffixProd[k];
        }
        return result;
    }
}  
