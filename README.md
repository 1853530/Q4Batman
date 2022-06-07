# Q4Batman
## Game Description:
In this game, the user plays as batman and has to evade and shoot various enemies such as Drip Goku, Bane, Deathstroke, and the Rock. Batman shoots and defeats the villans by facing the villans, and pointing his gun at them. The player's score increases at the top left of the screen only if the player deals damage to the villians by shooting them. If the user does not deal damage to the villians, the user's score doesn't increment. If the player reaches 2,000 points, Drip Goku appears and shoots lasers out of his eyes at the player. Once the player defeats Goku, level 2 begins, the screen changes, Bane appears, and moves very rapidly across the screen. Once Bane is defeated, level 3 begins, Deathstroke appears, and starts shooting at the player. Throughout the game, Smash Balls fom Super Smash Bros appears that gives Batman special Batmbobile powers for a short time. If the user clashes with either one of the obstacles, Baman's hp runs out, the game ends, and the score resets to 0. See below for more information of different objects, their classes, and how the game works.

### Usage:
W key = Jump
A key = Face right
A key (hold) = Move right
D key = Face left
D key (hold) = Move left


#### Classes:

##### Frame Class:
This class is designed to set up all objects, collisions, and movement that is observed during gameplay. It contains all the code neccessary to put the objects in motion, and for them to interact with eachother



###### Batman Class:
This class is made to set up the Batman character that the user plays as. Only one Batman object is created in frame. It was originally created in pixilart.com, and it was custom drawn by Jacob.

