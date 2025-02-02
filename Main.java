package com.jspider.musicalbum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {
			
		Album album = new Album("Album1",  "AC/DC");
		
		album.addSong("TNT", 4.5);
		album.addSong("Highway to hell", 3.5);
		album.addSong("ThunderStuck", 5.0);
		albums.add(album);
		
		album = new Album("Album2" , "Hardy Snadu");
		
		album.addSong("Backbone", 4.5);
		album.addSong("Horn Blow", 5.0);
		album.addSong("Naah Goriye", 3.8);
		
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<>();
		
		albums.get(0).addPlayList("TNT", playList_1);
		albums.get(0).addPlayList("Highway to hell", playList_1);
		albums.get(0).addPlayList("Rap god", playList_1);
		albums.get(0).addPlayList("Love yourself", playList_1);
		
		play(playList_1);
		
	}
	
	@SuppressWarnings("resource")
	private static void play(LinkedList<Song> playList) {
		Scanner s = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("This playlist is no song....");
		}
		else {
			System.out.println("Current song playing is " + listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = s.nextInt();
			s.nextLine();
			
			switch(action) {
			   
			case 0 :
				System.out.println("Playlist complete");
				quit = true;
				break;
				
			case 1 :
				 if(!forward) {
					 if(listIterator.hasNext()) {
						 listIterator.next();
					 }
					 forward = true;
				    }
				      if(listIterator.hasNext()) {
					      System.out.println("Now playing " + listIterator.next().toString());
				       }
				      else {
					       System.out.println("no next song , reached to the end of list");
					       forward = false;
				       }
				         break;
			
			case 2 :
				if(!forward) {
				if(listIterator.hasPrevious()) {
					listIterator.previous();
			      }
			       	forward = false;
			      }
			        if(listIterator.hasPrevious()) {
				         System.out.println("now playing " + listIterator.previous().toString());
			         }
			         else {
				           System.out.println("We are at the first song");
	             		   forward = false;
		                }
		                   break;
		                  
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing" + listIterator.previous().toString());
						forward = false;
					}
					else {
						System.out.println("Now we are the start at list");
					}
				 }
				 else {
					if(listIterator.hasNext()) {
						System.out.println("now playing" + listIterator.next().toString());
						forward = true;
					}
					else {
						System.out.println("We reached to end of list");
					}
				 }
				  break;
				
			case 4 :
				printList(playList);
				break;
				
			case 5 :
				printMenu();
				break;
				
			case 6 :
				if(playList.size() > 0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing" + listIterator.next().toString());
					}
					else {
						if(listIterator.hasPrevious())
						System.out.println("now playing" + listIterator.previous().toString());
					}
				}
							
			}
	     }
	 }
	
	private static void printMenu() {
		System.out.println("Available options \n press");
		System.out.println( "0 - to quit \n" +
		                    "1 - to play next song \n" +
				            "2 - to play previous song \n" +
		                    "3 - to replay current song \n" +
				            "4 - list of all songs \n" +
		                    "5 - print all avilable option \n" +
				            "6 - Delete all songs from album");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("----------------------------");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("---------------------");
	}
}
