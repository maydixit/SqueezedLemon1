import java.util.HashMap;
import java.util.Vector;

/**
 * Created by May on 2/25/16.
 */
public class Node {
    int id;
    Vector<String> mlabels;
    HashMap<String, String> mproperties;

    public Node(int index ){
        id = index;
        mlabels = new Vector<String>();
        mproperties = new HashMap<String, String>();
    }

    public int getId() {
        return id;
    }

    public Vector<String> getLables() {
        return mlabels;
    }

    public HashMap<String, String> getProperties() {
        return mproperties;
    }

    public void setLabel(String label) {
        mlabels.add(label);
    }

    public void setProperty(String p1, String p2) {
        mproperties.put(p1,p2);
    }

    public boolean removeLabel(String label){
        return mlabels.remove(label);
    }

    public void removeProperty(String prop){
        mproperties.remove(prop);
    }

    public void printAll(){
        System.out.println(getId());
        System.out.println(getLables().toString());
        System.out.println(getProperties().toString());
    }

}
