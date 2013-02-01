package javabean;

import java.util.EventObject;
import java.util.Vector;

public abstract class Model {
	private Vector listeners = new Vector(); // 定义了一个储存事件监听者的数组

	/*上面设计格式中的< ListenerType>在此处即是下面的ModelChangedListener*/
	public synchronized void addModelChangedListener(ModelChangedListener mcl) {
		listeners.addElement(mcl);
	}//把监听者注册入listeners数组中 

	public synchronized void removeModelChangedListener(ModelChangedListener mcl) {
		listeners.removeElement(mcl); //把监听者从listeners中注销
	}

	/*以上两个方法的前面均以synchronized，是因为运行在多线程环境时，可能同时有几个对象同时要进行注册和注销操作，使用synchronized来确保它们之间的同步。开发工具或程序员使用这两个方法建立源与监听者之间的事件流*/
	protected void notifyModelChanged() {//类似于changes.firePropertyChange("myStr", oldStr, newStr);的点火
		/*事件源使用本方法通知监听者发生了modelChanged事件*/
		Vector l;
		EventObject e = new EventObject(this);
		/* 首先要把监听者拷贝到l数组中，冻结EventListeners的状态以传递事件。
		 * 这样来确保的在循环发送事件时，即使其它线程对监听者集合进行了增删，也不会
		 * 影响原来需要触发的监听者集合。这里的同步块只是在拷贝时同步，在调用时没同步，
		 * 因为调用监听者方法或能是个长方法，所以先拷贝*/
		synchronized (this) {
			l = (Vector) listeners.clone();
		}
		for (int i = 0; i < l.size(); i++) {
			/* 依次通知注册在监听者队列中的每个监听者发生了modelChanged事件，
			并把事件状态对象e作为参数传递给监听者队列中的每个监听者*/
			((ModelChangedListener) l.elementAt(i)).modelChanged(e);
		}
	}

        public static void main(String[] args) {

            Model model = new Model() {};
            model.addModelChangedListener(new ModelChangedListener() {

            public void modelChanged(EventObject e) {
                System.out.println(e.getSource());
                System.out.println(e.toString());
            }
        } );

          model.notifyModelChanged();
    }
}