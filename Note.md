# SpringBoot使用库笔记
>通过这个使用笔记可以更加高效的使用SpringBoot

##1、基本配置信息与启动原理
在SpringBoot中一个比较关键的注解就是@SpringBootApplication       
    
@SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan       

### 1.1 通过 @Value( “ ${name} ”) ) 形式来使用属性

### 1.2 @ConfigurationProperties 读取配置文件的信息，读取并自动封装成实体类

### 1.3  参数间引用

### 1.4  用自定义配置文件 @PropertySource("")

### 1.5 配置文件的优先级

### 1.6 @Value( “ #{a.b} ”) )
不仅可以使用@Value(“${name}”) 这样，还可以使用类似于 @Value(“#{a.b}”)的用法。

### 1.7 处理 url 中的参数


## 2 、开发 Web 应用之 Thymeleaf 篇

### 2.1 Spring MVC 自动配置









