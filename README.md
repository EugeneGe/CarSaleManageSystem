# 汽车销售管理系统

#### 背景
Java基础课程设计

#### 介绍
利用Java和MySQL语言，通过MVC模式实现汽车销售信息管理，主要实现增删改查功能

#### 软件架构
Java原生MVC
#### 环境
- 数据库：MySQL8.0
- 开发环境：JDK1.8
- 开发工具：MyEclipse

#### 安装教程

1.  安装JDK1.8和MyEclipse（或者Eclipse）
2.  安装数据库MySQL8.0
3.  克隆项目到本地

#### 使用说明
1.  新建数据库carsalesystem，编码格式为utf-8，其他默认
2.  将数据库文件（CarsSaleSystem.sql）导入数据库
3.  在MyEclipse中打开克隆到本地的项目
3.  修改配置文件中的数据库信息（路径src/dbconfig.properties），主要修改数据库用户名和密码，如果数据库名不为carsalesystem，需要修改数据库连接信息中的数据库名，即url中的carsalesystem关键字
4.  以上准备工作做完后，运行src/com/main/Main.java的主启动类即可进入登录界面
5.  系统信息（用户名：root，密码：toor）

#### 项目结构
![项目结构](https://images.gitee.com/uploads/images/2020/0506/024751_6c212c05_5105169.png "项目结构.png")

#### 数据库模型

![数据库模型](https://images.gitee.com/uploads/images/2020/0506/025913_dcc71b2a_5105169.png "Diagram 1.png")

#### 运行截图
-   **登录界面** 

![登录界面](https://images.gitee.com/uploads/images/2020/0506/024229_458fa23c_5105169.png "1.png")

-  **主界面** 

![主界面](https://images.gitee.com/uploads/images/2020/0506/024427_74162025_5105169.png "主界面.png")

-  **汽车信息** 

![汽车信息](https://images.gitee.com/uploads/images/2020/0506/024456_d8bc905a_5105169.png "01.png")

-  **员工信息** 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0506/024540_9563649b_5105169.png "02.png")

-  **客户信息** 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0506/024557_c02eaa33_5105169.png "03.png")

-  **销售信息** 

![输入图片说明](https://images.gitee.com/uploads/images/2020/0506/024605_6251d4e8_5105169.png "04.png")



#### 开发者信息
-  **_GhostGuest_** 
- 个人博客地址：[http://www.ghostai.top](http://www.ghostai.top)