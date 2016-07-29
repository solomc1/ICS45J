// Solomon Chan 40786337, Matthew Downing 32969058

import java.io.IOException;
import java.util.ArrayList;

public class MusicManager implements MusicManagerInterface
{
	MusicList musicList;
	final String IN_FILE_NAME = "music.txt";
	final String OUT_FILE_NAME = "index.txt";
	
	public MusicManager(){
		// Constructs the music list
		musicList = new MusicList();

		//open file
		MusicFile musicFile = new MusicFile();
		try{
			// Ask for file to fill up (currently) empty musicList
			musicFile.open(IN_FILE_NAME);
			//read each line in while loop to create MusicItem
			// and add to musicList 
			while (musicFile.hasMoreItems()){
				ArrayList<String> musicItemArray = musicFile.readItem();
				if (musicItemArray.get(2).equals(MusicItemInterface.PAPER)){
					musicList.addItem(new PaperMusicItem(musicItemArray));
				}
				else if (musicItemArray.get(2).equals(MusicItemInterface.COMPACT)){
					musicList.addItem(new CompactMusicItem(musicItemArray));
				}
				else if (musicItemArray.get(2).equals(MusicItemInterface.VINYL)){
					musicList.addItem(new VinylMusicItem(musicItemArray));
				}
				else if (musicItemArray.get(2).equals(MusicItemInterface.WAX_CYLINDER)){
					musicList.addItem(new WaxCylinderMusicItem(musicItemArray));
				}
			}
		}
		catch(IOException e){
			//exit program
			System.out.println("Error reading from file - exiting program.\n" + e);
		}
		finally{
			//close file
			musicFile.close();
		}
		
	}

	public void makeIndexAndDisplayCounts(){
		// Prepares an index file from an incoming list of music items;
		// displays to the screen the media category counts
		// and a total count of items processed.
		//
		// writing file requires PrintWriter-- week 7
		IndexFile indexFile = new IndexFile();
		try{
			indexFile.open(OUT_FILE_NAME);
			for (Bucket bucket : musicList.getBuckets()){
				for (MusicItem musicItem : bucket.getItems()){
					indexFile.writeItem(musicItem);
				}
			}
		}
		catch(IOException e){
			System.out.println("Error writing to file - exiting program.\n" + e);
		}
		finally{
			//close file
			indexFile.close();
		}
		
		// Tell user the out file's name
		System.out.println("The output file is called \"" + OUT_FILE_NAME + "\"");
		//Prints out the media counts
		System.out.println("Paper Item Count: " + musicList.getPaperItemCount());
		System.out.println("Compact Item Count: " + musicList.getCompactMediaItemCount());
		System.out.println("Vinyl Item Count: " + musicList.getVinylItemCount());
		System.out.println("Wax Cylinder Item Count: " + musicList.getWaxCylinderItemCount());
		// Prints out the total item count
		System.out.println("Total Item Count: " + musicList.getTotalItemCount());
	}
}
