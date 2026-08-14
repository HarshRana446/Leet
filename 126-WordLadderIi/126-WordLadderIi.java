// Last updated: 8/14/2026, 12:39:14 PM
class Solution {
    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        if (!dict.contains(endWord)) {
            return ans;
        }

        Map<String, List<String>> parent = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int k = 0; k < size; k++) {
                String word = q.poll();
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;
                        String next = new String(chars);

                        if (!dict.contains(next)) {
                            continue;
                        }

                        if (!visited.contains(next)) {
                            if (!levelVisited.contains(next)) {
                                levelVisited.add(next);
                                q.add(next);
                            }

                            parent.computeIfAbsent(
                                    next,
                                    x -> new ArrayList<>()).add(word);

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        } else if (levelVisited.contains(next)) {
                            parent.computeIfAbsent(
                                    next,
                                    x -> new ArrayList<>()).add(word);
                        }
                    }

                    chars[i] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parent, path, ans);

        return ans;
    }

    private void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parent,
            List<String> path,
            List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            ans.add(result);
            return;
        }

        if (!parent.containsKey(word)) {
            return;
        }

        for (String prev : parent.get(word)) {
            path.add(prev);
            dfs(prev, beginWord, parent, path, ans);
            path.remove(path.size() - 1);
        }
    }
}