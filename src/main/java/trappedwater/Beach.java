package trappedwater;

public class Beach {

    private final LithosphereSection[] litSections;
    private final int m; // alias to litSections.length

    public Beach(int[] _groundScheme) {
        this.m = _groundScheme.length;
        this.litSections = new LithosphereSection[this.m];
        for (int i = 0; i < this.m; i++) {
            this.litSections[i] = new LithosphereSection(_groundScheme[i]);
        }
    }

    public void takeWaveFromLeft(int _waveHeight) {
        boolean waveStillMoves = true;
        for (int i = 0; i < this.m; i++) {
            if (waveStillMoves) {
                if (_waveHeight > this.litSections[i].groundHeight) {
                    this.litSections[i].setWaterHeight(_waveHeight);
                } else {
                    waveStillMoves = false;
                }
            }
        }
    }

    public void extraWaterPourOff() {
        // Pour water on boarders
        this.litSections[0].extraWaterPourOff();
        this.litSections[this.m - 1].extraWaterPourOff();

        // Pour water to the left
        for (int i = 1; i < this.m - 1; i++) {
            this.litSections[i].extraWaterPourOff(this.litSections[i - 1]);
        }

        // Pour water to the right
        for (int i = this.m - 2; i > 0; i--) {
            this.litSections[i].extraWaterPourOff(this.litSections[i + 1]);
        }
    }

    public int getTrappedWater() {
        int sumWater = 0;
        for (LithosphereSection litSection : this.litSections) {
            sumWater += litSection.getTrappedWater();
        }
        return sumWater;
    }

    public void dry() {
        for (int i = 0; i < this.m; i++) {
            this.litSections[i].setWaterHeight(0);
        }
    }
}
