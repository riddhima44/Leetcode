// Last updated: 3/2/2026, 5:05:22 PM
1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3        List<List<Integer>> ans = new ArrayList<>();
4        Arrays.sort(candidates);
5        fun(candidates,0,target,new ArrayList<>(),ans);
6        return ans;
7
8    }
9    public void fun(int[] arr,int index ,int target,List<Integer> list,List<List<Integer>> ans){
10        if(target==0){
11            ans.add(new ArrayList<>(list));
12            return;
13        }
14        for(int i=index;i<arr.length;i++){
15            if(i>index && arr[i]==arr[i-1]){
16                continue;
17            }
18            if(arr[i]>target) break;//Aaage jake bhi koi fyda nhi
19            list.add(arr[i]);
20            fun(arr,i+1,target-arr[i],list,ans);
21            list.remove(list.size()-1);
22        }
23    }
24}