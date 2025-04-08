import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    @Test
    public void unreachable() {
        int[][] island = {
            {1,2,2,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,2,0,3},
            {1,1,1,2,2,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void Allreachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,1},
        };

        int actual = ExplorerSearch.reachableArea(island);
        int count = 0;

        for(int i = 0; i < island.length; i++) {
            for(int k = 0; k < island[i].length; k++) {
                count++;
            }
        }
        
        assertEquals(count, actual);
    }

    @Test
    public void checkStartingLocation() {
        int[][] island = {
            {1,2,2,3,1,1},
            {3,2,3,2,3,1},
            {1,1,3,3,3,3},
            {3,1,2,2,0,3},
            {1,1,1,2,2,1},
        };
        int[] actual = ExplorerSearch.startingLocation(island);
        int[] expected = {3,4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPossibleMovesCenterAllDirections() {
        int[][] island = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        List<int[]> moves = ExplorerSearch.getPossibleMoves(island, 1, 1);
        assertEquals(4, moves.size());
        assertArrayEquals(new int[]{0, 1}, moves.get(0));
        assertArrayEquals(new int[]{2, 1}, moves.get(1));
        assertArrayEquals(new int[]{1, 0}, moves.get(2));
        assertArrayEquals(new int[]{1, 2}, moves.get(3));
    }

    @Test
    public void testPossibleMovesCorner() {
        int[][] island = {
            {1, 1},
            {1, 1}
        };
        List<int[]> moves = ExplorerSearch.getPossibleMoves(island, 0, 0);
        assertEquals(2, moves.size());
        assertArrayEquals(new int[]{1, 0}, moves.get(0));
        assertArrayEquals(new int[]{0, 1}, moves.get(1));
    }

    @Test
    public void testPossibleMovesWithObstacleAbove() {
        int[][] island = {
            {1, 2, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        List<int[]> moves = ExplorerSearch.getPossibleMoves(island, 1, 1);
        assertEquals(3, moves.size());
        assertArrayEquals(new int[]{2, 1}, moves.get(0));
        assertArrayEquals(new int[]{1, 0}, moves.get(1));
        assertArrayEquals(new int[]{1, 2}, moves.get(2));
    }

    @Test
    public void testPossibleMovesBlocked() {
        int[][] island = {
            {0, 2},
            {2, 1}
        };
        List<int[]> moves = ExplorerSearch.getPossibleMoves(island, 0, 0);
        assertEquals(0, moves.size());
    }

    @Test
    public void testPossibleMovesEdgeCell() {
        int[][] island = {
            {1, 0, 1},
            {1, 1, 1}
        };
        List<int[]> moves = ExplorerSearch.getPossibleMoves(island, 0, 1);
        assertEquals(3, moves.size());
        assertArrayEquals(new int[]{1, 1}, moves.get(0));
        assertArrayEquals(new int[]{0, 0}, moves.get(1));
        assertArrayEquals(new int[]{0, 2}, moves.get(2));
    }

    @Test
    public void testPossibleMovesMixedObstacles() {
        int[][] island = {
            {1, 1, 1},
            {3, 0, 2},
            {1, 1, 1}
        };
        List<int[]> moves = ExplorerSearch.getPossibleMoves(island, 1, 1);
        assertEquals(2, moves.size());
        assertArrayEquals(new int[]{0, 1}, moves.get(0));
        assertArrayEquals(new int[]{2, 1}, moves.get(1));
    }

}
