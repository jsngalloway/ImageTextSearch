
public class Meme {
	private String URL;
	private String content;
	
	Meme(){
		
	}
	
	Meme(String URL, String content){
		this.URL = URL;
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	public String getURL() {
		return this.URL;
	}
	
	public String toString() {
		return URL + "\t" + content;
	}

}
