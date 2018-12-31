package trappedwater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BeachTest {

	static Beach beach;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		int[] groundScheme = new int[] { 1, 2, 3, 2, 3, 4, 5, 1, 4, 6, 7, 6, 7, 2, 3, 1 };
		beach = new Beach(groundScheme);
	}

	
	private int run(int waveHeight) {
		beach.dry();
		beach.takeWaveFromLeft(waveHeight);
		beach.extraWaterPourOff();
		return beach.getTrappedWater();
	}
	
	@Test
	void test() {
		assertEquals(0, run(1));
		assertEquals(0, run(2));
		assertEquals(0, run(3));
		assertEquals(1, run(4));
		assertEquals(1, run(5));
		assertEquals(6, run(6));
		assertEquals(6, run(7));
		assertEquals(8, run(8));
		assertEquals(8, run(9));
	}
}
