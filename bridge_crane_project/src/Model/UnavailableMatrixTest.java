package Model;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.BridgeCraneController;

public class UnavailableMatrixTest {

	@Test
	public void test() 
	{
		BridgeCraneModel bridge = new BridgeCraneModel();
		BridgeCraneController controller = new BridgeCraneController(bridge,false);
		
		int rightPassword = 1234;
		controller.setBPM(rightPassword);
		
		while(bridge.getColumnaActual()==7)
		{
			bridge = new BridgeCraneModel();
		}

		int columnaInicial = bridge.getColumnaActual();
		bridge.irDerecha();
		int columnaFinal = bridge.getColumnaActual();
		
		assertEquals(columnaInicial,columnaFinal);	
	}
}
