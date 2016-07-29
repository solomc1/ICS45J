// Written by James Hardjadinata and Richert Wang
// Modified for ICS 45J Lab 4 Fall 2015

//Julio Chavez, 86213565
//Solomon Chan, 40786337

package com.example.flashcard45j;

import java.io.Serializable;



//This is the implementation for the card class.
//A card consists of a string type, string question, one of the types of answers, and the difficulty as an int variable.

// The Card class represents a FlashCard used for this application.
// All cards consists of a String question and a String question type (i.e. subject such as "Inheritance",
// "Exceptions", "Loops", etc). Each card has a correct Answer associated with it and a difficulty
// (between 1 - 3). For this lab, you can assume all Cards have a difficulty of "1".
public class Card implements Serializable {
	
	//Private variables for Card object
	private String question;
	private String type;
	private Answer answer;
	private int difficulty;

	// Constructor taking in to necessary fields to assign to the Card's class variables.
	public Card(String question, Answer answer, int difficulty, String type) {
		this.question = question;
		this.type = type;
		this.answer = answer;
		this.difficulty  = difficulty;
	}
	
	// Copy constructor
	public Card(Card c) {
		new Card(c.getQuestion(), c.getAnswer(), c.getDifficulty(), c.getType());
	}
	
	// Getter method returning the Card's Question.
	public String getQuestion() {
		return question;
	}
	
	// Getter method returning the Card's Answer
	public Answer getAnswer() {
		return answer;
	}
	
	// Getter method returning the Card's Difficulty
	public int getDifficulty() {
		return difficulty;
	}

	// Getter method returning the Card's Type
    public String getType() {
    	return type;
    }

    // Checks if two cards are equal if they have the same question, question type, and answer.
    public boolean equals(Card card) {
    	return (card.getAnswer().equals(answer) 
    			&& card.getQuestion().equals(question) 
    			&& card.getType().equals(type));
    }

    // The cardFactory method takes in a String array containing multiple pieces of information that is required
    // to construct specific cards.
	// Strings passed a form of: {question};{difficulty};{question type};{answer type};{answer};{case sensitive if applicable}.
    // You should use the card type to construct the appropriate Answer object.
    // Once all pieces are obtained, a new Card is constructed and returned.
    // If the answer type is unrecognizable, then throw an IllegalArgumentException()
	public static Card cardFactory(String[] args) throws IllegalArgumentException {
		Answer answerType;
		if (args[3].equals("SA")){
			  answerType = new ShortAnswer(args[4], Boolean.parseBoolean(args[5]));
		}
		else if (args[3].equals("TF")){
			answerType = new TruthAnswer(Boolean.parseBoolean(args[4]));
		}
		else if (args[3].equals("MC")){
			answerType = new MultipleChoiceAnswer(args[4].split(","));
		}
		
		else{
			throw new IllegalArgumentException();
		}

		return new Card(args[0],answerType,Integer.parseInt(args[1]),args[3]);

	
	}
}
