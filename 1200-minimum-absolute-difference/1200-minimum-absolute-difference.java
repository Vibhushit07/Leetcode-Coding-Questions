class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];

            if(diff < minDiff) {
                res = new ArrayList<>();
                res.add(Arrays.asList(arr[i - 1], arr[i]));
                minDiff = diff;
            } else if(minDiff == diff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return res;
    }
}