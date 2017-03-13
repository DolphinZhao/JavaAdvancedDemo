package com.qihoo.wait_notify;

public class Producer implements Runnable {

	private EventStorage storage;
	
	public Producer(EventStorage storage) {
		this.storage = storage;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.set();
		}
	}

}
