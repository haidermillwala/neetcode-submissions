
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            int difference = target - nums[i];

            if (map.containsKey(difference)) {
                result[0] = Math.min(i, map.get(difference));
                result[1] = Math.max(i, map.get(difference));
            } else {
                map.put(nums[i], i);
            }
        }
    return result;
    }
}