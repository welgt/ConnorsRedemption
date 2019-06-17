package connorsRedemption;

import java.util.ArrayList;
import java.util.List;

public class Node {
    
    private int ID;
    private float h, g, f; // para o A*
    private Node father;
    private boolean visited;
    private boolean blocked;
    private List<Node> neighbors;
    
    public Node(int ID){
        this.ID = ID;
        this.visited = false;
        this.blocked = false;
        this.neighbors = new ArrayList();
    }
    
    public Node(Node node){
        this.ID = node.getID();
        this.visited = node.isVisited();
        this.blocked = node.isBlocked();
        this.neighbors = node.getNodes();
    }
    
    /* nao quero que altere o ID de ninguem
    public void setID(int ID){
        this.ID = ID;
    }
    */
    
    public int getID(){
        return this.ID;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }
    
    public Node getFather(){
        return this.father;
    }
    
    public void setFather(Node father){
        this.father = father;
    }
    
    public void setVisited(boolean v){
        this.visited = v;
    }
    
    public boolean isVisited(){
        return this.visited;
    }
    
    public void setBlocked(boolean b){
        this.blocked = b;
    }
    
    public boolean isBlocked(){
        return this.blocked;
    }
    
    public void setNodes(Node node){
        this.neighbors.add(node);
    }
    
    public List<Node> getNodes(){
        return this.neighbors;
    }
    
    
}
