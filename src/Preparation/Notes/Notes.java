package Preparation.Notes;


import java.util.PriorityQueue;
import java.util.Queue;

public class Notes {
    //����������� ����� ���� �� package statement
    //������� ����� �������������� ���������� �������� ����������� ��� ����������
    /*������ ���������� ����� � ��� ������, ����� �������� ��������� � ������� ��� ��������� ������������.
     ��������, "(String) new Long(1)".
     � ��������� ������� ������������� �������� �������������� �� ����� ����������.*/
    //��� ����� ������ ������ ����������� super.getI() �� ���������� ��������������� ����������� ������ � ����������� ������ ������ �����������
    //������� �� �������� �������� ������������� ������������
    //� ������ source ����� ������ ��� ������ ����� � ������ �������
    //��� ���������� �������� � bucket collection �� �� ��������� - ���� ��������� IllegalArgumentException
    //����� Preferences !!! ������ ������ ����� ��������� ��������� !!!
    //CloneNotSupportedException �������������� ����� ����� �� ��������� Cloneable. CloneNotSupportedException ��������� checked !!!
    //when the remainder operation returns a nonzero result, it has the same sign as its left operand.
    //������ ���������� ��� ������������ CHECKED ���������� �� try ������, ��� ����� ���������� �� ����� ���������� � ��������
    //� enum ������ this
    //� static'�� ������� �� ����� ���� ������� ��������� this
    //�� ����� ���� ����������� ��������� �������
    //sleep(), wait(), join() ������ ���� �������� try/catch ������ !!!!!!!
    //notify/notifyAll �� ��������� ����������, ���������� ��������� �� ������ �� ������������������� �����
    //����� wait() �� ��������������������� ����� ������� IllegalMonitorStateException
    //null ����������� �� �����
    //���������� �������, �� ����������
    //������ � ����������� ������������� ����������� public static
    //� ������ ������ ���������� ������� ����� �������
    //���������� ������������� ������ �� ����� ��������� static �����, �� ����� ��������� ��������� static final
    //��������� ������ �� ����� ������������ ���������� ������, �� ����� ������������ ��������� final ������, ����������� ����� ����������� ������
    //� Generic's �� ��������� ����������� �� ����������������� ����
    //List<List<Integer>> table = new ArrayList<ArrayList<Integer>>(); ������ ����������
    //��������� �������� ������ ������� ���������� � ���
    //���������� � ����������� � ������� ���������
    //� TreeSet ����� �������� ��������, �� ���� ��� �� ��������� Comparable - ��������� RunTime Exception
    //�������� ���������� �� ����� ���������� � ����
    //����������� �� ����� ���� final, static, abstract, ����� ����� ����� ����������� �������
    //������������ �� ����� ���� ��������� � ������ !!!
    //������������ - ��� ����� � ������������� ���-��� ��������� �����������, ������� ����� ���� ���������� �������, �������� ���������� �������
    //JVM �������� ������ ��� �������� �� ����� ������������� � �� ����������, ������� ������ ��������� ������ ������� ��� ���������� int[4] ar
    //volatile ������� ����������� �� ���������� ���������� ��� ������� ������, � ������ ����� �������� �� ������
    //� ������� ������ ���� ���� ���� �������
    //���������� �������������� �������� ��� �������� ����� ��������, �� ���� ����������� ������� ������ � RunTime
    //����������������� ����� ������ �������������� ������ (public, protected, package)
    //���������������� ������ ����� �������� ������������ ��� �� ��������� (�.�. �� ��� �������������� �� ���������)
    //� ��������� ��������� ���� ������ � ������ �������� ����� ���������� ���, �� � ��������� �������� ����� ������ �� ���� !!!!
    //(null instanceof Object) false
    //super ������ ������������� � wildcard
/*  ���� ��������� ����������������� � ? super SomeClass, �� � ��������� ����� ��������� ������� ����� �������
    � ���������� ������ ��� � ��������� ���������� ������� Object, ������ �������� ��� Integer i = collection.pollFirst() ��������*/
    //����������� �� ����������������� �� ����, ����. ������
    //����� �������������� ������ ���������� �� ����� ���������� �� ��������� ���� ������ !!!
    //����� ����������������� ������ ���������� � runtime �� ��������� ������������ ���� �������
    //� ������ ������� ������������ ���� ��� ������ ������������ ����� super() ��� this(). ���������� ������������� ����������� super()
    //��������� �����. �������� � �������������� ����������� - ������ int !!!
    //compound operators (+=, -=, *= ...) will all put in an implicit cast
    //��������� ���������� �� �������������� ��������, ���� null, ������� �� ������ ������������ ����� ��������������
    /*������ ������ � ����� ������� ��������� ������ �� ������ ������ ���������� int[] != byte[].
    �� ����� ������ �� ����� �������� ������ ��������� ������ �� ������ �������� ��������� Object[] i = new Long[3];*/

