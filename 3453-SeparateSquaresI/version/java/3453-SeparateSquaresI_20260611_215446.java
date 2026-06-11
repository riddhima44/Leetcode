// Last updated: 6/11/2026, 9:54:46 PM
1class Solution {
2
3    static class Robot {
4        int pos;
5        int health;
6        int idx;
7        char dir;
8
9        Robot(int p, int h, int i, char d) {
10            pos = p;
11            health = h;
12            idx = i;
13            dir = d;
14        }
15    }
16
17    public List<Integer> survivedRobotsHealths(
18            int[] positions,
19            int[] healths,
20            String directions) {
21
22        int n = positions.length;
23
24        Robot[] robots = new Robot[n];
25
26        for (int i = 0; i < n; i++) {
27            robots[i] = new Robot(
28                    positions[i],
29                    healths[i],
30                    i,
31                    directions.charAt(i));
32        }
33
34        Arrays.sort(robots, (a, b) -> a.pos - b.pos);
35
36        Stack<Robot> stack = new Stack<>();
37
38        for (Robot curr : robots) {
39
40            if (curr.dir == 'R') {
41                stack.push(curr);
42                continue;
43            }
44
45            while (!stack.isEmpty()
46                    && stack.peek().dir == 'R'
47                    && curr.health > 0) {
48
49                Robot top = stack.peek();
50
51                if (top.health == curr.health) {
52                    stack.pop();
53                    curr.health = 0;
54                    break;
55                }
56
57                if (top.health > curr.health) {
58                    top.health--;
59                    curr.health = 0;
60                    break;
61                }
62
63                stack.pop();
64                curr.health--;
65            }
66
67            if (curr.health > 0) {
68                stack.push(curr);
69            }
70        }
71
72        List<Robot> survivors = new ArrayList<>(stack);
73
74        survivors.sort((a, b) -> a.idx - b.idx);
75
76        List<Integer> ans = new ArrayList<>();
77
78        for (Robot r : survivors) {
79            ans.add(r.health);
80        }
81
82        return ans;
83    }
84}