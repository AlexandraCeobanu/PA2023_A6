package tema3;

import java.util.*;

public class Network {
    private List<Node> nodes=new ArrayList<>();
    private Map<Node,Integer> importanceOfNode =new HashMap<>();
    public void addNode(Node node)
    {
        nodes.add(node);
    }

    public void computeImportance()
    {
        for(Node node:nodes)
        {
            importanceOfNode.put(node,node.getNumberOfRelationships());
            //System.out.println(node.getName()+ ' ' + node.getNumberOfRelationships());
        }
    }
    @Override
    public String toString() {
        Collections.sort(nodes,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        sb.append("Network {");
        sb.append("\n");
        for(Node node: nodes)
        {
            sb.append(node);
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
