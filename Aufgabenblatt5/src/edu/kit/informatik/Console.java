package edu.kit.informatik;

import edu.kit.informatik.helper.Commands;
import edu.kit.informatik.helper.Terminal;

public class Console {

    public static void main(String[] args) {
        
        // Loops until "quit"
        while(true) {
            String[] input = Terminal.readLine().split(" ");
            
            switch(Commands.valueOf(input[0])) {
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
