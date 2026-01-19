// Last updated: 1/19/2026, 10:48:21 PM
class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int start=0,end=0;
        int fr[] = new int[100001];
        int unique = 0;
        while(end<n){
            int f = arr[end];
            if(fr[f] == 0)unique++;
            fr[f]++;
            end++;
            while(unique>2){
                int st = arr[start];
                fr[st]--;
                if(fr[st] == 0){
                    unique --;
                }start++;
            }
            max = Math.max(max,end-start);

        }

        
        return max;
        
    }
}
