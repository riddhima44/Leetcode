// Last updated: 1/19/2026, 10:49:47 PM

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){  
            int h[]=new int[c];            
            for(int j=i;j<r;j++){
                for(int k=0;k<c;k++){
                    h[k]+=matrix[j][k]-'0';
                }
                int t=j-i+1;
                int s=0;
                for(int k=0;k<c;k++){
                    if(h[k]==t){
                        s+=t;
                        ans=Math.max(ans,s);
                    }
                    else s=0;
                }
            }
        }
        return ans;
    }
}