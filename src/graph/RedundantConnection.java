package graph;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] size = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            size[i] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = find(edges[i][0], parent);
            int y = find(edges[i][1], parent);
            if (x == y) {
                return edges[i];
            }
            union(x, y, size, parent);
        }
        return new int[0];
    }

    public int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public void union(int x, int y, int[] size, int[] parent) {
        if (size[x] > size[y]) {
            size[x] += size[y];
            parent[y] = x;
        } else {
            size[x] += size[y];
            parent[x] = y;
        }
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        RedundantConnection rc = new RedundantConnection();
        int[] result = rc.findRedundantConnection(edges);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

}
