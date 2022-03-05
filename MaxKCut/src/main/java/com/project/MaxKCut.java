package com.project;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.List;

public class MaxKCut {

    public static Graph computeSets(Graph graph, int minSetNo, int maxSetNo, int numberOfTransrfers) {
        int transfers = 0;
        while (!isFinalized(graph, minSetNo, maxSetNo) && transfers < numberOfTransrfers) {
            for (Node node : graph.getNodeList()) {
                for (int i = minSetNo; i <= maxSetNo; i++) {
                    if (node.getSetNo() != i && node.getTotalDirectedEdgeCount(graph) > node.getTotalCrossingEdgeCount(graph, i)) {
                        System.out.println("Transferring " + node.value + " " + node.getSetNo() + " to " + i
                                + " because d " + node.getTotalDirectedEdgeCount(graph) + " c " + node.getTotalCrossingEdgeCount(graph, i));
                        node.setSetNo(i);
                        transfers++;
                        if (transfers > numberOfTransrfers) {
                            return graph;
                        }
                    }
                }
            }
        }

        return graph;
    }


    public static Boolean isFinalized(Graph graph, int minSetNo, int maxSetNo) {


        for (Node node : graph.getNodeList()) {
            for (int i = minSetNo; i < maxSetNo; i++) {
                if (node.getTotalDirectedEdgeCount(graph) > node.getTotalCrossingEdgeCount(graph, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CSVParser parser = new CSVParser();
        int maxNodes = 6005;
        int numberOfTransrfers = 750;
        List<Edge> edgeList = parser.parseCSV("/home/shantanu/backend/kdu-backend-examples/temp/Resource/soc-sign-bitcoinotc.csv");
        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < maxNodes; i++) {
            nodeList.add(new Node(i, 0));
        }

        Graph graph = new Graph(edgeList, maxNodes, nodeList);


        int minSetNo = 1;
        int maxSetNo = 20;

        /**
         * Randomly assigning set value
         */
        for (Node node : graph.getNodeList()) {
            int randomNum = ThreadLocalRandom.current().nextInt(minSetNo, maxSetNo + 1);
            node.setSetNo(randomNum);
        }

//        for (int i = 0; i < maxNodes; i++) {
//            nodeList.get(i).setSetNo(1);
//        }


        computeSets(graph, minSetNo, maxSetNo, numberOfTransrfers);


        System.out.println("===================================  Finally =================================");

        for (Node node : graph.getNodeList()) {
            System.out.println(node.value + " is in set " + node.getSetNo());
        }


    }
}
