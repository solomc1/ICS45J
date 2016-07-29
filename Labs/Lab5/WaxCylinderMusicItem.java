// Solomon Chan 40786337, Matthew Downing 32969058

import java.util.ArrayList;

public class WaxCylinderMusicItem extends MusicItem{

	private String maker;
	
	public WaxCylinderMusicItem(ArrayList<String> item){
		// Construct a music item from item
		// position 0: accession number
		// position 1: title
		// position 2: media code
		// position 3: maker
		super(item);
		maker = item.get(MEDIA_CODE_POSITION + 1);
	}
	
	@Override
	public String displaySupplementalInfo(){
		// Provide's wax cylinder's supplemental
		// information in a form suitable for printing
		return "Maker: " + maker;
	}
}