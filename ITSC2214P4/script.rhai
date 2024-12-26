let proj = new_java_project();

// Documentation grading (20 points)
let req_1 = new_docs_grader()
    .project(proj)
    .files(["ExpressionTree", "ExpressionTreeTest"])
    .out_of(15.0)
    .req_name("Documentation for `ExpressionTree.java` and tests")
    .penalty(1.0)
    .run();

// Hidden tests grading (40 points)
let req_2 = new_by_hidden_test_grader()
    .url("https://www.dropbox.com/scl/fi/tzohr9lwzb4h65rbc0mqh/ExpressionTreeHiddenTest.java?rlkey=shcii63g4tw2an0q0hz4romyd&st=go7vr7t0&raw=1")
    .test_class_name("ExpressionTreeHiddenTest")
    .out_of(70.0)
    .req_name("Hidden Tests for `ExpressionTree.java`")
    .run();

// Student-written tests grading (40 points)
let req_3 = new_by_unit_test_grader()
    .project(proj)
    .req_name("Student-written tests for `ExpressionTree.java`")
    .out_of(15.0)
    .test_files(["ExpressionTreeTest"])
    .run();

let reqs = [req_1, req_2, req_3];

show_results(reqs, #{
    "show_table": true,
    "results_json": false,
    "feedback": true,
    "leaderboard": false,
    "debug": false,
    "project_title": "Project 4 - Expression Tree Evaluator",
    "project_description": "This project explores using a stack to build an expression tree and recursion to process expression trees. Students implement methods to parse postfix expressions into binary trees, evaluate arithmetic expressions, and convert expressions to infix notation. The project emphasizes understanding of binary trees, stacks, and recursive algorithms while handling arithmetic operations and proper error conditions.",
    "source_files": ["ExpressionTree"],
    "test_files": ["ExpressionTreeTest"],
    "slo_logic": true,
    "slo_error_handling": true,
    "slo_testing": true,
    "slo_algorithmic_solutions": true,
});

generate_feedback(reqs);