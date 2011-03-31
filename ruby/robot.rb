class Board
  
  @@move_operations = {
      "N" => [lambda{|x| x}, lambda{|y| y+1}], 
      "E" => [lambda{|x| x+1}, lambda{|y| y}], 
      "S" => [lambda{|x| x}, lambda{|y| y-1}],
      "W" =>  [lambda{|x| x-1}, lambda{|y| y}]      
  } 

  attr_accessor :x, :y

  def initialize(x, y)
    self.x = x
    self.y = y
  end

  def is_valid_move?(x, y)
    x <= self.x && y <= self.y
  end

  def move_to(robot, x, y)
    if is_valid_move?(x, y)
      robot.x = x
      robot.y = y
    end
  end

  def move(robot)
    move_operation = @@move_operations[robot.direction]
    move_to(robot, move_operation.first.call(robot.x), move_operation.last.call(robot.y))
  end

end

class Robot

  @@turn_directions = {
    "N" => ["W", "E"],
    "E" => ["N", "S"],
    "S" => ["E", "W"],
    "W" => ["S", "N"]
  }

  attr_accessor :x, :y, :direction

  def initialize(x, y, direction)
    self.x = x
    self.y = y
    self.direction = direction
  end

  def turn_to(side)
    new_direction = @@turn_directions[self.direction]
    self.direction = (side == "L" ? new_direction.first : new_direction.last)
  end

  def to_s
    "#{self.x} #{self.y} #{self.direction}"
  end

end

class RobotGrammarParser

  def make_board(line)
    x, y = line.chomp.split(/[\s]/)
    @board = Board.new(x.to_i, y.to_i)
  end

  def make_robot(line)
    x, y, direction = line.chomp.split(/[\s]/)
    @robot = Robot.new(x.to_i, y.to_i, direction)
  end

  def make_all_movements(lines)
    (2...lines.length).each do |i|
      line = lines[i]
      make_movements(line) if line =~ /^[LRM]+/
      teleport(line) if line =~ /^T+/
    end
  end

  def make_movements(line)
    line.scan(/[\w]/).each do |operation|
      @board.move(@robot) if operation == "M"
      @robot.turn_to(operation) if operation =~ /[LR]/
    end
  end

  def teleport(line)
    operation, x, y = line.chomp.split(/[\s]/)
    @board.move_to(@robot, x.to_i, y.to_i)
  end

  def parse(filename)
    begin
      grammar = IO.readlines(filename)
      make_board(grammar[0])
      make_robot(grammar[1])
      make_all_movements(grammar)
      @robot.to_s
    rescue 
      abort("can't open %s" % filename)
    end
  end

end
