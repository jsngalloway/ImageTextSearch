
public class MemeResult implements Comparable<MemeResult> {

	private double percent;
	private Meme meme;
	
	public MemeResult(Meme meme, double percent) {
		this.percent = percent;
		this.meme = meme;
	}
	
	public int getPercentInt() {
		return (int) this.percent;
	}
	
	public String toString() {
		return meme.toString();
	}
	
	@Override
	public int compareTo(MemeResult other) {
	    return Integer.compare(this.getPercentInt(), other.getPercentInt());
	}

}
