import Connection.DatabaseConnection;
import Program.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
class TSP
{
	public static void main(String args[])
	{	
            int num ;
            int i = 0;
            ArrayList<Edge> list = new ArrayList<Edge>();
            try 
            {
                  Scanner scan = new Scanner(System.in);
                  
                  Connection conn = DatabaseConnection.getConnection();
                  Statement stmt =  conn.createStatement();
                  String sql = "SELECT * FROM tbl.tbl";
                  ResultSet rs = stmt.executeQuery(sql);
                  
                  while(rs.next())
                  {
                        //Retrieve by column name
                        int city  = rs.getInt("city");
                        int city1 = rs.getInt("city1");
                        int distance = rs.getInt("distance");
                        i++;
                        list.add(new Edge(city,city1,distance));   
                  }
                  num = (int) Math.sqrt(i);
                  System.out.println("Number of nodes already present in Database : "+num);
                  
                  matrix m1 = new matrix(num , list);
                  Shortest_Path one = new Shortest_Path();
                  Prims p1 = new Prims();
                  Dijkstras_Shortest_path d1 = new Dijkstras_Shortest_path();
                  
                  int choice;
                  while(true)
                  {
                        
                        System.out.println("Input your choice:\n1.Add Node\n2.Delete Node\n3.Nearest Neighbour\n4.Display Adjecency Matrix\n5.Prims\n6.Find Shortest path between two nodes\n7.Exit");
                        choice = scan.nextInt();
                        
                        if(choice == 1)
                        {
                              m1.Add_Node();
                        }
                        
                        else if(choice == 2)
                        {
                              m1.Delete_Node();
                        }
                        
                        else if(choice == 3)
                        {
                              one.path_detect(m1.getmatrix(),m1.getnode());
                        }
                        
                        else if(choice == 4)
                        {
                              m1.Display_Matrix();
                        }
                        
                        else if (choice == 5)
                        {
                              p1.primMST(m1.getmatrix(),m1.getnode());
                        }
                        
                        else if (choice == 6)
                        {
                              System.out.println("Enter the source ");
                              int source = scan.nextInt();
                              
                              System.out.println("Enter the destination ");
                              int destination = scan.nextInt();
                              
                              d1.dijkstra_algorithm(m1.getmatrix(),source , destination , m1.getnode());
                              
                        }
                        
                        else if(choice == 7)
                        {
                              sql = "DELETE FROM tbl";
                              stmt.execute(sql);
                              for(int x = 0 ; x < m1.getnode() ; x++)
                              {
                                    for(int y = 0 ; y < m1.getnode() ; y++)
                                    {
                                          int edge[][] = m1.getmatrix();
                                          sql = "INSERT INTO tbl.tbl VALUES('"+x+ "', '" +y+ "', '"+edge[x][y]+ "')";
                                          stmt.execute(sql);
                                    }
                              }
                              System.exit(0);
                        }
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(TSP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                  Logger.getLogger(TSP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
	}
}