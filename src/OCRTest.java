import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OCRTest {

	public static void main(String[] args) throws IOException {
//		System.out.println("this is a great program");
		
		ProcessBuilder pb = new ProcessBuilder("python","/Users/yangzhang/git/ImageTextSearch/src/testpy.py");
		Process p = pb.start();
		
		//reads out the Python output
		BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line = "";     
		while ((line = bfr.readLine()) != null){
		    System.out.println("Python Output: " + line);
		}
	}
}
