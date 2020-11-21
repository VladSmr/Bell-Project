1. Установить JDK 1.8

http://www.oracle.com/technetwork/java/javase/downloads/index.html

Выбрать Java SE 8

2. Добавить системную переменные среды

Name:JAVA_HOME
Value:C:\Program Files\Java\jdk1.8.0_131

Добавить в конец значения переменной path:
;%JAVA_HOME%\bin

Проверить установку в консоли:

echo %JAVA_HOME%

Команда должна вывести в консоль значение переменной

java -version

3. Установить maven

http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz

Распаковать архив. Добавить системную переменные среды:

Name:M2_HOME
Value:<путь к распакованному архиву>

Добавить в конец значения переменной path:
;%M2_HOME%\bin

Проверить установку в консоли:

mvn --version

3. Запуск проекта

В консоли перейти в папку с проектом, выполнить

mvn spring-boot:run

Проект будет доступен по url: http://localhost:8888

4. Импорт проекта в IDEA

File->Open
Выбрать файл pom.xml в корневой папке проекта

Ok->Open as Project


**Ответ сервера на запрос в форме:**

    {“data”:{ //то, что в параметре out } }

В случае ошибки:

    {“error”:” текст ошибки” }


1. api/organization/list

In (фильтр):

    {

    “name”:””, //обязательный параметр
  
    “inn”:””,
  
    “isActive”:””
    }

Out:

    [

      {
  
      “id”:””,
    
      “name”:””,
    
      “isActive”:”true”  //пример
    
      },
  
      ...
  
    ]


2. api/organization/{id}

Out:

    {

      “id”:””,
  
      “name”:””,
  
      “fullName”:””,
  
      “inn”:””,
  
      “kpp”:””,
  
      “address”:””,
  
      “phone”,””,
  
      “isActive”:”true”  //пример
  
    }


3. api/organization/update

In:

    {

      “id”:””, //обязательный параметр
  
      “name”:””, //обязательный параметр
  
      “fullName”:””, //обязательный параметр
  
      “inn”:””, //обязательный параметр
  
      “kpp”:””,  //обязательный параметр
  
      “address”:””, //обязательный параметр
  
      “phone”,””,
  
      “isActive”:”true”  //пример
  
    }

Out:

    {

        “result”:”success”
    
    }


4. api/organization/save

In:

    {

      “name”:””, //обязательный параметр
  
      “fullName”:””, //обязательный параметр
  
      “inn”:””, //обязательный параметр
  
      “kpp”:””, //обязательный параметр
  
      “address”:””, //обязательный параметр
  
      “phone”,””,
  
      “isActive”:”true”  //пример
  
    }

Out:

    {

    “result”:”success”
    
    }


5. api/office/list

In (фильтр):

    {

      “orgId”:””, //обязательный параметр
  
      “name”:””,
  
      “phone”:””,
  
      “isActive” 
  
    }

Out:

    [

      {
  
        “id”:””,
    
        “name”:””,
    
        “isActive”:”true”  //пример
    
      },
  
      ...
  
    ]


6. api/office/{id}

Out:

    {

      “id”:””,
  
      “name”:””,
  
      “address”:””,
  
      “phone”,””,
  
      “isActive”:”true”  //пример
  
    }


7. api/office/update

In:

    {

      “id”:””, //обязательный параметр
  
      “name”:””, //обязательный параметр
  
      “address”:””, //обязательный параметр
  
      “phone”,””,
  
      “isActive”:”true” //пример
  
    }

Out:

    {

    “result”:”success”
    
    }


8. api/office/save

In:

    {

      “orgId”:””, //обязательный параметр
  
      “name”:””,
  
      “address”:””,
  
      “phone”,””,
  
      “isActive”:”true”  //пример
  
    }

Out:

    {

    “result”:”success”
    
    }


9. api/user/list

In (фильтр):

    {

      “officeId”:””, //обязательный параметр
  
      “firstName”:””,
  
      “secondName”:””,
  
      “middleName”:””,
  
      “position”,””,
  
      “docCode”:””,
  
      “citizenshipCode”:””
  
    }

Out:

    [

      {

        “id”:””,
  
        “firstName”:””,
  
        “secondName”:””,
  
        “middleName”:””,
  
        “position”:””
  
      },
      
      ...
      
    ]


10. api/user/{id}

Out:

    {

      “id”:””,
  
      “firstName”:””,
  
      “secondName”:””,
  
      “middleName”:””,
  
      “position”:””
  
      “phone”,””,
  
      “docName”:””,
  
      “docNumber”:””,
  
      “docDate”:””,
  
      “citizenshipName”:””,
  
      “citizenshipCode”:””,
  
      “isIdentified”:”true”  //пример
  
    }


11. api/user/update

In:

    {

      “id”:””, //обязательный параметр
  
      “officeId”:””,
  
      “firstName”:””, //обязательный параметр
  
      “secondName”:””,
  
      “middleName”:””,
  
      “position”:”” //обязательный параметр
  
      “phone”,””,
  
      “docName”:””,
  
      “docNumber”:””,
  
      “docDate”:””,
  
      “citizenshipCode”:””,
  
      “isIdentified”:”true” //пример
  
    }

Out:

    {

    “result”:”success”
    
    }


12. api/user/save

In:

    {

      “officeId”:””, //обязательный параметр
  
      “firstName”:””, //обязательный параметр
  
      “secondName”:””,
  
      “middleName”:””,
  
      “position”:”” //обязательный параметр
  
      “phone”,””,
  
      “docCode”:””,
  
      “docName”:””,
  
      “docNumber”:””,
  
      “docDate”:””,
  
      “citizenshipCode”:””,
  
      “isIdentified”:”true” //пример
  
    }


13. api/docs

(Справочники)

    [

      {
  
        “name”:“Паспорт гражданина РФ”,
    
        “code”:”21”
    
      },
  
      ...
  
    ]


14. api/countries

(Виды документов, удостоверяющих личность физического лица)

    [

      {
  
        “name”:“Российская Федерация”,
    
        “code”:”643”
    
      },
  
      ...
  
    ]