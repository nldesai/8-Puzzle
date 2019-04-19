import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//Each Node represents a state and the attributes listed below are stored here
public class Node implements Comparable<Node>{

    int[] state;
    Node parent;
    int depth;
    String action;
    int pathcost = 0;
    int totalcost;
    boolean expanded = false;
    ArrayList<Node> children;

    //Constructor for Node. Initialized with either the easy, medium, or hard arrays.
    Node (int[] state) {
        this.state = state;
        this.children = new ArrayList<Node>();
    }

    //Sets the parent of the current Node
    public void setParent (Node parent) {
        this.parent = parent;
    }

    //Sets whether the Node has been expanded or not
    public void setExpanded () {
        this.expanded = true;
    }

    //Sets the cost of a single move on the board
    public void setPathCost (int pathcost) {
        this.pathcost = pathcost;
    }

    //Sets the total cost of moves made up to and including this state
    public void setTotalCost (int totalcost) {
    	this.totalcost = totalcost;
    }

    //Sets the direction of the move made
    public void setAction(String action) {
        this.action = action;
    }

    //Adds a child link to current Node
    public void addChild(Node current) {
    	this.children.add(current);
    }


    /* Override of equals and hashCode methods for Node in order to use ".contains" efficiently in PuzzleSolver.java
     	when searching for repeated states
     */
	@Override
	public boolean equals (Object o) {

		if (!(o instanceof Node)) {
			return false;
		}

		Node s = (Node) o;

		return Arrays.equals(s.state, state);

	}

	@Override
	public int hashCode() {
		int result = 17;
		for (int hash : state) {
			result = 37*result + hash;
		}

		return result;
	}

	//Override of compareTo method of Node using Comparator. This is used for the Priority Queues in some of the search functions.
	@Override
	public int compareTo (Node other) {
		if (this.totalcost > other.totalcost) {
			return 1;
		}
		else if (this.totalcost < other.totalcost) {
			return -1;
		}
		return 0;
	}
}
