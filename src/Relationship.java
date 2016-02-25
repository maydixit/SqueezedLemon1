import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by May on 2/25/16.
 */
public class Relationship {
    int id;
    Vector<String> mLabels;
    Map<String, String> mProperties;
    Vector<Integer> mNodes;
    Directionality mDirectionality;

    public Relationship(int i, String label) {
        id = i;
        mLabels = new Vector<String>();
        mProperties = new HashMap<String,String>();
        mNodes = new Vector<Integer>();
        mLabels.add(label);
    }

    public int getId() {
        return id;
    }

    public Vector<String> getLabels() {
        return mLabels;
    }

    public void setLabel(String label) {
        mLabels.add(label);
    }

    public void setProperty(String p1, String p2) {
        mProperties.put(p1,p2);
    }

    public boolean removeLabel(String label){
        return mLabels.remove(label);
    }

    public void removeProperty(String prop){
        mProperties.remove(prop);
    }

    public Map<String, String> getProperties() {
        return mProperties;
    }

    public void setConnections(Node n1, Node n2, Directionality d){
        mDirectionality = d;
        mNodes.add(n1.getId());
        mNodes.add(n2.getId());

    }

    public void printAll() {
        System.out.println(getId());
        System.out.println(getLabels().toString());
        System.out.println(getProperties().toString());

    }
}
