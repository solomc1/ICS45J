// Solomon Chan 40786337, Matthew Downing 32969058

import java.util.ArrayList;

public class MusicList implements MusicListInterface{
	
	// ArrayList Variable
	private ArrayList<Bucket> buckets;
	// Counter Variables
	private int totalItemCount;
	private int paperItemCount;
	private int compactMediaItemCount;
	private int vinylItemCount;
	private int waxCylinderItemCount;
	
	public MusicList(){
		// Make a bucket for each of the 26 list locations;
		// Set counts of items to zero
		
		buckets = new ArrayList<Bucket>();
		
		for (int i = 0; i < 26; i++){
			buckets.add(new Bucket());
		}
		
		totalItemCount = 0;
		paperItemCount = 0;
		compactMediaItemCount = 0;
		vinylItemCount = 0;
		waxCylinderItemCount = 0;
	}
	
	public void addItem(MusicItem item){
		// Add an item into the correct bucket in the list
		// Bucket to use is one corresponding to first letter in title
		// Increment the appropriate media count
		
		String firstLetter = String.valueOf(item.getTitle().charAt(0));
		int bucketIndex = firstLetter.compareTo("A");
		
		buckets.get(bucketIndex).addItem(item); // THIS MIGHT CAUSE PROBLEMS
		
		totalItemCount ++;
		
		if (item.getMedia().equals(MusicItemInterface.PAPER))
			paperItemCount ++;
		else if (item.getMedia().equals(MusicItemInterface.COMPACT))
			compactMediaItemCount ++;
		else if (item.getMedia().equals(MusicItemInterface.VINYL))
			vinylItemCount ++;
		else if (item.getMedia().equals(MusicItemInterface.WAX_CYLINDER))
			waxCylinderItemCount ++;
	}

	public ArrayList<Bucket> getBuckets(){
		// returns the ArrayList of buckets
		return buckets;
	}

	public int getTotalItemCount(){
		// returns the total item count
		return totalItemCount;
	}

	public int getPaperItemCount(){
		// returns the paper count
		return paperItemCount;
	}

	public int getCompactMediaItemCount(){
		// returns the compact media count
		return compactMediaItemCount;
	}

	public int getVinylItemCount(){
		// returns the vinyl count
		return vinylItemCount;
	}

	public int getWaxCylinderItemCount(){
		// returns the wax cylinder count
		return waxCylinderItemCount;
	}

}
