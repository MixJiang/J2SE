package javabean;

import java.util.EventObject;

public interface ModelChangedListener extends java.util.EventListener {
	void modelChanged(EventObject e);
}