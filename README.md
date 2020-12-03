## Java 

### 环境
- 安装`jdk`和`jir`
- 配置环境变量

### 编译
`javac -sourcepath src -encoding UTF-8 src/Main.java `
`java -cp src Main`
或者
`npm run build`(需要安装nodejs环境)

### 书写规范
跟`ActionScript3`类似
- 包名需要跟文件夹路径统一
- 开放的类名需要跟文件名字统一
  
### Logger控制选项说明
- `\033[0m` 关闭所有属性 
- `\033[1m` 设置高亮度 
- `\033[4m` 下划线 
- `\033[5m` 闪烁 
- `\033[7m` 反显 （当鼠标把此处选中时才会显示）
- `\033[8m` 消隐 
- `\033[30m -- \033[37m` 设置前景色 
- `\033[40m -- \033[47m` 设置背景色 
- `\033[nA` 光标上移n行 
- `\033[nB` 光标下移n行 
- `\033[nC` 光标右移n行 
- `\033[nD` 光标左移n行 
- `\033[y;xH`设置光标位置 
- `\033[2J` 清屏 
- `\033[K` 清除从光标到行尾的内容 
- `\033[s` 保存光标位置 
- `\033[u` 恢复光标位置 
- `\033[?25l` 隐藏光标 
- `\033[?25h` 显示光标

### 一些差异
  - 不支持函数默认参数 只能用重载实现

### 实现装饰器
  - JAVA的注解特性，这个跟C#是一样的

### 关于反射
基于全局反射可以实现自动注入
但JAVA不能进行全局反射
可以使用第三方`https://github.com/ronmamo/reflections`;
但此库依赖项较多,当前项目不宜引用

### 关于Vitamin
这是一个依赖注入的简易框架实现
用法实例
```java
//注入模型
Vitamin.injectModel(ModelUser.class);
//注入Command
Vitamin.injectCmd(CmdRename.class);

//取出一个视图
ViewMain viewmain=(ViewMain)Vitamin.getView(ViewMain.class);
//打开视图
viewmain.enter();
```
ViewMain实现
```java
public class ViewMain extends ViewBase {

    @Model
    public ModelUser user;
    
    public void enter(){
        super.enter();
        Logger.debug("ViewMain->",user.uid);
        this.exec("user.rename","kevin.chen");
    }
}
```