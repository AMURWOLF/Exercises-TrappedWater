package trappedwater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IslandTest {
    
    private int run(int[][] _groundScheme) {
        Island island = new Island(_groundScheme);
        island.overfillByWater();
        island.extraWaterPourOff();
        return island.getTrappedWater();
    }
    
    @Test
    void test01() {
        int[][] groundScheme = new int[][] { 
            { 5, 3, 4, 5 }, 
            { 6, 2, 1, 4 }, 
            { 3, 1, 1, 4 }, 
            { 8, 5, 4, 3 } 
        };
        assertEquals(7, run(groundScheme));
    }
    
    @Test
    void test02() {
        int[][] groundScheme = new int[][] { 
            { 8, 6, 8, 8 }, 
            { 8, 2, 2, 4 }, 
            { 8, 2, 2, 8 }, 
            { 8, 8, 8, 8 } 
        };
        assertEquals(8, run(groundScheme));
    }
}
