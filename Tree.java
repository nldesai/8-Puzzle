import java.util.ArrayList;
import java.util.List;

/*
 * This class, specifically the function getChildren, is used to populate the search tree with children.
 */
public class Tree {

	public static List<Node> getChildren (Node current) {

        int[] state = current.state;
        int blank_position = 0;

        List<Node> children = new ArrayList<>();

        //Finding the position of the blank/0
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                blank_position = i;
            }
        }

        /*
         * Hard Coded possible combinations (moves) of children based on where the blank space is in the puzzle
         * Utilized a swap function to make the new state (array) after the move
         * Used the array to create a new child Node, and set fields such as action, parent, pathcost, and totalcost
         */
        if (blank_position == 0) {
            Node child1 = new Node(swap(state, blank_position, 1));
            child1.setParent(current);
            child1.setPathCost(state[1]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Right");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 3));
            child2.setParent(current);
            child2.setPathCost(state[3]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Down");
            children.add(child2);
        }

        if (blank_position == 1) {
            Node child1 = new Node(swap(state, blank_position, 0));
            child1.setParent(current);
            child1.setPathCost(state[0]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Left");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 2));
            child2.setParent(current);
            child2.setPathCost(state[2]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Right");
            children.add(child2);

            Node child3 = new Node(swap(state, blank_position, 4));
            child3.setParent(current);
            child3.setPathCost(state[4]);
            child3.setTotalCost(current.pathcost + child3.pathcost);
            child3.setAction("Down");
            children.add(child3);
        }

        if (blank_position == 2) {
            Node child1 = new Node(swap(state, blank_position, 1));
            child1.setParent(current);
            child1.setPathCost(state[1]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Left");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 5));
            child2.setParent(current);
            child2.setPathCost(state[5]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Down");
            children.add(child2);
        }

        if (blank_position == 3) {
            Node child1 = new Node(swap(state, blank_position, 4));
            child1.setParent(current);
            child1.setPathCost(state[4]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Right");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 0));
            child2.setParent(current);
            child2.setPathCost(state[0]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Up");
            children.add(child2);

            Node child3 = new Node(swap(state, blank_position, 6));
            child3.setParent(current);
            child3.setPathCost(state[6]);
            child3.setTotalCost(current.pathcost + child3.pathcost);
            child3.setAction("Down");
            children.add(child3);
        }

        if (blank_position == 4) {
            Node child1 = new Node(swap(state, blank_position, 3));
            child1.setParent(current);
            child1.setPathCost(state[3]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Left");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 5));
            child2.setParent(current);
            child2.setPathCost(state[5]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Right");
            children.add(child2);

            Node child3 = new Node(swap(state, blank_position, 1));
            child3.setParent(current);
            child3.setPathCost(state[1]);
            child3.setTotalCost(current.pathcost + child3.pathcost);
            child3.setAction("Up");
            children.add(child3);

            Node child4 = new Node(swap(state, blank_position, 7));
            child4.setParent(current);
            child4.setPathCost(state[7]);
            child4.setTotalCost(current.pathcost + child4.pathcost);
            child4.setAction("Down");
            children.add(child4);
        }

        if (blank_position == 5) {
            Node child1 = new Node(swap(state, blank_position, 4));
            child1.setParent(current);
            child1.setPathCost(state[4]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Left");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 2));
            child2.setParent(current);
            child2.setPathCost(state[2]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Up");
            children.add(child2);

            Node child3 = new Node(swap(state, blank_position, 8));
            child3.setParent(current);
            child3.setPathCost(state[8]);
            child3.setTotalCost(current.pathcost + child3.pathcost);
            child3.setAction("Down");
            children.add(child3);
        }

        if (blank_position == 6) {
            Node child1 = new Node(swap(state, blank_position, 7));
            child1.setParent(current);
            child1.setPathCost(state[7]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Right");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 3));
            child2.setParent(current);
            child2.setPathCost(state[3]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Up");
            children.add(child2);
        }

        if (blank_position == 7) {
            Node child1 = new Node(swap(state, blank_position, 6));
            child1.setParent(current);
            child1.setPathCost(state[6]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Left");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 8));
            child2.setParent(current);
            child2.setPathCost(state[8]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Right");
            children.add(child2);

            Node child3 = new Node(swap(state, blank_position, 4));
            child3.setParent(current);
            child3.setPathCost(state[4]);
            child3.setTotalCost(current.pathcost + child3.pathcost);
            child3.setAction("Up");
            children.add(child3);
        }

        if (blank_position == 8) {
            Node child1 = new Node(swap(state, blank_position, 7));
            child1.setParent(current);
            child1.setPathCost(state[7]);
            child1.setTotalCost(current.pathcost + child1.pathcost);
            child1.setAction("Left");
            children.add(child1);

            Node child2 = new Node(swap(state, blank_position, 5));
            child2.setParent(current);
            child2.setPathCost(state[5]);
            child2.setTotalCost(current.pathcost + child2.pathcost);
            child2.setAction("Up");
            children.add(child2);
        }

        return children;
    }

	//Swap function to create a new state (array) after a piece has been moved
    public static int[] swap (int[] state, int pos, int newpos) {

        int[] temp = state.clone();
        int tmp = temp[pos];
        temp[pos] = temp[newpos];
        temp[newpos] = tmp;

        return temp;
    }
}