    //When you assign an array to a previously declared array reference, the array you're assigning must be the same dimension as the reference you're assigning it to
    //Wrapper ������ immutable
    //� ������� ���� �����������, ����������� ��������� ������� ���������� (Integer i2 = Integer.valueOf("101011", 2))
    //����� �������� ��� ���������� �������� � �������� ����� �������� !!!
    //������� � ����� : Boolean, Byte, Character (from \u0000 to u007f), Short, Integer and FUCKING LONG (not mentioned in JLS) !!!
    //��� ������ �������������� ������ JVM ���������� ����� � ���������� ���������� ������� ���� ���������
/*    Java 5's designers decided that the most important rule should be that preexisting
    code should function the way it used to, so since widening capability already existed,
    a method that is invoked via widening shouldn't lose out to a newly created method
    that relies on boxing*/
    //widening beats boxing
    //widening beats var-args
    //boxing beats vararg
    //������� �� ������������
    //�.�. Short �� ����������� � Integer
/*    ���������� ��� ������ ������������� ������� ������� ����������� ���������� � ������ ������� ��� ������ ������,
    � ����� ���������, ��������� �� ���������� ������� �������� ��������� ������ (is-a)*/
    //Runtime object provides a mechanism for communicating directly with JVM
    //For any given object, finalize() will be called only once (at most) by the garbage collector

    //Calling finalize() can actually result in saving an object from deletion.
    //Wrapper constructors can take a String or a primitive, except for Character, which can only take a char.
    //Byte b = 200 compilation fails
    //��� ������ �������������� ������ �� ���������� ��������� ������� ��������� int x = 7; test(short); {} test(x) - compilation fails
    /*The instanceof operator can be used only to test objects (or null) against class types that are in the same class hierarchy.*/

