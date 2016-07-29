// Solomon Chan 40786337, Matthew Downing 32969058

import java.util.ArrayList;

public class PaperMusicItem extends MusicItem{

	private int numOfPages;
	
	public PaperMusicItem(ArrayList<String> item){
		// Construct a music item from item
		// position 0: accession number
		// position 1: title
		// position 2: media code
		// position 3: number of pages
		super(item);
		numOfPages = Integer.parseInt(item.get(MEDIA_CODE_POSITION + 1)); 
	}
	
	@Override
	public String displaySupplementalInfo(){
		// Provide's paper's supplemental
		// information in a form suitable for printing
		return "# of pages: " + String.valueOf(numOfPages);
	}
}