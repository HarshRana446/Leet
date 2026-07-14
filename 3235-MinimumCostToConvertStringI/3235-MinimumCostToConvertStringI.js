// Last updated: 7/14/2026, 2:48:52 PM
var minimumCost = function(source, target, original, changed, cost) {
    const n = source.length;
    const alphabetSize = 26;
    const maxCost = 1e9; // A large number to represent infinity

    // Convert character to index (0 for 'a', 1 for 'b', ..., 25 for 'z')
    const charToIndex = c => c.charCodeAt(0) - 'a'.charCodeAt(0);

    // Initialize cost matrix with infinity
    const minCost = Array.from({ length: alphabetSize }, () => Array(alphabetSize).fill(maxCost));
    
    // Set the cost of transforming a character to itself to 0
    for (let i = 0; i < alphabetSize; i++) {
        minCost[i][i] = 0;
    }

    // Fill the cost matrix with the given costs
    for (let i = 0; i < original.length; i++) {
        const from = charToIndex(original[i]);
        const to = charToIndex(changed[i]);
        minCost[from][to] = Math.min(minCost[from][to], cost[i]);
    }

    // Apply Floyd-Warshall algorithm to find the shortest paths
    for (let k = 0; k < alphabetSize; k++) {
        for (let i = 0; i < alphabetSize; i++) {
            for (let j = 0; j < alphabetSize; j++) {
                if (minCost[i][k] < maxCost && minCost[k][j] < maxCost) {
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                }
            }
        }
    }

    // Calculate the total minimum cost to transform source to target
    let totalCost = 0;
    for (let i = 0; i < n; i++) {
        const from = charToIndex(source[i]);
        const to = charToIndex(target[i]);
        if (minCost[from][to] === maxCost) {
            return -1; // Transformation is impossible
        }
        totalCost += minCost[from][to];
    }

    return totalCost;
};
