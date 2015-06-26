package combined.djview;

public class ExchangableTestDrive 
{
	int model = 1;
	
	static BeatModelInterface m1 = new BeatModel();;
	static HeartModel heartModel = HeartModel.getInstance();
	static BridgeCraneModel bridge = new BridgeCraneModel();
    
	public ExchangableTestDrive(int a)
	{
		runModel(a);
	}

	public void runModel(int a)
	{
		if(a==1)
		{
			//BeatModelInterface m1 = new BeatModel();
			ControllerInterface controller = new BeatController(m1);
			heartModel.clear();
			m1.clear();
		}
		else if(a==2)
		{
			//HeartModel heartModel = HeartModel.getInstance();
	        ControllerInterface model2 = new HeartController(heartModel);
	        m1.clear();
	        bridge.clear();
	        
		}
		else if(a==3)
		{
			//BridgeCraneModel bridgeCraneModel = new BridgeCraneModel();
	        ControllerInterface model3 = new BridgeCraneController(bridge);
	        m1.clear();
	        heartModel.clear();
		}
	}
}
