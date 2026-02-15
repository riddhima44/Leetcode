// Last updated: 2/15/2026, 10:21:32 PM
1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder sb = new StringBuilder();
4
5        int i = a.length() - 1;
6        int j = b.length() - 1;
7        int carry = 0;
8
9        while (i >= 0 || j >= 0 || carry > 0) {
10
11            int sum = carry;
12
13            if (i >= 0) sum += a.charAt(i--) - '0';
14            if (j >= 0) sum += b.charAt(j--) - '0';
15
16            sb.append(sum % 2);  
17            carry = sum / 2;     
18        }
19
20        return sb.reverse().toString();
21    }
22}
23