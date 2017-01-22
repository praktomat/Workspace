package edu.kit.informatik;

import edu.kit.informatik.accounts.Professor;
import edu.kit.informatik.accounts.Student;
import edu.kit.informatik.helper.Commands;
import edu.kit.informatik.helper.Terminal;
import edu.kit.informatik.sorting.LinkedSortedAppendList;

public class Console {

    public static void main(String[] args) {

        LinkedSortedAppendList<Student> studentList = new LinkedSortedAppendList<Student>();
        LinkedSortedAppendList<Professor> professorList = new LinkedSortedAppendList<Professor>();

        // Loops until "quit"
        while (true) {
            String[] input = Terminal.readLine().split(" ");

            switch (Commands.valueOf(input[0])) {
            case ADD_LECTURE:

                break;
            case ADD_MODULE:
                break;
            case ADD_PROFESSOR:
                break;
            case EXAMINATION_MARKING:
                break;
            case LIST_LECTURE:
                break;
            case LIST_MODULE:
                break;
            case LIST_PROFESSOR:
                break;
            case LIST_STUDENT:
                break;
            case QUIT:
                break;
            case RESET:
                break;
            case SUMMARY_LECTURE:
                break;
            case SUMMARY_MODULE:
                break;
            case SUMMARY_PROFESSOR:
                break;
            case SUMMARY_STUDENT:
                break;
            default:
                break;

            }

        }

        // TODO: gleitkommazahlen auf 2 nachkommastellen
    }
}
