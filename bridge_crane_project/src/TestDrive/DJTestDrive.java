package TestDrive;

import Controller.BeatController;
import Controller.ControllerInterface;
import Model.BeatModel;
import Model.BeatModelInterface;
  
public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
<<<<<<< HEAD
		ControllerInterface controller = new BeatController(model,false);
=======
		ControllerInterface controller = new BeatController(model,1);
>>>>>>> origin/Third
    }
}
