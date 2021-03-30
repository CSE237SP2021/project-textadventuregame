# cse237-project

CSE 237 Project - Jiaqi Li, Mingyang Xie, Yuqi Lei - text adventure game

# Iteration 1

## What user stories were completed this iteration?

We add game screen and 4 options button with functions. <br />
We make a window for the player to interact with the game. <br />
A player can set the title of the game and create a start button. <br />
To be more detailed, we create Game class for players to interact. We create abstract Role class. Player class and Enemy class inherit Role class. We create Tool interface and poisson class implement it. We also create two test file to make sure the inherited role classes work well.

## What user stories do you intend to complete next iteration?
We need to make more game props classes and try to use these classes in Game class to make our game more fantastic(the player can have different game props and weapons in the adventure and can meet various monsters). In addition, we need to make Game class more functional so that players can play a part of the designed game.
## Is there anything that you implemented but doesn't currently work?
Everything should work now. However, we haven't add player and enemy into the game yet.

## What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
 First navigate to TextGame folder and then type the code below to compile. <br />
 javac Game.java TitleScreenHandler.java
