package Program;
import java.util.ArrayList;
import java.util.Scanner;

 public class matrix
{
	public int edge[][];
	public int node;

        Scanner scan = new Scanner(System.in);
	
    public matrix(int num_node , ArrayList<Edge> list)
    {
	node = num_node;
	edge = new int[node][node];
      Edge e = new Edge();
	int x,y,distance;
      for(int i = 0; i< list.size() ; i++)
      {
            e = list.get(i);
            x = e.getSource();
            y = e.getDestination();
            distance = e.getDistance();
            edge[x][y] = distance;
      }
      
      }
      
	public void Add_Node()
	{
		int new_node;
		new_node = node+1;
		
		int general[][] = new int[new_node][new_node];
		
		for(int i=0;i<node;i++)
		{
			for(int j=0;j<node;j++)
			{
				general[i][j] = edge[i][j];
			}
		}
		
		for(int j=0;j<new_node-1;j++)
		{
				System.out.println("Input the distance from node "+new_node+" to node "+(j+1)+" :");
				general[node][j] = scan.nextInt();
				general[j][node] = general[node][j];
		}
		
		general[node][node] = 0;

		edge = general;
		node = new_node; 	
	}

	public void Delete_Node()
	{   
		int node_no,new_node;
		System.out.println("Input the node number you want to delete:");
		node_no = scan.nextInt();
		
		if(node_no>-1 && node_no<node)
		{
			
			int general[][] = new int[node-1][node-1];
			
			for(int i=0;i<node_no-1;i++)
			{
				for(int j=0;j<node_no-1;j++)
				{
					general[i][j] = edge[i][j];
				}
			}
			
			for(int i=node_no;i<node;i++)
			{
				for(int j=node_no;j<node;j++)
				{
					general[i-1][j-1] = edge[i][j];
				}
			}
			
			for(int i=node_no;i<node;i++)
			{
				for(int j=0;j<node_no-1;j++)
				{
					general[i-1][j] = edge[i][j];
				}
			}

                        
			for(int i=0;i<node_no-1;i++)
			{
				for(int j=node_no;j<node;j++)
				{
					general[i][j-1] = edge[i][j];
				}
			} 
                
			edge = general;
			node = node - 1;
		}
	}
	

	public void Display_Matrix()
	{
		System.out.print("0 ");
		for(int i=0;i<node;i++)
		{
			System.out.print((i+1)+" ");
		}
		System.out.println("\n");
		for(int j=0;j<node;j++)
		{
			System.out.print((j+1)+" ");
			for(int k=0;k<node;k++)
			{
				if(j==k)
				{
					System.out.print("0 ");
				}
				else
				{
					System.out.print(edge[j][k]+" ");
				}
			}
			System.out.println("\n");
		}
	}
		public int[][] getmatrix()
		{
			return edge;
		}
		
		public int getnode()
		{
			return node;
		}
}
