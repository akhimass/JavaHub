import java.util.Stack; // if you need a stack, use java.util.Stack
import itsc2214.BinaryNode; // IMPORTANT: use this, do not create your own

/**
 * A class that represents and evaluates arithmetic expressions using a binary tree.
 * The expressions are given in postfix notation and converted to a binary tree
 * for evaluation and conversion to infix notation.
 */
public class ExpressionTree {
    /** 
     * the postfix expression
     */
    private String postfix;
    /**
     * the root node of binary tree
     */
    private BinaryNode<String> root;

    /**
     * constructs an ExpressionTree with the given postfix expression.
     * 
     * @param postfix the postfix express
     */
    public ExpressionTree(String postfix) {
        this.postfix  = postfix;
        this.root = null;
    }

    /**
     * parses the postfix expression and builds expression tree
     * 
     * @return true 
     */
    public boolean parse() {
        if (postfix == null || postfix.isEmpty()) {
            root = null;
            return false; //for invalid expression
        }
    
        Stack<BinaryNode<String>> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+"); //split postfix into tokens
    
        try {
            for (String token : tokens) {
                if (isOperator(token)) {
                    //operators need two operands
                    if (stack.size() < 2) {
                        root = null;
                        return false;
                    }
                    BinaryNode<String> right = stack.pop();
                    BinaryNode<String> left = stack.pop();
                    BinaryNode<String> operatorNode = new BinaryNode<>(token, left, right);
                    stack.push(operatorNode);
                } else {
                    try {
                        Integer.parseInt(token); //attempt parse token as integer
                        stack.push(new BinaryNode<>(token)); // valid number push to stack
                    } catch (NumberFormatException e) {
                        //token is not a valid number
                        root = null;
                        return false;
                    }
                }
            }
    
            if (stack.size() != 1) {
                root = null; //too many operands)
                return false;
            }
    
            root = stack.pop(); //final tree root
            return true; //success parse
        } catch (Exception e) {
            root = null;
            return false;
        }
    }

    /**
     * returns root of expression tree
     * 
     * @return root of tree
     */
    public BinaryNode<String> getRoot() {
        return root;
    }

    /**
     * evaluates root of expression tree
     * 
     * @return the result of evaluating expression
     * @throws ArithmeticException if arithmetic error occurs
     */
    public int evaluate() throws ArithmeticException {
        if (root == null){
            throw new IllegalStateException("Tree not built. Call parse() first.");
        }
        return evaluateNode(root);
    }

    /**
     * converts the expression tree into infix notation.
     * 
     * @return string representing expression in infix notation
     */
    public String infixNotation() {
        if (root == null){
            throw new IllegalStateException("Tree not built. Call parse() first.");
        }
        return nodeToInfix(root);
    }

    // Helper methods

    /**
     * checks whether given token is an operator
     * 
     * @param token token to check
     * @return true if token operator, false if not
     */
    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    /**
     * evaluates a specific node in the tree.
     * 
     * @param node node to evaluate
     * @return result of evaluating node
     */
    private int evaluateNode(BinaryNode<String> node) {
        if (isLeaf(node)) {
            return Integer.parseInt(node.getValue());
        }
    
        // recursively evaluate left and right children
        int leftValue = evaluateNode(node.getLeft());
        int rightValue = evaluateNode(node.getRight());
    
        // perform the operation based on the operator
        switch (node.getValue()) {
            case "+":
                return (int) (leftValue + rightValue);
            case "-":
                return (int) (leftValue - rightValue);
            case "*":
                return (int) (leftValue * rightValue);
            case "/":
                if (rightValue == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return (int) (leftValue / rightValue); // integer division
            default:
                throw new IllegalArgumentException("Unknown operator: " + node.getValue());
        }
    }

    /**
     * converts a node to its corresponding infix expression.
     * 
     * @param node node to convert
     * @return string representing node in infix notation
     */
    private String nodeToInfix(BinaryNode<String> node) {
        if (isLeaf(node)) {
            return node.getValue();
        }
        String left = nodeToInfix(node.getLeft());
        String right = nodeToInfix(node.getRight());
        return "(" + left + " " + node.getValue() + " " + right + ")";
    }

    /**
     * Checks whether the given node is leaf node
     * 
     * @param node node to check
     * @return true if node leaf, false if not
     */
    private boolean isLeaf(BinaryNode<String> node) {
        return node.getLeft() == null && node.getRight() == null;
    }
}