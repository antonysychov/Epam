package Preparation.Notes;


import java.util.PriorityQueue;
import java.util.Queue;

public class Notes {
    //комментарии могут идти до package statement
    //следить чтобы унаследованный суперкласс содержал конструктор без параметров
    /*Ошибка компиляции будет в том случае, когда исходное выражение и целевой тип полностью несовместимы.
     Например, "(String) new Long(1)".
     В остальных случаях окончательная проверка осуществляется во время исполнения.*/
    //при явном вызове метода суперкласса super.getI() не происходит полиморфическое определение метода а вызываеться именно метода суперкласса
    //следить за неявными вызовами конструкторов суперклассов
    //в каждом source файле должен бть указан пакет в первой строчке
    //при добавлении элемента в bucket collection не из диапазона - буде выброшено IllegalArgumentException
    //класс Preferences !!! хранит данные между запусками программы !!!
    //CloneNotSupportedException выбрасываеться когда класс не реализует Cloneable. CloneNotSupportedException являеться checked !!!
    //when the remainder operation returns a nonzero result, it has the same sign as its left operand.
    //ошибка компиляции при отлавливании CHECKED исключений из try блоков, где такие исключения не могут возникнуть в принципе
    //в enum нельзя this
    //в static'ах никогда не может быть прямого указателя this
    //не может быть статических локальных классов
    //sleep(), wait(), join() должны быть охвачены try/catch блоком !!!!!!!
    //notify/notifyAll не отпускают блокировку, блокировка снимается по выходу из синхронизированного блока
    //вызов wait() из несинхронизированного блока вызовет IllegalMonitorStateException
    //null приводиться ко всему
    //переменные классов, не полиморфны
    //классы в интерфейсах автоматически становяться public static
    //в циклах нельзя чередовать условия через запятую
    //внутренние нестатические классы не могут содержать static полей, но могут содержать константы static final
    //локальные классы не могут использовать переменные метода, но могут использовать константы final метода, находящиеся перед объявлением класса
    //в Generic's не действует полиморфизм на параметризируемые типы
    //List<List<Integer>> table = new ArrayList<ArrayList<Integer>>(); ошибка компиляции
    //строковые литералы всегда сначала заносяться в пул
    //посмотреть и разобраться в методах коллекций
    //в TreeSet можно добавить элементы, но если они не реализуют Comparable - возникнет RunTime Exception
    //названия переменных не могут начинаться с цифр
    //конструктор не может быть final, static, abstract, может иметь любой модификатор доступа
    //перечисления не могут быть объявлены в методе !!!
    //перечисления - это класс с фиксированным кол-вом возможных экземпляров, могущих иметь свои реализации методов, значения переменных классов
    //JVM выделяет память для объектов во время инициализации а не объявления, поэтому нельзя указывать размер массива при объявлении int[4] ar
    //volatile говорит компилятору не кешировать переменную для каждого потока, а всегда брать значения из памяти
    //у каждого потока есть свой стек вызовов
    //нисходящее преобразование возможно для оклассов одной иерархии, но есть вероятность выброса ошибки в RunTime
    //переобпределяться могут только унаследованные методы (public, protected, package)
    //переопределенные методы могут изменять возвращаемый тип на ковариант (т.е. на тип унаследованный от супертипа)
    //в тернарном операторе если второй и третий операнды имеют одинаковый тип, то и результат операции будет такого же типа !!!!
    //(null instanceof Object) false
    //super всегда используеться с wildcard
/*  если коллекция параметризирована с ? super SomeClass, то в коллекцию можно добавлять объекты любых классов
    и компилятор думает что в коллекции находяться объекты Object, нельзя написать так Integer i = collection.pollFirst() например*/
    //полиморфизм не распространяеться на поля, стат. методы
    //выбор перегруженного метода происходит на этапе компиляции на основании типа ссылки !!!
    //выбор переопределенного метода происходит в runtime на основании фактического типа объекта
    //в начале каждого конструктора явно или неявно выполняеться вызов super() или this(). компилятор автоматически подставляет super()
    //результат арифм. операций с целочисленными аргументами - всегда int !!!
    //compound operators (+=, -=, *= ...) will all put in an implicit cast
    //локальным переменным не присваиваеться значение, даже null, поэтому их нельзя использовать перед инициализацией
    /*нельзя ссылке с типом массива присвоить ссылку на массив других ПРИМИТИВОВ int[] != byte[].
    Но можно ссылке на масив ОБЪЕКТОВ класса присвоить ссылку на массив объектов подкласса Object[] i = new Long[3];*/

