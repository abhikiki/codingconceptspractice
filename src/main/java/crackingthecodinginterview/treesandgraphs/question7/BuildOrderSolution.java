package crackingthecodinginterview.treesandgraphs.question7;

import java.util.ArrayList;
import java.util.HashMap;

class Node{
    char project;
    boolean isVisited;

    Node(char project){
        this.project = project;
    }
}
public class BuildOrderSolution {
    private HashMap<Character, Node> projectToNodeMap = new HashMap<>();
    //Adjacency List
    private HashMap<Character, ArrayList<Node>> adjList = new HashMap<>();
    private ArrayList<Character> projectOrderList = new ArrayList<>();

    boolean isCycle = false;

    // Time Complexity: O(V+E) where V=Total no. of vertices
    // E = Total no. of edges
    public ArrayList<Character> buildOrder(char[] projects, char[][] dependencies){
        if(projects == null || projects.length == 0 || dependencies == null
           || dependencies.length ==0 || dependencies[0].length != 2)
            throw new IllegalArgumentException("Invalid Input");

        buildGraph(projects, dependencies);

        for(Character project : projects){
            buildProjectOrder(projectToNodeMap.get(project));
            adjList.get(project).clear();
            if(isCycle){
                System.out.println("Cycle Found");
                break;
            }
        }
        if(projectOrderList.size() != projects.length){
            System.out.println("Project order cannot be build");
            projectOrderList.clear();
        }
        return projectOrderList;
    }

    private void buildProjectOrder(Node node){
        if(node == null)
            return;
        if(node.isVisited && !projectOrderList.contains(node.project)){
            isCycle = true;
            return;
        }
        node.isVisited = true;
        for(Node neighbour : adjList.get(node.project)){
            buildProjectOrder(neighbour);
        }
        if(!projectOrderList.contains(node.project))
            projectOrderList.add(node.project);
    }

    private void buildGraph(char[] projects, char[][] dependencies) {
        for(Character project : projects){
            projectToNodeMap.putIfAbsent(project, new Node(project));
            adjList.put(project, new ArrayList<>());
        }

        for(char[] dependency : dependencies){
            char from = dependency[0];
            char to = dependency[1];
            adjList.get(from).add(projectToNodeMap.get(to));
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> results = new BuildOrderSolution().buildOrder(
                new char[]{'a', 'b', 'c', 'd', 'e', 'f'},
                new char[][]{
                        {'d', 'a'},
                        {'b', 'f'},
                        {'d', 'b'},
                        {'a', 'f'},
                        {'c', 'd'}
                });
        System.out.println("First Solution=" + results.toString());

        char[] numTasks = {'a', 'b', 'c', 'd'};
        char[][] prerequisites
                = { { 'b', 'a' }, { 'c', 'b' }, { 'd', 'c' } };
        results  = new BuildOrderSolution().buildOrder(numTasks, prerequisites);
        System.out.println("Second Solution=" + results.toString());


        char[][] prerequisitesCycle
                = { { 'b', 'a' }, { 'c', 'b' }, { 'd', 'c' }, {'b','c'} };
        results  = new BuildOrderSolution().buildOrder(numTasks, prerequisitesCycle);
        System.out.println("Third Cycle Solution=" + results.toString());
    }
}
