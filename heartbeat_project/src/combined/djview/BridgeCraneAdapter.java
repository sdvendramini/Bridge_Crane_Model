package combined.djview;

public class BridgeCraneAdapter implements BeatModelInterface {
	BridgeCraneModelInterface bridgeCrane;
	
	public BridgeCraneAdapter(BridgeCraneModelInterface bridgeCrane){
		this.bridgeCrane = bridgeCrane;
	}

	public void initialize() {}

	public void on() {}

	public void off() {}

	public void setBPM(int bpm) {}

	public int getBPM() {return 0;}

	public void registerObserver(BeatObserver o) {
		bridgeCrane.registerObserver(o);
	}

	public void removeObserver(BeatObserver o) {
		bridgeCrane.removeObserver(o);
	}

	public void registerObserver(BPMObserver o) {
		bridgeCrane.registerObserver(o);
	}

	public void removeObserver(BPMObserver o) {
		bridgeCrane.removeObserver(o);
	}
	
	
	public int[][] getMatriz(){
		return bridgeCrane.getMatriz();}

}

