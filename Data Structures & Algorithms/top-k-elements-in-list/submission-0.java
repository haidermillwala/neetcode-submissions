class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        

        Map<Integer, Integer> eleFreq = new HashMap<>();

        for(int val: nums) {
            eleFreq.put(val, eleFreq.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
            );

        for(Map.Entry<Integer, Integer> entry: eleFreq.entrySet()) {
            pq.add(new int[] {entry.getValue(), entry.getKey()});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = result.length - 1;
        
        while(!pq.isEmpty()) {
            result[i--] = pq.poll()[1];
        }

        return result;
    }
}
