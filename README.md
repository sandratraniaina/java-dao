# Java Spring DAO

## Introduction

It is a generalized DAO based on Spring framework and java

## Getting Started

**Directory Structure:**

* **src/**: Contains the source code for the project.
* **build.bat**: Script for building the project into JAR file.

**Prerequisites**

* Java Development Kit (JDK)
* JDBC driver

### Building the Project

The repository contains a batch script file to build the project. Run the following command in the terminal:

```bash
./build.bat
```

The script will create a JAR file named **dao.jar**. Add the file to your project's libraries and it will be ready to use for your web application.

**Note:** You need to have a xml context file for your database setup like te following. Do not forget to change values into your actual values.

```xml
    <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
    

    <bean id="dao" class="dao.Dao">
        <property name="sqlUtils" ref="sql_utils" />
    </bean>

    <bean id="sql_utils" class="utils.SQLUtils">
        <property name = "url" value = "database url" /> 
        <property name = "driver" value = "driver classs" />
        <property name = "user" value = "user" />
        <property name = "password" value = "username" />
        <property name = "engineType" value = "password" />
    </bean>
  
    </beans>
```

## Example 

After finishing your xml setup, you need to get the xml context file in your application: 

```java
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml"); // Get context xml file

    Connection c = ((SQLUtils) context.getBean("sql_utils")).getConnection(); //Get your SQL connection (Optionnal)

    Dao dao = (Dao) context.getBean("dao"); // Get Dao main instance

    //Read all employee form database using Connection object(Optionnal)
    Employee emp = new Employee();
    ArrayList<Object> list = dao.readAll(c, emp);
    for (Object o : list) {
        Employee e = ((Employee) o);
        System.out.println(e.getName());
    }
```

**Note**: Do not forget to add Annotation class(table_name) and AnnotationAttribute(column_name) on your model class file. 

```java
    // Attribute id has id as column name in table named brand in database
    @AnnotationClass("brand")
    public class Employee {
        @AnnotationAttribute("id")
        String id;
    }
```

## Feature

* ReadAll
* ReadByCriteria
* Create
* ReadByRange
* ReadByPagination

## Contributing

Contributions are welcome. Please feel free to fork the project and submit your pull requests by :

* Implementing additional features based on the Spring framework.
* Improving the existing code.
* Adding documentation and comments.

## License

This project is licensed under the MIT License. This license grants you permission to freely use, modify, and distribute this software under certain conditions. Please refer to the [LICENSE](./LICENSE) file for more details.

## Contact

You can reach me at: [sandratrarafa@gmail.com](mailto:sandratrarafa@gmai.com)

## Acknowledgments

Mr Naina
