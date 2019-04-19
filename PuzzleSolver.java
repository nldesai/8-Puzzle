import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

//This class does all of the searching and printing of the solution.
public class PuzzleSolver {
    Node root;
    int[] goal;

    //Initialized with the root Node, and the goal state
    PuzzleSolver(Node root, int[] goal) {
        this.root = root;
        this.goal = goal;
    }

    /*
     * Breadth First Search Algorithm. Using a Queue to keep track of Nodes, and a LinkedHashSet to store the solutions.
     * The LinkedHashSet was used to efficiently look up if a Node State already exists, made possible by the overriding
     * of equals and hashCode in Node.java
     */
    public void bfs() {

        int time = 0;
        int space = 0;


        Queue<Node> queue = new LinkedList<>();
        Node current = root;
        queue.add(current);
        space += 1;

        LinkedHashSet<Node> solution = new LinkedHashSet<>();

        while (!queue.isEmpty() && !Arrays.equals(current.state, goal)) {

        	current = queue.poll();
        	time += 1;
        	if (!solution.contains(current)) {
        		solution.add(current);
        	}
        	List<Node> children = Tree.getChildren(current);

        	for (Node child : children) {
        		if (!solution.contains(child)) {
        			solution.add(child);
        			current.addChild(child);
        			queue.add(child);
        			space += 1;
        		}
        	}
        }

        printsolution(solution, goal, time, space);

    }

    /*
     * Depth First Search Algorithm. Using a Stack to keep track of Nodes, and a LinkedHashSet to store the solutions.
     * The LinkedHashSet was used to efficiently look up if a Node State already exists, made possible by the overriding
     * of equals and hashCode in Node.java
     */
    public void dfs() {

        int time = 0;
        int space = 0;


        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);
        space += 1;

        LinkedHashSet<Node> solution = new LinkedHashSet<>();

        while (!stack.isEmpty() && !Arrays.equals(current.state, goal)) {

        	current = stack.pop();
        	time += 1;
        	if (!solution.contains(current)) {
        		solution.add(current);
        	}
        	List<Node> children = Tree.getChildren(current);

        	for (Node child : children) {
        		if (!solution.contains(child)) {
        			solution.add(child);
        			current.addChild(child);
        			stack.push(child);
        			space += 1;
        		}
        	}
        }

