import java.io.Console;
import java.util.HashSet;

public class Test
{
    public static String sExpression(String nodes){
        boolean[][] table = new boolean [26][26];
        HashSet<String> node = new HashSet<String>();
        //construct graph and check error E2: duplicate edges
        boolean E2 = false;
        for(int i=1;i<nodes.length();i+=6){
            int x = nodes.charAt(i)-'A', y = nodes.charAt(i+2)-'A';
            if(table[x][y]) //duplicate edge
            E2 = true;
            table[x][y] = true;
            node.add(String.valueOf(nodes.charAt(i)));
            node.add(String.valueOf(nodes.charAt(i+2)));
        }
        //check error E1: more than 2 children
        boolean E1 = false;
        for(int i=0;i<26;i++){
            int count = 0; //number of child
            for(int j=0;j<26;j++){
                if(table[i][j])
                count++;
            }
            if(count>2)
                return "E1";
        }
        if(E2) return "E2"; //return E2 after checking E1

        //check E3: cycle present and E4: multiple roots
        int numOfRoots = 0;
        char root =' ';
        for (String no : node){//only check char that in the tree
            for(int i=0;i<26;i++){
                if(table[i][no.charAt(0)-'A'])
                break;
                if(i==25){
                    numOfRoots++;
                    root = no.charAt(0);
                    boolean[] visited = new boolean[26];
                    if(IsCycle(no, table, visited))
                        return "E3";
                }
            }
        }
        if(numOfRoots==0) return "E3"; //if no root, must be a cycle
        if(numOfRoots>1) return "E4"; //if more than one roots
        if(root==' ') return "E5"; //if no edge in input string, invalid input error
        return GetExpressionHelper(String.valueOf(root), table);

    }

    //true means there is a cycle, false means no cycle
    private static boolean IsCycle(String node, boolean[][] graph, boolean[] visited){
        if(visited[node.charAt(0)-'A']) //node has already been visited, must has a cycle
            return true;
        visited[node.charAt(0)-'A'] = true;
        for(int i=0;i<26;i++){
            if(graph[node.charAt(0)-'A'][i]){
                if(IsCycle((String.valueOf(i)+'A'), graph, visited))
                    return true;
            }
        }
        return false;
    }

    //Recursive DFS to get the expression/construct the tree
    private static String GetExpressionHelper(String node, boolean[][] graph){
        String left = "", right = ""; //if no children, left and right should be empty
        for(int i=0;i<26;i++){
            if(graph[node.charAt(0)-'A'][i]){
                left = GetExpressionHelper((String.valueOf(i)+'A'), graph);
                for(int j=i+1;j<26;j++){
                    if(graph[node.charAt(0)-'A'][j]){
                        right = GetExpressionHelper((String.valueOf(j)+'A') ,graph);
                        break;
                    }
                }
                break;
            }
        }
        return "("+node+left+right+")";
    }


    @org.junit.Test
    public  void sol()
    {
       String resullt = Test.sExpression("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)");
    }
}