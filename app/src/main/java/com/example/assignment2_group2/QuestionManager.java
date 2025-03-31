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
        // Shuffle the questions
        Collections.shuffle(questions);
        // Limit questions to 5 per play but can be changed by user settings later
        if (questions.size() > 5) {
            questions = new ArrayList<>(questions.subList(0, 5));
        }
        currentIndex = 0;
    }

    private void loadQuestions() {
        // For each question, we prepare the list, record the original correct answer,
        // shuffle the list, and then update the correct answer index.

        // Question 1: Easy - Missing semicolon
        List<String> options1 = new ArrayList<>();
        options1.add("Missing semicolon at the end of the statement."); // originally correct
        options1.add("Incorrect use of double quotes.");
        options1.add("Missing import for System.");
        options1.add("Incorrect method name.");
        options1.add("Extra semicolon present.");
        options1.add("No error exists.");
        options1.add("Incorrect capitalization of 'System'.");
        options1.add("Missing parentheses around the argument.");
        options1.add("Semicolon not required in Java.");
        options1.add("None of the above.");
        int origCorrect1 = 0;
        String correct1 = options1.get(origCorrect1);
        Collections.shuffle(options1);
        int newCorrect1 = options1.indexOf(correct1);
        questions.add(new Question(
                "System.out.println(\"Hello World\")",
                options1,
                newCorrect1
        ));

        // Question 2: Medium - Array index out of bounds
        List<String> options2 = new ArrayList<>();
        options2.add("Array size is too small.");
        options2.add("Array index out of bounds."); // originally correct
        options2.add("Incorrect declaration of the array.");
        options2.add("Array should be initialized with values.");
        options2.add("Using 'numbers' instead of 'numbers[]' in assignment.");
        options2.add("Missing semicolon at the end.");
        options2.add("Invalid array index.");
        options2.add("Runtime error due to index mismatch.");
        options2.add("No error in code.");
        options2.add("None of the above.");
        int origCorrect2 = 1;
        String correct2 = options2.get(origCorrect2);
        Collections.shuffle(options2);
        int newCorrect2 = options2.indexOf(correct2);
        questions.add(new Question(
                "int[] numbers = new int[5];\nnumbers[5] = 10;",
                options2,
                newCorrect2
        ));

        // Question 3: Medium-Hard - Assignment instead of comparison
        List<String> options3 = new ArrayList<>();
        options3.add("Missing semicolon after if statement.");
        options3.add("Assignment operator used instead of comparison operator."); // originally correct
        options3.add("Incorrect method signature for main.");
        options3.add("Variable x is not declared.");
        options3.add("Brackets missing in the if block.");
        options3.add("Error in the printing statement.");
        options3.add("Wrong package declaration.");
        options3.add("No error in code.");
        options3.add("Return type of main is incorrect.");
        options3.add("None of the above.");
        int origCorrect3 = 1;
        String correct3 = options3.get(origCorrect3);
        Collections.shuffle(options3);
        int newCorrect3 = options3.indexOf(correct3);
        questions.add(new Question(
                "public class Test {\n    public static void main(String[] args) {\n        int x = 10;\n        if(x = 5) {\n            System.out.println(\"x is 5\");\n        }\n    }\n}",
                options3,
                newCorrect3
        ));

        // Question 4: Hard - Comparing strings with '=='
        List<String> options4 = new ArrayList<>();
        options4.add("Using equals() method instead of '==' for string comparison.");
        options4.add("Using '==' operator to compare string contents."); // originally correct
        options4.add("Missing semicolon after variable declaration.");
        options4.add("Incorrect instantiation of string object.");
        options4.add("No error; code works correctly.");
        options4.add("Misplaced if statement.");
        options4.add("Incorrect main method signature.");
        options4.add("Missing import for String.");
        options4.add("String objects should be declared final.");
        options4.add("None of the above.");
        int origCorrect4 = 1;
        String correct4 = options4.get(origCorrect4);
        Collections.shuffle(options4);
        int newCorrect4 = options4.indexOf(correct4);
        questions.add(new Question(
                "public class Example {\n    public static void main(String[] args) {\n        String s1 = \"Hello\";\n        String s2 = new String(\"Hello\");\n        if(s1 == s2) {\n            System.out.println(\"Equal\");\n        } else {\n            System.out.println(\"Not Equal\");\n        }\n    }\n}",
                options4,
                newCorrect4
        ));

        // Question 5: Hard - Unintended semicolon in for loop
        List<String> options5 = new ArrayList<>();
        options5.add("Missing braces for the for loop.");
        options5.add("Unintended semicolon after the for loop header."); // originally correct
        options5.add("Incorrect loop condition.");
        options5.add("Loop variable is not incremented.");
        options5.add("Print statement should be inside the loop.");
        options5.add("For loop is not required.");
        options5.add("Extra block after the loop.");
        options5.add("Syntax error in the loop declaration.");
        options5.add("Missing semicolon after System.out.println.");
        options5.add("None of the above.");
        int origCorrect5 = 1;
        String correct5 = options5.get(origCorrect5);
        Collections.shuffle(options5);
        int newCorrect5 = options5.indexOf(correct5);
        questions.add(new Question(
                "public class LoopTest {\n    public static void main(String[] args) {\n        for(int i = 0; i < 10; i++);\n        {\n            System.out.println(\"Iteration\");\n        }\n    }\n}",
                options5,
                newCorrect5
        ));

        // Question 6: Easy - Incorrect capitalization for System
        List<String> options6 = new ArrayList<>();
        options6.add("Incorrect capitalization of 'System'."); // originally correct
        options6.add("Missing semicolon.");
        options6.add("Incorrect method name.");
        options6.add("Missing parentheses.");
        options6.add("No error exists.");
        options6.add("Extra bracket present.");
        options6.add("Wrong package name.");
        options6.add("Using single quotes instead of double quotes.");
        options6.add("System should be imported.");
        options6.add("None of the above.");
        int origCorrect6 = 0;
        String correct6 = options6.get(origCorrect6);
        Collections.shuffle(options6);
        int newCorrect6 = options6.indexOf(correct6);
        questions.add(new Question(
                "system.out.println(\"Test\");",
                options6,
                newCorrect6
        ));

        // Question 7: Medium - Missing return statement in a non-void method
        List<String> options7 = new ArrayList<>();
        options7.add("Missing return statement in the method."); // originally correct
        options7.add("Incorrect method name.");
        options7.add("Wrong parameter type.");
        options7.add("Extra semicolon.");
        options7.add("No error exists.");
        options7.add("Missing brackets.");
        options7.add("Unreachable code detected.");
        options7.add("Incorrect variable declaration.");
        options7.add("Return type is void.");
        options7.add("None of the above.");
        int origCorrect7 = 0;
        String correct7 = options7.get(origCorrect7);
        Collections.shuffle(options7);
        int newCorrect7 = options7.indexOf(correct7);
        questions.add(new Question(
                "public int add(int a, int b) {\n    int sum = a + b;\n}",
                options7,
                newCorrect7
        ));

        // Question 8: Medium - Infinite loop due to wrong loop condition
        List<String> options8 = new ArrayList<>();
        options8.add("Infinite loop because the condition is always true."); // originally correct
        options8.add("Syntax error in the loop declaration.");
        options8.add("Incorrect increment operator.");
        options8.add("Missing break statement.");
        options8.add("Loop variable not declared.");
        options8.add("Array index out of bounds.");
        options8.add("Extra semicolon causing empty loop.");
        options8.add("Incorrect use of assignment operator.");
        options8.add("No error exists.");
        options8.add("None of the above.");
        int origCorrect8 = 0;
        String correct8 = options8.get(origCorrect8);
        Collections.shuffle(options8);
        int newCorrect8 = options8.indexOf(correct8);
        questions.add(new Question(
                "public class LoopExample {\n    public static void main(String[] args) {\n        for(int i = 0; i >= 0; i++) {\n            System.out.println(i);\n        }\n    }\n}",
                options8,
                newCorrect8
        ));

        // Question 9: Hard - Null pointer exception risk
        List<String> options9 = new ArrayList<>();
        options9.add("Calling a method on a null reference."); // originally correct
        options9.add("Incorrect string comparison.");
        options9.add("Array index out of bounds.");
        options9.add("Missing semicolon.");
        options9.add("Uninitialized variable.");
        options9.add("Division by zero.");
        options9.add("Incorrect type casting.");
        options9.add("Invalid use of static.");
        options9.add("Incorrect method override.");
        options9.add("None of the above.");
        int origCorrect9 = 0;
        String correct9 = options9.get(origCorrect9);
        Collections.shuffle(options9);
        int newCorrect9 = options9.indexOf(correct9);
        questions.add(new Question(
                "public class Test {\n    public static void main(String[] args) {\n        String s = null;\n        System.out.println(s.length());\n    }\n}",
                options9,
                newCorrect9
        ));

        // Question 10: Hard - Incorrect overriding of equals() method
        List<String> options10 = new ArrayList<>();
        options10.add("Incorrect method signature for equals()."); // originally correct
        options10.add("Missing return statement in equals().");
        options10.add("Using '==' instead of equals().");
        options10.add("Missing hashCode() implementation.");
        options10.add("Extra parameter in equals().");
        options10.add("Overloading instead of overriding equals().");
        options10.add("No error; code works fine.");
        options10.add("Final method cannot be overridden.");
        options10.add("Incorrect variable declaration.");
        options10.add("None of the above.");
        int origCorrect10 = 0;
        String correct10 = options10.get(origCorrect10);
        Collections.shuffle(options10);
        int newCorrect10 = options10.indexOf(correct10);
        questions.add(new Question(
                "public class Person {\n    private String name;\n    public boolean equals(Person p) {\n        return this.name.equals(p.name);\n    }\n}",
                options10,
                newCorrect10
        ));

        // Question 11: Medium - Unreachable code after return statement
        List<String> options11 = new ArrayList<>();
        options11.add("Unreachable code detected after a return statement."); // originally correct
        options11.add("Missing semicolon.");
        options11.add("Incorrect variable type.");
        options11.add("Extra braces.");
        options11.add("No error exists.");
        options11.add("Method is void.");
        options11.add("Missing method parameter.");
        options11.add("Return type is incorrect.");
        options11.add("Misplaced break statement.");
        options11.add("None of the above.");
        int origCorrect11 = 0;
        String correct11 = options11.get(origCorrect11);
        Collections.shuffle(options11);
        int newCorrect11 = options11.indexOf(correct11);
        questions.add(new Question(
                "public int test() {\n    return 1;\n    System.out.println(\"Unreachable\");\n}",
                options11,
                newCorrect11
        ));

        // Question 12: Hard - Duplicate local variable declaration
        List<String> options12 = new ArrayList<>();
        options12.add("Duplicate local variable declaration."); // originally correct
        options12.add("Missing semicolon.");
        options12.add("Incorrect loop condition.");
        options12.add("Wrong data type.");
        options12.add("Variable is not initialized.");
        options12.add("No error exists.");
        options12.add("Incorrect method call.");
        options12.add("Array index out of bounds.");
        options12.add("Missing return statement.");
        options12.add("None of the above.");
        int origCorrect12 = 0;
        String correct12 = options12.get(origCorrect12);
        Collections.shuffle(options12);
        int newCorrect12 = options12.indexOf(correct12);
        questions.add(new Question(
                "public class Test {\n    public static void main(String[] args) {\n        int value = 5;\n        {\n            int value = 10;\n            System.out.println(value);\n        }\n    }\n}",
                options12,
                newCorrect12
        ));

        // Question 13: Hard - Generic type mismatch
        List<String> options13 = new ArrayList<>();
        options13.add("Cannot add an Integer to a List<String>."); // originally correct
        options13.add("Incorrect use of generics.");
        options13.add("Missing type parameter in ArrayList.");
        options13.add("Invalid cast exception.");
        options13.add("Syntax error in generic declaration.");
        options13.add("Array index out of bounds.");
        options13.add("Type erasure error.");
        options13.add("No error exists.");
        options13.add("Raw type usage error.");
        options13.add("None of the above.");
        int origCorrect13 = 0;
        String correct13 = options13.get(origCorrect13);
        Collections.shuffle(options13);
        int newCorrect13 = options13.indexOf(correct13);
        questions.add(new Question(
                "List<String> list = new ArrayList<>();\nlist.add(10);",
                options13,
                newCorrect13
        ));

        // Question 14: Hard - Reference to non-static variable in a static context
        List<String> options14 = new ArrayList<>();
        options14.add("Cannot reference non-static variable from a static context."); // originally correct
        options14.add("Missing semicolon.");
        options14.add("Incorrect variable type.");
        options14.add("Method should be static.");
        options14.add("Extra parameter in method call.");
        options14.add("No error exists.");
        options14.add("Incorrect loop declaration.");
        options14.add("Null pointer exception.");
        options14.add("Type mismatch error.");
        options14.add("None of the above.");
        int origCorrect14 = 0;
        String correct14 = options14.get(origCorrect14);
        Collections.shuffle(options14);
        int newCorrect14 = options14.indexOf(correct14);
        questions.add(new Question(
                "public class Test {\n    public int x = 5;\n    public static void main(String[] args) {\n        System.out.println(x);\n    }\n}",
                options14,
                newCorrect14
        ));

        // Question 15: Hard - Final method cannot be overridden
        List<String> options15 = new ArrayList<>();
        options15.add("Final method cannot be overridden."); // originally correct
        options15.add("Missing semicolon.");
        options15.add("Incorrect class declaration.");
        options15.add("Variable type mismatch.");
        options15.add("Incorrect constructor usage.");
        options15.add("Overloading instead of overriding.");
        options15.add("Missing return statement.");
        options15.add("Abstract method not implemented.");
        options15.add("Syntax error in method signature.");
        options15.add("None of the above.");
        int origCorrect15 = 0;
        String correct15 = options15.get(origCorrect15);
        Collections.shuffle(options15);
        int newCorrect15 = options15.indexOf(correct15);
        questions.add(new Question(
                "public class A {\n    public final void show() {}\n}\npublic class B extends A {\n    public void show() {}\n}",
                options15,
                newCorrect15
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
