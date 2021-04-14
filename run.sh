#!/bin/bash

cd src
javac game/*.java
javac tools/*.java
javac util/*.java
javac character/*.java
java game.Game
