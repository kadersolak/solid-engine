package berlinclock;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class test {

	private Main _testMain;
	
	@BeforeEach
	public void setUp() {
		_testMain = new Main();
	}
	
	
	@DisplayName("Wrong Input")
	@Test
	void WrongInputNotTimeAtAll() {
		assertEquals(_testMain.berlinClock(""), "");
		assertEquals(_testMain.berlinClock("aaasasa"), "");
		assertEquals(_testMain.berlinClock("12:66:01"), "");
	}
	
	@DisplayName("Send Normal Time")
	@Test
	void NormalTimeTest() {
		
		assertEquals(_testMain.berlinClock("12:56:01"), "O\\nRROO\\nRROO\\nYYRYYRYYRYY\\nYOOO");
		
		assertEquals(_testMain.berlinClock("17:56:01"), "O\\nRRRO\\nRROO\\nYYRYYRYYRYY\\nYOOO");
		
		assertEquals(_testMain.berlinClock("00:00:00"), "Y\\nOOOO\\nOOOO\\nOOOOOOOOOOO\\nOOOO");
		
		assertEquals(_testMain.berlinClock("22:32:45"), "O\\nRRRR\\nRROO\\nYYRYYROOOOO\\nYYOO");

	}

}
