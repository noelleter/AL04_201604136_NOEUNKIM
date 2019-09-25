package graph;

public class UndirectedAdjacencyMatrixGraph<E extends Edge> implements Graph<E>{

    private static final int EDGE_EXIST = 1;
    private static final int EDGE_NONE = 0;

    private int _numberOfVertices;
    private int _numberOfEdges;
    private int[][] _adjacency;

    // Getter & Setters
    @Override
    public int numberOfVertices() {
        return 0;
    }
    protected void setNumberOfVertices(int newNumberOfVerteices) {
        this._numberOfVertices = newNumberOfVerteices;
    }
    @Override
    public int numberOfEdges() {
        return 0;
    }
    protected void setNumberOfEdges(int newNumberOfEdges) {
        this._numberOfEdges = newNumberOfEdges;
    }
    protected int[][] adjacency() {
        return this._adjacency;
    }
    protected void setAdjacency(int[][] newAdjacency){
        this._adjacency = newAdjacency;
    }

    // Getting & setting Adjacency
    protected int adjacencyOfEdge(int tailVertex, int headVertex){
        return this.adjacency()[tailVertex][headVertex];
    }
    protected void setAdjacencyOfEdgeAs(int tailVertex, int headVertex, int anAdjacencyOfEdge){
        this.adjacency()[tailVertex][headVertex] = anAdjacencyOfEdge;
    }
    protected void setAdjacencyOfEdgeAsExist(int tailVertex, int headVertex){
        this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_EXIST);
    }
    protected void setAdjacencyOfEdgeAsNone(int tailVertex, int headVertex){
        this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_NONE);
    }

    // Constructor, protected method
    public UndirectedAdjacencyMatrixGraph(){
    }

    public UndirectedAdjacencyMatrixGraph(int givenNumberOfVertices){
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setNumberOfEdges(0);
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]);
        for(int tailVertex = 0; tailVertex < this.numberOfVertices(); tailVertex++){
            for (int headVertex = 0; headVertex < this.numberOfVertices(); headVertex++){
                this.setAdjacencyOfEdgeAsNone(tailVertex, headVertex);
            }
        }
    }

    protected boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVertex){
        return (this.adjacencyOfEdge(tailVertex, headVertex) != UndirectedAdjacencyMatrixGraph.EDGE_NONE);
    }


    // Public Methods
    @Override
    public boolean vertexDoesExist(int aVertex) {
        return (aVertex >= 0 && aVertex < this.numberOfVertices());
    }

    @Override
    public boolean edgeIsValid(int aTailVertex, int aHeadVertex) {
        return (this.vertexDoesExist(aTailVertex) && this.vertexDoesExist(aHeadVertex));
    }
    @Override
    public boolean edgeIsValid(E anEdge) {
        if(anEdge != null){
            return (this.edgeIsValid(anEdge.tailVertex(), anEdge.headVertex()));
        }
        return false;
    }
    @Override
    public boolean edgeDoesExist(int aTailVertex, int aHeadVertex) {
        if(this.edgeIsValid(aTailVertex, aHeadVertex)){
            return (this.adjacencyOfEdgeDoesExist(aTailVertex, aHeadVertex));
        }
        return false;
    }
    @Override
    public boolean edgeDoesExist(E anEdge) {
        if(anEdge != null){
            return this.edgeDoesExist(anEdge.tailVertex(), anEdge.headVertex());
        }
        return false;
    }

    @Override
    public E edge(int aTailVertex, int aHeadVertex) {
        return null;
    }
    @Override
    public boolean addEdge(E anEdge) {
        if(this.edgeIsValid(anEdge) && !this.edgeDoesExist(anEdge)){
            int tailVertex = anEdge.tailVertex();
            int headVertex = anEdge.headVertex();
            this.setAdjacencyOfEdgeAsExist(tailVertex, headVertex);
            this.setAdjacencyOfEdgeAsExist(tailVertex, tailVertex);
            this.setNumberOfEdges(this.numberOfEdges()+1);
            return true;
        }
        return false;
    }

}
