package trappedwater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IslandTest {

    @Test
    void test() {
        int[][] groundScheme = new int[][] { 
            { 5, 3, 4, 5 }, 
            { 6, 2, 1, 4 }, 
            { 3, 1, 1, 4 }, 
            { 8, 5, 4, 3 } 
        };
        Island island = new Island(groundScheme);
        island.overfillByWater();
        island.extraWaterPourOff();
        assertEquals(7, island.getTrappedWater());
    }
}
