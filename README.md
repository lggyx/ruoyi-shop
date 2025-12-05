<p align="center">
	<img alt="logo" src="https://oscimg.oschina.net/oscnet/up-d3d0a9303e11d522a06cd263f3079027715.png">
</p>
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">RuoYi v3.9.0</h1>
<h4 align="center">基于SpringBoot+Vue前后端分离的Java快速开发框架</h4>
<p align="center">
	<a href="https://gitee.com/y_project/RuoYi-Vue/stargazers"><img src="https://gitee.com/y_project/RuoYi-Vue/badge/star.svg?theme=dark"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue"><img src="https://img.shields.io/badge/RuoYi-v3.9.0-brightgreen.svg"></a>
	<a href="https://gitee.com/y_project/RuoYi-Vue/blob/master/LICENSE"><img src="https://img.shields.io/github/license/mashape/apistatus.svg"></a>
</p>


## 配置项目启动

### 后端

修改ruoyi-admin/src/main/resources/application-druid.yml

配置数据库连接信息

启动mysql服务，启动redis服务

运行sql/路径下的脚本，确保运行成功

启动ruoyi-admin/src/main/java/com/ruoyi/RuoYiApplication.java

### 前端

确认安装node

ruoyi-ui/目录下命令行执行

```bash
npm install
npm run dev
```

## 代码生成

![image-20251205103644379](./assets/image-20251205103644379.png)

如图打开代码生成界面

![image-20251205103718567](./assets/image-20251205103718567.png)

点击导入是导入数据库中存在的表，也可以使用创建，可以创建未存在的表

导入表后打开编辑

![image-20251205103846407](./assets/image-20251205103846407.png)

确保业务名没有重复且不合法的写法，没有问题点击提交

![image-20251205104008310](./assets/image-20251205104008310.png)

菜单可以如下图所示位置创建

![image-20251205104055920](./assets/image-20251205104055920.png)

选择表，点击生成

![image-20251205104153575](./assets/image-20251205104153575.png)

![image-20251205105505904](./assets/image-20251205105505904.png)

## 代码导入

### 后端

使用idea打开项目，右键项目，新建模块

![image-20251205104307538](./assets/image-20251205104307538.png)

模块名称与代码生成设置的保持一致

![image-20251205104437054](./assets/image-20251205104437054.png)

创建后复制一份ruoyi-system/pom.xml到新创建的模块中替换掉创建时生成的pom文件，同时修改artifactId名为模块名

![image-20251205104757127](./assets/image-20251205104757127.png)

打开ruoyi-framework/pom.xml，添加新增模块坐标

![image-20251205104918961](./assets/image-20251205104918961.png)

重新构建项目

打开生成的代码压缩包，将main目录下的文件放置到如下，除contorller目录下的内容放置如下

![image-20251205105121445](./assets/image-20251205105121445.png)



在ruoyi-admin/src/main/java/com/ruoyi/web/controller目录下新建目录为创建的模块名，复制controller目录下文件到此处

![image-20251205105257077](./assets/image-20251205105257077.png)

### 前端

将vue目录下的文件放置到ruoyi-ui/src下

![image-20251205105622061](./assets/image-20251205105622061.png)

### 数据库

运行压缩包中的sql脚本

![image-20251205105713688](./assets/image-20251205105713688.png)

运行后启动前后端服务，刷新，项目生成代码运行成功
