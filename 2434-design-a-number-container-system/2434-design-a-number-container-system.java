class NumberContainers {

    HashMap<Integer, Integer> hm;
    HashMap<Integer, TreeSet<Integer>> hm1;

    public NumberContainers() {
        hm = new HashMap<>();
        hm1 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(!hm.containsKey(index)) {
            hm.put(index, number);
        } else {
            int value = hm.get(index);
            TreeSet<Integer> ts = hm1.get(value);
            ts.remove(index);
            if(ts.isEmpty()) {
                hm1.remove(value);
            } else {
                hm1.put(value, ts);
            }
            hm.put(index, number);
        }

        updateValue(index, number);
    }
    
    public int find(int number) {
        return !hm1.containsKey(number) ? 
            -1 : hm1.get(number).first();    
    }

    private void updateValue(int index, int number) {
        if(!hm1.containsKey(number)) {
            hm1.put(number, new TreeSet<>());
        }

        TreeSet<Integer> ts = hm1.get(number);
        ts.add(index);

        hm1.put(number, ts);
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */