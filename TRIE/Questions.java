package TRIE;

public class Questions {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    // Word break problem
    public static boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }

        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    // START WITH PROBLEM
    public static boolean startsWith(String str) {      // O(L)
        Node curr = root;
        for(int i=0; i<str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }
    
    // Unique substring
    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }

    // Longest Word with all prefix
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1); 
            }
        }
    }

    public static void main(String[] args) {
        // String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }

        // String key = "ilikesamsung";

        // System.out.println(wordBreak(key));
        // System.out.println(startsWith("mob"));

        // String str = "apple";
        
        // // Suffix -> Insert in TRIE
        // for(int i=0; i<str.length(); i++) {
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }

        // System.out.println(countNodes(root));

        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
