package datapasePart1;

import application.Question;

/**
 * JAVADOC 
 * This class is responsible for testing the functionality of the Question class.
 * It includes various test cases to verify object creation and validation logic.
 */
public class QuestionTest {
    
    /**
     * The main method executes all test cases.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        performTests();
    }

    /**
     * Executes all test cases and displays the results in the console.
     */
    private static void performTests() {
        String testResults = "\n/// Question Class Test ///\n";
        
        // Perform general tests
        testResults += performGeneralTests();
        
        // Perform validation tests
        testResults += performValidationTests();

        // Print test results
        System.out.println(testResults);
    }

    /**
     * Runs general tests related to object creation.
     * 
     * @return A formatted string containing test results.
     */
    private static String performGeneralTests() {
        String testResults = "\nGeneral Tests:\n";
        
        testResults += testQuestionCreation();
        testResults += testSetTitle();
        testResults += testSetDescription();
        
        return testResults;
    }

    /**
     * Runs validation tests for the Question class.
     * 
     * @return A formatted string containing test results.
     */
    private static String performValidationTests() {
        String testResults = "\nValidation Tests:\n";
        
        testResults += validateValidQuestion();
        testResults += validateNullQuestion();
        testResults += validateEmptyTitle();
        testResults += validateLongTitle();
        testResults += validateEmptyDescription();
        testResults += validateLongDescription();
        
        return testResults;
    }

    /**
     * Tests the creation of a Question 
     * 
     * @return Test result string.
     */
    private static String testQuestionCreation() {
        Question question = new Question(1, "Sample Title", "Sample Description", 0);
        
        if (question.getUserId() == 1 && 
            question.getTitle().equals("Sample Title") && 
            question.getDescription().equals("Sample Description") &&
            question.getParentQuestionId() == 0) {
            return "Question Creation: PASSED\n";
        }
        
        return "Question Creation: FAILED\n";
    }

    /**
     * Tests the setTitle() method.
     * 
     * @return Test result string.
     */
    private static String testSetTitle() {
        Question question = new Question(1, "Old Title", "Description", 0);
        question.setTitle("New Title");
        
        if (question.getTitle().equals("New Title")) {
            return "Set Title: PASSED\n";
        }
        
        return "Set Title: FAILED\n";
    }

    /**
     * Tests the setDescription() method.
     * 
     * @return Test result string.
     */
    private static String testSetDescription() {
        Question question = new Question(1, "Title", "Old Description", 0);
        question.setDescription("New Description");
        
        if (question.getDescription().equals("New Description")) {
            return "Set Description: PASSED\n";
        }
        
        return "Set Description: FAILED\n";
    }

    /**
     * Tests validation for a valid Question object.
     * 
     * @return Test result string.
     */
    private static String validateValidQuestion() {
        Question question = new Question(1, "Valid Title", "Valid Description", 0);
        
        if (Question.validate(question).equals("")) {
            return "Valid Question Validation: PASSED\n";
        }
        
        return "Valid Question Validation: FAILED\n";
    }

    /**
     * Tests validation when the Question object is null.
     * 
     * @return Test result string.
     */
    private static String validateNullQuestion() {
        if (Question.validate(null).equals("*** Error *** Question cannot be null")) {
            return "Null Question Validation: PASSED\n";
        }
        
        return "Null Question Validation: FAILED\n";
    }

    /**
     * Tests validation when the title is empty.
     * 
     * @return Test result string.
     */
    private static String validateEmptyTitle() {
        Question question = new Question(1, "", "Description", 0);
        
        if (Question.validate(question).equals("*** Error *** Question title cannot be empty")) {
            return "Empty Title Validation: PASSED\n";
        }
        
        return "Empty Title Validation: FAILED\n";
    }

    /**
     * Tests validation when the title exceeds 255 characters.
     * 
     * @return Test result string.
     */
    private static String validateLongTitle() {
        String longTitle = "A".repeat(256);
        Question question = new Question(1, longTitle, "Description", 0);
        
        if (Question.validate(question).equals("*** Error *** Question title cannot exceed maximum length (255 characters)")) {
            return "Long Title Validation: PASSED\n";
        }
        
        return "Long Title Validation: FAILED\n";
    }

    /**
     * Tests validation when the description is empty.
     * 
     * @return Test result string.
     */
    private static String validateEmptyDescription() {
        Question question = new Question(1, "Title", "", 0);
        
        if (Question.validate(question).equals("*** Error *** Question description cannot be empty")) {
            return "Empty Description Validation: PASSED\n";
        }
        
        return "Empty Description Validation: FAILED\n";
    }

    /**
     * Tests validation when the description exceeds 65535 characters.
     * 
     * @return Test result string.
     */
    private static String validateLongDescription() {
        String longDescription = "A".repeat(65536);
        Question question = new Question(1, "Title", longDescription, 0);
        
        if (Question.validate(question).equals("*** Error *** Question description cannot exceed maximum length (65535 characters)")) {
            return "Long Description Validation: PASSED\n";
        }
        
        return "Long Description Validation: FAILED\n";
    }
}
