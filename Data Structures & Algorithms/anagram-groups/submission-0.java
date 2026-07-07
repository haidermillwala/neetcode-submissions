class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> result = new HashMap<>();

        for(String word: strs) {

            int[] freq = new int[26];

            for(char c: word.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int count: freq) {
                key.append("#").append(count);
            }

            result.computeIfAbsent(key.toString(), k -> new ArrayList())
                .add(word);
            
        }

        return new ArrayList<>(result.values());
    }
}
