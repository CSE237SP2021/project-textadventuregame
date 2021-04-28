# cse237-project

CSE 237 Project - Jiaqi Li, Mingyang Xie, Yuqi Lei - text adventure game

# Iteration 3

## What user stories were completed this iteration?

A player have his inital HP, attack, defense and other attributes(we add backpack!!!). All these attributes are dynamic chaning in the game<br />
The game Now have different kinds of tools. weapons, and portions<br />
The game has several enemies, and even a boss in the end! you need to use some strategy to kill him.<br />
Different role now have different response to different tools. This is achived by visitor design pattern  <br />
The game have a store to sell tools. If you don't have enough gold, it will mention you. And you can also sell tools in your backpack to earn money<br />
The adventure in the game has several locations now<br />
The game has a complete story and players can either go back to last scene or exit<br />
To be more detailed, we create Game class for players to interact. We create abstract Role class. Player class, Guard calss and Monster class inherit Role class and they are all in game_new.character package. We create Tool interface and poisson class implement it. In addition, we have weapon, armor classes and store classes. They are all in game_new.weapon package. All UI stuff and related clasees are in game_new and game_new.extendClass packages.

## Is there anything that you implemented but doesn't currently work?
Everything should work now. Only key function is a bit imcomplete(Use a key to open a specific door). We are thinking about using a data structure or a design pattern to improve it. Moreover, since we are doing a lot GUI stuff in UI part. We could test our functionality by just look at the window. Thus, we didn't have much unit test to write although we added some tests to test some important functionaloities.

## What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)

we add a run.sh in the development branch. So just run ./run.sh <br />
However, if linux system doesn't initiate x server, it might fail due to the usage of GUI