    //When you assign an array to a previously declared array reference, the array you're assigning must be the same dimension as the reference you're assigning it to
    //Wrapper классы immutable
    //у оберток есть конструктор, принимающий основание системы исчисления (Integer i2 = Integer.valueOf("101011", 2))
    //арифм операции над оболочками приводят к созданию новых оболочек !!!
    //обертки с пулом : Boolean, Byte, Character (from \u0000 to u007f), Short, Integer and FUCKING LONG (not mentioned in JLS) !!!
    //при выборе перегруженного метода JVM использует метод с наименьшим аргументом который шире параметра
/*    Java 5's designers decided that the most important rule should be that preexisting
    code should function the way it used to, so since widening capability already existed,
    a method that is invoked via widening shouldn't lose out to a newly created method
    that relies on boxing*/
    //widening beats boxing
    //widening beats var-args
    //boxing beats vararg
    //обертки не расширяються
    //т.е. Short не приводиться к Integer
/*    компилятор при выборе перегруженных методов сначала упаковывает переменные в родные обертки для вызова метода,
    а потом проверяет, являеться ли полученная обертка подтипом параметра метода (is-a)*/
    //Runtime object provides a mechanism for communicating directly with JVM
    //For any given object, finalize() will be called only once (at most) by the garbage collector

    //Calling finalize() can actually result in saving an object from deletion.
    //Wrapper constructors can take a String or a primitive, except for Character, which can only take a char.
    //Byte b = 200 compilation fails
    //при вызове перегруженного метода не происходит вохможное сужение аргумента int x = 7; test(short); {} test(x) - compilation fails
    /*The instanceof operator can be used only to test objects (or null) against class types that are in the same class hierarchy.*/

    //instanceof не может быть использован с парметризированными типами, instanceof Set<Integer> - ошибка компиляции
    //instanceof не может быть использован с самими параметрами, instanceof T - ошибка компиляции
    /*блок инициализции инициализирующий переменную может идти до объявления переменной !!!, но переменная инициализируеться в итоге последним выражением
    если последним выражением идет просто объявление без инициализаци - то итоговое значение переменной опр-ся инициализационными блоками*/
    //в switch могут стоять byte, short, int, String ... long приведет к ошибке компиляции
    /*The case constant must be a literal or FINAl variable that is assigned to literal, or a constant
    expression, including an enum. You cannot have a case that includes a nonfinal
    variable, or a range of values.*/
    //The compiler will stop you from defining catch clauses that can never be reached. !!!
    //String methods use zero-based indexes, except for the second argument of substring().
    //When the JVM finds a String literal, it is added to the String literal pool. !!!!!!!!!! литерал добавляеться как объект класса String
    //Strings have a method: length(); arrays have an attribute named length.
    //File objects can represent either a file or a directory.
/*    Classes in java.io are designed to be "chained" or "wrapped." (This is a common use of the decorator design pattern.)*/
    //Console objects can read non-echoed input and are instantiated using System.console().
    //A Date is stored as a long, the number of milliseconds since January 1, 1970.
    //The String.split() method tokenizes the entire source data all at once, so large amounts of data can be quite slow to process.
    //The Scanner class allows you to tokenize data from within a loop, which allows you to stop whenever you want to.
    //The Scanner class allows you to tokenize Strings or streams or files.
    //method scope and static scope ain't the same static int x = 10; for(int x=0;x<5;x++){ 5. } is normal
    //приватные методы класса доступны также через оператор "." для объектов класса в этом же классе (в методе main например) !!!
    //при использовании assert как идентификаторов и компиляции под версиями ниже 1.4 - возникают предупреждения компиляции
    //в обычном for можно использовать объявленные ранее переменные, в for-each - нельзя
    //в catch блоке нельзя указывать исключения, которые никак не могут быть выброшены в try блоке - это ошибка компиляции
    //NumberFormatException - подкласс IllegalArgumentException
    //finally блок может не завершиться, например если в нем возникнет не обрабатываемый RuntIme Exception !!!
    //переполнение стека - не такая уж и критичная ошибка, если отловить исключение то можно продолжать работу
    //операнды - вещи слева и справа от оператора
    //выражения рассчитываються слева направо по умолчанию, если не применены скобки, или нету операторов с разными приоритетами
    //если один из операндов выражения - String, оператор + выполняет конкатенацию
    //Java law decrees that an else clause belongs to the innermost if statement to which it might possibly belong
    //shortcircuit operator compares whole part before and after the operator
    //in "case x :" it's allowed only to use a constant or final variable that is assigned a literal value

