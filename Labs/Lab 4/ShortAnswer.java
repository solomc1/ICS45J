// Written by James Hardjadinata and Richert Wang
// Modified for ICS 45J Lab 4 Fall 2015

//Julio Chavez, 86213565
//Solomon Chan, 40786337

package com.example.flashcard45j;

import java.io.Serializable;

// Class defining a ShortAnswer object for short answer questions.
// Contains a String representing the correct answer and a boolean field
// representing if the answer is case sensitive or not.
public class ShortAnswer implements Answer, Serializable {
	//Private variables for Answer Short Answer object
	private String answer;
	private boolean caseSensitive;
	
    // Constructor that sets the answer and caseSensitive flag to the
    // class variables.
	public ShortAnswer(String answer, boolean caseSensitive) {
		this.answer = answer;
		this.caseSensitive = caseSensitive;
	}
	
	// Method that checks if the answer passed in the parameter is equal to the
	// correct answer (checking case sensitivity if necessary).
	public boolean checkAnswer(String answer) { 
        if (caseSensitive){
        	return (answer.equals(this.answer));
        }
        else{
        	return (answer.equalsIgnoreCase(this.answer));
        }
	}

	// Method that returns the correct answer
    public String toString() {
    	return answer;
    }

    // Method that checks if the Answer object has the correct answer.
    public boolean equals(Answer answer) {
    	return checkAnswer(answer.toString());
    }
}
