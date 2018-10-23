package com.example.demo.patterns.structural.adapter;

public class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("Playing mp4 file. Name: "+ fileName);		
	}

}
