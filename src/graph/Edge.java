package graph;

// 3) EDGE 삽입
public class Edge {
    // Instance Variable
    private int _tailVertex;
    private int _headVertex;

    // Generator; 캡화로 정보 은닉
    public Edge(int givenTailVertex, int givenHeadVertex){
        this.setTailVertex (givenTailVertex);
        this.setHeadVertex (givenHeadVertex);
    }
    // getter setter
    public void setTailVertex(int newTailVertex){
        this._tailVertex = newTailVertex;
    }
    public int tailVertex (){
        return this._tailVertex;
    }

    public void setHeadVertex (int newHeadVertex){
        this._headVertex = newHeadVertex;
    }
    public int headVertex (){
        return this._headVertex;
    }
}
