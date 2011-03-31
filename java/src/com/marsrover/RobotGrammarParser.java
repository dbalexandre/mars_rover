package com.marsrover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotGrammarParser {

    private Board board;
    private Robot robot;
    private List<String> grammar;
    
    public void loadGrammar(String filename) throws FileNotFoundException {
        
        Scanner s = null;
        
        try {
            
            this.grammar = new ArrayList<String>();
            
            s = new Scanner(new BufferedReader(new FileReader(filename)));

            while (s.hasNextLine()) {
                
                this.grammar.add(s.nextLine());
            }
            
        } finally {
            
            if (s != null) {
                s.close();
            }
        }
    }
    
    public Board makeBoard(String line) {
        
        String[] input = line.split(" ");
        this.board = new Board(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        
        return this.board;
    }
    
    public Robot makeRobot(String line) {
        
        String[] input = line.split(" ");
        this.robot = new Robot(Integer.parseInt(input[0]), Integer.parseInt(input[1]), input[2]);
        
        return this.robot;
    }
    
    public void makeAllMovements(List<String> grammar) {
        
        String line = null;
        
        for (int i = 2; i < grammar.size(); i++) {
            
            line = grammar.get(i);
            
            if (line.matches("^[LRM]+"))
            {
                makeMovements(line);
            }
            else if (line.startsWith("T"))
            {
                teleport(line);
            }
        }
    }
    
    public void makeMovements(String line) {
        
        for (char input : line.toCharArray()) {

            switch (input) {
            
                case 'L':
                case 'R': {
                    this.robot.turnTo(input);
                    break;
                }
                case 'M': {
                    this.board.move(this.robot);
                    break;
                }
            }
        }
    }
    
    public void teleport(String line) {
        
        String[] input = line.split(" ");
        this.board.moveTo(this.robot, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
    }
    
    public String parse(String filename) throws FileNotFoundException {
    
        loadGrammar(filename);
        makeBoard(this.grammar.get(0));
        makeRobot(this.grammar.get(1));
        makeAllMovements(this.grammar);
        
        return robot.toString();
    }
    
}
