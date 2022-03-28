class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid + k < arr.length && x - arr[mid] > arr[mid+k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        List<Integer> result = new ArrayList<>();
        for (int y : Arrays.copyOfRange(arr, left, left + k)) {
            result.add(y);
        }
        return result;
    }
}