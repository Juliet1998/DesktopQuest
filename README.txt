![Desktop Quest](./DesktopQuest/src/images/example.png)

How to Run 
1. executable jar is provided within the zip file, double click to run
2. The build environment for this project is Java 8, should be able to 
   run on the most machines (tested already).
3. This project did not use extra module or library.


How to Play
1.This project is a RPG game rendered with windows-like UIs.
2.Highly recommanded to open all windows before proceeding the events to check game features.
3.More Instructions are accessible in the game via the user guide interface.

Menubar
1.The menubar is within the help guide with full functionalities. (as it should be in desktop interface)

Fast way to win game
1.Keep proceeding with events until you see a event said "You find a box. It says "Java" on it."
2.Choose "Open the box" and you will get an item looks like java icon
3.At goal, choose "Show the coffee" and you will win the game

Other ways to win (Game structures)
1.Take 30 damage - you need to reach at least level 4 to have more then 30 HP
2.Vitality - you need equipments to increase your Vitality
3."Coffee" - as described above, only need the certain item in your bag or equipped

Other game features (If hard to understand)
1.Items are consumable, they will dispose when appeared, after adding described effect to your status.
2.Equipment can be equip from bag window and unequipped from player window
3.You need to right click on item to trigger the popup menu (mentioned in the item details)
4.Double click may not respond sometimes, quick click twice usually solves it. This is how java listener takes the click counted. 

The IDE for this project is intellij, so the project directory is different from a normal project,
If it looks confused please refer to the following path to find the file.

DesktopQuest/src   		Source folder containing all source code for this project (Main Class called "Runner.java")
DesktopQuest/src/images		Resource folder containing all image files used as icon in this project 
DesktopQuest/out/production	compiled java .class files
DesktopQuest/.idea 		intellij setting files (not important)