![pixilart-drawing](https://user-images.githubusercontent.com/90793175/172443280-add3a374-aead-41a2-8fba-179953fa67de.gif)

###### Rock Class: 
This class is made for the Rock, one of the objects that the player has to evade. Two Rock objects is created are frame. However, several loops are placed in the code that makes it seem like there is an endless amount of Rock enemies that spawn after the user kills one. 

![theRock-removebg-preview (3)](https://user-images.githubusercontent.com/90793175/172443774-2f5fbaf5-7aa7-4743-8984-f7aafa8c1c03.png)


##### Background Class: 
This class is made to set up the Gotham City backgrounds that can be seen in the game.

![maxresdefault](https://user-images.githubusercontent.com/90793175/172444053-9e495f7f-2c9c-4cf9-b311-db330f8b4725.jpg)

![background2](https://user-images.githubusercontent.com/90793175/172444159-1956d857-0916-40c4-af6b-fd70b8e65fc7.jpg)


###### Boss Class:
This class is made for Drip Goku, one of 3 final bosses that the user has to defeat. One Goku object is created in frame. Once Goku's health runs out, he dissapears to the bottom of the screen and is never seen again.

![goku  drippy](https://user-images.githubusercontent.com/90793175/172444282-b561522c-58ba-410e-b85a-c9a0ab46a728.png)

###### Laser Class:
This class is made for the lasers that shoot out of Goku's eyes, and works exactly the same as Goku's code.

![output-onlinegiftools (6)](https://user-images.githubusercontent.com/90793175/172444668-2c1ed235-5214-4817-8cdf-4a5e51847c94.gif)


###### Gun Class:
This class is made for the gun that Batman uses to shoot the villans. One Gun class is created in frame. The gun sticks to Batman by following Batman's every move, and flips every time Batman turns left or right. 

![gun](https://user-images.githubusercontent.com/90793175/172444755-6efd7857-f248-4740-975b-72b68a040118.gif)

![leftGun](https://user-images.githubusercontent.com/90793175/172444836-2538062b-28b9-4246-9e0b-f7f94467fe32.gif)

###### Bane Class: 
This class is made for Bane, another one of the final bosses that the user has to defeat. One Bane object is created in frame. Once Bane's health runs out, he dissapears to the bottom of the screen and is never seen again.

![bane](https://user-images.githubusercontent.com/90793175/172444992-e38933cd-809a-4242-bcaf-48c5ce830516.gif)


##### finalSmash Class:
This class is made for the Final Smash Ball that the user can collide with and gain Batmobile powers for a short time. One Smash Ball object is created in frame. Once the user collides into the Smash Ball, the Smash Ball resets to a place on the screen where it can't be seen until the user has to battle one of the final bosses.

![smashball](https://user-images.githubusercontent.com/90793175/172445220-9a6b2739-9959-4068-ace9-8b9929f8f733.png)


##### Batmobile Class:
This class is made for the Batmobile animation that plays once the user collides with the Smash Ball. One Batmobile object is created in frame. Once the Batmbile animation is activated, it resets to a place on the screen where it can't be seen until the user collides with the smash ball again.

![batmobile](https://user-images.githubusercontent.com/90793175/172445287-d63865d5-6bc5-4b57-8e66-ae306c4daa3e.gif)


##### Deathstroke Class:
This class is made for Deathstroke, the last final boss that the user has to defeat. One Deathstroke object is created in frame. Once Bane's health runs out, he dissapears to the bottom of the screen and is never seen again. 

![Deathstroke_mkvsdc_white](https://user-images.githubusercontent.com/90793175/172445884-2af4345b-9142-4aba-a460-70e446b2ca8b.jpg)


##### Collisions for Batman and Rock enemies:
Collisions between Batman and the Rock obstacles are a very important factor in this game. This is because when Batman comes in contact with either the first or second Rock enemy, the game stops and the user's score is reset to 0. Collisions are coded by using if statements that check to see whether or not the line of fire of Batman's gun is in the same path as the Rock objects' movement. If statements are also put in place to check the Rock's hp level. If the Rock's hp is 0, the Rock objects disappear the far right of the screen and are never seen again.

![IMG_4728](https://user-images.githubusercontent.com/90793175/172446742-91b5723e-a856-437c-a539-7f374f1aee0a.jpg)

![IMG_4704 (1)](https://user-images.githubusercontent.com/90793175/172446988-6d4d9ff2-f940-473d-9400-066afaa0b8ac.jpg)



##### Collisions between Batman and Final Bosses:
Collisions between Batman and final bosses are similar to the collisions between Batman and the Rock enemies. Collisions are coded by using if statements that check to see whether or not the line of fire of Batman's gun is in the same path as the final boss's movement. If statements are also put in place to check the final boss's hp level. If the final boss's hp is 0, the final boss objects disappear the bottom of the screen and is never seen again.

![IMG_4729](https://user-images.githubusercontent.com/90793175/172447351-28ae42b5-a4de-4402-8cf2-0232387be27e.jpg)


#### Collisions between Batman and Final Smash Ball:
Collision between the final smash ball and Batman is coded by using an if statement to check to see if the vertical level of the ball overlaps the horizontal level of Batman. If this is the case, the ball disappears to the far right side of the screen, the Batmobile anaimation from Batman Arkham Knight plays, and the user gets special Batmobile powers for a short time.

![IMG_4733](https://user-images.githubusercontent.com/90793175/172448389-86cb5b32-106b-4580-bdb2-c3c103540962.jpg)


#### How Objects are Created: 
The objects in the game are created under Frame.java. The individual objects in my game are created regularly without any for loops.

![IMG_4735](https://user-images.githubusercontent.com/90793175/172448888-5f5ce966-ac40-474d-9312-664f9f93643b.jpg)


#### Roadmap: 
If any future updates were to happen, I would most likely add power-ups that Batman can use throughout the game. Some ideas that I have for power-ups that I could incorporate into the game would be a power-up that restores Batman's hp, a power-up that upgrades Batman's gun to deal more damage permanently throughout the rest of the game, and a power-up that changes Batman's suit to give him more defense.

#### Authors and Acknowledgement:
Background, Bane, Drip Goku, Batmobile animation, Smash Ball, Rock, and Deathstroke are all images from Google. All other images are from pixilart.com, and are custom drawn by me. This game was coded by Jacob Simbulan and Isaac Valle, and was based on the original Mario game.
