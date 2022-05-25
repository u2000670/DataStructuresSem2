package com.company.Week9Graph;

public class Vertex<T extends Comparable<T> ,N extends  Comparable<N>> {
    T vertexInfo;
    int indeg;
    int outdeg;
    //Vertex would be the the rows
    //points to the next Vertex in the list == nodes in a linked list
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;

    public Vertex(){
        vertexInfo = null;
        indeg = 0;
        outdeg = 0;
        nextVertex = null;
        firstEdge = null;

    }
    public Vertex(T vertexInfo, Vertex<T,N> nextVertex){
        this.vertexInfo = vertexInfo;
        indeg = 0;
        outdeg = 0;
        this.nextVertex = nextVertex;
        firstEdge = null;

    }

}
