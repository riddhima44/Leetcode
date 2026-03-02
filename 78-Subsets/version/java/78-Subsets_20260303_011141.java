// Last updated: 3/3/2026, 1:11:41 AM
1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> ans = new ArrayList<>();
4        fun(nums,new ArrayList<>(),ans,0);
5        return ans;
6    }
7    public void fun(int[] arr,List<Integer> list , List<List<Integer>> ans,int index){
8        if(index==arr.length){
9            ans.add(new ArrayList<>(list));
10            return;
11        }
12        list.add(arr[index]);
13        fun(arr,list,ans,index+1);
14        list.remove(list.size()-1);
15        fun(arr,list,ans,index+1);
16    }
17}