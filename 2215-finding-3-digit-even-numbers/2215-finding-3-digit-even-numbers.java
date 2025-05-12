class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> hs = new HashSet<>();
        int n = digits.length;

        for(int i = 0; i < n; i++) {
            if(digits[i] != 0) {
                int num = digits[i];
                for(int j = 0; j < n; j++) {
                    if(j != i) {
                        num = num * 10 + digits[j];
                        for(int k = 0; k < n; k++) {
                            if(k != j && k != i) {
                                num = num * 10 + digits[k];
                                if(num % 2 == 0) {
                                    hs.add(num);
                                }
                                num /= 10;
                            }
                        }
                        num /= 10;
                    }
                }
            }
        }

        int[] intArray = new int[hs.size()];
        int index = 0;
        for(Integer num : hs){
            intArray[index++] = num;
        }

        Arrays.sort(intArray);

        return intArray;
    }
}