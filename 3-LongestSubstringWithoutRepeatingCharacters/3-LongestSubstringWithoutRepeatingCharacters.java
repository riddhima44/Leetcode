// Last updated: 1/19/2026, 10:50:55 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int we=0;
        int ws=0;
        int maxlen=Integer.MIN_VALUE;
        int len=0;
        HashMap<Character,Integer> map= new HashMap<>();
        while(we<s.length()){
            char ch=s.charAt(we);
            if(map.containsKey(ch)&&map.get(ch)>=ws){
                ws=map.get(ch)+1;
            }
            map.put(ch,we);
           
            len=we-ws+1;
            maxlen=Math.max(maxlen,len);
             we++;
        }
        return (maxlen==Integer.MIN_VALUE)?0:maxlen;
    }
}