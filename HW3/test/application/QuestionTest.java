package application;

import java.util.ArrayList;

public class QuestionTest {
    
    public static void main(String[] args) {
        performTests();
    }
    
    private static void performTests() {
        String testResults = "\n/// Question Validation Tests ///\n";
        
        // Run test cases
        testResults += testValidQuestion();
        testResults += testNullQuestion();
        testResults += testNullUser();
        testResults += testEmptyTitle();
        testResults += testExceedingTitleLength();
        testResults += testEmptyDescription();
        testResults += testExceedingDescriptionLength();
        
        System.out.println(testResults);
    }
    
    private static String testValidQuestion() {
        Question question = new Question(0, "Valid Title", "This is a valid description.", -1);
        
        if (Question.validate(question) == "") {
            return "Valid Question: PASSED\n";
        }
        return "Valid Question: FAILED\n";
    }
    
    private static String testNullQuestion() {
        if (Question.validate(null) != "") {
            return "Null Question: PASSED\n";
        }
        return "Null Question: FAILED\n";
    }
    
    private static String testNullUser() {
        Question question = new Question(0, "Title", "Description", -1);
        
        if (Question.validate(question) != "") {
            return "Null User: PASSED\n";
        }
        return "Null User: FAILED\n";
    }
    
    private static String testEmptyTitle() {
        Question question = new Question(0, "", "Valid description.", -1);
        
        if (Question.validate(question) != "") {
            return "Empty Title: PASSED\n";
        }
        return "Empty Title: FAILED\n";
    }
    
    private static String testExceedingTitleLength() {
        String longTitle = "a".repeat(256); // Exceeds 255 character limit
        Question question = new Question(0, longTitle, "Valid description.", -1);
        
        if (Question.validate(question) != "") {
            return "Exceeding Title Length: PASSED\n";
        }
        return "Exceeding Title Length: FAILED\n";
    }
    
    private static String testEmptyDescription() {
        Question question = new Question(0, "Valid Title", "", -1);
        
        if (Question.validate(question) != "") {
            return "Empty Description: PASSED\n";
        }
        return "Empty Description: FAILED\n";
    }
    
    private static String testExceedingDescriptionLength() {
        String longDescription = "a".repeat(65536); // Exceeds 65535 character limit
        Question question = new Question(0, "Valid Title", longDescription, -1);
        
        if (Question.validate(question) != "") {
            return "Exceeding Description Length: PASSED\n";
        }
        return "Exceeding Description Length: FAILED\n";
    }
}
