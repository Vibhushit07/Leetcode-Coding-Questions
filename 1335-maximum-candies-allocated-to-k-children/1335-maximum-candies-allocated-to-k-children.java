class Solution {

    private boolean divideCandies(int[] candies, long k, int pile) {
        long count = 0;

        for(int candy : candies) {
            count += candy / pile;
        }

        return count >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int max = Arrays.stream(candies).max().getAsInt();

        int left = 1, right = max, pile = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(divideCandies(candies, k, mid)) {
                left = mid + 1;
                pile = mid;
            } else {
                right = mid - 1;
            }
        }

        return pile;

    }
}