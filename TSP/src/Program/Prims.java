package Program;
public class Prims
{
    
    int minKey(int key[], Boolean mstSet[],int V)
    {
    
          int min = Integer.MAX_VALUE, min_index=-1;
 
          for (int v = 0; v < V; v++)
          if (mstSet[v] == false && key[v] < min)
          {
                min = key[v];
                min_index = v;
          }
 
        return min_index;
    }
 
    void printMST(int parent[], int graph[][] , int V)
    {
          int j;
          int distance=0;
        System.out.println("Edge   Weight");
        int i;
        for (i = 1; i < V; i++)
        {
            System.out.println((parent[i]+1) + " - " + (i+1) + "    " + graph[i][parent[i]]);
            distance+=graph[i][parent[i]];
        }
        System.out.println("Weight of Minimum Spanning Tree is : " + distance + "\n");
        distance+=graph[i-1][parent[1]];
        System.out.print("Shortest Path according to Prims Algorithm is : ");
        j = 0;
        printPreorder(j , parent , V);
        System.out.println(j+1);
        System.out.println("Distance according to shorest path is : " + distance + "\n");
        
    }
    
    public void printPreorder(int i , int parent[] , int V)
        {
              int j;
              System.out.print((i+1)+"->");
              for(j = 1 ; j < V ; j++)
              {
                  if(i == parent[j])
                  {
                        printPreorder(j , parent , V);
                  }
              }
        }

    
 
    public void primMST(int graph[][],int V)
    {
    
          int parent[] = new int[V];
 
        int key[] = new int [V];
 
        Boolean mstSet[] = new Boolean[V];
 
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        key[0] = 0; 
        parent[0] = -1;
 
        
        for (int count = 0; count < V-1; count++)
        {
            int u = minKey(key, mstSet , V);
 
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
 
                if (graph[u][v]!=0 && mstSet[v] == false && graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }
 
        printMST(parent, graph , V);
    }
}