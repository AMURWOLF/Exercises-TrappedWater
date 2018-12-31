package trappedwater;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LithosphereSectionTest {
	
	static LithosphereSection testLitSection;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testLitSection = new LithosphereSection(5);
	}
	
	@Test
	void test01() {
		testLitSection.setWaterHeight(10);
		assertEquals(5, testLitSection.getTrappedWater());
	}
	
	
	@Test
	void test02() {
		testLitSection.setWaterHeight(10);
		LithosphereSection litSection2 = new LithosphereSection(7);
		LithosphereSection litSection3 = new LithosphereSection(8);
		LithosphereSection litSection4 = new LithosphereSection(6);
		litSection4.setWaterHeight(7);
		
		testLitSection.extraWaterPourOff(litSection2, litSection3, litSection4);
		assertEquals(2, testLitSection.getTrappedWater());
	}

	
	@Test
	void test03() {
		testLitSection.setWaterHeight(10);
		LithosphereSection litSection2 = null;
		
		testLitSection.extraWaterPourOff(litSection2);
		assertEquals(0, testLitSection.getTrappedWater());
	}
}
