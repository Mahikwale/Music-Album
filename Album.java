package com.jspider.musicalbum;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Album() {
		//not use but have a empty constructor
	}
	
	public Song findSong1(String title) {
		for(Song checkedSong : songs) {
			if(checkedSong.getTitle().equals(title)) return checkedSong;		
		}
		return null;
	}

	//if song is already exist so return false;
	
	public boolean addSong(String title, double duration) {
		if(findSong1(title) == null) {
			songs.add(new Song(title, duration));
			//System.out.println(title + " Successfully added to list");
			return true;
		}
		else {
			//System.out.println("Song already exists....!!!");
			return false;
		}
	}
	
	//add songs in album which is already present in playlist.
	
	public boolean addToPlayList(int trackNumber , LinkedList<Song> Playlist) {
		int index = trackNumber - 1;
		if(index > 0 && index <= this.songs.size()) {
			Playlist.add(this.songs.get(index));
			return true;
		}
		//System.out.println("This album doesn't have song with track number...." + trackNumber);
		return false;
	}
	
	//same method with different parameters. because check condition based on condition they add.
	//check the condition is song is present add sing inn album otherwise send message.
	
	public boolean addPlayList(String title, LinkedList<Song> playLinkedList) {
		for(Song checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				playLinkedList.add(checkedSong);
				return true;
			}
		}
			//System.out.println("There is no such song in album....");
			return false;
	}
}
