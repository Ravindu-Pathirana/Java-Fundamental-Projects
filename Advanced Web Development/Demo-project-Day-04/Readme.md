ORM stands for Object-Relational Mapping.

It is a technique/framework that lets you work with a database using Java objects instead of writing SQL manually.

⸻

✅ Simple idea

Instead of doing this (SQL):
```
INSERT INTO student (id, name) VALUES (1, 'Ravindu');
```
You do this (Java):
```
Student s = new Student(1, "Ravindu");
studentRepository.save(s);
```
ORM will automatically convert the Java object into SQL queries.

⸻

✅ What ORM does for you

✔ Maps a Java class → Database table
✔ Maps class fields → table columns
✔ Automatically handles CRUD operations
(Create, Read, Update, Delete)

⸻

✅ Example mapping
```
@Entity
public class Student {
@Id
private int id;
private String name;
}
```
This becomes a table like:

id	name
1	Ravindu


⸻

✅ ORM in Spring Boot

In Spring Boot, the most common ORM framework is:

✅ Hibernate (used through Spring Data JPA)

⸻

If you want, I can also explain JPA vs Hibernate vs ORM in a very simple way.