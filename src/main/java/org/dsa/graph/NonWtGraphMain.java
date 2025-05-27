package org.dsa.graph;

import java.util.Scanner;

class NonWtGraph{
    private int vertexCount;
    private int edgeCount;
    private int[] []adjMat;

    public NonWtGraph(int vertCount) {
        vertexCount = vertCount;
        edgeCount = 0;
        adjMat = new int[vertCount][vertCount];
        for (int i=0;i<vertexCount;i++){
            for (int j=0;j<vertexCount;j++){
                adjMat[i][j]=0;
            }
        }
    }
    public void accept(Scanner sc){
        System.out.print("Enter number of edges :");
        edgeCount = sc.nextInt();
        for (int i=0;i<vertexCount;i++){
            System.out.print("Enter edge (src dest): ");
            int src = sc.nextInt();
            int dest = sc.nextInt();
            adjMat[src][dest]=1;
//            adjMat[dest][src]=1;//delete this line for directed graph
        }
    }
    public void display(){
        System.out.print("\nAdjecency matrix: \n");
        for(int i=0;i<vertexCount;i++){
            for(int j=0;j<vertexCount;j++){
                System.out.print(adjMat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
public class NonWtGraphMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices : ");
        int verCount = sc.nextInt();
        NonWtGraph gh = new NonWtGraph(verCount);
        gh.accept(sc);
        gh.display();
        sc.close();
    }

}
