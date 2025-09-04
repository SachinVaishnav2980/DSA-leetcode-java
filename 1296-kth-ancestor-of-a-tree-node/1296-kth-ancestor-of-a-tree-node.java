class TreeAncestor {
private int[][] up;   // up[v][j] = 2^j-th ancestor of v
    private int LOG;
    
    public TreeAncestor(int n, int[] parent) {
        LOG = 1;
        while ((1 << LOG) <= n) LOG++; // max power of 2 needed

        up = new int[n][LOG];
        
        // Initialize immediate parent
        for (int v = 0; v < n; v++) {
            up[v][0] = parent[v];
        }

        // Precompute ancestors using DP
        for (int j = 1; j < LOG; j++) {
            for (int v = 0; v < n; v++) {
                int p = up[v][j - 1];
                up[v][j] = (p == -1) ? -1 : up[p][j - 1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) == 1) {
                node = up[node][j];
                if (node == -1) break;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */