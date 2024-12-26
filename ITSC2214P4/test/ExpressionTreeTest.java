import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import itsc2214.BinaryNode;

/**
 * Test class for ExpressionTree class
 */

/**
 * Default constructor for ExpressionTreeTest
 */
public class ExpressionTreeTest {
    /** An instance of a valid expression tree. */
    private ExpressionTree tree1;
    
    /** An instance of another valid expression tree. */
    private ExpressionTree tree2;
    
    /** An instance of a different valid expression tree. */
    private ExpressionTree tree3;
    
    /** An instance representing an invalid expression tree. */
    private ExpressionTree treeInvalid;

    /**
     * sets up test environment by init ExpressionTree
     */
    @Before
    public void setUp() {
        tree1 = new ExpressionTree("3 4 +");
        tree2 = new ExpressionTree("3 4 5 * +");
        tree3 = new ExpressionTree("2 3 + 4 5 * + 5 /");
        treeInvalid = new ExpressionTree("3 +"); //invalid postfix expression
    }

    /**
     * test method for parsing valid postfix expressions
     */
    @Test
    public void testParseValidExpressions() {
        assertTrue(tree1.parse());
        assertTrue(tree2.parse());
        assertTrue(tree3.parse());
    }

    /**
     * test method for parsing invalid postfix expressions
     */
    @Test
    public void testParseInvalidExpression() {
        assertFalse(treeInvalid.parse());
    }

    /**
     * test method for checking the root of the expression tree
     */
    @Test
    public void testGetRoot() {
        tree1.parse();
    BinaryNode<String> root = tree1.getRoot();
    assertNotNull(root);
    String rootValue = root.getValue();
    assertEquals("+", rootValue);
    }

    /**
     * test method for evaluating expression
     */
    @Test
    public void testEvaluate() {
        tree1.parse();
        assertEquals(7, tree1.evaluate()); // 3 + 4 = 7

        tree2.parse();
        assertEquals(23, tree2.evaluate()); // 3 + (4 * 5) = 23

        tree3.parse();
        assertEquals(5, tree3.evaluate()); // ((2 + 3) + (4 * 5)) / 5 = 5
    }

    /**
     * test method for handling division by zero in the expression
     */
    @Test(expected = ArithmeticException.class)
    public void testEvaluateDivisionByZero() {
        ExpressionTree tree = new ExpressionTree("4 0 /");
        tree.parse();
        tree.evaluate(); //throws ArithmeticException
    }

    /**
     * test method for converting expression to infix notation
     */
    @Test
    public void testInfixNotation() {
        tree1.parse();
        assertEquals("(3 + 4)", tree1.infixNotation());

        tree2.parse();
        assertEquals("(3 + (4 * 5))", tree2.infixNotation());

        tree3.parse();
        assertEquals("(((2 + 3) + (4 * 5)) / 5)", tree3.infixNotation());
    }

    /**
     * test method for edge case with single number in postfix expression
     */
    @Test
    public void testEdgeCaseSingleNumber() {
        ExpressionTree tree = new ExpressionTree("10");
        tree.parse();
        assertEquals(10, tree.evaluate());
        assertEquals("10", tree.infixNotation());
    }

    /**
     * test method for edge case with single invalid operator
     */
    @Test
    public void testEdgeCaseSingleOperatorInvalid() {
        ExpressionTree tree = new ExpressionTree("+");
        assertFalse(tree.parse());
    }
}
