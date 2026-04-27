// Last updated: 4/28/2026, 1:23:11 AM
1class LUPrefix {
2
3    private boolean[] uploaded;
4    private int curr;
5
6    public LUPrefix(int n) {
7        uploaded = new boolean[n + 2]; // extra space to avoid bounds issues
8        curr = 1;
9    }
10    
11    public void upload(int video) {
12        uploaded[video] = true;
13    }
14    
15    public int longest() {
16        while (uploaded[curr]) {
17            curr++;
18        }
19        return curr - 1;
20    }
21}
22
23/**
24 * Your LUPrefix object will be instantiated and called as such:
25 * LUPrefix obj = new LUPrefix(n);
26 * obj.upload(video);
27 * int param_2 = obj.longest();
28 */