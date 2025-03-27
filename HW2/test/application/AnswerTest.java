package application;

import java.util.ArrayList;

public class AnswerTest {
    
    public static void main(String[] args) {
        performTests();
    }
    
    private static void performTests() {
        String testResults = "\n/// Answer Validation Tests ///\n";
        
        // Run test cases
        testResults += testValidAnswer();
        testResults += testNullAnswer();
        testResults += testNullUser();
        testResults += testEmptyContent();
        testResults += testExceedingContentLength();
        
        System.out.println(testResults);
    }
    
    private static String testValidAnswer() {
        Answer answer = new Answer(0, 0, "This is valid answer content.");
        
        if (Answer.validate(answer) == "") {
            return "Valid Answer: PASSED\n";
        }
        return "Valid Answer: FAILED\n";
    }
    
    private static String testNullAnswer() {
        if (Answer.validate(null) != "") {
            return "Null Answer: PASSED\n";
        }
        return "Null Answer: FAILED\n";
    }
    
    private static String testNullUser() {
        Answer answer = new Answer(0, 0, "Valid content");
        
        if (Answer.validate(answer) != "") {
            return "Null User: PASSED\n";
        }
        return "Null User: FAILED\n";
    }
    
    private static String testEmptyContent() {
        Answer answer = new Answer(0, 0, "");
        
        if (Answer.validate(answer) != "") {
            return "Empty Content: PASSED\n";
        }
        return "Empty Content: FAILED\n";
    }
    
    private static String testExceedingContentLength() {
        String longContent = "a".repeat(65536); // Exceeds 65535 character limit
        Answer answer = new Answer(0, 0, longContent);
        
        if (Answer.validate(answer) != "") {
            return "Exceeding Content Length: PASSED\n";
        }
        return "Exceeding Content Length: FAILED\n";
    }
}
