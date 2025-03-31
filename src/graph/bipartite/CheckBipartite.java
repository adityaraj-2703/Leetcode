package graph.bipartite;

public class CheckBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        // List<List<Integer>> adjList = new ArrayList<>();
        // for(int i=0;i<graph.length;i++){
        // adjList.add(new ArrayList<>());
        // }
        // for(int i=0;i<graph.length;i++){
        // for(int j=0;j<graph[i].length;j++){
        // adjList.get(i).add(graph[i][j]);
        // }
        // }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;
            }

            for (int j = 0; j < graph[i].length; j++) {
                if (color[graph[i][j]] != -1) {
                    if (color[i] == color[graph[i][j]]) {
                        return false;
                    }

                } else {
                    color[graph[i][j]] = color[i] == 0 ? 1 : 0;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        CheckBipartite c = new CheckBipartite();
        System.out.println(c.isBipartite(graph));
    }

}
