//Version 1.0
The version 1.0 of this bot has been develoved in a time of approximately 4 days starting the 20/07/2020 during the which I fisrt
learnt how to kind of deal with asynchronous operations in JS. 

It was develoved with node.js v10.19.0 and discord.js 12.2.0

  //How to use it
  Challenge another player within the same guild with "!challenge <tag the challenged user>"
  (Obviously the bot needs to be able to read messages on the selected channel)
  The challenged player then replies with either "!accept" if it accepts the challenge or "!reject" if it doesnt
  The bot then selects who goes first, use "!mark <box number>" to check a box, "!surrender" to surrender
  and "!renember" to get a refresher on the current state of the game

  //Explanation of the code
  (See the the EXPLANATION.rd)
  
  //Known errors/bugs
  It's massive and unconsistently and poorly formatted
  
  //Future plans
  -->Short term
    Separate it into modules
  -->Long term
    Have multiple games happen at once
    Make it so that you can play with yourself, having the bot control the other player
    Being able to play in grid bigger 3x3 (Cannot confirm if the previous objective will be able to work in tandem w/ this one)
