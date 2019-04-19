import java.util.Scanner;

//Main Program Code
public class Puzzle {

	public static void main(String[] args) {

        int[] easy = {1,3,4,8,6,2,7,0,5};
        int[] medium = {2,8,1,0,4,3,7,6,5};
        int[] hard = {5,6,7,4,0,8,3,2,1};

        int[] goal = {1,2,3,8,0,4,7,6,5};

        Node root; //Used for root of search tree
        PuzzleSolver tree; //Search functions are in here

        //Code for 1st menu presented to user
        Scanner input = new Scanner(System.in);
        int choice;

        do {

        	System.out.println("8 Puzzle Solver");
        	System.out.println("--------------------------");
        	System.out.println("1) Run the easy problem");
        	System.out.println("2) Run the medium problem");
        	System.out.println("3) Run the hard problem");
        	System.out.println("4) Quit");
        	System.out.println();

        	choice = input.nextInt();

        	switch(choice) {

        	case 1:
        		root = new Node(easy);
        		tree = new PuzzleSolver(root, goal);
        		algorithm(tree);
        		break;

        	case 2:
        		root = new Node(medium);
        		tree = new PuzzleSolver(root, goal);
        		algorithm(tree);
        		break;

        	case 3:
        		root = new Node(hard);
        		tree = new PuzzleSolver(root, goal);
        		algorithm(tree);
        		break;

        	case 4:
        		input.close();
        		System.out.println("Exiting Program.");
        		break;
        	}


        } while (choice != 4);
	}

	//Code for 2nd menu presented to user
	public static void algorithm (PuzzleSolver tree) {

		Scanner input = new Scanner(System.in);
        int choice;
        do {
        	System.out.println();
        	System.out.println("Choose Algorithm");
        	System.out.println("--------------------------");
        	System.out.println("1) Breadth First Search");
        	System.out.println("2) Depth First Search");
        	System.out.println("3) Uniform Cost Search");
        	System.out.println("4) Best First Search (h = tiles not in correct position)");
        	System.out.println("5) A*1 (h = tiles not in correct position)");
        	System.out.println("6) A*2 (h = sum of manhattan distances of tiles and correct position)");
        	System.out.println();

        	choice = input.nextInt();

        	switch(choice) {

        	case 1:
        		tree.bfs();
        		choice = 7;
        		break;

        	case 2:
        		tree.dfs();
        		choice = 7;
        		break;

        	case 3:
        		tree.uniform();
        		choice = 7;
        		break;

        	case 4:
        		tree.bestfirst();
        		choice = 7;
        		break;


        	case 5:
        		tree.astar1();
        		choice = 7;
        		break;

        	case 6:
        		tree.astar2();
        		choice = 7;
        		break;

        	}

        } while (choice != 7);

	}

}
