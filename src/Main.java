import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Vector;

/**
 * Created by May on 2/25/16.
 */
public class Main {
    public static void main(String[] args){

        Graph graph = new Graph();
        Node cityNode = new Node(0);
        cityNode.setLabel("City");
        cityNode.setProperty("name", "St.Gallen");
        cityNode.setProperty("id", "3601683941");
        graph.addNode(cityNode);

        Node categoryNode = new Node(1);
        categoryNode.setLabel("Category");
        categoryNode.setProperty("name", "cafe");
        graph.addNode(categoryNode);

        int rId = 0;

        JSONParser parser = new JSONParser();
        try{
            JSONObject obj = (JSONObject)parser.parse(new FileReader("data/data.json"));
            JSONArray elements = (JSONArray) obj.get("elements");

            for (int i = 0; i < elements.size(); i++){
                JSONObject o1 = (JSONObject) elements.get(i);

                if(o1.get("type").equals("node")){
                    Node cafeNode = new Node(i+2);
                    cafeNode.setLabel("Element");
                    for(Object key: o1.keySet()){
                        cafeNode.setProperty((String)key , o1.get(key).toString());
                    }
                    graph.addNode(cafeNode);
                    Relationship isIn = new Relationship(rId++, "IS_IN");
                    Relationship isA = new Relationship(rId++, "IS_A");
                    isIn.setConnections(cafeNode, cityNode, Directionality.LeftToRight);
                    isA.setConnections(categoryNode,cafeNode,Directionality.RightToLeft);
                    graph.addRelationship(isIn);
                    graph.addRelationship(isA);
                }


            }

        }
        catch(Exception e){
            System.out.println(e.toString());
        }

        displayGraph(graph);
    }

    private static void displayGraph(Graph graph) {
        Vector<Node> nodes = graph.getNodes();
        for (Node node: nodes){
            node.printAll();
        }
        for (Relationship r: graph.getRelationships()){
            r.printAll();
        }

    }
}
