package UnitTest;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.Test;

import Controller.BridgeCraneController;
import Model.BeatModelInterface;
import Model.BridgeCraneAdapter;
import Model.BridgeCraneModel;
import View.DJView;

public class EmptySetTest {

	@Test
	public void test() 
	{
		boolean flag = false;
		BridgeCraneModel model = new BridgeCraneModel();
		BridgeCraneController controller = new BridgeCraneController(model,false);
		
		//falta implementar. Habria de haber tenido que haber fallado.
		
		assertEquals(flag,true);
	}

}
