# 7.13 第三天 运算符和类型转换 #

## 111 ％ 13 ##
111 = 13*9-4 = 13 * 8 + 7 
the answer is 7

## what is the value of y ##
```java 
x=4;y=5;y=x++;
```
the answer is 4

## what is the output ##
``` java 
public static void main(String[] args){
	int n = 7 ; //n = 111b
	n<<=3; // n = 111000b = 56 
	n=n&n+1|n+2^n+3;
	//四则运算的优先级高于位运算
	n>>=2;
	System.out.println(n);
}
```
the answer is 14
n=n&(n+1)|(n+2)^(n+3)

## instanceof 是一个二元操作数 ##

## 运算符的优先级 ##
[运算符优先级](http://www.cnblogs.com/gw811/archive/2012/10/13/2722752.html,"优先级")

## `equlas()` 和 `==` 的区别 ##
默认的`equals()`和`==`都是比较值类型的值或者引用类型的引用是否相同。
但是`equals()`可以被重载 比如‘String.equals()`

## 参数传递 ##
值类型数据在函数内不修改外不变量的值
引用类型因为传递的实际上是地址所以函数内部的修改会对外面的值产生影响
`void test(myObject object){ object=object.change();}`
String是特殊的，线程安全的，在函数内部不饿能被改写
`public static void test(String str){ str="ddd"; }`
等效于
`public static void test(String str){ str = new String("ddd");} `
str对应的地址变了但是函数外部对应的变量仍然指向str传入时的地址 


##  final 用于变量 ##

final 用于变量 表示这个变量是一个常量，不能再次被修改，只能执行一次赋值。

## 数据类型转换 ##
- 低级数据类型到高级数据类型自动转换
- 高级数据类型到低级数据类型必须强制转换
- 包装类过度类型能够转换 
	- 包装过度类型值得是Character Integer Long 等。
	- 他可以将基本数据类型当做对象来使用，也提供了类型之间的转换方法
```java
float f1 = 100.00f;
Float F1 = new Float(f1);
double d1 = F1.doubleValue();
```

## 时间日期相关的类 ##
- Date类
	- 存在于包 java.util 中
	- 记录从1970.1.1以后的毫秒数，用long类型表示，通过`getTime()`方法来获得这个值
- DataFormat类
- GregorianCalender 类

	- 
