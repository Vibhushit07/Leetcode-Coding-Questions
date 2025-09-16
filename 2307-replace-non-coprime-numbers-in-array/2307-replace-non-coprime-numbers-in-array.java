class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int num : nums) {
            
            while(!res.isEmpty()) {
                int n = res.size();
                int top = res.get(n - 1);

                int hcf = gcd(top, num);

                if(hcf == 1)
                    break;
                res.remove(n - 1);
                num = (top / hcf) * num;
            }

            res.add(num);

        }

        return res;

    }

    int gcd(int a, int b) {

        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}