package SearchEngine;

public class TextParser {
	
	//parse through the text file and take the strings to input as documents in the engine
	public static String[] ContentParser(String directoryToFiles) {

		String arr[][] = new String[4000][2]; 
        int i = 0;
        File file;
        while (i < 3225) {
	        file = new File("C:\\Users\\jsnga\\workspace\\ImageTextSearch\\database\\database\\"+ i + ".txt");
        	System.out.println(file.toString());
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		            String line = br.readLine();
		            //System.out.println(line);
		            arr[i][0] = line;
		            line = br.readLine();
		            arr[i][1] = line;
		            //System.out.println(line);
	        } catch (Exception e) {
	        	System.out.println("maybe there is an error with this file");
	        }
	        i++;
        }
        //i = 0;
        // while(i < 3225) {
        // 	System.out.println(arr[i][0] + "\t" + arr[i][1]);
        // 	i ++;
        // }

		return arr;	
	}
}
