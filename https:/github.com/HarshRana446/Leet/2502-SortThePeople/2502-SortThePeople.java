// Last updated: 7/14/2026, 2:36:21 PM
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Integer index[] = new Integer[n];
        for(Integer i=0;i<n;i++){
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return heights[b] - heights[a];
            }
        });
        String res[] = new String[n];
        int i =0;
        for(Integer ind : index){
            res[i] = names[ind];
            i++;
        }
        return res;
    }
}