// Solomon Chan 40786337, Matthew Downing 32969058

import java.util.ArrayList;

public class VinylMusicItem extends MusicItem{

	private String label;
	private int speed;
	
	public VinylMusicItem(ArrayList<String> item){
		// Construct a music item from item
		// position 0: accession number
		// position 1: title
		// position 2: media code
		// position 3: record label's imprint (string)
		// position 4: speed of play - 33, 45, 78 (integer)
		super(item);
		label = item.get(MEDIA_CODE_POSITION + 1);
		speed = Integer.parseInt(item.get(MEDIA_CODE_POSITION + 2));
	}
	
	@Override
	public String displaySupplementalInfo(){
		// Provide's vinyl's supplemental
		// information in a form suitable for printing
		return "Label: " + label + " | RPM: " + String.valueOf(speed);
	}
}