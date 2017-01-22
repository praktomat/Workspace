package edu.kit.informatik.helper;

public enum Commands {

    ADD_PROFESSOR("add-professor"),
    LIST_PROFESSOR("list-professor"),
    SUMMARY_PROFESSOR("summary-professor"),
    LIST_STUDENT("list-student"),
    SUMMARY_STUDENT("summary-student"),
    ADD_MODULE("add-module"),
    LIST_MODULE("list-module"),
    SUMMARY_MODULE("summary-module"),
    ADD_LECTURE("add-lecture"),
    LIST_LECTURE("list-lecture"),
    SUMMARY_LECTURE("summary-lecture"),
    EXAMINATION_MARKING("examination-marking"),
    RESET("reset"),
    QUIT("quit");
    
    /**
     * The string that has to be typed in to evoke this command
     */
    private String name;

    Commands(String name) {
        this.name = name;
    }
}
