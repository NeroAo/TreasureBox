package neroao.treasurebox.linescounter.test;

import neroao.treasurebox.linescounter.counterImpl.LinesCounter;

import org.junit.Test;

public class LinesCounterTest {
	
	@Test
	public void counterTest(){
		LinesCounter counter = new LinesCounter("F:\\New Git\\BPS","java,js,html,jsp,xml,properties");
		counter.countLines();
	}

}
