// Solomon Chan 40786337, Matthew Downing 32969058
import java.io.IOException;
import java.io.PrintWriter;


public class IndexFile implements IndexFileInterface
{
	PrintWriter indexFile = null;
	boolean firstPrint = true;
	
	public IndexFile(){	}

	public void open(String indexFileName) throws IOException
	{
		// Open index file with name indexFileName
		// for sequential writing
		//
		// Opens a sequential text file to accept 
		// output; prints out report headings
		//
		// Throws IOException if index file cannot
		// be opened or other IO problems occur
		indexFile = new PrintWriter(indexFileName);
	}

	public void writeItem(MusicItem itemToWrite){
		// Writes out the current line of the report,
		// contained in itemToWrite
		if (firstPrint){
			indexFile.printf("%-50s %-11s %-5s  %s%n", "TITLE", "ACCESSION #", "MEDIA", "ADDITIONAL INFORMATION");
			indexFile.println("--------------------------------");
			firstPrint = false;
		}
		String title = itemToWrite.getTitle();
		String number = itemToWrite.getAccessionNumber();
		String media = itemToWrite.getMedia();
		String additional = itemToWrite.displaySupplementalInfo();
		indexFile.printf("%-50s %-11s %-5s  %s%n", title, number, media, additional);
	}

	public void close()
	{
		// closes the index file
		if (indexFile != null){
			indexFile.close();
		}
	}

}
