# 第一天 7.11 java chapter1  基础  
## 命名java变量
- 命名包
	- 包名前要加上唯一前缀以示区分
	- 一般采用域名等来表示这个前缀
- 命名类
	- 首字母大写
	- 驼峰命名
- 方法命名
	- 首字母小写
	- 其余单词驼峰
- 常量的命名
	- 全大写
	- 单词使用下划线区分
- 参数的命名
	- 同方法的命名
	- 尽可能明确
- JavaDoc命名
	- 去学javadoc咯！


## 静态变量和参数重名的情况
```java
public class Main
{
	public static void main(String[] args){
		moidfy (a);
		System.out.println(a);
	} 
	public static int a;
	
	public static void modify(int a){
		a++;
	}
}
```
这段代码输出的是0.

```java
public class Main{
	public static void main(String args){
		modify();
		System.out.println(a);
	}
	
	public static int a;

	public stati void modify(){
		Main.a++;
	}
} 
```
这段代码输出的是1。

## UML
- 设计模式再见

## javac 命令
- javac <option> <file>
- 手动配置classpath
	`javac -classpath .;a.jar;b.jar;c.jar Main.java `


## java 命令
- java 要执行的类
	- 不需要带.class
	- 多包时输入完整的包名
## jar 命令
- 格式
	jar [ctxu] [vfm0M] *.jar mainfest -c <directory> <target_name> <source_name>
- 参数  jar 子命令 【 一般只选一个
	- c 创建新的jar包
	- t 列出jar文件包含的内容列表
	- x 展开jar包的制定文件或者全部文件
	- u 更新一存在的jar文件包，即添加或者删除文件到jar包
- 参数 jar选项 任选
	- v 生成具体报告并打印到标准输出
	- f 指定jar文件的文件名，一般必选
	- m 指定徐啊哟包含的manifest清单文件
	- 0 只储存  不压缩
	- M 不产生manifest清单文件 和-m冲突
- C 目录 
	- 跳转到指定目录下执行jar命令
	- 就是把对应目录里的文件打包到jar包中并保存到当前文件夹
- manifest 
	- 没说！！！！！！！
	- 没说！！！！！！！
	- 没说！！！！！！！
	- (╯‵□′)╯︵┻━┻

 
