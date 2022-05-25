package com.company.Week9Graph;

public class Edge <T extends Comparable<T> ,N extends  Comparable<N>>{
    Vertex<T,N> toVertex;
    N weight;
//Edge would be the columns
    //points to the next edge in the edge list == nodes in a linked list
    Edge<T,N> nextEdge;

    public Edge(){
        toVertex = null;
        weight =null;
        nextEdge = null;
    }
    public Edge(Vertex<T,N> destination, Edge<T,N> nextEdge){
        toVertex = destination;
        this.nextEdge = nextEdge;
    }
    public Edge(Vertex<T,N> destination, N weight, Edge<T,N> nextEdge){
        toVertex = destination;
        this.weight =weight;
        this.nextEdge = nextEdge;
    }

}
