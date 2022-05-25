package com.company.Week9Graph;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>, N extends Comparable<N>> {

    Vertex<T, N> head;
    int size;

    public Graph() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean hasVertex(T v) {
        if (head == null) //if graph is empty
            return false;

        Vertex<T, N> currentVertex = head;         //start currentVertex pointer at the head node
        while (currentVertex.nextVertex != null) {
            if (currentVertex.vertexInfo.compareTo(v) == 0) //check if the currentVertex is the same as the searched vertex
                return true;
            currentVertex = currentVertex.nextVertex;       //moves currentVertex pointer to the next vertex
        }
        return false;

    }

    public boolean hasEdge(T source, T destination) {
        if (head == null) return false;
        if (!hasVertex(source) || !hasVertex(destination)) return false;
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) { //source is found
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0)
                        return true;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T v) {
        if (hasVertex(v))//if vertex is already in the graph
            return false;
        else {
            Vertex<T, N> newVertex = new Vertex<>(v, null);
            if (head == null)   //if initially graph is empty
                head = newVertex;   //then the newVertex is the head
            else {
                Vertex<T, N> temp = head;
                Vertex<T, N> previous = head;
                while (temp != null) {
                    previous = temp;
                    temp = temp.nextVertex;
                }//temp == null when exiting the loop & previous == last vertex of the graph
                previous.nextVertex = newVertex;    //this newVertex would be added at the end of the Vertex list
            }
            size++;
            return true;
        }
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
                        sourceVertex.firstEdge = new Edge<>(destVertex, weight, sourceVertex.firstEdge);
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


    public N getEdgeWeight(T source, T destination) {
        if (head == null) return null;
        if (!hasVertex(source) || !hasVertex(destination)) return null;
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) { //source is found
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0)//source is found
                        return currentEdge.weight;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return null;
    }

    public int getInDeg(T v) {
        if (hasVertex(v)) {
            Vertex<T, N> temp = head;
            while (temp != null) {
                if (temp.vertexInfo.compareTo(v) == 0)
                    return temp.indeg;
                temp = temp.nextVertex;
            }
        }
        return -1;  //if the vertex is not in the graph
    }

    public int getOutDeg(T v) {
        if (hasVertex(v)) {
            Vertex<T, N> temp = head;
            while (temp != null) {
                if (temp.vertexInfo.compareTo(v) == 0)
                    return temp.outdeg;
                temp = temp.nextVertex;
            }
        }
        return -1;  //if the vertex is not in the graph
    }

    public int getIndex(T v) {
        Vertex<T, N> searchedVertex = head;
        int position = 0;
        while (searchedVertex != null) {
            if (searchedVertex.vertexInfo.compareTo(v) == 0)
                return position;
            searchedVertex = searchedVertex.nextVertex;
            position++;
        }
        return -1;
    }

    public T getVertex(int position) {
        if (position > size - 1 || position < 0) return null; //invalid index
        Vertex<T, N> currentVertex = head;
        for (int i = 0; i < position; i++)
            currentVertex = currentVertex.nextVertex;
        //when exiting loop, currentVertex == i-th Vertex
        return currentVertex.vertexInfo;
    }

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> vertexList = new ArrayList<>();
        Vertex<T, N> currentVertex = head;
        while (currentVertex != null) {
            vertexList.add(currentVertex.vertexInfo);
            currentVertex = currentVertex.nextVertex;
        }
        return vertexList;
    }

    public ArrayList<T> getNeighbours(T v) {
        if (hasVertex(v)) {
            ArrayList<T> neighboursList = new ArrayList<>();
            Vertex<T, N> currentVertex = head;
            while (currentVertex != null) {
                if (currentVertex.vertexInfo.compareTo(v) == 0) {//found the searched vertex
                    Edge<T, N> currentEdge = currentVertex.firstEdge;
                    while (currentEdge != null) {//loop through edges of searched vertex to add destination vertices to list
                        neighboursList.add(currentEdge.toVertex.vertexInfo);
                        currentEdge = currentEdge.nextEdge;
                    }
                }
                currentVertex = currentVertex.nextVertex;
            }
        }
        return null;
    }

    public void printEdges() {
        Vertex<T, N> currentVertex = head;
        while (currentVertex != null) {
            System.out.print("# " + currentVertex.vertexInfo + " : ");
            Edge<T, N> currentEdge = currentVertex.firstEdge;
            while (currentEdge != null) {
                System.out.print("[" + currentVertex.vertexInfo + "," + currentEdge.toVertex.vertexInfo + "]");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            currentVertex = currentVertex.nextVertex;
        }
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
                        sourceVertex.firstEdge = new Edge<>(destVertex, weight, sourceVertex.firstEdge);
                        destVertex.firstEdge = new Edge<>(sourceVertex, weight, destVertex.firstEdge);

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
    public boolean removeEdge(T source, T destination) {
        if (head == null) return false; //empty graph
        if (!hasVertex(source) || !hasVertex(destination)) return false;
        Vertex<T, N> sourceVertex = head;
        Vertex<T, N> destVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) { //source is found
                Edge<T, N> prevEdge = sourceVertex.firstEdge;
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    prevEdge = currentEdge;
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) { //destination is found
                        prevEdge.nextEdge = currentEdge.nextEdge;

                        currentEdge.nextEdge = null; //unnecessary?

                        sourceVertex.outdeg--;
                        destVertex.indeg--;
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

}
