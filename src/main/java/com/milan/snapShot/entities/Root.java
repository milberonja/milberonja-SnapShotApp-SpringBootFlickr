package com.milan.snapShot.entities;

public class Root {

	private Photos photos;
	private String stat;

	public Photos getPhotos() {
		return photos;
	}

	public void setPhotos(Photos photos) {
		this.photos = photos;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "Root [photos=" + photos + ", stat=" + stat + "]";
	}

}
