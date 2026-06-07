class Solution {
    public int maxArea(int[] heights) {
        
        int left=0, right=heights.length - 1;
        int result = 0;
        while (left < right ) {
            int water = Math.min(heights[left], heights[right]) * (right - left);
            result = Math.max(water, result);

            if(heights[left] < heights[right])
                left += 1;
            else 
                right -= 1;
        }

        return result;
    }
}
