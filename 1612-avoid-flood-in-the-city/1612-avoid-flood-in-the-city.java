class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> pq = new ArrayList<>();

        int n = rains.length;

        int ans[] = new int[n];

        for(int i = 0; i < n; i++) {
            if(rains[i] == 0) {
                pq.add(i);

            } else {
                if(!map.containsKey(rains[i])) {
                    map.put(rains[i], i);
                    ans[i] = -1;

                } else {
                    if(pq.isEmpty()) {
                        return new int[]{};

                    } 
                    else {    
                        int day = map.get(rains[i]);
                        int d = getDay(pq, day);

                        if(d == -1) {
                            return new int[]{};
                        }
                        ans[d] = rains[i];
                        ans[i] = -1;
                        map.put(rains[i], i);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(ans[i] == 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    int getDay(List<Integer> pq, int day) {
        int l = 0, r = pq.size();
        int ind = -1;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(mid < pq.size() && pq.get(mid) > day) {
                ind = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if(ind == -1) {
            return -1;
        }

        int d = pq.get(ind);
        pq.remove(ind);

        return d;
    }
}