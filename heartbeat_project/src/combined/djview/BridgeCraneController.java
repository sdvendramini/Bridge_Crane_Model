package combined.djview;

public class BridgeCraneController implements ControllerInterface{
	BridgeCraneModelInterface model;				
	DJView view;
	boolean upOrDown;	

	public BridgeCraneController(BridgeCraneModelInterface model)
	{
		this.model=model;
		view = new DJView(this, new BridgeCraneAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
		view.createView2();
		upOrDown=false;
	}													//la implementacion de los metodos va a depender del modelo
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		((BridgeCraneModel) model).irDerecha();
	}
    
	public void decreaseBPM() {
		((BridgeCraneModel) model).irIzquierda();
	}
  
 	
 	public void up() {
 		((BridgeCraneModel) model).irArriba();
 	}
 	
 	public void down() {
 		((BridgeCraneModel) model).irAbajo();
 	}


 	public void setBPM(int bpm) {
 		if(bpm==1234)
 		{ 	
 			if(model.getBPM() == -10)
 			model.setBPM(-20);
 			else
 				model.setBPM(-10);
 		}
	
 	}
}
