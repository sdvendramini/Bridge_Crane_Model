package combined.djview;

public class ExchangableTestDrive {

	public static void main (String[] args) 
	{
		BridgeCraneModel bridgeCraneModel = new BridgeCraneModel();
        ControllerInterface model = new BridgeCraneController(bridgeCraneModel,true);
	}

}
