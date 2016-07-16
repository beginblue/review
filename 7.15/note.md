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
- final用于声明属性、方法和类 分别表示属性不可变，方法不可覆盖和类不可以继承
- finally是异常处理的一部分，表示在捕获或者未捕获异常时总是执行的代码段
- finalize 是Object类的一个方法，在GC执行的时候会调用这个方。可以继承这个方法，来实现类似于析构函数的功能。

## 包含抽象方法的类必须是抽象类 ##

## java的访问修饰符 ##
*friendly等同于没有修饰符有的地方也称谓default*

|修饰符	|同一类中|同一包中|不同包中的子类|不同包中的非子类|
|-------|--------|--------|--------------|----------------|
|private|可以访问|不能访问|不能		 |不能		  |
|friendly|可以	 |可以	  |不能		 |不能		  |
|protected|可以	 |可以	  |可以		 |不能		  |
|public	|可以	 |可以	  |可以		 |可以		  |

## 构造函数 ##
1.构造函数的作用是生成对象实例
2.构造函数不能有abstract、final、native、static或synchronize修饰符
3.构造函数没有返回值
4.构造函数可可以在其中通过this调用其他构造函数，但是必须再度第一行
```java
public class Test {
	public Test(String name ){ this.name = name; }	
	public Test(){ this("blue");}
	private String name;
	//....omitted
}
```
5. 构造函数中通过使用super调用父类的构造函数，但是必须在第一行
```java 
public class A {
	public A(){ System.out.println("A"); }
	//...omitted
}
public class B exteds A {
	public B() { super(); System.out.println("B"); }
}
```
6.当用户的类不包含构造函数的时候，编译器会默认的加上一个不带参数的构造函数。
7.构造函数不能被继承。
8.构造函数不能调用。
```java
public class A{
	private A a;
	String str;
	public A(){  
		System.out.println("no para");
		a = new A("Blue");
		//a= new A();
	}
	public A(String str ){
		System.out.println("str para");
		this.str = str;
		this.a = this;
	}


	public A(int b){
		this("Hello");
	}

	public static void main(String[] args){
		A b = new A();
	}
}
```
9.构造函数的执行顺序
用代码说话
```java
// A.java 
public class A{

    {
        System.out.println("A dynamic block");
    }

    //Inner class cannot have static declaration
    static {
        System.out.println("A static block");
    }
    public A(){
        System.out.println("A constructor");
    }

}

//B.java
public class B extends A{
    {
        System.out.println("B dynamic block");
    }

    static {
        System.out.println("B static block");
    }

    public B(){
        super();
        System.out.println("B constructor");
    }
}
```	
如果 主类是 
``` java 
public class Main {


    public static void main(String[] args) {
        A a = new A();
        System.out.println("-----");
        B b = new B();
        System.out.println("-----");
        A aa = new B();
    }
}
```
则执行结果是
``` 
A static block
A dynamic block
A constructor
   ---
B static block
A dynamic block
A constructor
B dynamic block
B constructor
      ---
A dynamic block
A constructor
B dynamic block
B constructor
```

如果主类是 
``` java
public class Main {
    public static void main(String[] args) {
        B b = new B();
        System.out.println("-----");
        A aa = new B();
    }
}

```
则结果是 
```
A static block
B static block
A dynamic block
A constructor
B dynamic block
B constructor
-----
A dynamic block
A constructor
B dynamic block
B constructor
```

由此可以看出来一个类执行的顺序是
调用构造-调用`super();`-调用static 块-调用dynamic块 -`super();`方法体-构造方法体

当父类与子类都有静态代码块和构造函数的时候，执行顺序如下：

- 父类静态代码块 > 子类静态代码块 ( java虚拟机加载类时，就会执行该块代码。)

- 父类构造函数 > 子类构造函数 （先有父亲，后有孩子）
- 如果是多级继承关系的话，高层的父类首先执行，然后依次递减
- 总结：静态优先执行，父类优先于子类执行
- 静态代码块是在JVM加载类的时候执行的，而且静态代码块执行且仅执行一次


*more* 
*构造函数默认先执行`super();`*
于是B类变成了这个样子～ 
``` java 
public class B extends A{
    {
        System.out.println("B dynamic block");
    }

    static {
        System.out.println("B static block");
    }

    public B(){
        this(2);
        System.out.println("B constructor");
    }

    public B(int a){
        System.out.println("B constructor with para");
    }
}
```
主类把无关的代码的去掉
``` java 
public class Main {
    public static void main(String[] args) {
        B b = new B();
    }
}
```
于是结果变成了这个样子

```
A static block
B static block
A dynamic block
A constructor
B dynamic block
B constructor with para
B constructor
```

