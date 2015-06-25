package combined.djview;

public interface HeartModelInterface {
	int getHeartRate();
	int	getCuenta();
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
	
}
