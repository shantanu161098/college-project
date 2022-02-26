import java.util.ArrayList;
import java.util.List;

public class Node
{
    int value, weight,setNo = 0;
    //creating a constructor of the class Vertex
    Node(int value, int weight)
    {
        this.value = value;
        this.weight = weight;
    }

    public Node searchWithValue(int value, List<Node> nodeList){
        for(Node node: nodeList){
            if(node.value == value){
                return node;
            }
        }
        return nodeList.get(0);
    }

    public int getSetNo() {
        return setNo;
    }

    public void setSetNo(int setNo) {
        this.setNo = setNo;
    }

    //overrides the toString() method
    @Override
    public String toString()
    {
        return this.value + " (" + this.weight + ")";
    }

    public int getTotalDirectedEdgeCount(Graph graph){
        int totalDirectedEdges = 0;

        for(Edge edge: graph.getEdges()){
            if(edge.getSource() == this.value &&  searchWithValue(edge.getDestination(),graph.getNodeList()).getSetNo() == this.setNo ){
                totalDirectedEdges = totalDirectedEdges + edge.getWeight();
            }
        }

        return totalDirectedEdges;
    }

    public int getTotalCrossingEdgeCount(Graph graph,int setNo){

        if(getSetNo() == setNo){
            return 0;
        }
        int totalCrossingEdges = 0;
        for(Edge edge: graph.getEdges()){
//            System.out.println("VAL " + edge.getDestination() + " SET NO " + searchWithValue(edge.getDestination(),graph.getNodeList()).getSetNo());
            if((edge.getSource() == this.value && searchWithValue(edge.getDestination(),graph.getNodeList()).getSetNo() == setNo ) ||
                    (edge.getDestination() == this.value &&  searchWithValue(edge.getSource(),graph.getNodeList()).getSetNo() == setNo)){
//                System.out.println("If block");
                totalCrossingEdges = totalCrossingEdges + edge.getWeight();
            }
        }
        return totalCrossingEdges;
    }

}
