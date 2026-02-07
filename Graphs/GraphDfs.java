import java.util.*;
class GraphDfs{
     int v;
	 ArrayList<ArrayList<Integer>> adj;

    GraphDfs(int v){
	 this.v=v;
	 adj=new ArrayList<>();
	 for(int i=0;i<v;i++) adj.add(new ArrayList<>());
	}
	
	public void addEdge(int x, int y){
	  adj.get(x).add(y);
	  adj.get(y).add(x);
	}
	public  void dfs(int start, boolean[] visited){
      visited[start]=true;
	  System.out.print(start +" ");
	  for(int neigh : adj.get(start)){
	  if(!visited[neigh]) dfs(neigh, visited);
	  }
	
	}
	


public static void main(String args[]){
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter the number of vertices ");
   int ver=sc.nextInt();
   GraphDfs g= new GraphDfs(ver);
    System.out.println("Enter the number of edges ");
   int  e= sc.nextInt();
    System.out.println("Add the  edges ");
     for(int i=0;i<e;i++){
	   int x=sc.nextInt();
	   int y=sc.nextInt();
	   g.addEdge(x,y);
	 }
	 System.out.println("Enter the start node  ");
	 int start=sc.nextInt();

	 boolean [] visited= new boolean[ver];
	 	 g.dfs(start, visited);
	 sc.close();
  }
}