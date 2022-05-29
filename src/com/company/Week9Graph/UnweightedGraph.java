package com.company.Week9Graph;

public class UnweightedGraph <T extends Comparable<T>, N extends Comparable<N>> extends Graph<T,N>{

    Vertex<T, N> head;
    int size;

    public UnweightedGraph() {
        head = null;
        size = 0;
    }

    public boolean addDirectedEdge(T source, T destination, N weight) {
        if (head == null) return false; //empty graph
        if (!hasVertex(source) || !hasVertex(destination)) return false;
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) { //source is found
                Vertex<T, N> destVertex = head;
                while (destVertex != null) {
                    if (destVertex.vertexInfo.compareTo(destination) == 0) { //destiantion is found

                        //adds the new edge to the end of the Edge list
                        /*Edge<T,N> prevEdge = sourceVertex.firstEdge;
                        Edge<T,N> tempEdge = sourceVertex.firstEdge;
                        while(tempEdge!= null){
                            prevEdge = tempEdge;
                            tempEdge = tempEdge.nextEdge;
                        }//prevEdge = last edge of the sourceVertex && tempEdge ==null
                        assert prevEdge != null;
                        prevEdge.nextEdge = new Edge<T,N>(destVertex, weight,null);
                        */

                        //adds new edge to the front of Edge list
                        sourceVertex.firstEdge = new Edge<>(destVertex, sourceVertex.firstEdge);
                        sourceVertex.outdeg++;
                        destVertex.indeg++;
                        return true;
                    }
                    destVertex = destVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    //lab qn1
    public boolean addUndirectedEdge(T source, T destination, N weight) {
        if (head == null) return false; //empty graph
        if (!hasVertex(source) || !hasVertex(destination)) return false;
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) { //source is found
                Vertex<T, N> destVertex = head;
                while (destVertex != null) {
                    if (destVertex.vertexInfo.compareTo(destination) == 0) { //destination is found
                        //adds new edge to the front of Edge list
                        sourceVertex.firstEdge = new Edge<>(destVertex, sourceVertex.firstEdge);
                        destVertex.firstEdge = new Edge<>(sourceVertex, destVertex.firstEdge);

                        sourceVertex.outdeg++;
                        sourceVertex.indeg++;
                        destVertex.outdeg++;
                        destVertex.indeg++;
                        return true;
                    }
                    destVertex = destVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    //lab qn 2
}