    //instanceof �� ����� ���� ����������� � ������������������� ������, instanceof Set<Integer> - ������ ����������
    //instanceof �� ����� ���� ����������� � ������ �����������, instanceof T - ������ ����������
    /*���� ������������ ���������������� ���������� ����� ���� �� ���������� ���������� !!!, �� ���������� ����������������� � ����� ��������� ����������
    ���� ��������� ���������� ���� ������ ���������� ��� ������������ - �� �������� �������� ���������� ���-�� ������������������ �������*/
    //� switch ����� ������ byte, short, int, String ... long �������� � ������ ����������
    /*The case constant must be a literal or FINAl variable that is assigned to literal, or a constant
    expression, including an enum. You cannot have a case that includes a nonfinal
    variable, or a range of values.*/
    //The compiler will stop you from defining catch clauses that can never be reached. !!!
    //String methods use zero-based indexes, except for the second argument of substring().
    //When the JVM finds a String literal, it is added to the String literal pool. !!!!!!!!!! ������� ������������ ��� ������ ������ String
    //Strings have a method: length(); arrays have an attribute named length.
    //File objects can represent either a file or a directory.
/*    Classes in java.io are designed to be "chained" or "wrapped." (This is a common use of the decorator design pattern.)*/
    //Console objects can read non-echoed input and are instantiated using System.console().
    //A Date is stored as a long, the number of milliseconds since January 1, 1970.
    //The String.split() method tokenizes the entire source data all at once, so large amounts of data can be quite slow to process.
    //The Scanner class allows you to tokenize data from within a loop, which allows you to stop whenever you want to.
    //The Scanner class allows you to tokenize Strings or streams or files.
    //method scope and static scope ain't the same static int x = 10; for(int x=0;x<5;x++){ 5. } is normal
    //��������� ������ ������ �������� ����� ����� �������� "." ��� �������� ������ � ���� �� ������ (� ������ main ��������) !!!
    //��� ������������� assert ��� ��������������� � ���������� ��� �������� ���� 1.4 - ��������� �������������� ����������
    //� ������� for ����� ������������ ����������� ����� ����������, � for-each - ������
    //� catch ����� ������ ��������� ����������, ������� ����� �� ����� ���� ��������� � try ����� - ��� ������ ����������
    //NumberFormatException - �������� IllegalArgumentException
    //finally ���� ����� �� �����������, �������� ���� � ��� ��������� �� �������������� RuntIme Exception !!!
    //������������ ����� - �� ����� �� � ��������� ������, ���� �������� ���������� �� ����� ���������� ������
    //�������� - ���� ����� � ������ �� ���������
    //��������� ��������������� ����� ������� �� ���������, ���� �� ��������� ������, ��� ���� ���������� � ������� ������������
    //���� ���� �� ��������� ��������� - String, �������� + ��������� ������������
    //Java law decrees that an else clause belongs to the innermost if statement to which it might possibly belong
    //shortcircuit operator compares whole part before and after the operator
    //in "case x :" it's allowed only to use a constant or final variable that is assigned a literal value

    //it's illegal to have more than one "case" label using the same value;
    //���������� � ���������� ��������� while ����� ������ ���� ��������� ����
    //when continue statement is hit, the iteration expression still runs
    //The labeled varieties are needed only in situations where you have a nested loop
    //The switch statement can evaluate integer primitive types that can be implicitly cast to an int (those types are byte, short, int, char)
    //when you have exception hierarchy you should use the most precise exception to inherit from
    //asserts throw AssertionError
    //������ ����� assert ������ ���� ������������� � ������ assert booleanTest : String.valueOf() compatible
    //javac -source 1.3 OldCode.java
    //���������� ����� ��������� ��� ����� �������. �������� ��� ��� ������� 1.3 � ���� - �� ����� ������������ assert ��� ������������� � �� ����������������� �����
    //assert �� ������ �������� ��������� ���������, ����� �������� ������ �� assert'a
    //Set.remove ���������� boolean
    //if several reference variables refer to the same String without even knowing it, it would be very bad if any of them could change String's value
    //������ �������� ������ String.substring (a1, a2) �������� 1-based
    //StringBuffer/Builder's methods can be chained
    //When you make a new instance of the class File, you're not yet making an actual file, you're just creating a filename
    //��� �������� Writer ���������� - ������������� ��������� �����
    //BufferedReader.readLine () ���������� null ���� ������ �� �������� ������ � ������
    /*If you are a serializable class, but your superclass is NOT serializable, then any
    instance variables you INHERIT from that superclass will be reset to the values they
    were given during the original construction of the object. This is because the nonserializable
    class constructor WILL run!*/ //!!!!!!!!!
    //transient ���� ��� �������������� ������� �������� �� ���������
    //������������ ��������������� ������� �� �����������, �� ����������� ������������ �� ���������������� ������������
    //If you serialize a collection or an array, every element must be serializable! A single non-serializable element will cause serialization to fail.
/*    Remember that both DateFormat and NumberFormat objects can have
    their locales set only at the time of instantiation. Watch for code that attempts to
    change the locale of an existing instance �no such methods exist*/
    //In general, a regex search runs from left to right, and once a source's character has been used in a match, it cannot be reused.
    //if you have a mismatch between the type specified in your conversion character and your argument, you'll get a runtime exception System.out.format("%d", 12.3); (d - integer)

