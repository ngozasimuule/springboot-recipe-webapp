# springboot-recipe-webapp

1. Import File into Intellij Idea after Downloading and extracting zip file.

   N.B: Technologies used: Maven, Spring Boot Initialliser, Intellij Idea, Java, MySql in MySql Workbench.

2. MOCK DATA for MySql Queries to add to MySql Workbench to help operate CRUD Operations:

a) INSERT THE 'INSERT INTO' QUERY PLUS THE 'ALTER TABLE' QUERY IN ONE FILE/ ON SAME TAB IN MYSQL WORKBENCH TO EXECUTE QUERY AND HELP SEE DATA IN BROWSER. PLEASE SEE        QUERIES BELOW: 

INSERT INTO `recipes` VALUES 
(1,' Content goes here','2022-07-18 10:45:18.617432','In this blog post, you will important OOPS concepts in Java with examples','OOPS Concepts in Java','2022-07-18 10:45:18.617561','2022-07-18 10:45:18.617561','oops-concepts-in-java' ),
(2,' Content goes here','2022-07-18 10:45:18.630278','In this blog post, you will learn about Variables in Java with examples','Variables in Java','2022-07-18 10:45:18.630297','2022-07-18 10:45:18.617561','variables-in-java'),
(3,' Content goes here','2022-07-18 10:45:18.632620','In this blog post, you will learn about Primitive Data Types in Java with examples','Primitive Data Types in Java','2022-07-18 10:45:18.632632','2022-07-18 10:45:18.617561','variables-in-java'),
(4,' Content goes here','2022-07-18 10:45:18.634347','In this blog post, you will learn about Access Modifiers in Java with examples','Access Modifiers in Java','2022-07-18 10:45:18.634357','2022-07-18 10:45:18.617561','variables-in-java'),
(5,' Content goes here','2022-07-18 10:45:18.635878','In this blog post, you will learn about Arrays in Java with examples','Arrays in Java','2022-07-18 10:45:18.635889','2022-07-18 10:45:18.617561','arrys-in-java'),
(6,' Content goes here','2022-07-18 10:45:18.634347','In this blog post, you will learn about Access Modifiers in Java with examples','Access Modifiers in Java','2022-07-18 10:45:18.634357','2022-07-18 10:45:18.617561','access-modifiers-in-java');


ALTER TABLE `recipes` 
CHANGE `name` `name` VARCHAR(50) CHARACTER 
SET latin1 COLLATE latin1_swedish_ci NULL;





