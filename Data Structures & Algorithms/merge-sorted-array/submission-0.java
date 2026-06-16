class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] results = new int[m + n];
        int i=0, j=0, k=0;

        while (i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                results[k++] = nums1[i++];
            } else {
                results[k++] = nums2[j++];
            }
        }

        while (i < m) {
            results[k++] = nums1[i++];
        }

        while (j < n) {
            results[k++] = nums2[j++];
        }

        for(int a=0; a<results.length; a++) {
            nums1[a] = results[a];
        }
    }
}