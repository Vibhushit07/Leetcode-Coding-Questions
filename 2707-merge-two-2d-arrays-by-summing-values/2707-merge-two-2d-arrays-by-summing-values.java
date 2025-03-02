class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < l1; i++) {
            hs.add(nums1[i][0]);
        }

        for(int i = 0; i < l2; i++) {
            hs.add(nums2[i][0]);
        }

        int res[][] = new int[hs.size()][2];

        int i = 0, j = 0, k = 0;

        while(i < l1 && j < l2) {
            int n1 = nums1[i][1], n2 = nums2[j][1];
            int i1 = nums1[i][0], i2 = nums2[j][0];

            if(i1 < i2) {
                res[k][0] = i1;
                res[k][1] = n1;
                i++;
            } else if (i1 > i2) {
                res[k][0] = i2;
                res[k][1] = n2;
                j++;
            } else {
                res[k][0] = i1;
                res[k][1] = n1 + n2;
                i++;
                j++;
            }

            k++;
        }

        while(i < l1) {
            res[k][0] = nums1[i][0];
            res[k][1] = nums1[i][1];
            i++;
            k++;
        }

        while(j < l2) {
            res[k][0] = nums2[j][0];
            res[k][1] = nums2[j][1];
            j++;
            k++;
        }

        return res;
    }
}