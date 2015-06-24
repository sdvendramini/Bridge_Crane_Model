package combined.djview;

import java.util.ArrayList;
import java.util.Random;

public class BridgeCraneModel implements BridgeCraneModelInterface, Runnable {
	
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	ArrayList matrizObservers= new ArrayList();
	int bpm = -10;
	int [][] matriz;
	int filas=8;
	int columnas=8;
	int a;
	int b;
	int contador = 10;
	Thread thread;

	public BridgeCraneModel () {
		matriz = new int [filas][columnas];
		inicializarMatriz();
		thread =new Thread (this);
		thread.start();
	}

	public void run()
	{

		for(;;)
		{
			try
			{
				notifyBPMObservers();
				notifyMatrizObserver();
				
			}
			catch(NullPointerException e){};

			try
			{
				Thread.sleep(50);
				contador--;
			}
			catch(Exception e){};
			
			if(contador == 0)
			{
				if(bpm == -20)
				 {
						notifyBeatObservers();
				 }
				contador = 10;
			}
		}
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
	
	public void inicializarMatriz(){
		Random random=new Random();
		a=random.nextInt(8);
		b=random.nextInt(8);
		
		for (int i=0; i<filas; i++)
			for (int j=0; j<columnas; j++)
			{
				if (i==a && j==b)
				matriz[i][j]=1;
				else 
					matriz[i][j]=0;				
			}
	} 
	
	public void cambiarMatriz()
	{
		for (int i=0; i<filas; i++)
			for (int j=0; j<columnas; j++)
			{
				matriz[i][j]=0;			
			}
		matriz[a][b] = 1;
		System.out.println(a + "  " + b );
	}
	
	public void irDerecha()
	{
		if(b!=7)
			b++;
		cambiarMatriz();
	}
	
	public void irIzquierda()
	{
		if(b!=0)
			b--;
		cambiarMatriz();
	}
	
	public void irArriba()
	{
		if(a!=0)
			a--;
		cambiarMatriz();
	}
	
	public void irAbajo()
	{
		if(a!=7)
			a++;
		cambiarMatriz();
	}

	public void setBPM(int i) 
	{
		bpm = i;
	}

	public int getBPM() {
		return bpm;
	}

}
