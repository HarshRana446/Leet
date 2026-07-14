// Last updated: 7/14/2026, 2:49:23 PM
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> _Map = new HashMap<>();
        for(int t : target){
            int count = _Map.getOrDefault(t, 0);
            _Map.put(t, count+1);
        }

        for(int a: arr){
            if (_Map.containsKey(a) && _Map.get(a)>0) {
                _Map.put(a, _Map.get(a)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}