package com.prodyna.esd.filemanager.event;

import com.prodyna.esd.filemanager.observer.FileSystemListener;
import com.prodyna.esd.filemanager.observer.Observable;
import com.prodyna.esd.filemanager.observer.ObserverHelper;

public class EventMediator implements Observable {

	private final static class LazyHolder {
		private final static EventMediator INSTANCE = new EventMediator();
	}

	private EventMediator() {
	}

	public static EventMediator getInstance() {
		return LazyHolder.INSTANCE;
	}

	private ObserverHelper helper = new ObserverHelper();

	@Override
	public void addListener(FileSystemListener listener) {
		helper.addListener(listener);
	}

	@Override
	public void removeListener(FileSystemListener listener) {
		helper.removeListener(listener);
	}

	@Override
	public void notifyListeners(FileSystemEvent event) {
		helper.notifyListeners(event);
	}

}
