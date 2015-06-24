package combined.djview;

import java.util.ArrayList;
import java.util.Random;

public class BridgeCraneModel implements BridgeCraneModelInterface, Runnable {
	
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	ArrayList matrizObservers= new ArrayList();
	int [][] matriz;
	int filas=8;
	int columnas=8;
	Thread thread;

	public BridgeCraneModel () {
		matriz = new int [filas][columnas];
		inicializarMatriz();
		thread =new Thread (this);
		thread.start();
	}

	public void run(){
		//
	}
	
	public int[][] getMatriz(){
		return matriz;
	}
	
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}
	
	
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}
	
	public void registerObserver(MatrizObserver o){
		matrizObservers.add(o);
	}
	
	public void removeObserver(MatrizObserver o){
		int i = matrizObservers.indexOf(o);
		if (i >= 0) {
			matrizObservers.remove(i);
		}
	}

	public void notifyMatrizObserver(){
		for(int i = 0; i < matrizObservers.size(); i++) {
			MatrizObserver observer = (MatrizObserver)matrizObservers.get(i);
			observer.updateMatriz(filas,columnas);
		}
	}
	
	public void increaseBar(){
		
	}

	public void decreaseBar(){

	}
	
	public void inicializarMatriz(){
		Random random=new Random();
		int a=random.nextInt(8);
		int b=random.nextInt(8);
		
		for (int i=0; i<filas; i++)
			for (int j=0; j<columnas; j++)
			{
				if (i==a && j==b)
				matriz[i][j]=1;
				else 
					matriz[i][j]=0;				
			}
	} 
	
}
