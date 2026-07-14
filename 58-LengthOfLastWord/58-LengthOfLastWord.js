// Last updated: 7/14/2026, 2:50:45 PM
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
   let length=0;
   let i = s.length-1;
    while( i >= 0 && s[i] === " "){
        i--;
    }
    while( i >= 0 && s[i] !== " "){
        length++;
        i--;
    }
    return length;
};