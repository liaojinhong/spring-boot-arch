���Բ�����ֱ�ӽ�ѹ����eclipse�����루Existing Maven Projects��,ѡ����Ŀpom.xml����Ŀ¼

������ݿ��Ƿ�������navicat for mysql
ϵͳ�����ļ��� application.properities 

spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.properties.hibernate.hbm2ddl.auto=update

#config application run port
server.port=7001

׼�����ݿ�  mysql  ʵ��  test
�Զ�������s_user ϵͳ�û���  s_role�û���ɫ��
ҵ���Student  �ֶΣ� id  name  age
��ʼ�ű���
	 s_user��
   INSERT INTO `` (`id`, `dob`, `email`, `name`, `password`) VALUES (1, '2018-5-30', '377890166@qq.com', 'liaojinhong', '123456');
   s_role��
   INSERT INTO `` (`id`, `name`, `uid`) VALUES (1, 'ROLE_admin', 1);
	 INSERT INTO `` (`id`, `name`, `uid`) VALUES (2, 'ROLE_user', 1);
	 Student��
   INSERT INTO `` (`id`, `age`, `name`) VALUES (1, 20, 'a');

   
��ҳ���ʣ�http://localhost:7001/home
��¼ҳ�棺http://localhost:7001/login

��¼�û���liaojinhong   123456

��Ŀ������Maven
		  �����mvn package
��Ŀ����
    ֱ������
      ��ʽ1��eclipseֱ������Startup.java 
      ��ʽ2��eclipse��������Startup.java 
      ��ʽ3 ��������  java -jar targe/spring-boot-0.0.1-SNAPSHOT.war
      
      
IE��ȸ���������ʣ�
      ��ѯAPI:http://localhost:7001/user/query/1
      ����API:http://localhost:7001/user/save/�ν���
      ɾ��API:http://localhost:7001/user/delete/�ν���
      
      
ʵ����ʾ���ܰ�����
	spring boot����
	��¼��֤
	���ݿ�����
	��ɾ�Ĳ����
	servlet
	������
	������
	webservice
	��־���
	javaģʽ
	junit����
	��������AOPʵ��
	�ḻ�Ĺ�����
	���߳��첽����
	��ʱ����
	�ȵ�
	
Redis������ʾ��
 1. ����һ��keyֵ
  http://localhost:7001/redis/set/mykey-001
 2. ���һ��keyֵ
  http://localhost:7001/redis/get/mykey