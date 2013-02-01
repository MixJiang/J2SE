package  test;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 栈的数组实现，允许自动增长
 * @author lihui
 *
 */
public class Stack<T> {

        /**
         * 对象数组，用来存储值
         */
        private T[] arrays;

        /**
         * 栈的容量，默认为10
         */
        private int capacity = 10;

        /**
         * 栈的元素个数
         */
        private int size = 0;

        /**
         * 栈元素满后，是否自动增长，默认为不增长
         */
        private boolean autoGrow = false;

        /**
         * 创建一个栈，使用默认容量
         */
        public Stack() {
                //java中不允许创建泛型数组，这里用了强转，违背了泛型的初衷
                arrays = initArray(capacity);
        }

        /**
         * 创建一个容量为capacity的栈
         * @param capacity 长度
         */
        public Stack(int capacity) {
                this.capacity = capacity;
                arrays = initArray(capacity);
        }

        /**
         * 创建一个容量为capacity的栈，自动增长属性为autoGrow
         * @param capacity
         * @param autoGrow
         */
        public Stack(int capacity, boolean autoGrow) {
                this(capacity);
                this.autoGrow = autoGrow;
        }

        /**
         * 初始化数组
         * @param capacity
         * @return 泛型数组
         */
        @SuppressWarnings("unchecked")
        private T[] initArray(int capacity) {
                return (T[]) new Object[capacity];
        }

        /**
         * 设置栈capacity是否能自动增长
         * @param autoGrow
         */
        public void setAutoGrow(boolean autoGrow) {
                this.autoGrow = autoGrow;
        }

        /**
         * 获得当前栈的容量
         * @return
         */
        public int getCapacity() {
                return capacity;
        }

        /**
         * 获得当前栈的元素数量
         * @return
         */
        public int getSize() {
                return size;
        }

        /**
         * 栈的容量翻倍
         */
        private void expand() {
                capacity = capacity*2;
                T[] newArray = initArray(capacity);
                for(int i=0;i<size;i++) {
                        newArray[i] = arrays[i];
                }
                arrays = null;
                arrays = newArray;
        }

        /**
         * 栈是否为空
         * @return
         */
        public boolean isEmpty() {
                if(size==0) {
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * 栈是否满员
         * @return
         */
        public boolean isFull() {
                if(size==capacity) {
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * 往栈中压入元素，返回栈本身
         * @param o
         * @return
         * @throws Exception 
         */
        public Stack<T> push(T o) throws Exception {
                //检查是否已满
                boolean isFull = isFull();
                if(isFull) {
                        //自动增长
                        if(autoGrow) {
                                expand();
                        //抛出异常
                        } else {
                                throw new Exception("栈只能存储"+size+"个元素，已满");
                        }
                }
                //压入元素
                arrays[size] = o;
                size ++;
                return this;
        }

        /**
         * 弹出栈顶元素
         * @return
         * @throws Exception 
         */
        public T pop() throws Exception {
                boolean isEmpty = isEmpty();
                //为空抛出异常
                if(isEmpty) {
                        throw new Exception("栈已为空");
                }
                size--;
                T o = arrays[size];
                arrays[size] = null;
                return o;
        }

        /**
         * @param args
         * @throws Exception 
         */
        public static void main(String[] args) throws Exception {
                
               
                InputStreamReader   stdin   =   new   InputStreamReader(System.in);//键盘输入 
                BufferedReader   bufin   =   new   BufferedReader(stdin); 
                String str   =   bufin.readLine();
                     
                int num = Integer.valueOf(str);
        	
                //如果输入是0
                if(num == 0){
                	System.out.print("0");
                	return;
                }
                
                //如果输入是负数
                boolean isNumNegative = false;
                if(num < 0){
                	isNumNegative = true;
                	num = -num;
                }
                
                Stack<Integer> stack = new Stack<Integer>(100,true);
                while(num != 0){
                	stack.push(num%2);
                	num = num / 2;
                }
                
                if(isNumNegative == true){
                	System.out.print("-");
                }
                while(!stack.isEmpty()) {
                        System.out.print(stack.pop());
                }

        }

}