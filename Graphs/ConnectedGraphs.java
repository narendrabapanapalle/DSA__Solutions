import java.util.*;
class ConnectedGraphs{
    int v;
	ArrayList<ArrayList<Integer>> adj;
	ConnectedGraphs(int v){
	 this.v=v;
	 adj = new ArrayList<>();
	 for(int i=0;i<v;i++){
	   adj.add(new ArrayList<>());
	 }
	}
	
	
	public void addEdge(int x, int y){
	   adj.get(x).add(y);
	   adj.get(y).add(x);
	}
	public void dfs(int start, boolean[] visited){
	    visited[start]=true;
		System.out.print(start+ " ");
		for(int neigh:adj.get(start)){
		  if(!visited[neigh]) dfs(neigh, visited);
		}
	}
	
	public void connectedcom(){
	   boolean [] visited= new boolean[v];
	   int count=0;
	   for(int i=0;i<v;i++){
		if(!visited[i]){
	     count++;
	     System.out.println("component " +count);
		 dfs(i,visited);
		 System.out.println();
	   }
	   }
	
	}
	


   public static void main(String args[]){
      Scanner sc= new Scanner(System.in);
	  System.out.println("Enter the number of vertices ");
	  int ver=sc.nextInt();
	  ConnectedGraphs g= new ConnectedGraphs(ver);
	  System.out.println("Enter the number of edges ");
	  int e=sc.nextInt();
	  
	  System.out.println("Enter edges ");
	  for(int i=0;i<e;i++){
	     int x=sc.nextInt();
		 int y=sc.nextInt();
		 g.addEdge(x,y);
	  }
	   g.connectedcom();
   }
  
   

}