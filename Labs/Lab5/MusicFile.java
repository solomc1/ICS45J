// Solomon Chan 40786337, Matthew Downing 32969058
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MusicFile implements MusicFileInterface
{
	Scanner musicFile = null;
	
	public MusicFile(){ }
	
	public void open(String indexFileName) throws IOException{
		// Opens a sequential text file to accept 
		// music info and parse it
		// Throws IOException if music file cannot
		// be opened or other IOproblems occur
		
		//reads from console where it needs to read from
		Scanner console = new Scanner(System.in);
		
		String source;
		while(true){
			System.out.println("Is the music file on the disk or on the web?\n"
				+ "(Type DISK or WEB)"); // asks for disk or web file
			
			source = console.nextLine(); // gets user input
			
			if (source.equalsIgnoreCase("disk") || source.equalsIgnoreCase("web")){
				// if input correct, close console and continue with code
				console.close();
				break;  
			}else{
				// otherwise, ask for input again
				System.out.println("Invalid input, try again please.");  
			}
		}
		
		// Opens file or throws IOException
		if (source.equalsIgnoreCase("disk")){
			musicFile = new Scanner(new File(indexFileName));
		}
		else if (source.equalsIgnoreCase("web")){
			URL webLocation = new URL("http://www.ics.uci.edu/~rkwang/" + indexFileName);
			URLConnection webConnection = webLocation.openConnection();
			musicFile = new Scanner(webConnection.getInputStream());
		}
	}

	public boolean hasMoreItems(){
		// Are there more items in the file?
		// true = yes (not at end of file); false otherwise
		return musicFile.hasNextLine();
	}

	public ArrayList<String> readItem()
	{
		// Read and return one music item, as ArrayList<String>
		// Number of attributes will vary depending on type of item
		//	read -- but first three are always the same:
		//	accession number, title, media code
		// Hint: Read in a line, then use string tokenizer to break it
		//	into fields, with ";" (and end of string) as the delimiter 
		try{
			musicFile.useDelimiter("\r\n");
			String nextLine = musicFile.next();
			//if (nextLine.trim() != ""){
			//System.out.println(nextLine);
			String[] tempArray = nextLine.split("; "); //turns line into Array
			
			ArrayList<String> result = new ArrayList<String>();  // creates ArrayList that will be returned
			for (String temp: tempArray ){
				// adds all Array items to result ArrayList
				result.add(temp);
			}	
			return result;
			//}
		}
		catch(Exception e){
			return new ArrayList<String>(Arrays.asList("","",""));
		}
		//System.out.println("WE FUCKED UP");
		//return new ArrayList<String>(Arrays.asList("","",""));
	}

	public void close()
	{
		if (musicFile != null) {
			musicFile.close();
		}
	}

}
