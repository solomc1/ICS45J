// Solomon Chan 40786337, Matthew Downing 32969058

import java.util.ArrayList;

public class CompactMusicItem extends MusicItem{

	private int numOfTracks;
	private String year;
	
	public CompactMusicItem(ArrayList<String> item){
		// Construct a music item from item
		// position 0: accession number
		// position 1: title
		// position 2: media code
		// position 3: number of tracks
		// position 4: year of release
		super(item);
		numOfTracks = Integer.parseInt(item.get(MEDIA_CODE_POSITION + 1));
		year = item.get(MEDIA_CODE_POSITION + 2);
	}
	
	@Override
	public String displaySupplementalInfo(){
		// Provide's compact's supplemental
		// information in a form suitable for printing
		return "# of tracks: " + String.valueOf(numOfTracks) + " | Year released: " + year;
	}
}
