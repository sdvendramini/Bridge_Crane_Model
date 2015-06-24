package combined.djview;

public interface BridgeCraneModelInterface {
	
	//faltan metodos q dependen del modelo
	
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
	void registerObserver(MatrizObserver o);
	void removeObserver(MatrizObserver o);
	
	int [][] getMatriz();

	
	//no van creo
	void increaseBar();
	void decreaseBar();
	
}
