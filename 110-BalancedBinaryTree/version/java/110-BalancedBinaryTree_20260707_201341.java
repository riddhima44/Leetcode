// Last updated: 7/7/2026, 8:13:41 PM
1class Solution {
2
3    class TrieNode {
4        TrieNode[] child = new TrieNode[26];
5        int bestIndex = -1;
6    }
7
8    TrieNode root = new TrieNode();
9    String[] words;
10
11    private void update(TrieNode node, int idx) {
12        if (node.bestIndex == -1 ||
13            words[idx].length() < words[node.bestIndex].length() ||
14            (words[idx].length() == words[node.bestIndex].length()
15                    && idx < node.bestIndex)) {
16            node.bestIndex = idx;
17        }
18    }
19
20    private void insert(String word, int idx) {
21        TrieNode curr = root;
22        update(curr, idx);
23
24        for (int i = word.length() - 1; i >= 0; i--) {
25            int c = word.charAt(i) - 'a';
26
27            if (curr.child[c] == null)
28                curr.child[c] = new TrieNode();
29
30            curr = curr.child[c];
31            update(curr, idx);
32        }
33    }
34
35    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
36
37        words = wordsContainer;
38
39        for (int i = 0; i < wordsContainer.length; i++)
40            insert(wordsContainer[i], i);
41
42        int[] ans = new int[wordsQuery.length];
43
44        for (int i = 0; i < wordsQuery.length; i++) {
45
46            TrieNode curr = root;
47
48            String q = wordsQuery[i];
49
50            for (int j = q.length() - 1; j >= 0; j--) {
51                int c = q.charAt(j) - 'a';
52
53                if (curr.child[c] == null)
54                    break;
55
56                curr = curr.child[c];
57            }
58
59            ans[i] = curr.bestIndex;
60        }
61
62        return ans;
63    }
64}