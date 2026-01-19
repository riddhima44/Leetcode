// Last updated: 1/19/2026, 10:50:14 PM
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        fun(candidates , ans,l,0,0,target);
        return ans;
        
    }
    void fun(int arr[],List<List<Integer>> ans,List<Integer> l, int in,int sum,int target){
        if(sum>target)return;
        if(sum==target){
            ans.add(new ArrayList<>(l));
            return ;
        }
        for(int i=in;i<arr.length;i++){
            l.add(arr[i]);
            fun(arr,ans,l,i,sum+arr[i],target);
            l.remove(l.size()-1);
        }
    }
}