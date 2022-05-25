package com.company.Week9Graph;

public class GraphTest {
    public static void main(String[] args) {
        //tutorial qn 2
        int[][] adjacencyMatrix = {
                {0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        //tutorial qn3
        Graph<Character, Integer> graph = new Graph<>();

        //more efficient way: adding vertices by loop thorugh array of vertices
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        for (char letter : letters) {
            graph.addVertex(letter);
        }

        /* //adding vertices manually
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
*/
        graph.addDirectedEdge('A', 'C', 1);
        graph.addDirectedEdge('A', 'D', 1);
        graph.addDirectedEdge('B', 'D', 1);
        graph.addDirectedEdge('C', 'E', 1);
        graph.addDirectedEdge('C', 'F', 1);
        graph.addDirectedEdge('D', 'E', 1);
        graph.addDirectedEdge('E', 'G', 1);
        graph.addDirectedEdge('F', 'H', 1);
        graph.addDirectedEdge('G', 'H', 1);
        graph.addDirectedEdge('H', 'I', 1);

        graph.printEdges();
    }
}
