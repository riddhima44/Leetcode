// Last updated: 1/23/2026, 11:36:34 PM
1import java.util.*;
2
3class Solution {
4    static class Node {
5        long val;
6        int idx;
7        Node prev, next;
8        Node(int i, long v) {
9            idx = i;
10            val = v;
11        }
12    }
13    
14    static class Pair implements Comparable<Pair> {
15        long sum;
16        int leftIdx;
17        Pair(long s, int li) {
18            sum = s;
19            leftIdx = li;
20        }
21        public int compareTo(Pair o) {
22            if (sum != o.sum) return Long.compare(sum, o.sum);
23            return Integer.compare(leftIdx, o.leftIdx);
24        }
25    }
26    
27    public int minimumPairRemoval(int[] nums) {
28        int n = nums.length;
29        if (n <= 1) return 0;
30        
31        Node[] nodes = new Node[n];
32        TreeSet<Pair> pairSet = new TreeSet<>();
33        int decCount = 0;
34        
35        Node prevNode = null;
36        for (int i = 0; i < n; i++) {
37            Node node = new Node(i, nums[i]);
38            nodes[i] = node;
39            if (prevNode != null) {
40                node.prev = prevNode;
41                prevNode.next = node;
42                long pSum = prevNode.val + node.val;
43                pairSet.add(new Pair(pSum, prevNode.idx));
44                if (prevNode.val > node.val) decCount++;
45            }
46            prevNode = node;
47        }
48        
49        int ops = 0;
50        while (decCount > 0 && !pairSet.isEmpty()) {
51            Pair minPair = pairSet.pollFirst();
52            Node left = nodes[minPair.leftIdx];
53            Node right = left.next;
54            if (right == null || left.val + right.val != minPair.sum) {
55                continue;
56            }
57            ops++;
58            
59            if (left.val > right.val) decCount--;
60            
61            long oldLeftVal = left.val;
62            left.val += right.val;
63            
64            Node rightNext = right.next;
65            if (rightNext != null) {
66                if (right.val > rightNext.val) decCount--;
67            }
68            
69            left.next = rightNext;
70            if (rightNext != null) {
71                rightNext.prev = left;
72                if (left.val > rightNext.val) decCount++;
73                long newSum = left.val + rightNext.val;
74                pairSet.add(new Pair(newSum, left.idx));
75            }
76            
77            Node pLeft = left.prev;
78            if (pLeft != null) {
79                boolean oldPDec = (pLeft.val > oldLeftVal);
80                if (oldPDec) decCount--;
81                boolean newPDec = (pLeft.val > left.val);
82                if (newPDec) decCount++;
83                long newPSum = pLeft.val + left.val;
84                pairSet.add(new Pair(newPSum, pLeft.idx));
85            }
86            
87            right.prev = right.next = null;
88        }
89        return ops;
90    }
91}