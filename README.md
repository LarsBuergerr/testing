![bannerImage](src/main/resources/mastermind_git_header.png)

---

![MAIN status](https://github.com/LarsBuergerr/mastermind/actions/workflows/codecov.yml/badge.svg)
[![codecov](https://codecov.io/gh/LarsBuergerr/mastermind/branch/07-DesignPattern/graph/badge.svg?token=PUIFJ9PH30)](https://codecov.io/gh/LarsBuergerr/mastermind/tree/develop)
![MAIN status](https://github.com/LarsBuergerr/mastermind/actions/workflows/coveralls.yml/badge.svg)
[![Coverage Status](https://coveralls.io/repos/github/LarsBuergerr/mastermind/badge.svg?branch=09-GUI)](https://coveralls.io/github/LarsBuergerr/mastermind?branch=09-GUI)

![RepoSize](https://img.shields.io/github/repo-size/LarsBuergerr/mastermind)
[![License](https://img.shields.io/github/license/LarsBuergerr/mastermind?color=green)](https://cdn130.picsart.com/272563229032201.jpg?r1024x1024)
![Forks](https://img.shields.io/github/forks/LarsBuergerr/mastermind?color=green&style=social)
![Watcher](https://img.shields.io/github/watchers/LarsBuergerr/mastermind?style=social)
[![Reddit](https://img.shields.io/reddit/subreddit-subscribers/ich_iel?color=green&style=social)](https://www.reddit.com/r/ich_iel/comments/aje7qh/ich_iel/)
[![Reddit2](https://img.shields.io/reddit/subreddit-subscribers/sailing?style=social)](https://www.reddit.com/r/sailing)

---

## Contributors
| [LarsBuergerr](https://github.com/LarsBuergerr)  |  [Smokey95](https://github.com/Smokey95) | 
|---|---|
| ![image](https://github-readme-streak-stats.herokuapp.com/?user=LarsBuergerr) | ![image](https://github-readme-streak-stats.herokuapp.com/?user=Smokey95)  |

---

## Description

This is a implementation of the game Mastermind. The game is played against the computer. The game creates a secret code of four to five stones (depends on the chosen difficult) . The layer tries to guess the code. After each guess the player gets feedback about how many stones are in the right position and how many stones are in the wrong position. The game ends when the player guesses the code or when the player has used all his tries.

## How to play
| Icon | Description               |
|-----------------|--------------------------------|
| <img src="src/main/resources/coursers/courser_R.png" style="width:50px;"/> | <span style="font-size:larger;">Courser shows the current selected color which is used when placing stones</span> |
| <img src="src/main/resources/info/scroll.png" style="width:50px;"/> | <span style="font-size:larger;">Scroll down your mouse wheel to change the courser color and therefore the stone placing color</span> |
| <img src="src/main/resources/info/left-click.png" style="width:50px;"/> | <span style="font-size:larger;">Place your guess on an empty stone in the current row (see point below)</span> |
| <img src="src/main/resources/stones/stone_A.png" style="width:50px;"/> | <span style="font-size:larger;">Empty stone where you can place your hint (Shows the active row)</span> |
| <img src="src/main/resources/hintstones/hstone_W.png" style="width:50px;"/> | <span style="font-size:larger;">Hint that shows you that you guess a right color but at the wrong position</span> |
| <img src="src/main/resources/hintstones/hstone_R.png" style="width:50px;"/> | <span style="font-size:larger;">Hint that shows you that you guess a right color and at the right position</span> |

## Win/Lose
You won the game if you guess the secret code so that all hint stones are red. 
You lose the game if you used all your tries and you did not guess the secret code.

---

<!--- BRANCH 07 ONLY --->
## 07-Design Pattern Info

The following pattern are implemented:
### Strategy:
The strategy pattern was used to select a gamemode according to userinput. See the implementation [here](https://github.com/LarsBuergerr/mastermind/blob/07-DesignPattern/src/main/scala/de/htwg/se/mastermind/util/GameMode.scala)

### Factory:
The factory pattern replaces the original enum declaration of the stones. To show the difference the game-stones are implemented using the pattern, the hint-stones are still implemented as enum. See the implementation [here](https://github.com/LarsBuergerr/mastermind/blob/07-DesignPattern/src/main/scala/de/htwg/se/mastermind/model/Stone.scala)

### State:
The state pattern was used to keep track over current game state. There are events defined to switch the state of a game instance and methods to check the current state. See the implementation of the states [here](https://github.com/LarsBuergerr/mastermind/blob/07-DesignPattern/src/main/scala/de/htwg/se/mastermind/model/State.scala). The Events are defined [here](https://github.com/LarsBuergerr/mastermind/blob/07-DesignPattern/src/main/scala/de/htwg/se/mastermind/util/Event.scala). To switch between states there is a handler (called request) implemented in game class [here](https://github.com/LarsBuergerr/mastermind/blob/07-DesignPattern/src/main/scala/de/htwg/se/mastermind/model/Game.scala)

### Chain of Responsibility:
The Cain-of-Responsibility is used so analyze users input. See the implementation [here](https://github.com/LarsBuergerr/mastermind/blob/07-DesignPattern/src/main/scala/de/htwg/se/mastermind/util/Request.scala) and in the game class


---      
      
## Attribution
We thank the following people for their contributions to this project:

| Creator         | Content               | Link |
|-----------------|-----------------------|------------|
| Smashicons      | Mouse Scroll Icon     | [Scroll Logo Template](https://www.flaticon.com/free-icon/scroll_3646197?term=mouse%20wheel&related_id=3646197)      |