    //The Locale class is used with DateFormat and NumberFormat to generate a variety of output styles that are language and/or country specific.
    //String.split() allows full regex patterns for tokenizing, but tokenizing is done in one step, hence large data sources can take a long time to process.
    //���� �� �������������� ����� � �������� ���� ��������� ����, �� ���� ����� ����� ���� �� ������������� �� ��������� Exception
    //Readers �� ����� ������ flush()
    //Console.readPassword() method returns a char[]. Because Strings are not deleted from the heap and those can be found by hackers !!!
    //The setMaximumFractionDigits() applies to the formatting but not the parsing
    //static public ����������� public static !!!!!!
    //%.1f ���������
    //-1 ��� ��� �������
    //z+=z+=z+=z+=z =5 ��� z=1
    //enum ������������� �����������
    //instanceof � cast'� ������ ������ ���������� ���� ��� ������� � ����������� ��� � ������ ��������� !!!
    //����� ����������������� ������ ���������� ��� ���������� � �������������� - �� ����� ����������
    //�������� == �� ����� ���� �������� � ����� � ������ ���������
    //abstract static ������������
    //top level ����� ����� ���� final
    //������ set'� (�� �������������������) ����������� ClassCastException ���� �������� � ��� �������, �� ����������� Comparable

    //Hashtable �� ��������� ����� null, HashMap ��������� !!!
/*   ��� ������������� �������, ����������� ��������� ������� ������ �������� -  ������ �������� ����� � ���������� null, ����� ������ ����������
     ���� ������ ����� ���������� - � ����� �������� - ���������� ����� � �������� ����������� ����� */
    //byte �� ����������� ������ � char
    //char �� ����������� ������ � short
    //default capacity of java.util.Hashtable is 11!
    /*����� ���������, ������ ����������� ��� ���������� (throw new smth) ��� break [label] ����� �������� ��� "unreachable statement"
     � ����� ������ ����������*/
  /* ���� ����������� �� ������, ����������� �������� ������� checked ����������, ���������� �������� ����������� ��������� ����� �� ����������
     � � ���� �������������, ���������� ���� � ������ ����������� �����������*/
    //������ ��������� �� ���������� ������� ����� �������� ������������ ����������� (�� ����� �������� ������ ��������������) !!!
    //��� ������ ������������ ������ ������ ����� ������ �� ������ ������ ������, ��� ������ ������ ���� ���������������� (���� �� null)
/*   ���� � try ����� ���������� checked ����������, � � finally ����� ���� return �� ���������� � try ����� ����� �� ������������
    (�.�. ���-����� ���������� ������� ���������� � finally)*/
    //final instance variables can be initialized in initialization blocks, constructors, uninitialized final variables lead compiler error
    //'\u0000' is the default value for a character. It's decimal equivalent is 0.
    //String ����� �������������� � switch ������ ������� � 7-� ������ JDK !!!
    //� ��������� ������� ������ �������������� ������������
    //include is not a keyword
    //public static void sleep(long millis, int nanos) �� ���� �����������, ������ �������������� millis ���� nanos >= 500000'
    //add(int index, Object element) of Vector is not synchronized
    //ClassNotFoundException  - checked exception
    //ClassCastException - unchecked exception
    //������ <<, >>, >>> �� �����������. >>> ������ �������� ������� ����� ��� �� ���� (����� ��� ����� ������������� ��������). ��� ������� ����������� � ������ ���� ������� �� ����� �����
    //FileReader ��� �������� ����� ��������� ���������� �� ����
    //File ����� ������ mkdir, mkdirs ��� �������� �����. mkdir - �������� ����� �����, mkdirs - �������� ������ �����
    //Math.round, ceil, floor
    //����������� static � not static ������ � override-compatible �����������, not static ����� �� ����� �������������� static ������ � ��������, ��� compile-time error
    //��� ��������� � ����������� ���������� ������, ���� ��� �� ����� ����������� ��� ����������� - �� ��� ����� ����� �� ����������� (�� ����������� ��� ����������� �������������)
    //garbage collector runs in daemon thread
    //servlet's ������������ ������� � �������� ������ (��� ��������), ����� � ������
    //int i = 0; i = i++ ���� ����
    //����� start() � Thread - �� final, ��� ����� ��������������
    //String.toString() ���������� this
    //����� �������� ������ ��������� ("\u0048\u0049")
    //FUCKING Float has constructor with double argument (new Float (1.0d) is valid) !!!
    //modifying operations with StringBuffer return StringBuffer itself - because builders/buffers are supposed to be chained !!!!!
    //throwing exception can replace need of return statements
    //any comparing operations with Float.NaN, Double.NaN lead to false
    //Void is not a wrapper class
    //For each instance of the outer class, there can exist many instances of a non-static inner class
    //Collection.retainAll(Collection c) ������� ��� ������� �� ��������� ������� ��� � ��������� - ���������
    //�������� clone() ���������� ����� ������ �� �����, ������� ������������� clone() ��� public
    //Boolean �� ��������� Number
    //��� ������������� ���������� ������, ������ ������������ ���� ����������� ���� - ������ �����������
    //Throwable - ��� �����
    //String.toUpperCase, trim, substring(0), substring(0,length()), replace('t','t') ������ this ���� ������ ��������
    //('\_u000A') - line feed, ������ ������������ � ��������� ���������, ������������ ���� \n \r, ������ ���� � ������������ ������ �����
 /* final ���������� ���������������� ��� �������� ������� � ��� ��������� ������������ ������� ����������.
    ��������
    private final int i = 10;
    private byte k = i;*/ //!!!!!!!!!!!!
    /*�������� ������� �������� native ������� ���������� � runtime, ���������� ������� �������,
    �� ���� � runtime �� ��������� �������������� ���������� � ���������� - ����������� ����������*/
    //String.startsWith(""), endsWith("") ������ ���������� true
    //StringBuffer/Builder do not override equals(), hashCode() because they are mutable
    //������ � ����������� �� ����� ���� native, synchronized
    //(0.0 == -0.0) is true
    //����������� ������ ����� ����� ������������
    //������� � 8-� Java, ���������� ����� ����� ����������� ������ � ������
    //���� � finalize() ��������� Runtime exception �� ��� ������������� �� ������ �� ���������� ��������� ������
    //daemon ThreadGroup ����� ��������� ���������������� ������, ������ �������������, ����� ��� ������ ���������
    //super.super is not allowed
    //~i = (- i) � 1
    //.class ������ ������������ � �������������������� ������ !!!
    //������� �� ������� ������� ������� ����������, ���������������� ��������
    //����� join - �� static
    //Thread.yield() - ����������� �����
/*  StringBuffer initial capacity is 16. The capacity of newly created StringBuffer is (16+length of the string, that buffer contains).
    further appendages could double the size of the buffer in case append string argument can't fit into the buffer capacity */
    //Math.floor, ceil ���������� float
    //Weather a higher priority thread gets CPU time than a lower priorty thread is platform dependent and cannot be certain
    //��� ������ wait(), ��������� ����� �����, ��� ���-�� ������� notify() �� ��� �� �������
    //strictfp can by applied to class or method
    //type of aprimitive array can�t be changed to another primitive type by a cast !!!
    //int[] i = new byte[3] - WRONG, Class[] o = new SubClass[3] - CORRECT !!!

