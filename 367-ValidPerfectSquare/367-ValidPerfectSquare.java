// Last updated: 1/19/2026, 10:49:04 PM

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        for(long i = 1; i*i <= num; i ++){
            if(i*i==num){
                return true;
            }
        }
        return false;
    }
}