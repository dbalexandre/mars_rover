package com.marsrover;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String args[]) {

		if (args.length == 0) {
			System.out.println("No file name entered");
			System.out.println("Usage: javac Main filename");
			return;
		}

		RobotGrammarParser parser = new RobotGrammarParser();

		try {

			System.out.println(parser.parse(args[0]));

		} catch (FileNotFoundException e) {
			System.out.println("Can't open file " + args[0]);
		}
	}

}
