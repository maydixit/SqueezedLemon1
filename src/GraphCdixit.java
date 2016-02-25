import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by May on 2/25/16.
 */
public class GraphCdixit {

    Vector<Node> mNodes;
    Vector<Relationship> mRelationships;

    public GraphCdixit() {
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

    public void display() {

        Graph<Integer, String> g;
        g = new SparseMultigraph<Integer, String>();

        for (Node node: mNodes){
            g.addVertex(node.getId());
        }

        for(Relationship r: mRelationships){
            g.addEdge(r.getLabels().get(0)+String.valueOf(r.getId()), r.getNodes().get(0), r.getNodes().get(1));
        }

        Layout<Integer, String> layout = new CircleLayout(g);
        layout.setSize(new Dimension(300,300));
        BasicVisualizationServer<Integer,String> vv = new BasicVisualizationServer<Integer,String>(layout);
        vv.setPreferredSize(new Dimension(350,350));
        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
