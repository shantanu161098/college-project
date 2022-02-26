public class Edge {
    int source, destination, weight;

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    Edge(int source, int destination, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }


}
