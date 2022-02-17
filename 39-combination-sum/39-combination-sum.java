class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void combinationSum(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) result.add(new ArrayList<>(current));
        else {
            for (int i = start; i < candidates.length; i++) {
                current.add(candidates[i]);
                combinationSum(result, current, candidates, remain - candidates[i], i);
                current.remove(current.size() - 1);
            }
        }
    }
}