    //it's illegal to have more than one "case" label using the same value;
    //переменные в логическом выражении while цикла должны быть объявлены выше
    //when continue statement is hit, the iteration expression still runs
    //The labeled varieties are needed only in situations where you have a nested loop
    //The switch statement can evaluate integer primitive types that can be implicitly cast to an int (those types are byte, short, int, char)
    //when you have exception hierarchy you should use the most precise exception to inherit from
    //asserts throw AssertionError
    //вторая часть assert должна быть конвертируема в строку assert booleanTest : String.valueOf() compatible
    //javac -source 1.3 OldCode.java
    //компилятор можно запустить под любой версией. Запустив его под версией 1.3 и ниже - он будет воспринимать assert как идентификатор а не зарезервированное слово
    //assert не должен изменять состояние программы, плохо вызывать методы из assert'a
    //Set.remove возвращает boolean
    //if several reference variables refer to the same String without even knowing it, it would be very bad if any of them could change String's value
    //второй аргумент метода String.substring (a1, a2) является 1-based
    //StringBuffer/Builder's methods can be chained
    //When you make a new instance of the class File, you're not yet making an actual file, you're just creating a filename
    //при создании Writer реализаций - автоматически содаються файлы
    //BufferedReader.readLine () возвращает null если больше не осталось данных в потоке
    /*If you are a serializable class, but your superclass is NOT serializable, then any
    instance variables you INHERIT from that superclass will be reset to the values they
    were given during the original construction of the object. This is because the nonserializable
    class constructor WILL run!*/ //!!!!!!!!!
    //transient поля при десериализации получат значения по умолчанию
    //конструкторы сериализируемых классов не вызываються, но вызываються конструкторы их неериализируемых суперклассов
    //If you serialize a collection or an array, every element must be serializable! A single non-serializable element will cause serialization to fail.
/*    Remember that both DateFormat and NumberFormat objects can have
    their locales set only at the time of instantiation. Watch for code that attempts to
    change the locale of an existing instance —no such methods exist*/
    //In general, a regex search runs from left to right, and once a source's character has been used in a match, it cannot be reused.
    //if you have a mismatch between the type specified in your conversion character and your argument, you'll get a runtime exception System.out.format("%d", 12.3); (d - integer)

