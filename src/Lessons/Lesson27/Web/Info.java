package Lessons.Lesson27.Web;

public class Info {
    //WebServer ожидает http запрос от клиентов
    //WebApps - корневая директория на сервере TomCat
    /*допустим есть запрос http://127.0.0.1:8080/aaa/bbb?key = value1 & key2 = value2
     сервер будет искать файл /webApps/aaa/web-inf/web.xml
     в котором буддет искать класс которые будет обрабатывать соответствующий запрос
     сам класс находиться в папке /webApps/aaa/web-inf/classes */
    //request являеться также контейнером, в нем есть метод setAttribute ()

//чтобы сделать сервлет однопоточным, нужно имплементировать интерфейс-маркер SingleThreadModel
}
