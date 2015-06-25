package combined.djview;

public class BridgeCraneTestDrive {

	public static void main (String[] args) {
		BridgeCraneModel bridgeCraneModel = new BridgeCraneModel();
        ControllerInterface model = new BridgeCraneController(bridgeCraneModel);
	}
}