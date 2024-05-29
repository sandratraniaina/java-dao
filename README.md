# Java DAO

## Introduction

It is a generalized DAO made in Java

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

**Note:** You need to have a xml context file for your database setup.

```xml
    <dao>
        <url>database url</url>
        <driver>database driver class</driver>
        <user>username</user>
        <password>password</password>
        <engine>database engine type</engine>
    </dao>
```

## Example 

```java
    // Here is the class used on our test
    @Table("brand")
    public class Employee {
        @Column("id")
        String id;
    }
```

```java
    Dao dao = new Dao("path\\to\\xml-file.xml");
    ArrayList<Object> employees = dao.readAll(new Employee());
    for (Object object : Empployee) {
        Employee driver = ((Driver)object);

        System.out.println(employee.getId());
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
