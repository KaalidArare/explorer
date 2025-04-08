import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        int[] start = startingLocation(island);
        boolean[][] visited = new boolean[island.length][island[0].length];

        return canReach(island,start[0], start[1], visited);
    }

    public static int canReach(int[][] island, int r, int c, boolean[][] visited) { 
        if (r < 0 || r >= island.length || c < 0 || c >= island[0].length) return 0;
        if (visited[r][c]) return 0;
        
        if (island[r][c] == 2 || island[r][c] == 3) return 0;

        visited[r][c] = true;

        int count = 1;

        count += canReach(island, r - 1, c, visited);
        count += canReach(island, r + 1, c, visited);
        count += canReach(island, r, c - 1, visited);
        count += canReach(island, r, c + 1, visited);
    
        return count;
    }

    public static List<int[]> getPossibleMoves(int[][] island, int row, int col) {
        List<int[]> moves = new ArrayList<>();

        int numRows = island.length;
        
        int numCols = island[0].length;
        
        
        if (row - 1 >= 0 && island[row - 1][col] != 2 && island[row - 1][col] != 3) {
            moves.add(new int[]{row - 1, col});
        }
        
        if (row + 1 < numRows && island[row + 1][col] != 2 && island[row + 1][col] != 3) {
            moves.add(new int[]{row + 1, col});
        }
        
        if (col - 1 >= 0 && island[row][col - 1] != 2 && island[row][col - 1] != 3) {
            moves.add(new int[]{row, col - 1});
        }
        
        if (col + 1 < numCols && island[row][col + 1] != 2 && island[row][col + 1] != 3) {
            moves.add(new int[]{row, col + 1});
        }
        
        return moves;
    }

    public static int[] startingLocation(int[][] island) {

        for(int r = 0; r < island.length; r++) {
            for(int c = 0; c < island[0].length; c++) {
                if(island[r][c] == 0) {
                    return new int[]{r,c};
                }
            }
        }
        throw new IllegalArgumentException("Blocked section");
    }
}
