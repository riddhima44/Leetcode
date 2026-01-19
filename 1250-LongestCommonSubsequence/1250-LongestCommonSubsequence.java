// Last updated: 1/19/2026, 10:47:30 PM
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer dp[][]= new Integer[text1.length()][text2.length()];
        return lcs(text1, text2, 0,0,dp);
        
    }
    static int lcs(String text1, String text2, int i, int j,Integer dp[][]){
        if(i>=text1.length() || j >=text2.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans;
        if(text1.charAt(i)==text2.charAt(j)){
            
            ans= 1+lcs(text1,text2,i+1,j+1,dp);
            
        }
        else{
            
            ans= Math.max(lcs(text1,text2,i,j+1,dp),lcs(text1,text2,i+1,j,dp));
        }
        return dp[i][j]=ans;
    }

    
}