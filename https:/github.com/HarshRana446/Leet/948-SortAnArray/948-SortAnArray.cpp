// Last updated: 7/14/2026, 2:37:52 PM
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        sort(begin(nums), end(nums));
        return nums;
    }
};