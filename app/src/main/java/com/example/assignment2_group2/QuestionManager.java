package com.example.assignment2_group2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionManager {

    private List<Question> questions;
    private int currentIndex;

    public QuestionManager() {
        questions = new ArrayList<>();
        loadQuestions();
        // shuffle the questions
        Collections.shuffle(questions);
        // Limit questions to 5 per play but can change if wanted by user in settings
        if (questions.size() > 5) {
            questions = new ArrayList<>(questions.subList(0, 5));
        }
        currentIndex = 0;
    }

    private void loadQuestions() {
        // Question 1: Easy - Missing semicolon
        List<String> options1 = new ArrayList<>();
        options1.add("Missing semicolon at the end of the statement.");
        options1.add("Incorrect use of double quotes.");
        options1.add("Missing import for System.");
        options1.add("Incorrect method name.");
        options1.add("Extra semicolon present.");
        options1.add("No error exists.");
        options1.add("Incorrect capitalization of 'System'.");
        options1.add("Missing parentheses around the argument.");
        options1.add("Semicolon not required in Java.");
        options1.add("None of the above.");
        questions.add(new Question(
                "System.out.println(\"Hello World\")",
                options1,
                0  // Correct answer: Missing semicolon.
        ));

        // Question 2: Medium - Array index out of bounds
        List<String> options2 = new ArrayList<>();
        options2.add("Array size is too small.");
        options2.add("Array index out of bounds.");
        options2.add("Incorrect declaration of the array.");
        options2.add("Array should be initialized with values.");
        options2.add("Using 'numbers' instead of 'numbers[]' in assignment.");
        options2.add("Missing semicolon at the end.");
        options2.add("Invalid array index.");
        options2.add("Runtime error due to index mismatch.");
        options2.add("No error in code.");
        options2.add("None of the above.");
        questions.add(new Question(
                "int[] numbers = new int[5];\nnumbers[5] = 10;",
                options2,
                1  // Correct answer: Array index out of bounds.
        ));

        // Question 3: Medium-Hard - Assignment instead of comparison
        List<String> options3 = new ArrayList<>();
        options3.add("Missing semicolon after if statement.");
        options3.add("Assignment operator used instead of comparison operator.");
        options3.add("Incorrect method signature for main.");
        options3.add("Variable x is not declared.");
        options3.add("Brackets missing in the if block.");
        options3.add("Error in the printing statement.");
        options3.add("Wrong package declaration.");
        options3.add("No error in code.");
        options3.add("Return type of main is incorrect.");
        options3.add("None of the above.");
        questions.add(new Question(
                "public class Test {\n    public static void main(String[] args) {\n        int x = 10;\n        if(x = 5) {\n            System.out.println(\"x is 5\");\n        }\n    }\n}",
                options3,
                1  // Correct answer: Assignment operator used instead of comparison operator.
        ));

        // Question 4: Hard - Comparing strings with '=='
        List<String> options4 = new ArrayList<>();
        options4.add("Using equals() method instead of '==' for string comparison.");
        options4.add("Using '==' operator to compare string contents.");
        options4.add("Missing semicolon after variable declaration.");
        options4.add("Incorrect instantiation of string object.");
        options4.add("No error; code works correctly.");
        options4.add("Misplaced if statement.");
        options4.add("Incorrect main method signature.");
        options4.add("Missing import for String.");
        options4.add("String objects should be declared final.");
        options4.add("None of the above.");
        questions.add(new Question(
                "public class Example {\n    public static void main(String[] args) {\n        String s1 = \"Hello\";\n        String s2 = new String(\"Hello\");\n        if(s1 == s2) {\n            System.out.println(\"Equal\");\n        } else {\n            System.out.println(\"Not Equal\");\n        }\n    }\n}",
                options4,
                1  // Correct answer: Using '==' operator to compare string contents.
        ));

        // Question 5: Hard - Unintended semicolon in for loop
        List<String> options5 = new ArrayList<>();
        options5.add("Missing braces for the for loop.");
        options5.add("Unintended semicolon after the for loop header.");
        options5.add("Incorrect loop condition.");
        options5.add("Loop variable is not incremented.");
        options5.add("Print statement should be inside the loop.");
        options5.add("For loop is not required.");
        options5.add("Extra block after the loop.");
        options5.add("Syntax error in the loop declaration.");
        options5.add("Missing semicolon after System.out.println.");
        options5.add("None of the above.");
        questions.add(new Question(
                "public class LoopTest {\n    public static void main(String[] args) {\n        for(int i = 0; i < 10; i++);\n        {\n            System.out.println(\"Iteration\");\n        }\n    }\n}",
                options5,
                1  // Correct answer: Unintended semicolon after the for loop header.
        ));

        // Question 6: Easy - Incorrect capitalization for System
        List<String> options6 = new ArrayList<>();
        options6.add("Incorrect capitalization of 'System'.");
        options6.add("Missing semicolon.");
        options6.add("Incorrect method name.");
        options6.add("Missing parentheses.");
        options6.add("No error exists.");
        options6.add("Extra bracket present.");
        options6.add("Wrong package name.");
        options6.add("Using single quotes instead of double quotes.");
        options6.add("System should be imported.");
        options6.add("None of the above.");
        questions.add(new Question(
                "system.out.println(\"Test\");",
                options6,
                0  // Correct answer: Incorrect capitalization of 'System'.
        ));

        // Question 7: Medium - Missing return statement in a non-void method
        List<String> options7 = new ArrayList<>();
        options7.add("Missing return statement in the method.");
        options7.add("Incorrect method name.");
        options7.add("Wrong parameter type.");
        options7.add("Extra semicolon.");
        options7.add("No error exists.");
        options7.add("Missing brackets.");
        options7.add("Unreachable code detected.");
        options7.add("Incorrect variable declaration.");
        options7.add("Return type is void.");
        options7.add("None of the above.");
        questions.add(new Question(
                "public int add(int a, int b) {\n    int sum = a + b;\n}",
                options7,
                0  // Correct answer: Missing return statement.
        ));

        // Question 8: Medium - Infinite loop due to wrong loop condition
        List<String> options8 = new ArrayList<>();
        options8.add("Infinite loop because the condition is always true.");
        options8.add("Syntax error in the loop declaration.");
        options8.add("Incorrect increment operator.");
        options8.add("Missing break statement.");
        options8.add("Loop variable not declared.");
        options8.add("Array index out of bounds.");
        options8.add("Extra semicolon causing empty loop.");
        options8.add("Incorrect use of assignment operator.");
        options8.add("No error exists.");
        options8.add("None of the above.");
        questions.add(new Question(
                "public class LoopExample {\n    public static void main(String[] args) {\n        for(int i = 0; i >= 0; i++) {\n            System.out.println(i);\n        }\n    }\n}",
                options8,
                0  // Correct answer: Infinite loop because condition is always true.
        ));

        // Question 9: Hard - Null pointer exception risk
        List<String> options9 = new ArrayList<>();
        options9.add("Calling a method on a null reference.");
        options9.add("Incorrect string comparison.");
        options9.add("Array index out of bounds.");
        options9.add("Missing semicolon.");
        options9.add("Uninitialized variable.");
        options9.add("Division by zero.");
        options9.add("Incorrect type casting.");
        options9.add("Invalid use of static.");
        options9.add("Incorrect method override.");
        options9.add("None of the above.");
        questions.add(new Question(
                "public class Test {\n    public static void main(String[] args) {\n        String s = null;\n        System.out.println(s.length());\n    }\n}",
                options9,
                0  // Correct answer: Calling a method on a null reference.
        ));

        // Question 10: Hard - Incorrect overriding of equals() method
        List<String> options10 = new ArrayList<>();
        options10.add("Incorrect method signature for equals().");
        options10.add("Missing return statement in equals().");
        options10.add("Using '==' instead of equals().");
        options10.add("Missing hashCode() implementation.");
        options10.add("Extra parameter in equals().");
        options10.add("Overloading instead of overriding equals().");
        options10.add("No error; code works fine.");
        options10.add("Final method cannot be overridden.");
        options10.add("Incorrect variable declaration.");
        options10.add("None of the above.");
        questions.add(new Question(
                "public class Person {\n    private String name;\n    public boolean equals(Person p) {\n        return this.name.equals(p.name);\n    }\n}",
                options10,
                0  // Correct answer: Incorrect method signature for equals().
        ));

        // Question 11: Medium - Unreachable code after return statement
        List<String> options11 = new ArrayList<>();
        options11.add("Unreachable code detected after a return statement.");
        options11.add("Missing semicolon.");
        options11.add("Incorrect variable type.");
        options11.add("Extra braces.");
        options11.add("No error exists.");
        options11.add("Method is void.");
        options11.add("Missing method parameter.");
        options11.add("Return type is incorrect.");
        options11.add("Misplaced break statement.");
        options11.add("None of the above.");
        questions.add(new Question(
                "public int test() {\n    return 1;\n    System.out.println(\"Unreachable\");\n}",
                options11,
                0  // Correct answer: Unreachable code detected after return.
        ));

        // Question 12: Hard - Duplicate local variable declaration
        List<String> options12 = new ArrayList<>();
        options12.add("Duplicate local variable declaration.");
        options12.add("Missing semicolon.");
        options12.add("Incorrect loop condition.");
        options12.add("Wrong data type.");
        options12.add("Variable is not initialized.");
        options12.add("No error exists.");
        options12.add("Incorrect method call.");
        options12.add("Array index out of bounds.");
        options12.add("Missing return statement.");
        options12.add("None of the above.");
        questions.add(new Question(
                "public class Test {\n    public static void main(String[] args) {\n        int value = 5;\n        {\n            int value = 10;\n            System.out.println(value);\n        }\n    }\n}",
                options12,
                0  // Correct answer: Duplicate local variable declaration.
        ));

        // Question 13: Hard - Generic type mismatch
        List<String> options13 = new ArrayList<>();
        options13.add("Cannot add an Integer to a List<String>.");
        options13.add("Incorrect use of generics.");
        options13.add("Missing type parameter in ArrayList.");
        options13.add("Invalid cast exception.");
        options13.add("Syntax error in generic declaration.");
        options13.add("Array index out of bounds.");
        options13.add("Type erasure error.");
        options13.add("No error exists.");
        options13.add("Raw type usage error.");
        options13.add("None of the above.");
        questions.add(new Question(
                "List<String> list = new ArrayList<>();\nlist.add(10);",
                options13,
                0  // Correct answer: Cannot add an Integer to a List<String>.
        ));

        // Question 14: Hard - Reference to non-static variable in a static context
        List<String> options14 = new ArrayList<>();
        options14.add("Cannot reference non-static variable from a static context.");
        options14.add("Missing semicolon.");
        options14.add("Incorrect variable type.");
        options14.add("Method should be static.");
        options14.add("Extra parameter in method call.");
        options14.add("No error exists.");
        options14.add("Incorrect loop declaration.");
        options14.add("Null pointer exception.");
        options14.add("Type mismatch error.");
        options14.add("None of the above.");
        questions.add(new Question(
                "public class Test {\n    public int x = 5;\n    public static void main(String[] args) {\n        System.out.println(x);\n    }\n}",
                options14,
                0  // Correct answer: Cannot reference non-static variable from a static context.
        ));

        // Question 15: Hard - Final method cannot be overridden
        List<String> options15 = new ArrayList<>();
        options15.add("Final method cannot be overridden.");
        options15.add("Missing semicolon.");
        options15.add("Incorrect class declaration.");
        options15.add("Variable type mismatch.");
        options15.add("Incorrect constructor usage.");
        options15.add("Overloading instead of overriding.");
        options15.add("Missing return statement.");
        options15.add("Abstract method not implemented.");
        options15.add("Syntax error in method signature.");
        options15.add("None of the above.");
        questions.add(new Question(
                "public class A {\n    public final void show() {}\n}\npublic class B extends A {\n    public void show() {}\n}",
                options15,
                0  // Correct answer: Final method cannot be overridden.
        ));
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getCurrentQuestion() {
        if (!questions.isEmpty()) {
            return questions.get(currentIndex);
        }
        return null;
    }

    public void goToNext() {
        if (currentIndex < questions.size() - 1) {
            currentIndex++;
        }
    }

    public void goToPrevious() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}
