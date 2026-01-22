class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            list.add(num);
        }

        while(!isSorted(list)) {
            int index = getMinSumIndex(list);
            list.set(index, list.get(index) + list.get(index + 1));
            list.remove(index + 1);
        }

        return nums.length - list.size();
    }

    private boolean isSorted(List<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i + 1))
                return false;
        }

        return true;
    }

    private int getMinSumIndex(List<Integer> list) {
        int minSum = Integer.MAX_VALUE;
        int index = 0;

        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) + list.get(i + 1) < minSum) {
                minSum = list.get(i) + list.get(i + 1);
                index = i;
            }
        }

        return index;
    }
}