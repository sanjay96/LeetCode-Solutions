class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void combinationSum2(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        if (remain < 0) 
            return;
        else if (remain == 0) {
            result.add(new ArrayList<>(current));
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1])
                    continue;
                current.add(candidates[i]);
                combinationSum2(result, current, candidates, remain - candidates[i], i + 1);
                current.remove(current.size() - 1);
            }
        }
        
    }
}