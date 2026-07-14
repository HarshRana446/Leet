// Last updated: 7/14/2026, 2:49:21 PM
function numSub(s) {
    let total = 0;
    s.split("0").filter(block => {
        const length = block.length;
        if (length) total += (length * (length + 1)) / 2
    });
    return total % (10 ** 9 + 7);
};