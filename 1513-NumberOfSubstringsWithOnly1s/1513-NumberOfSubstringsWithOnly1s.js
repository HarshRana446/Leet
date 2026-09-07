// Last updated: 9/7/2026, 2:42:42 PM
function numSub(s) {
    let total = 0;
    s.split("0").filter(block => {
        const length = block.length;
        if (length) total += (length * (length + 1)) / 2
    });
    return total % (10 ** 9 + 7);
};