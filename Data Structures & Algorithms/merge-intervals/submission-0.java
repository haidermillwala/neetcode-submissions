class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i=0; i<intervals.length; i++) {

            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            if(current[0] <= last[1]) {
                last[1] = Math.max(current[1], last[1]);
            } else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
