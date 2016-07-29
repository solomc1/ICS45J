// Solomon Chan 40786337, Matthew Downing 32969058
import java.util.ArrayList;


public abstract class MusicItem implements MusicItemInterface
{
	private String accessionNumber;
	private String title;
	private String media;

	public MusicItem(ArrayList<String> item){
		// Construct a music item from item
		// position 0: accession number
		// position 1: title
		// position 2: media code
		accessionNumber = item.get(ACCESSION_NUMBER_POSITION);
		title = item.get(TITLE_POSITION);
		media = item.get(MEDIA_CODE_POSITION);
	}
	
	public String displaySupplementalInfo(){
		// is overridden in lower classes 
		return null;
	}

	public String getAccessionNumber(){
		// returns the accession number
		return accessionNumber;
	}

	public String getTitle(){
		// returns the title
		return title;
	}

	public String getMedia(){
		// returns the media type
		return media;
	}
}
