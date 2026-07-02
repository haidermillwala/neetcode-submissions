class Solution {
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length())
            return false;
        
        Map<Character, Integer> characterCount = new HashMap<>();

        for(char ch: s.toCharArray()) {
            characterCount.put(ch, characterCount.getOrDefault(ch,0) + 1);
        }

        for(char ch: t.toCharArray()) {
            int count = characterCount.getOrDefault(ch,0);

            if (count == 0)
                return false;
            
            characterCount.put(ch, count - 1);
        }

        return true;
    }
}
