let proj = new_java_project();

let req_1 = new_docs_grader()
    .project(proj)
    .files(["HashWords.java", "Project2.java", "WordFrequency.java"])
    .out_of(15.0)
    .req_name("Documentation for `HashWords.java`, `Project2.java`, and `WordFrequency.java`")
    .penalty(1.0)
    .run();

let req_2 = new_by_hidden_test_grader()
    .url("https://www.dropbox.com/scl/fi/h5ng8mrlyigzyff9q9zma/HashWordsHiddenTest.java?rlkey=82ybdtrir6piathuerg4y5ryp&st=1apbjvbd&raw=1")
    .test_class_name("HashWordsHiddenTest")
    .out_of(37.5)
    .req_name("Hidden Tests for `HashWords.java`")
    .run();

let req_3 = new_by_hidden_test_grader()
    .url("https://www.dropbox.com/scl/fi/xlk5mp04wgxfarffqjc78/WordFrequencyHiddenTest.java?rlkey=4p2a5i7gve6foo1ou3sz7ncoc&st=765apcrx&raw=1")
    .test_class_name("WordFrequencyHiddenTest")
    .out_of(37.5)
    .req_name("Hidden Tests for `WordFrequency.java`")
    .run();

let req_4 = new_by_unit_test_grader()
    .project(proj)
    .req_name("Student-written tests for `HashWords.java` and `WordFrequency.java`")
    .out_of(10.0)
    .test_files(["HashWordsTest", "WordFrequencyTest"])
    .run();

let reqs = [req_1, req_2, req_3, req_4];

show_results(reqs, #{
    "show_table": true,
    "results_json": false,
    "feedback": true,
    "leaderboard": false,
    "debug": false,
    "project_title": "Project 2",
    "project_description": "In this project, we were asked to explore the use of hash tables and hash functions to store words from documents and compute statistics on word frequencies. The main objectives were to build a hash table using arrays, create a hash function for words, and gain confidence with unit testing. We needed to implement two main classes: WordFrequency and HashWords. The WordFrequency class stores a single word and its count, with methods to get the word, get the count, and increment the count. The HashWords class implements a hash table with linear probing to handle collisions, and includes methods to add words, check for their existence, and compute various statistics like term frequency and the most common word. Throughout the project, we followed a test-driven development approach, writing test cases for each method to ensure our code worked as expected. This project not only helped us understand the mechanics of hash tables but also reinforced the importance of thorough testing in software development.",
    "source_files": ["HashWords", "Project2", "WordFrequency"],
    "test_files": ["HashWordsTest", "WordFrequencyTest"],
    "slo_logic": true,
    "slo_error_handling": true,
    "slo_testing": true,
    "slo_algorithmic_solutions": true,
});

generate_feedback(reqs);