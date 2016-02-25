import java.util.Vector;

/**
 * Created by May on 2/25/16.
 */
public class Graph {

    Vector<Node> mNodes;
    Vector<Relationship> mRelationships;

    public Graph() {
        mNodes = new Vector<Node>();
        mRelationships = new Vector<Relationship>();
    }
    public Vector<Node> getNodes() {
        return mNodes;
    }

    public void addNode(Node n1){
        mNodes.add(n1);
    }

    public void removeNode(Node n1){
        mNodes.remove(n1);
    }

    public Vector<Relationship> getRelationships() {
        return mRelationships;
    }

    public  void addRelationship(Relationship r){
        mRelationships.add(r);
    }

    public void removeRelationship(Relationship r){
        mRelationships.remove(r);
    }
}