    //The Locale class is used with DateFormat and NumberFormat to generate a variety of output styles that are language and/or country specific.
    //String.split() allows full regex patterns for tokenizing, but tokenizing is done in one step, hence large data sources can take a long time to process.
    //если мы серриализируем класс у которого есть ссылочное поле, то если класс этого поля не сериализируем то возникнет Exception
    //Readers не имеют метода flush()
    //Console.readPassword() method returns a char[]. Because Strings are not deleted from the heap and those can be found by hackers !!!
    //The setMaximumFractionDigits() applies to the formatting but not the parsing
    //static public равносильно public static !!!!!!
    //%.1f округляет
    //-1 это все единицы
    //z+=z+=z+=z+=z =5 при z=1
    //enum автоматически статические
    //instanceof и cast'ы выдают ошибку компиляции если тип объекта и проверяемый тип в разных иерархиях !!!
    //выбор переопределенного метода происходит при выполнении а перегруженного - на этапе компиляции
    //оператор == не может быть применен к типам в разных иерархиях
    //abstract static несовместимы
    //top level класы могут быть final
    //старые set'ы (не параметризированные) выбрасывают ClassCastException если добавить в них элемент, не реализующий Comparable

    //Hashtable не принимает ключи null, HashMap принимают !!!
/*   при перегруженных методах, принимающих аргументы классов разных иерархий -  нельзя вызывать метод с аргументом null, будет ошибка компиляции
     если классы типов аргументов - в одной иерархии - вызоветься метод с наиболее специфичным типом */
    //byte не приводиться неявно в char
    //char не приводиться неявно к short
    //default capacity of java.util.Hashtable is 11!
    /*любые операторы, вызовы размещенные под оператором (throw new smth) или break [label] будут помечены как "unreachable statement"
     и будет ошибка компиляции*/
  /* если наследуемся от класса, конструктор которого бросает checked исключение, необходимо объявить конструктор бросающий такое же исключение
     и у всех конструкторов, вызывающих явно и неявно нонструктор суперкласса*/
    //нельзя ссылаться на переменные объекта перед запуском конструктора суперкласса (но можно вызывать методы полиморфически) !!!
    //при вызове статического метода класса через ссылку на объект класса класса, эта ссылка должна быть инициализирована (хотя бы null)
/*   если в try блоке бросаеться checked исключение, а в finally блоке есть return то исключение в try блоке можно не обрабатывать
    (т.к. все-равно завершение функции произойдет в finally)*/
    //final instance variables can be initialized in initialization blocks, constructors, uninitialized final variables lead compiler error
    //'\u0000' is the default value for a character. It's decimal equivalent is 0.
    //String может использоваться в switch только начиная с 7-й версии JDK !!!
    //в анонимных классах нельзя переопределять конструкторы
    //include is not a keyword
    //public static void sleep(long millis, int nanos) не ждет милисекунды, просто инерементирует millis если nanos >= 500000'
    //add(int index, Object element) of Vector is not synchronized
    //ClassNotFoundException  - checked exception
    //ClassCastException - unchecked exception
    //сдвиги <<, >>, >>> не циклические. >>> всегда заменяет крайний левый бит на ноль (давая тем самым положительные значения). Бит который появляеться с левого края зависит от знака числа
    //FileReader при создании сразу проверяет существует ли файл
    //File имеет методы mkdir, mkdirs для создания папок. mkdir - создание одной папки, mkdirs - создание дерева папок
    //Math.round, ceil, floor
    //отслеживать static и not static методы с override-compatible сигнатурами, not static метод не может переопределять static методы и наоборот, это compile-time error
    //при обращении к статической переменной класса, если она по факту принадлежит его суперклассу - то это класс может не загрузиться (не выполниться его статическая инициализация)
    //garbage collector runs in daemon thread
    //servlet's загружаеться сначала в тестовом режиме (для проверки), потом в боевом
    //int i = 0; i = i++ даст ноль
    //метод start() у Thread - не final, его можно переопределять
    //String.toString() возвращает this
    //можно набирать строку символами ("\u0048\u0049")
    //FUCKING Float has constructor with double argument (new Float (1.0d) is valid) !!!
    //modifying operations with StringBuffer return StringBuffer itself - because builders/buffers are supposed to be chained !!!!!
    //throwing exception can replace need of return statements
    //any comparing operations with Float.NaN, Double.NaN lead to false
    //Void is not a wrapper class
    //For each instance of the outer class, there can exist many instances of a non-static inner class
    //Collection.retainAll(Collection c) удаляет все объекты из коллекции которых нет в коллекции - аргументе
    //вызывать clone() необходимо через ссылку на класс, который переопределил clone() как public
    //Boolean не наследует Number
    //при инициализации переменных класса, нельзя использовать поля объявленные ниже - ошибка компилятора
    //Throwable - это класс
    //String.toUpperCase, trim, substring(0), substring(0,length()), replace('t','t') вернут this если нечего изменять
    //('\_u000A') - line feed, нельзя использовать в строковых литералах, использовать надо \n \r, нельзя даже в комментариях писать такое
 /* final переменная рассматриваеться как числовой литерал а для литералов выполняеться неявное приведение.
    например
    private final int i = 10;
    private byte k = i;*/ //!!!!!!!!!!!!
    /*проверка наличия привязки native методов происходит в runtime, компиляция пройдет успешно,
    но если в runtime не окажеться соответствующй реализации в библиотеке - выброситься исключение*/
    //String.startsWith(""), endsWith("") всегда возвращает true
    //StringBuffer/Builder do not override equals(), hashCode() because they are mutable
    //методы в интерфейсах не могут быть native, synchronized
    //(0.0 == -0.0) is true
    //абстрактные классы могут иметь конструкторы
    //начиная с 8-й Java, интерфейсы могут иметь статические методы с телами
    //если в finalize() возникнет Runtime exception то оно игнорируеться но объект не удаляеться сборщиком мусора
    //daemon ThreadGroup могут содержать пользовательские потоки, группа уничтожаеться, когда все потоки завершены
    //super.super is not allowed
    //~i = (- i) – 1
    //.class нельзя использовать с параметризированными типами !!!
    //следить за уровнем доступа методов интерфейса, имплементируемых классами
    //метод join - не static
    //Thread.yield() - статический метод
/*  StringBuffer initial capacity is 16. The capacity of newly created StringBuffer is (16+length of the string, that buffer contains).
    further appendages could double the size of the buffer in case append string argument can't fit into the buffer capacity */
    //Math.floor, ceil возвращают float
    //Weather a higher priority thread gets CPU time than a lower priorty thread is platform dependent and cannot be certain
    //при вызове wait(), программа будет ждать, что кто-то вызовет notify() на том же объекте
    //strictfp can by applied to class or method
    //type of aprimitive array can’t be changed to another primitive type by a cast !!!
    //int[] i = new byte[3] - WRONG, Class[] o = new SubClass[3] - CORRECT !!!

