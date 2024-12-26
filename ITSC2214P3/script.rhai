let proj = new_java_project();

let req_1 = new_docs_grader()
    .project(proj)
    .files(["datastructures.LinkedStack", "datastructures.LinkedQueue", "datastructures.LinkedStackTest", "datastructures.LinkedQueueTest"])
    .out_of(15.0)
    .req_name("Documentation for `LinkedStack.java`, `LinkedQueue.java`, and their tests")
    .penalty(1.0)
    .run();

let req_2 = new_by_hidden_test_grader()
    .url("https://www.dropbox.com/scl/fi/o5us4jtazze4cqgdyacft/LinkedStackHiddenTest.java?rlkey=bzrxutgyw6ecvdb75o3zhvdbx&st=aaofcelw&raw=1")
    .test_class_name("LinkedStackHiddenTest")
    .out_of(37.5)
    .req_name("Hidden Tests for `LinkedStack.java`")
    .run();

let req_3 = new_by_hidden_test_grader()
    .url("https://www.dropbox.com/scl/fi/16ctvo7gmoz9zsfszam0f/LinkedQueueHiddenTest.java?rlkey=9qgtvcnsi0kkphtk5mrn36j5o&st=o3h05fci&raw=1")
    .test_class_name("LinkedQueueHiddenTest")
    .out_of(37.5)
    .req_name("Hidden Tests for `LinkedQueue.java`")
    .run();

let req_4 = new_by_unit_test_grader()
    .project(proj)
    .req_name("Student-written tests for `LinkedStack.java` and `LinkedQueue.java`")
    .out_of(10.0)
    .test_files(["datastructures.LinkedStackTest", "datastructures.LinkedQueueTest"])
    .run();

let reqs = [req_1, req_2, req_3, req_4];

show_results(reqs, #{
    "show_table": true,
    "results_json": false,
    "feedback": true,
    "leaderboard": false,
    "debug": false,
    "project_title": "Project 3",
    "project_description": "In this assignment, we'll implement stack and queue data structures using linked lists in Java. We'll then apply these data structures to build a music melody management application that can play melodies forward and in reverse. We'll complete methods in LinkedStack, LinkedQueue, and Melody classes, as well as write unit tests. Finally, we'll run and interact with a menu-based application to load and manipulate melodies using our implemented data structures.",
    "source_files": ["datastructures.LinkedStack", "datastructures.LinkedQueue"],
    "test_files": ["datastructures.LinkedStackTest", "datastructures.LinkedQueueTest"],
    "slo_logic": true,
    "slo_error_handling": true,
    "slo_testing": true,
    "slo_algorithmic_solutions": true,
});

generate_feedback(reqs);