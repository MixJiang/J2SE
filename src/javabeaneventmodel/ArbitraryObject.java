package javabeaneventmodel;

public class ArbitraryObject implements MouseMovedExampleListener {
	public void mouseMoved(MouseMovedExampleEvent mme) {
	           System.out.println(mme.getSource());
                System.out.println(mme.toString());
	}
}