    //If the anonymous class extends another class then the class instance creation expression can include parameters.
    //wait(), notify() notifyAll() должны вызываться только из synchronized блоков, иначе будет IllegalMonitorStateException
    /* в случае когда несолько операторов инкремента/декремента присутствуют в выражении, значения переменных изменяються динамически
    ..т.е. в выражении y = x++ + ++x во второй части x уже будет изменен и второй инкремент будет уже над измененной переменной*/
    //результат тернарного оператора определяеться в runtime в зависимости от типов аргументов. Определение типа происходит как и в обычном выражении.
    //область видимости конструкторов по умолчанию определяеться видимостью их классов
    //компилятор не кастит возвращаемые типы методов, возвращаемых параметризированный тип
    //нельзя иметь 2 метода принимающих один множество объектов класса а другой - массив объектов класса
    //множество String... должно идти последним аргументом в объявлении метода

    //Servlets
    //HttpServletRequest, ServletRequest, Servlet - интерфейсы
    //HttpServlet, GenericServlet - абстрактные классы
    //HttpServlet extends GenericServlet
    //параметры в HTTP запросе отделяються амперсандом
    //аннотации для декларирования веб компонентов не избавляют от необходимости иметь дескриптор web.xml
    //Servlet, ServletRequest, HttpServletRequest are interfaces
    //sendRedirect() of HttpServletResponse используеться для перенаправления запроса на другой URL
    //запись в лог сервлета возможна методами log(message), getServletContext().log(message);
    //HttpServletRequest.getServletPath() - путь текущего запроса к веб-серверу
    //длительность сесси можно установить так : прописать в web.xml тег <session-timeout>, использовать метод session.setSessionTimeout
    //ServletContext, HttpSession, ServletRequest имеют методы getAttribute() и setAttribute()
    //при указании <url-pattern>*.go</url-pattern>  - Сервлет-контейнер будет искать первый подходящий сервлет по меппингу
    /*не параметризированный метод может переопределять параметризированный, но
    не параметризированный метод не может быть переопределен параметризированным */