        printsolution(solution, goal, time, space);

    }

    /*
     * Uniform Cost Search Algorithm. Using a Priority Queue to keep track of Nodes, and a LinkedHashSet to store the solutions.
     * The LinkedHashSet was used to efficiently look up if a Node State already exists, made possible by the overriding
     * of equals and hashCode in Node.java
     */
    public void uniform() {

        int time = 0;
        int space = 0;


        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        Node current = root;
        pqueue.add(current);
        space += 1;

        LinkedHashSet<Node> solution = new LinkedHashSet<>();

        while (!pqueue.isEmpty() && !Arrays.equals(current.state, goal)) {

        	current = pqueue.poll();
        	time += 1;
        	if (!solution.contains(current)) {
        		solution.add(current);
        	}
        	List<Node> children = Tree.getChildren(current);

        	for (Node child : children) {
        		if (!solution.contains(child)) {
        			solution.add(child);
        			current.addChild(child);
        			pqueue.add(child);
        			space += 1;
        		}
        	}
        }

        printsolution(solution, goal, time, space);

    }

    /*
     * Best First Search Algorithm. Using a Priority Queue to keep track of Nodes, and a LinkedHashSet to store the solutions.
     * The LinkedHashSet was used to efficiently look up if a Node State already exists, made possible by the overriding
     * of equals and hashCode in Node.java. The Heuristic used here was the number of tiles not in the correct position
     */
    public void bestfirst() {

        int time = 0;
        int space = 0;


        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        Node current = root;
        pqueue.add(current);
        space += 1;

        LinkedHashSet<Node> solution = new LinkedHashSet<>();

        while (!pqueue.isEmpty() && !Arrays.equals(current.state, goal)) {

        	current = pqueue.poll();
        	time += 1;
        	if (!solution.contains(current)) {
        		solution.add(current);
        	}
        	List<Node> children = Tree.getChildren(current);

        	for (Node child : children) {
        		if (!solution.contains(child)) {
        			solution.add(child);
        			current.addChild(child);
        			child.setTotalCost(heuristicone(child.state, goal));
        			pqueue.add(child);
        			space += 1;
        		}
        	}
        }

        printsolution(solution, goal, time, space);

    }

    /*
     * A*1 Search Algorithm. Using a Priority Queue to keep track of Nodes, and a LinkedHashSet to store the solutions.
     * The LinkedHashSet was used to efficiently look up if a Node State already exists, made possible by the overriding
     * of equals and hashCode in Node.java. The Heuristic used here was the number of tiles not in the correct position
     */
    public void astar1() {

        int time = 0;
        int space = 0;


        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        Node current = root;
        pqueue.add(current);
        space += 1;

        LinkedHashSet<Node> solution = new LinkedHashSet<>();

        while (!pqueue.isEmpty() && !Arrays.equals(current.state, goal)) {

        	current = pqueue.poll();
        	time += 1;
        	if (!solution.contains(current)) {
        		solution.add(current);
        	}
        	List<Node> children = Tree.getChildren(current);

        	for (Node child : children) {
        		if (!solution.contains(child)) {
        			solution.add(child);
        			current.addChild(child);
        			child.setTotalCost(heuristictwo(child, goal));
        			pqueue.add(child);
        			space += 1;
        		}
        	}
        }

        printsolution(solution, goal, time, space);

    }

    /*
     * A*2 Algorithm. Using a Priority Queue to keep track of Nodes, and a LinkedHashSet to store the solutions.
     * The LinkedHashSet was used to efficiently look up if a Node State already exists, made possible by the overriding
     * of equals and hashCode in Node.java. The Heuristic used here was the sum of Manhattan distances between all
     * tiles and their correct positions
     */
    public void astar2() {

        int time = 0;
        int space = 0;


        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        Node current = root;
        pqueue.add(current);
        space += 1;

        LinkedHashSet<Node> solution = new LinkedHashSet<>();

        while (!pqueue.isEmpty() && !Arrays.equals(current.state, goal)) {

        	current = pqueue.poll();
        	time += 1;
        	if (!solution.contains(current)) {
        		solution.add(current);
        	}
        	List<Node> children = Tree.getChildren(current);

        	for (Node child : children) {
        		if (!solution.contains(child)) {
        			solution.add(child);
        			current.addChild(child);
        			child.setTotalCost(heuristicthree(child, goal));
        			pqueue.add(child);
        			space += 1;
        		}
        	}
        }

        printsolution(solution, goal, time, space);

    }

    /*
     * This Heuristic is the number of tiles not in their correct positions and it is made for Best First Search.
     */
    public int heuristicone(int[] state, int[] goal) {

    	int wrongposition = 0;
    	for (int i = 0; i < goal.length; i ++) {
    		if (state[i] != goal[i]) {
    			wrongposition += 1;
    		}
    	}
    	return wrongposition;

    }

    /*
     * This Heuristic is the number of tiles not in their correct positions. It is used for A*1 instead of Heuristic One
     * because it was easier to sum the total path cost at the current state with the result from Heuristic One doing it this way
     */
    public int heuristictwo(Node current, int[] goal) {

    	int h1 = heuristicone(current.state, goal);
    	int totalcost = h1 + current.totalcost;
    	return totalcost;

    }

    /*
     * This Heuristic is the sum of Manhattan distances between all tiles and their correct positions. It is used for
     * A*2
     */
    public int heuristicthree(Node current, int[] goal) {

    	int manhattan = 0;
    	int[] state = current.state;
    	for (int i = 0; i < goal.length; i++) {
    		for (int j = 0; j < state.length; j++) {
    			manhattan += ( Math.abs(goal[i] - goal[j]) + Math.abs(state[i] - state[j]) );
    		}
    	}
    	return manhattan + current.totalcost;

    }

    /*
     * A utility function to print the solution path and relevant information
     */
    public static void printsolution (LinkedHashSet<Node> solution, int[] goal, int time, int space) {

        int totalcost = 0;
        int solutionsize = 0;

        for (Node x : solution) {
        	if (!Arrays.equals(x.state, goal)) {
	        	printstate(x.state);
	        	totalcost += x.pathcost;
	        	System.out.println(x.action + ", " + "cost = " + x.pathcost + ", " + "total cost = " + totalcost);
	        	System.out.println();
	        	solutionsize += 1;
        	}
        	else {
        		printstate(x.state);
            	totalcost += x.pathcost;
            	System.out.println(x.action + ", " + "cost = " + x.pathcost + ", " + "total cost = " + totalcost);
            	System.out.println();
            	solutionsize += 1;
        		break;
        	}

        }

        System.out.println("Length of Solution Path: " + solutionsize);
        System.out.println("Cost of Solution Path: " + totalcost);
        System.out.println("Time (nodes popped off): " + time);
        System.out.println("Space (Max Queue Size): " + space);
        System.out.println();
    }

    /*
     * A utility function used to print the states (arrays). This function is used in printsolution.
     */
    public static void printstate(int[] x) {
    	for (int a : x) {
    		System.out.print(a + " ");
    	}
    	System.out.println();
    }

}
