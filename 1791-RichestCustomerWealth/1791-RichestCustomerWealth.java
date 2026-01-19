// Last updated: 1/19/2026, 10:46:32 PM
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxwealth=0;
        for(int i=0;i<accounts.length;i++){
            int money=0;
            for(int j=0;j<accounts[i].length;j++){
                money+=accounts[i][j];

            }
            maxwealth = Math.max(maxwealth,money);
        }
        return maxwealth;
    }
}