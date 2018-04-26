package Program;
import java.util.Scanner;

public class Shortest_Path 
{
	
	Scanner inp = new Scanner(System.in);

	int start,check1=0,count=0;
	int visited[][];
	int sum[];
	
	public void path_detect(int edge[][],int node)
	{
		int count=0,check,smallest_distance=Integer.MAX_VALUE,eff_start_point=0;
		
		visited = new int[node][node];
		
		sum = new int[node];
		
		
		for(int i=0;i<node;i++)
		{
			for(int j=0;j<node;j++)
			{
				visited[i][j] = -1;
			}
		}

                for(int j=0;j<node;j++)
		{
			start = j;
			recurssive(j,node,edge);
		}
		
		for(int i=0;i<node;i++)
		{
			if(smallest_distance>sum[i])
			{
				smallest_distance = sum[i];
				eff_start_point = i;
				
			}
		}
		
		System.out.println("The shortest path is:");
		for(int j=0;j<node;j++)
		{
			System.out.print(visited[eff_start_point][j]+"--> ");
		}
		System.out.println(eff_start_point);
		System.out.println("The shortest distance is :"+sum[eff_start_point]);
	}


	public void recurssive(int j,int node,int edge[][])
	{
		int smallest = Integer.MAX_VALUE;
		int gotoindex=0;
		int check=0;
		
		visited[start][count] = j;

		count++;

			for(int i=0;i<node;i++)
			{
				for(int k=0;k<node;k++)
				{
					if(i==visited[start][k])
					{
						check = 1;
						break;
					}

					else if(i==j)
					{
						check = 1;
						break;
					}

					else
					{
						check = 2;
					}
				}
				
				if(check == 1)
				{
					
				}

				else if(check == 2)
				{
					if(smallest > edge[j][i])
					{
						smallest=edge[j][i];
						gotoindex = i;
					}
				}
			}
				
			if(smallest == Integer.MAX_VALUE)
			{
				smallest = edge[j][start];
				count = 0;
			}
			
			sum[start] = sum[start] + smallest;
			
			smallest = Integer.MAX_VALUE;

			if(check1<node-1)
			{
				check1++;
				recurssive(gotoindex,node,edge);
			}
			
			check1 = 0;
	}
}
