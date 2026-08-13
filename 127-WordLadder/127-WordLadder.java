// Last updated: 8/13/2026, 4:50:59 PM
class Pair {
    String first;
    int second;

    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<String>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(endWord) == true)
                return steps;
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replaceCharArray[] = word.toCharArray();
                    replaceCharArray[i] = ch;
                    String replaceCharWord = new String(replaceCharArray);
                    if (st.contains(replaceCharWord) == true) {
                        st.remove(replaceCharWord);
                        q.add(new Pair(replaceCharWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}