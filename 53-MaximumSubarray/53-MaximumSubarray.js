// Last updated: 7/14/2026, 2:50:56 PM
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let sum = 0;
    let maxi = nums[0];

    for(let i = 0; i < nums.length; i++){
        sum += nums[i];

    maxi = Math.max(maxi , sum)

    if(sum < 0){
        sum=0;
    }
    }
    return maxi;

};