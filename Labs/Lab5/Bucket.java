// Solomon Chan 40786337, Matthew Downing 32969058

import java.util.LinkedList;

public class Bucket implements BucketInterface
{
	private LinkedList<MusicItem> musicItems;
	
	public Bucket(){
		musicItems = new LinkedList<MusicItem>();
	}
	
	public void addItem(MusicItem itemToAdd)
	{
		// Add the music item into the this bucket, 
		// in alphabetical order by title
		
		int size = musicItems.size();
		
		for (int i = 0; i < size; i++){
			int compareVar = itemToAdd.getTitle().compareTo(musicItems.get(i).getTitle());
			if (compareVar < 0){
				musicItems.add(i,itemToAdd);
				break;
			}
			else if (i == size - 1){
				musicItems.add(itemToAdd);
			}
		}
		
		if (size == 0){
			musicItems.add(itemToAdd);
		}
	}

	public LinkedList<MusicItem> getItems()
	{
		// returns music items
		return musicItems;
	}

}
