// Last updated: 7/14/2026, 2:39:16 PM
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            list.add(nthRowOfPascalTriangle(i));
        }
        return list;
    }

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 1;
        if(n == 1){
            list.add(1);
            return list;
        }
        list.add(1);
        for(int i = 1; i <= n -1; i++){
            ans = ans * (n - i);
            ans = ans / i;
            list.add(ans);
        }
        return list;
    }
}