    //If the anonymous class extends another class then the class instance creation expression can include parameters.
    //wait(), notify() notifyAll() ������ ���������� ������ �� synchronized ������, ����� ����� IllegalMonitorStateException
    /* � ������ ����� �������� ���������� ����������/���������� ������������ � ���������, �������� ���������� ����������� �����������
    ..�.�. � ��������� y = x++ + ++x �� ������ ����� x ��� ����� ������� � ������ ��������� ����� ��� ��� ���������� ����������*/
    //��������� ���������� ��������� ������������� � runtime � ����������� �� ����� ����������. ����������� ���� ���������� ��� � � ������� ���������.
    //������� ��������� ������������� �� ��������� ������������� ���������� �� �������
    //���������� �� ������ ������������ ���� �������, ������������ ������������������� ���
    //������ ����� 2 ������ ����������� ���� ��������� �������� ������ � ������ - ������ �������� ������
    //��������� String... ������ ���� ��������� ���������� � ���������� ������

    //Servlets
    //HttpServletRequest, ServletRequest, Servlet - ����������
    //HttpServlet, GenericServlet - ����������� ������
    //HttpServlet extends GenericServlet
    //��������� � HTTP ������� ����������� �����������
    //��������� ��� �������������� ��� ����������� �� ��������� �� ������������� ����� ���������� web.xml
    //Servlet, ServletRequest, HttpServletRequest are interfaces
    //sendRedirect() of HttpServletResponse ������������� ��� ��������������� ������� �� ������ URL
    //������ � ��� �������� �������� �������� log(message), getServletContext().log(message);
    //HttpServletRequest.getServletPath() - ���� �������� ������� � ���-�������
    //������������ ����� ����� ���������� ��� : ��������� � web.xml ��� <session-timeout>, ������������ ����� session.setSessionTimeout
    //ServletContext, HttpSession, ServletRequest ����� ������ getAttribute() � setAttribute()
    //��� �������� <url-pattern>*.go</url-pattern>  - �������-��������� ����� ������ ������ ���������� ������� �� ��������
    /*�� ������������������� ����� ����� �������������� �������������������, ��
    �� ������������������� ����� �� ����� ���� ������������� ������������������� */

