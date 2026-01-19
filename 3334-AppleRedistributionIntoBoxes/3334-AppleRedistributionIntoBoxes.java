// Last updated: 1/19/2026, 9:57:47 PM
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApples=0;
        int m=capacity.length;
        for(int i=0;i<apple.length;i++){
            totalApples+=apple[i];
        }
        int usedcapacity=0;
        int minbox=0;
        for(int i=m-1;i>=0;i--){
            usedcapacity+=capacity[i];
            minbox++;
            if(usedcapacity>=totalApples){
                return minbox;
            }

        }
        return minbox;
    }
}