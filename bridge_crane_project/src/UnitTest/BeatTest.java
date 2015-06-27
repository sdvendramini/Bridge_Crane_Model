package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.BeatController;
import Model.BeatModel;
import Model.BeatModelInterface;

public class BeatTest {

	@Test
	public void negativeSetTest() 
	{
		BeatModelInterface model = new BeatModel();
		BeatController controller = new BeatController(model,false);		
		int inicial = model.getBPM();
		controller.setBPM(-15);
		int fin = model.getBPM();		
		assertEquals(inicial,fin);	
	}
	
	@Test
	public void negativeDecreaseTest() 
	{
		BeatModelInterface model = new BeatModel();
		BeatController controller = new BeatController(model,false);		
		controller.setBPM(0);
		controller.decreaseBPM();	
		assertEquals(0,model.getBPM());	
	}

}
