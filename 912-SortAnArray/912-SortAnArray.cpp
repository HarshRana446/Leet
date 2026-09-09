// Last updated: 9/9/2026, 1:27:13 PM
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        sort(begin(nums), end(nums));
        return nums;
    }
};