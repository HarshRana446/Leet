// Last updated: 7/14/2026, 2:49:43 PM
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        sort(begin(nums), end(nums));
        return nums;
    }
};