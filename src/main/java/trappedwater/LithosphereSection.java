package trappedwater;

import java.util.Arrays;

public class LithosphereSection {

    /* Height is above mean sea level in each case */
    public final int groundHeight;
    private int waterHeight;

    public LithosphereSection(int _groundHeight) {
        this.groundHeight = _groundHeight;
        this.waterHeight = 0;
    }

    public void setWaterHeight(int _waterHeight) {
        this.waterHeight = _waterHeight;
    }

    public void extraWaterPourOff(LithosphereSection... neighborSections) {
        if (hasPrecipiceForWater(neighborSections)) {
            this.waterHeight = 0;
        } else {        
            for (LithosphereSection neighbor : neighborSections) {
                int support = Integer.max(neighbor.waterHeight, neighbor.groundHeight);
                this.waterHeight = Integer.min(this.waterHeight, support);
            }
        }
    }
    
    private boolean hasPrecipiceForWater(LithosphereSection... neighborSections) {
        return neighborSections == null 
                || neighborSections.length == 0 
                || Arrays.asList(neighborSections).contains(null);
    }

    public int getTrappedWater() {
        int trappedWater = this.waterHeight - this.groundHeight;
        return (trappedWater > 0) ? trappedWater : 0;
    }
}
