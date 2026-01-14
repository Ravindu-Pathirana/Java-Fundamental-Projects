🔹 Java Exception Handling (Simple Explanation)

Exception handling in Java is a way to handle errors so that your program doesn’t crash suddenly.

👉 It allows the program to continue running or fail gracefully when an error occurs.

⸻

🧠 What is an Exception?

An exception is an unexpected problem during program execution.

Examples:
• Dividing by zero
• Accessing an invalid array index
• File not found

```
int x = 10 / 0;   // ArithmeticException
```

⸻

🛠 Why Exception Handling is Important
• Prevents program crash ❌
• Improves program reliability ✅
• Separates error-handling code from normal logic
• Helps in debugging

⸻

🔑 Keywords Used in Exception Handling

Keyword Purpose
try Code that may cause an exception
catch Handles the exception
finally Always executes (optional)
throw Manually throw an exception
throws Declare exceptions

⸻

💻 Simple Example

```
try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Program finished");
}
```

Output:

```
Cannot divide by zero
Program finished
```

⸻

📌 How It Works (Steps) 1. Code inside try is executed 2. If an error occurs → exception is thrown 3. catch block handles the error 4. finally block runs (optional)

⸻

🆚 Checked vs Unchecked Exceptions

Type Example Checked at Compile Time
Checked IOException ✅ Yes
Unchecked NullPointerException ❌ No

⸻

📝 One-Line Exam Answer

Java exception handling is a mechanism to handle runtime errors and prevent abnormal program termination.

If you want, I can also:
• Explain exception hierarchy with diagram
• Give exam-oriented short notes
• Show custom exception examples
