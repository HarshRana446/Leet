// Last updated: 7/14/2026, 2:37:42 PM
class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        vector<pair<int, int>> sortedNum;
        for(auto &num : nums){
            string requiredNumString;
            int tempNum = num;
            if(tempNum == 0){
                requiredNumString.push_back(mapping[0] + '0');
            }else{
                while(tempNum != 0){
                    requiredNumString.push_back(mapping[tempNum % 10] + '0');
                    tempNum = tempNum / 10;
                }
                reverse(begin(requiredNumString), end(requiredNumString));
            }
            int requiredNum = stoi(requiredNumString);
            sortedNum.push_back({requiredNum, num});
        }
        sort(begin(sortedNum), end(sortedNum), [](const pair<int, int> a, const pair<int, int> b){
            return a.first < b.first;
        });

        vector<int> result;
        for(auto &pair : sortedNum){
            result.push_back(pair.second);
        }
        
        return result;
    }
};