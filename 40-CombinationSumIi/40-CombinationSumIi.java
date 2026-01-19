// Last updated: 1/19/2026, 10:50:10 PM
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        helper(list,new ArrayList<>(),candidates,target,0);
        return list;
    }
    public void helper(List<List<Integer>> list,ArrayList<Integer> curr,int[] candidates,int target,int start){ 
        if(target==0){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]){
               continue;
            } 
            if(candidates[i]>target){
                break;
            }
            curr.add(candidates[i]);
            helper(list,curr,candidates,target-candidates[i],i+1);
            curr.remove(curr.size()-1); 
        }
    }
}