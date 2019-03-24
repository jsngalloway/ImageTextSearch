import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class SearchMemes {
    public static void main(String[] args) throws FileNotFoundException, IOException{
    	//ArrayList<String> arr = new ArrayList<String>();
        String arr[][] = new String[4000][2]; 
        ArrayList<Meme> memes = new ArrayList<Meme>();
        int i = 0;
        File file;
        while (i < 3225) {
	        file = new File("C:\\Users\\jsnga\\workspace\\ImageTextSearch\\database\\database\\"+ i + ".txt");
        	//System.out.println(file.toString());
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		            String URL = br.readLine();
		            //System.out.println(line);
		            arr[i][0] = URL;
		            String content = br.readLine();
		            arr[i][1] = content;
		            if (!(content.equalsIgnoreCase(""))) {
		            	Meme current = new Meme(URL, content);
	        			memes.add(current);
		            }
		            //System.out.println(line);
	        } catch (Exception e) {
	        	System.out.println("maybe there is an error with this file");
	        }
	        i++;
        }
        i = 0;
        System.out.println("Loaded (" + memes.size() + ") memes into database.\n");
//        while(i < memes.size()) {
//        	System.out.println(memes.get(i));
//        	i++;
//        }
        
        boolean loop = true;
    	PriorityQueue<MemeResult> results = new PriorityQueue<MemeResult>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(loop) {
        	results.clear();
        	System.out.println("Enter a word or phrase to search:");
        	String query = reader.readLine();
        	for(int j=0; j<memes.size(); j++) {
        		if (memes.get(j).getContent().toLowerCase().contains(query.toLowerCase())){
        			double percent = (double)memes.get(j).getContent().length()/(double)query.length();
        			results.add( new MemeResult(memes.get(j), percent) );
        		}
        	}
        	if(!results.isEmpty()) {
	        	System.out.println("Returned (" + results.size() + ") results.");
	        	if(results.size() > 5) {
	        		System.out.println("Top resuts:");
	        	}
	        	try {
	        		  Desktop desktop = java.awt.Desktop.getDesktop();
	        		  URI oURL = new URI(results.peek().getURL());
	        		  desktop.browse(oURL);
	        		} catch (Exception e) {
	        		  e.printStackTrace();
	        		}
	            for(int k = 0; (k <= 5 && !results.isEmpty()); k++) {
	                System.out.println(results.remove().toString());
	            }
        	}
            System.out.println("");
        }
    }
}