    //при возвращении методом ссылки на приватный объект класса - всегда лучше возвращать копию (например копию инкапсулированного списка)
    //если в самодельном контейнере не нейден компонент - лучше возвращать null, а не бросать исключение, т.к. лучше обойтись без try{} catch{}

    //JSP
    /*  JSP files are compiled the first time they are accessed by default
    but they can be compiled ahead of time (ie precompiled) using application server tools/settings or by writing your own script*/
    /*DECLARATION Elements ends up in the generated Servlet as an INSTANCE variable, not within the body of the _jspservice() method.
    Ensure their access is either read-only or synchronized.
    <%! Calendar c = Calendar.getInstance(); %>*/
    /*EXPRESSION Element: is the embedded Java expression, which gets evaluated by the service method.
    <%= new Date()%>*/
    /*SCRIPTLET Elements: are the embedded Java statements, which get executed as part of the service method.
    (Note: Not recommended to use Scriptlet elements because they don't provide reusability and maintainability.
    Use custom tags (like JSTL, JSF tags, etc) or beans instead).
    Variables declared inside the scriplets have the local scope and not shared*/
    /*ACTION Elements: A JSP element that provides information for execution phase.*/
    /*Directive Elements: A JSP element that provides global information for the translation phase.*/
    //forward () перенаправляет запрос на другой сервлет, не уведовляя клиента. Передает параметры запроса
    //sendRedirect() уведомляет клиента, но параметры запроса теряються т.к. браузер перенаправляеться на абсолютно другую страницу
    /*Certain objects that are available for the use in JSP documents without being declared first.
    These objects are parsed by the JSP engine and inserted into the generated servlet.
    The implicit objects are listed below:
    request, response, pageContext, session, application, out, config, page, exception*/
    //JSPs can be thread-safe by having them implement the SingleThreadModel interface. <%@ page isThreadSafe="false" %>
    //Custom tags with attribute could be used to print database selection
    /*    You cannot use a semicolon to end an expression.
    <%= (new java.util.Date()).toLocaleString() %> - хороший пример */

    //JDBC
    //5 уровней изоляции транзакций: TRANSACTION_NONE, TRANSACTION_READ_COMMITTED, TRANSACTION_READ_UNCOMMITTED, TRANSACTION_REPEATABLE_READ, TRANSACTION_SERIALIZABLE
    //параметров относящиеся к типам PreparedStatement : IN, OUT, INOUT

    //SQL
    //Нельзя использовать агрегат агрегата
    //кортеж и запись - синонимы
    //нельзя использовать агрегат агрегата
    //AND имеет более низкий приоритет по сравнению с &
/*  Приоритет операторов :
    1. Унарные '+' и '-'
    2. Умножение (*), деление (/)
    3. Сложение (+), вычитание(-)
    4. =, <>, <, >, <=, >=, BETWEEN, IN, LIKE, IS NULL
    5. NOT
    6. AND
    7. OR*/
    //AND имеет больший приоритет, нежели OR;


    public static void main(String[] args) {

    }
}

//написать собственный тег for-each
class TryMe {
    public static void main(String args[]) {
        Queue<String> q = new PriorityQueue<String>();
        q.add("3");
        q.add("1");
        q.add("2");
        System.out.print(q.poll() + " ");
        System.out.print(q.peek() + " ");
        System.out.print(q.peek());
    }
}