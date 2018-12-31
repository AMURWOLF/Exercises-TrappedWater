package trappedwater;

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
        for (LithosphereSection neighbor : neighborSections) {
                int support = Integer.max(neighbor.waterHeight, neighbor.groundHeight);
                this.waterHeight = Integer.min(this.waterHeight, support);
        }
    }

    public int getTrappedWater() {
        int trappedWater = this.waterHeight - this.groundHeight;
        return (trappedWater > 0) ? trappedWater : 0;
    }
}
