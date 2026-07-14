// Last updated: 7/14/2026, 2:51:25 PM
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for(let i = 0; i < nums.length; i++){
        for(let j = i +1; j <nums.length; j++){
        if(nums[i] + nums[j] === target){
            return [i,j];
        }
    }
    }
};