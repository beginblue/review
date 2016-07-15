# 7.15 第四章 声明和访问控制 #
## 声明数组 ##
```java
int[] nums = new int[]{};
int[] nums = new int[2];
int[][] nums = new int[4][4];
int[][] nums = new int[4][];

int[][] nums = new int[][3];//非法
```

## 改变数组的大小 ##
不能改变。Collection类的子类可以。

## 类不能用private ##

## this ##
- this 表示当前对象
	- 在匿名内部类中 this 表示内部类的对象
	- 指代外部类要使用类名
``` java
public class A {
	int i = 1;
	public A(){
		Thread thread = new Thread(){
			public void run(){
				for(;;){
					A.this.run();
				try{
					Thread.sleep(1000);
				} catch (IterruptedException e){}
				}
			}
		};
	}
	public void run(){
		System.out.println("i = "+i);
		i++；
	}
	public static void main(String[] args){
		new A();
	}
}

```


## 修饰符 ##


|修饰符	|类	|方法	|成员变量|局部变量|
|-------|-------|-------|--------|--------|
|abstract|yes	|yes	|no	|no	|
|static |yes	|yes	|yes	|no	|
|public |yes 	|yes	|yes	|no	|
|protected|yes	|yes	|yes	|no	|
|private|yes	|yes	|yes	|no	|
|synchronized|yes|yes	|yes	|no	|
|native	|no	|yes	|no	|no	|
|transient|no	|no	|yes	|no	|
|volatile|no	|no	|yes	|no	|
|final	|yes	|yes	|yes	|yes	|

## final finally finalize 的区别 ##


