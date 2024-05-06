import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            int numCases = scanner.nextInt();

            for (int i = 0; i < numCases; i++) {
                GraphBFS<Integer> g = new GraphBFS<>();
                int numNodes = scanner.nextInt();
                int numEdges = scanner.nextInt();
                for (int j = 0; j < numEdges; j++) {
                    g.insertEdge(scanner.nextInt(), scanner.nextInt());
                }
                g.BFS(scanner.nextInt());
            }
            
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No input file found: " + e.getMessage());
        }
    }
}