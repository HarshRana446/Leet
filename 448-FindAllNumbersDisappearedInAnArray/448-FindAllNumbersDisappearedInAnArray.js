// Last updated: 7/14/2026, 2:50:06 PM
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    let n = nums.length;
    for( let i = 0; i < n; i++){
        while(nums[i] !== nums[nums[i] - 1]){
            const temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
        }
    }
    const result = [];
    for(let i = 0; i < n; i++){
        if(nums[i] !== i + 1) result.push(i+1);
    }
    return result;
};