This code is really messy since it's my first "serious" try with JS

There are 3 objects; challenger, challenged and board
  Challenger: This objects used as a way to store data from the player that challenged the other player. It's properties and methods are:
    id: It stores the users Discord ID
    order: This ones used to know the order in which the players act within the game, 0 means you go first, 1 means you go second.
    name: It stores the users name
    reset(): This method resets the properties to their default state
  Challenged: It stores data from the challenged player. It's properties and methods are:
    id: It stores the users Discord ID
    order: This ones used to know the order in which the players act within the game, 0 means you go first, 1 means you go second.
    name: It stores the users name
    reset(): This method resets the properties to their default state
  Board: Its used to store the current state of the board alongside the methods used to do anything related with it. It's properties and methods are:
    boxes: Stores the current state of the board as an array
    formatted: Returns a ready to print formatted board
    reset: resets the board to its original state
    mark: marks the selected box. Also checks wether the box has already been written on
    check: checks if one of the players has won via a 27 lines long switch
  
The flow of the game is the following:
  First of all whenever a message is send checks if the message has been sent via a guild text channel and the user was not a bot
  Then using a switch sentence it evaluates the current value of the **state** variable to see in which phase of the game were at
  The state variable can hold 11 different values, ranging from to 0 to 11:
    0:The bot is waiting for someone to challenge another user
    1:The bot is waiting for the challenged user to either decline or accept the challenge
    2-11: The actual game

  The switch sentence basically makes it so that it can evaluate different things based on which state the games currently at
  
    0: Checks if a sent message corresponds with the syntax "!challenge <tag to the challenged user>" if it does then it 
    stores the id sent via the tag as the challenged users id, using this id it querys the Discord API to make sure 
    the challenged user is not a bot, if its false then the bot ignores the message but if its true then it stores
    the message authors id and increases state by one
    
    1: This one checks whether a message sent by the challenged player is either "!acept" or "!reject", if the messages says
    "!reject" then it sets the state counter back to 0 and tags the challenger saying the challenged user has denied the invitation
    If the message says "!acept" then it sets the challenged and challenger properties to that of the respective players with a terrible
    piece of code that could have been written with a .thenall. It determines whos the starting player with a RNG and sets the order of the
    other by giving it the opposite number. Increases the state counter by one
    
    2-11: First checks if the message authors is any of the two players and if it the content complies with any of the three possible commands for this
    state ("!surrender","!renember" and "!mark [1-9]"), if it passes it makes sure the player is not surrendering, if thats the case the game ends,
    the winner is decided and the state counter returns to 0 alongside the board and chalenger and challenged objects. Once that out of the way it gets the turn variable, 
    this one is obtained with the module of state divided by 2 if the result is 0 then its the turn of whoever player has 0 in its order property if not its the other one. 
    The turn variable represents the player whose turn its. Then it checks the message is a reminder, if it is it prints the current state of the board alongside of the player whose turn its. 
    Once that two options are out of the way it makes sure the message complies with the "!marco [1-9]" syntax. It then invokes the board.mark() method to mark the selected box; 
    once the state its >= 7 it checks if someone has won if someone wins it resets the state counter and the board and the challenger and challenged players, 
    if it is state == 11 and no one has won it declares a stalemate and resets everything to its default state. If none of the above happens the bot tags the user whose turn is next and
    adds 1 to the state counter.
    
 That's basically the whole thing.
    
