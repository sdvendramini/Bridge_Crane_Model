package Controller;

import Model.HeartAdapter;
import Model.HeartModel;
import Model.HeartModelInterface;
import View.DJView;
import View.ExchangeDJView;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
	ExchangeDJView exchangeView;
  
	public HeartController(HeartModelInterface model, boolean tipo) {
		this.model = model;
		
		if(tipo == false)
		{
			view = new DJView(this, new HeartAdapter(model));
			view.createView();
			view.createControls();
			view.disableStopMenuItem();
			view.disableStartMenuItem();	
		}
		else
		{
			exchangeView = new ExchangeDJView(this, new HeartAdapter(model));
			exchangeView.createView();
			exchangeView.createControls();
			exchangeView.disableStopMenuItem();
			exchangeView.disableStartMenuItem();
		}
		
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