    //��� ����������� ������� ������ �� ��������� ������ ������ - ������ ����� ���������� ����� (�������� ����� ������������������ ������)
    //���� � ����������� ���������� �� ������ ��������� - ����� ���������� null, � �� ������� ����������, �.�. ����� �������� ��� try{} catch{}

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
    //forward () �������������� ������ �� ������ �������, �� ��������� �������. �������� ��������� �������
    //sendRedirect() ���������� �������, �� ��������� ������� ��������� �.�. ������� ����������������� �� ��������� ������ ��������
    /*Certain objects that are available for the use in JSP documents without being declared first.
    These objects are parsed by the JSP engine and inserted into the generated servlet.
    The implicit objects are listed below:
    request, response, pageContext, session, application, out, config, page, exception*/
    //JSPs can be thread-safe by having them implement the SingleThreadModel interface. <%@ page isThreadSafe="false" %>
    //Custom tags with attribute could be used to print database selection
    /*    You cannot use a semicolon to end an expression.
    <%= (new java.util.Date()).toLocaleString() %> - ������� ������ */

    //JDBC
    //5 ������� �������� ����������: TRANSACTION_NONE, TRANSACTION_READ_COMMITTED, TRANSACTION_READ_UNCOMMITTED, TRANSACTION_REPEATABLE_READ, TRANSACTION_SERIALIZABLE
    //���������� ����������� � ����� PreparedStatement : IN, OUT, INOUT

    //SQL
    //������ ������������ ������� ��������
    //������ � ������ - ��������
    //������ ������������ ������� ��������
    //AND ����� ����� ������ ��������� �� ��������� � &
/*  ��������� ���������� :
    1. ������� '+' � '-'
    2. ��������� (*), ������� (/)
    3. �������� (+), ���������(-)
    4. =, <>, <, >, <=, >=, BETWEEN, IN, LIKE, IS NULL
    5. NOT
    6. AND
    7. OR*/
    //AND ����� ������� ���������, ������ OR;


    public static void main(String[] args) {

    }
}

//�������� ����������� ��� for-each
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