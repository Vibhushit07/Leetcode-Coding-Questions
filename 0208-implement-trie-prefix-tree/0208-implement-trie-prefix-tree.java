class Node {
    Node nodes[];
    boolean flag;

    public Node () {
        nodes = new Node[26];
        flag = false;
    }

    boolean containsKey(char ch) {
        return nodes[ch - 'a'] != null;
    }

    Node get(char ch) {
        return nodes[ch - 'a'];
    }

    void put(char ch, Node node) {
        nodes[ch - 'a'] = node;
    }

    boolean isEnd() {
        return flag;
    }

    void setEnd() {
        flag = true;
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();    
    }
    
    public void insert(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                node.put(ch, new Node());
            } 
            node = node.get(ch);
        }

        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                return false;
            } 
            node = node.get(ch);
        }

        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch)) {
                return false;
            } 
            node = node.get(ch);
        }

        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */