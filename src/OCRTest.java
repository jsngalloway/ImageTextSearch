import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OCRTest {

	public static void main(String[] args) throws IOException {
//		System.out.println("this is a great program");
		if (args.length != 2) {
			PathArgumentError();
			return;
		}
		String pyName = args[0];
		String pyPath = args[1];
		
		ProcessBuilder pb = new ProcessBuilder(pyName, pyPath);
		Process p = pb.start();
		
		//reads out the Python output
		BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));

		String line = "";     
		while ((line = bfr.readLine()) != null){
		    System.out.println("Python Output: " + line);
		}
	}
	
	private static void PathArgumentError() {
		System.out.println("******* ERROR: INCORRECT ARGUMENT INPUT *******");
		System.out.println("[Intended Argument Input Format]:");
		System.out.println("1. The string 'python'");
		System.out.println("2. Complete path of python file");
	}
}
