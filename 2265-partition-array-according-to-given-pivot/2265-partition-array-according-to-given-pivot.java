class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int res[] = new int[nums.length];

        int i = 0, i1 = 0, j = nums.length - 1, j1 = nums.length - 1;

        while(i < nums.length) {
            if(nums[i] < pivot) {
                res[i1] = nums[i];
                i1++;
            }

            if(nums[j] > pivot) {
                res[j1] = nums[j];
                j1--;
            }

            i++;
            j--;
        }

        while(i1 <= j1) {
            res[i1++] = pivot;
            res[j1--] = pivot;
        }

        return res;
    }
}