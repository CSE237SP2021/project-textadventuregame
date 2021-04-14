# cse237-project

CSE 237 Project - Jiaqi Li, Mingyang Xie, Yuqi Lei - text adventure game

# Iteration 2

## What user stories were completed this iteration?

The game have the tile screen and we can choose easy mode or hard mode by clicking corresponding part<br />
The game has a gameplay screen with JTextArea ad JButton. The user can move to gameplay screen using button <br />
The player, monster, tool, weaon, armor.etc are included in the game<br />
To be more detailed, we create Game class for players to interact. We create abstract Role class. Player class, Guard calss and Monster class inherit Role class and they are all in game_new.character package. We create Tool interface and poisson class implement it. In addition, we have weapon, armor classes and store classes. They are all in game_new.weapon package. All UI stuff and related clasees are in game_new and game_new.extendClass packages.

## What user stories do you intend to complete next iteration?
The game should have a complete sotry.<br />
The game need more tools, weapons, monsters, NPC, armors, and locations.<br />
Some locations need keys to access
## Is there anything that you implemented but doesn't currently work?
Everything should work now. However, since we are doing a lot GUI stuff in UI part. We could test our functionality by just look at the window. Thus, we didn't have much unit test to write.

## What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)

we add a run.sh in the development branch. So just run ./run.sh
However, if linux system doesn't initiate x server, it might fail due to the usage of GUI
