package com.example.demo.event;

import java.util.LinkedHashSet;
import java.util.Set;

public class EventSource {
	
	private Set<Handler> eventListeners;

	public EventSource() {
		this.eventListeners = new LinkedHashSet<Handler>();
	}

	public void addListeners(Handler handler) {
		this.eventListeners.add(handler);
	}

	public void removeListeners(Handler handler) {
		this.eventListeners.remove(handler);
	}

	public void triggerEvent1() {
		if (eventListeners == null) {
			return;
		}

		EventState state = new EventState(this, "triggerEvent state");
		notifies(state);
	}

	protected void notifies(EventState state) {
		if (eventListeners.size() > 0) {
			for (Handler handler : eventListeners) {
				handler.doHandler(state);
			}
		}
	}
}
