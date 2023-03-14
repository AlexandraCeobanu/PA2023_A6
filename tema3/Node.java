package tema3;

public interface Node extends Comparable<Node> {
    public String getName();
    public int getNumberOfRelationships();
    public default int compareTo(Node other) {
        return Integer.compare(this.getNumberOfRelationships(), other.getNumberOfRelationships());
    }

}
