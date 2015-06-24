package combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
		view.createView2();					//este aca no va
	}
  
	public void start() {
	}
 
	public void stop() {}
    
	public void increaseBPM() 
	{
		HeartModel.getInstance();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}

	public void up() {}

	public void down() {}

}



