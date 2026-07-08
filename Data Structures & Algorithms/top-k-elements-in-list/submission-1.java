class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> eleFreq = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            eleFreq.put(nums[i], eleFreq.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        for(Map.Entry<Integer, Integer> entry: eleFreq.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey()});

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i = k-1; i>=0; i--) {
            
            result[i] = pq.poll()[1];
        }

        return result;
    }
}
