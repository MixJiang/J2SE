package javabeaneventmodel;

/* 定义了鼠标移动事件的监听者接口 */
interface MouseMovedExampleListener extends java.util.EventListener {
	/* 在这个接口中定义了鼠标移动事件监听者所应支持的方法*/
	void mouseMoved(MouseMovedExampleEvent mme);
}