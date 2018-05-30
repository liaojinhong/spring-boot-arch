测试操作：直接解压，打开eclipse，导入（Existing Maven Projects）,选择到项目pom.xml所在目录

检查数据库是否启动：navicat for mysql
系统配置文件： application.properities 

spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.properties.hibernate.hbm2ddl.auto=update

#config application run port
server.port=7001

准备数据库  mysql  实例  test
自动创建表：s_user 系统用户表  s_role用户角色表
业务表：Student  字段： id  name  age
初始脚本：
	 s_user》
   INSERT INTO `` (`id`, `dob`, `email`, `name`, `password`) VALUES (1, '2018-5-30', '377890166@qq.com', 'liaojinhong', '123456');
   s_role》
   INSERT INTO `` (`id`, `name`, `uid`) VALUES (1, 'ROLE_admin', 1);
	 INSERT INTO `` (`id`, `name`, `uid`) VALUES (2, 'ROLE_user', 1);
	 Student》
   INSERT INTO `` (`id`, `age`, `name`) VALUES (1, 20, 'a');

   
首页访问：http://localhost:7001/home
登录页面：http://localhost:7001/login

登录用户：liaojinhong   123456

项目构建：Maven
		  打包：mvn package
项目部署：
    直接运行
      方式1：eclipse直接运行Startup.java 
      方式2：eclipse调试运行Startup.java 
      方式3 命令运行  java -jar targe/spring-boot-0.0.1-SNAPSHOT.war
      
      
IE或谷歌浏览器访问：
      查询API:http://localhost:7001/user/query/1
      新增API:http://localhost:7001/user/save/廖锦宏
      删除API:http://localhost:7001/user/delete/廖锦宏
      
      
实例演示功能包括：
	spring boot启动
	登录认证
	数据库连接
	增删改查操作
	servlet
	过滤器
	拦截器
	webservice
	日志输出
	java模式
	junit测试
	面向切面AOP实例
	丰富的工具类
	多线程异步处理
	定时任务
	等等
	
Redis操作演示：
 1. 设置一个key值
  http://localhost:7001/redis/set/mykey-001
 2. 获得一个key值
  http://localhost:7001/redis/get/mykey