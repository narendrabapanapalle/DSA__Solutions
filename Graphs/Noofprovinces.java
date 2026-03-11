import java.util.*;
class Noofprovinces
{
	 public void dfs(int city,int [][] adj, boolean[] visited){
	    visited[city]=true;
		for(int i=0;i<adj.length;i++){
		    if(adj[city][i]==1 && (!visited[i])) dfs(i,adj,visited);
		}
	 }

     public int findCircleNum(int[][] adj) {
	   int x=adj.length;
	   int pro=0;
	   boolean[] visited= new boolean[x];
	   for(int i=0;i<x;i++){
	     if(!visited[i]) {
		     pro++;
			 dfs(i,adj,visited);
		 }
	   }
	  return pro;
     }

   public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
     System.out.println("Enter the city");
	 int n=sc.nextInt();
	 int [][] adj= new int[n][n];
	 for(int i=0;i<n;i++){
	   for(int j=0;j<n;j++){
	     adj[i][j]=sc.nextInt();
	   } 
	 }
    Noofprovinces g= new Noofprovinces();
	int ans=g.findCircleNum(adj);
   System.out.print("No of Provinces" +ans);
   }
}