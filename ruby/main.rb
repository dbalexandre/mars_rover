require_relative 'robot'

unless ARGV.length == 1
  puts "No file name entered"
  puts "Usage: ruby main.rb filename"
  exit
end

grammar_parser = RobotGrammarParser.new
puts grammar_parser.parse(ARGV[0])
