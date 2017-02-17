package com.gdut.ds.utils;

import java.util.Timer;

public class TimerTest {

	public static void main(String[] args) {
	
		Timer timer = new Timer();
		timer.schedule(new TimeTask(), TimeTools.praseDate("2016-3-9 21:20:00"));
		
		timer.schedule(new TimeTask(), TimeTools.praseDate("2016-3-10 21:33:00"));
		
		timer.cancel();			//关闭定时器
		
	}
}
