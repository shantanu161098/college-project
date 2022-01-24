package com.MaxCut;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.List;

public class MaxKCut {


    public static Boolean isFinalized(Graph graph,int minSetNo,int maxSetNo){

        for(Node node: graph.getNodeList()){
            for(int i=minSetNo;i<maxSetNo;i++){
                if(node.getTotalDirectedEdgeCount(graph) > node.getTotalCrossingEdgeCount(graph,i)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(1, 2, 2),new Edge(2,3,3),new Edge(3,4,5), new Edge(4,5,3),new Edge(5,1,2));
        List<Node> nodeList = Arrays.asList(new Node(1,0),new Node(2,0),new Node(3,0),new Node(4,0),new Node(5,0));
        Graph graph = new Graph(edges,5,nodeList);
//        System.out.println(graph);

//        System.out.println(nodes.get(0).getTotalDirectedEdgeCount(graph));
//        System.out.println(nodes.get(0).getTotalCrossingEdgeCount(graph,0));

        int minSetNo = 1;
        int maxSetNo = 2;

        /**
         * Randomly assigning set value
         */
//        for(Node node: graph.getNodeList()){
//            int randomNum = ThreadLocalRandom.current().nextInt(minSetNo, maxSetNo + 1);
//            node.setSetNo(randomNum);
//            System.out.println("Node " + node.value + " is in " + node.getSetNo());
//        }

        nodeList.get(0).setSetNo(1);
        nodeList.get(1).setSetNo(2);
        nodeList.get(2).setSetNo(2);
        nodeList.get(3).setSetNo(2);
        nodeList.get(4).setSetNo(2);

    System.out.println(nodeList.get(1).getTotalCrossingEdgeCount(graph,1));

        while(!isFinalized(graph,minSetNo,maxSetNo)){
            for(Node node: graph.getNodeList()){
                for(int i=minSetNo;i<=maxSetNo;i++){
                    if(node.getSetNo() != i && node.getTotalDirectedEdgeCount(graph) > node.getTotalCrossingEdgeCount(graph,i)){
                        System.out.println("Transferring " + node.value + " " + node.getSetNo() + " to " + i
                        + " because d " + node.getTotalDirectedEdgeCount(graph) + " c " + node.getTotalCrossingEdgeCount(graph,i));
                        node.setSetNo(i);

                        System.out.println("After 1 change new formation is ");

                        for(Node n:graph.getNodeList()){
                            System.out.println(n.value + " " + n.getSetNo());
                        }

                    }


                }
            }
        }


        System.out.println("===================================  Finally =================================");

        for(Node node: graph.getNodeList()){
            System.out.println(node.value + " s " + node.getSetNo() + " d " + node.getTotalDirectedEdgeCount(graph));
        }


    }
}
