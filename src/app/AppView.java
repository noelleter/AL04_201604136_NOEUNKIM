package app;
import java.util.Scanner;

// AppController 입력 및 출력, static 성질 주의 ***
public final class AppView {
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    private AppView(){
    }

    public static void outputLine(String aString){
        System.out.println(aString);
    }

    public static void output(String aString){
        System.out.print(aString);
    }


    // Vertex 개수 입력
    public static int inputNumberOfVertices (){
        int numberOfVertices;
        String scannedToken;

        while(true){
            AppView.output("? vertex 수를 입력하시오: ");
            scannedToken = AppView.scanner.next();
            try {
                numberOfVertices = Integer.parseInt(scannedToken);
                return numberOfVertices;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) Vertex 수 입력에 오류가 있습니다: ");
            }
        }
    }

    // Edge 개수 입력
    public static int inputNumberOfEdges (){
        int numberOfEdges;
        String scannedToken;
        while (true){
            AppView.output("? edge 수를 입력하시오: ");
            scannedToken = AppView.scanner.next();
            try {
                numberOfEdges = Integer.parseInt(scannedToken);
                return numberOfEdges;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) edge 수 입력에 오류가 있습니다: ");
            }
        }
    }
    // Tail vertex 입력
    public static int inputTailVertex (){
        int tailVertex;
        String scannedToken;
        while (true){
            AppView.output("? tail vertex 를 입력하시오: ");
            scannedToken = AppView.scanner.next();
            try {
                tailVertex = Integer.parseInt(scannedToken);
                return tailVertex;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) tail vertex 입력에 오류가 있습니다: ");
            }
        }
    }
    // Head vertex 입력
    public static int inputHeadVertex (){
        int headVertex;
        String scannedToken;
        while (true){
            AppView.output("? head vertex 를 입력하시오: ");
            scannedToken = AppView.scanner.next();
            try {
                headVertex = Integer.parseInt(scannedToken);
                return headVertex;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) head vertex 입력에 오류가 있습니다: ");
            }
        }
    }

    // edge를 입력 받을 때, cost도 함께 입력받기 위함
    public static int inputCost(){
        int cost;
        String scannedToken;
        while (true){
            AppView.output("? cost 를 입력하시오: ");
            scannedToken = AppView.scanner.next();
            try {
                cost = Integer.parseInt(scannedToken);
                return cost;
            }
            catch (NumberFormatException e){
                AppView.outputLine("[오류] cost 입력에 오류가 있습니다: " + scannedToken);
            }
        }
    }
}
