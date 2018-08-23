package com.Lab1AED.model;

public class GenerationException extends Exception {
	public GenerationException() {
		super("Range between min number and max number is too short to generate numbers without repeating");
	}
}
