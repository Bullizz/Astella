# Astella
Astella is a game where the player moves through a procedural generated maze while trying to find its exit while being chased by a monster. The maze will have chests placed out at random location that will aid the player.

## Maze
The maze consists of an integer matrix with the size 25x25. Each matrix entry *N* will be represented as a 4-digit binary number, with each digit representing the presence or absent of a wall as 1 or 0 respectively, *N =* [Upper wall, Left wall, Lower wall, Right wall]. When the matrix is initialized, each *N* is assigned the value 15 = [1, 1, 1, 1], i.e. all walls, then the Depth-First Search algorithm is performed on the matrix to generate the maze. The center of the maze (13, 13) is set as the goal of the maze.

## Entities
### Player
### Monster
The monster will spawn in the opposite quadrant of the player and then constantly move towards the player. The A* algorithm will generate the path the monster will take to reach the player. Considering that the player moves the monster will need to update its path to reach it, the rate of updating the path *f<sub>pf</sub>* will have a set value initially, as will the monsters speed *v<sub>m</sub>*. The maze will contain 3 invisible circles, each varying in size but with the same center at the center of the maze. The smaller the circle the player is within, *f<sub>pf</sub>* and *v<sub>m</sub>* will increase, see image:
<img width="743" height="657" alt="maze-templ-circles" src="https://github.com/user-attachments/assets/4712aa80-01fe-4ccf-98b1-ed9917d44e0b" />
#### T.B.D.
Instead of checking if player is within said circles, maybe instead perform A* from player position to the goal to see how many actual steps the player has left, then update *f<sub>pf</sub>* and *v<sub>m</sub>* based on this.

### Chest
Chests will be placed randomly throughout the maze, 5 in each quadrant. Each chest will contain 2 items, one potion and one notebook. The notebooks will contain texts that gives the player advice or backstory, the potions will have different effects that aids the player but with diffuse names.
#### Potions
The potions will be actived through keys 1-9, their effect will last for **7 seconds**.
| Name  | Effect |
| ----- | ------ |
| Pesticide | Increase player speed |
| Carrot juice | Display road to goal |
| Party juice | Slow down monster |
| URC | Switch player and monster png, reverse monster movement |
| 8-up | See through walls |
| Red Bovine | Slow down player |
| Beer | Randomize key-inp --> movement |
| caementicium | Turn player to stone |
| cumenticaem | Turn monster to stone |
| pot10 | bruh |

## Game startup
Every time the game is launched, it will look for the folder **GPNFs**, in case no such folder exists, the player will not be able to choose the *continue* option in the start menu. When the player chooses the *New Game* option, the program will create this folder in the same direcotry as the game and auto-generate files.
| File in **GPNFs** | Description |
| ----- | ------ |
| chest.txt | Contains the position<x, y> and the content<potion, notebook> of all chests placed in the maze |
| player.txt | Contains the position<x, y> and the orientation<up, left, down, right> of the player |
| monster.txt | Contains the position<x, y>, the orientation<up, left, down, right>, and the current path of the monster |
| maze.txt. | Contains the matrix that constitutes the maze |
| inventory.txt | Contains the current inventory of the player, which notebooks and which potion at respective key |

The files will be written to when the in-game menu option *Save* is pressed.
