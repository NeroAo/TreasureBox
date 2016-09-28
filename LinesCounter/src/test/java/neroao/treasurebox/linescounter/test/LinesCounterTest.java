package neroao.treasurebox.linescounter.test;

import neroao.treasurebox.linescounter.LinesCounter;

import org.junit.Test;

public class LinesCounterTest {
	
	@Test
	public void counterTest(){
		LinesCounter counter = new LinesCounter("F:\\git\\BPFF1","java,js");
		counter.countLines();
	}

}
