// Last updated: 8/21/2026, 5:21:26 PM
class Disjoint {
    int[] parent;
    int[] size;

    public Disjoint(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findPar(int u) {
        if (u == parent[u])
            return u;
        else {
            parent[u] = findPar(parent[u]);
            return parent[u];
        }
    }

    public boolean find(int u, int v) {
        return findPar(u) == findPar(v);
    }

    public void union(int u, int v) {
        int paru = findPar(u), parv = findPar(v);
        if (paru == parv)
            return;
        if (size[paru] < size[parv]) {
            parent[paru] = parv;
            size[parv] += size[paru];
        } else {
            parent[parv] = paru;
            size[paru] += size[parv];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);
        HashMap<String, Integer> map = new HashMap<>();
        // PHASE 1 : MERGING 
        for (int j = 0; j < n; j++) {
            List<String> curr = accounts.get(j);
            int currSize = curr.size();
            for (int i = 1; i < currSize; i++) {
                String mail = curr.get(i);
                if (map.containsKey(mail)) {
                    int par = map.get(mail);
                    ds.union(par, j);
                } else {
                    map.put(mail, j);
                }
            }
        }
        // PHASE 2 : Staging Area
        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for (String mail : map.keySet()) {
            int orgNode = map.get(mail);
            int par = ds.findPar(orgNode);
            mergedMail[par].add(mail);
        }

        // PHASE 3 : BUILDING THE ans LIST
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;
            Collections.sort(mergedMail[i]);
            List<String> finalRow = new ArrayList<>();
            String name = accounts.get(i).get(0);
            finalRow.add(name);
            for (String mail : mergedMail[i]) {
                finalRow.add(mail);
            }
            ans.add(finalRow);
        }
        return ans;

    }
}
