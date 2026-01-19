// Last updated: 1/19/2026, 10:47:17 PM
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        
        String prev = "";
        
        for (String word : words) {
            if (!isAnagram(prev, word)) {
                result.add(word);
                prev = word;
            }
        }
        
        return result;
    }
    
    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        
        Arrays.sort(ca);
        Arrays.sort(cb);
        
        return Arrays.equals(ca, cb);
    }
}
