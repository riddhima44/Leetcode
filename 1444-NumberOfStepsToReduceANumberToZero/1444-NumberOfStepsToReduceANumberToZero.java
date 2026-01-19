// Last updated: 1/19/2026, 10:47:05 PM
class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while(num >0){
            step++;
            if(num % 2 == 0){
                num = num/2;
            }
            else{
                num -= 1;
            }
        }
        return step;
        
    }
}