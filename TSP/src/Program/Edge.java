package Program;

public class Edge
{
      private int source;
      private int destination;
      private int distance;
      
      Edge() 
      {
      
      }
      
      public Edge(int city,int city1,int dist)
      {
            source = city;
            destination = city1;
            distance = dist;
      }

      

      public int getSource() {
            return source;
      }

      public int getDestination() {
            return destination;
      }

      public int getDistance() {
            return distance;
      }
      
      
}