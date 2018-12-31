package trappedwater;

public class Island {

    private final LithosphereSection[][] litSections;
	private final int n; // rows
	private final int m; // columns
	private int highestGround;
	
	
	public Island(int[][] _groundScheme) {
		this.n = _groundScheme.length;
		this.m = _groundScheme[0].length;
		
		litSections = new LithosphereSection[this.n][this.m];
		highestGround = _groundScheme[0][0];
		for (int i = 0; i < this.n; i++) {
        	for (int j = 0; j < this.m; j++) {
        		this.litSections[i][j] = new LithosphereSection(_groundScheme[i][j]);
        		this.highestGround = Integer.max(this.highestGround, _groundScheme[i][j]);
        	}
		}
	}
		
	
	public void overfillByWater() {
		for (int i = 0; i < this.n; i++) {
        	for (int j = 0; j < this.m; j++) {
        		this.litSections[i][j].setWaterHeight(this.highestGround);
        	}
		}
	}
	
	
	public void extraWaterPourOff() {
		pourOffBoarders();
		boolean countOfPuddlesChanges = true;
		while (countOfPuddlesChanges) {
			int countOfPuddlesBefore = getTrappedWater();
			pourOffToNorthLeft();
			pourOffToSouthRight();
			countOfPuddlesChanges = getTrappedWater() != countOfPuddlesBefore;
		}
	}
	
	private void pourOffBoarders() {
		for (int i = 0; i < this.n; i++) {
        	for (int j = 0; j < this.m; j++) {
        		boolean isBorder = (i == 0) || (i == n - 1) || (j == 0) || (j == m - 1);
        		if (isBorder) {
        			this.litSections[i][j].extraWaterPourOff((LithosphereSection) null);
        		}
        	}
		}
	}
	
	
	private void pourOffToNorthLeft() {
		for (int i = 1; i < this.n - 1; i++) {
    		for (int j = 1; j < this.m - 1; j++) {
    			this.litSections[i][j].extraWaterPourOff(
    					this.litSections[i][j - 1], 
    					this.litSections[i - 1][j]
    			);
    		}
    	}
	}
	
	
	private void pourOffToSouthRight() {
    	for (int i = this.n - 2; i > 0; i--) {
    		for (int j = this.m - 2; j > 0; j--) {
    			this.litSections[i][j].extraWaterPourOff(
    					this.litSections[i][j + 1], 
    					this.litSections[i + 1][j]
    			);
    		}
    	}
	}
	
	
    public int getTrappedWater() {
        int sumWater = 0;
    	for (int i = 0; i < this.n; i++) {
    		for (int j = 0; j < this.m; j++) {
    			sumWater += this.litSections[i][j].getTrappedWater();
    		}
    	}
        return sumWater;
    }
}
