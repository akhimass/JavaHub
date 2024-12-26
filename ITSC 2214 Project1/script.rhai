let proj = new_java_project();

let req_1 = new_docs_grader()
    .project(proj)
    .files(["Project1.java"])
    .out_of(15.0)
    .req_name("JavaDoc for `Project1.java`")
    .penalty(3.0)
    .run();

let req_2 = new_by_hidden_test_grader()
    .url("https://www.dropbox.com/scl/fi/fpbjeovmta6p2hhql1nk0/Project1HiddenTest.java?rlkey=0z3iw4lthysdfwnppzr15uby5&st=0vyuyjx4&raw=1")
    .test_class_name("Project1HiddenTest")
    .out_of(75.0)
    .req_name("Hidden Tests for `Project1.java`")
    .run();

let req_3 = new_by_unit_test_grader()
    .project(proj)
    .req_name("Student-written tests for `Project1.java`")
    .out_of(10.0)
    .test_files(["Project1Test"])
    .run();

let reqs = [req_1, req_2, req_3];
show_results(reqs, #{
    "show_table": true,
    "results_json": false,
    "feedback": false,
    "leaderboard": false,
    "debug": true,
    "project_title": "Project 1",
});

print("\n------------------\nNOTE: Student-written tests will be graded manually, and your grade will be updated accordingly.\n------------------\n");

generate_feedback(reqs);