class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        return new ArrayList<>(Arrays.stream(strs)
                        .collect(
                            Collectors.groupingBy(word -> getKey(word))
                        )
                        .values()
        );
    }

    public static String getKey(String word) {
        int[] frequency = new int[26];
        StringBuilder builder = new StringBuilder();

        for(char c: word.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        for (int i: frequency) {
            builder.append("#").append(i);
        }
        return builder.toString();
    }
}
