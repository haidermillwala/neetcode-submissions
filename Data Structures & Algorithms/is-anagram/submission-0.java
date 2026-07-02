class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length())
            return false;
        
        Map<Character, Integer> characterCount = new HashMap<>();

        for(char ch: s.toCharArray()) {
            characterCount.put(ch, characterCount.getOrDefault(ch,0) + 1);
        }

        for(char ch: t.toCharArray()) {
            characterCount.put(ch, characterCount.getOrDefault(ch,0) - 1);
        }

        for(var pair: characterCount.entrySet()) {
            if(pair.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
