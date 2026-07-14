// Last updated: 7/14/2026, 2:50:15 PM
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    let n = nums.length;
    let expectedSum = n * (n+1)/2;
    let sum = 0;
    for(let i = 0; i < n; i++){
        sum += nums[i];
    }
    return expectedSum - sum;
};