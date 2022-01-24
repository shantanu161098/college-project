package com.MaxCut;

import java.util.ArrayList;
import java.util.List;

public class Graph
{
    //note that we have created an adjacency list (i.e. List of List)
    List<List<Node>> adjlist = new ArrayList<>();
    List<Node> nodeList = new ArrayList<>();
    private int numberOfNodes;
    List<Edge> edges;
    //creating a constructor of the class Graph that creates graph
    public Graph(List<Edge> edges,int numberOfNodes,List<Node> nodeList)
    {
        this.edges = edges;
        this.nodeList = nodeList;
        this.numberOfNodes = numberOfNodes;
//find the maximum numbered vertex
        int n = 0;
//iterates over the edges of the graph
        for (Edge e: edges)
        {
//determines the maximum numbered vertex
            n = Integer.max(n, Integer.max(e.source, e.destination));
        }
//reserve the space for the adjacency list
        for (int i = 0; i <= n; i++)
        {
            adjlist.add(i, new ArrayList<>());
        }
//adds the edges to the undirected graph
        for (Edge e: edges)
        {
//creating a new node (from source to destination) in the adjacency list
            adjlist.get(e.source).add(new Node(e.destination, e.weight));
//uncomment the following statement for undirected graph
//adj.get(e.dest).add(new Node(e.src, e.weight));
        }
    }
    //method that prints adjacency list of a graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjlist.size();
        System.out.printf("Adjacency List for the Graph is: ");
        while (src < n)
        {
//for-each loop prints the neighboring vertices with current vertex
            for (Node edge: graph.adjlist.get(src))
            {
                System.out.printf("%d -- > %s\t", src, edge);
            }
            System.out.println();
//increments the source by 1
            src++;
        }
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }
}
