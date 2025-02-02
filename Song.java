package com.jspider.musicalbum;

public class Song {

	String title;
	double duration;
	
	public Song(String title, double duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	
	public Song() {
		
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", duration=" + duration + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
}
