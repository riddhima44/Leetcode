// Last updated: 2/20/2026, 11:33:38 PM
1import java.util.*;
2
3class Solution {
4    public String makeLargestSpecial(String s) {
5        if (s.length() <= 2) return s;
6        
7        List<String> list = new ArrayList<>();
8        int count = 0;
9        int start = 0;
10        
11        for (int i = 0; i < s.length(); i++) {
12            if (s.charAt(i) == '1') count++;
13            else count--;
14            
15            if (count == 0) {
16                // recursively solve inside
17                String inner = makeLargestSpecial(s.substring(start + 1, i));
18                list.add("1" + inner + "0");
19                start = i + 1;
20            }
21        }
22        
23        // sort descending
24        Collections.sort(list, Collections.reverseOrder());
25        
26        StringBuilder result = new StringBuilder();
27        for (String str : list) {
28            result.append(str);
29        }
30        
31        return result.toString();
32    }
33}