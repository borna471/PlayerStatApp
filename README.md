# CPSC 210 Personal Project


## What will the application do?

The application will be a soccer statistics app that allows 
easy access to **player statistics** **across seasons** and different 
measures, with **comparison tools** as well.

#### Demo Video
https://www.loom.com/share/53e40056423e4f8e89c25061976cc67e

## Who will use it?

There are a multitude of personas that could make use of 
this product: 

- avid soccer fans needing quick reference of player stats
- commentators and professionals that may need quick reference
or comparison between players
- any young fan that may need to bring statistics to support
their argument regarding players in a discussion

  


## Why is the project of interest to me?

Just yesterday, I was amidst a heated discussion regarding 
the French striker Karim Benzema, and his status among
other great strikers of this generation. Aside from the 
extreme differences in opinion, we all had the issue of
not having easy access to statistics to support our statements,
with some sources being questioned, not accurate, or not
presenting the desired amalgamation of data to us users in 
dire need of relevant stats. As such, our discussion went 
sideways and ended in a stalemate, with no one side getting 
their points across effectively. This has been a recurring 
issue for us, and I believe a very simple solution that can 
even be built by a beginner programmer such as myself would 
help this problem immensely. I hope to create a simple, but 
effective platform with a variety of use cases, solving this
issue to the best degree possible. 



### User Stories

- As a user, I want to be able to view a player's (only attackers) stats (goals,
assists, goals per game, games played, goals in last 10 mins, etc.)
for the last season

- As a user, I want to be able to compare players, by adding
desired players to a compare-list

- As a user, I want to be able to filter players by positions

- As a user, I want to be able to navigate between these tabs
  and features through a menu

### Data Persistence Stories

- As a user, I want to be able to save my list of players to 
compare (players in my compare list)
- As a user, I want to be able to load a previously saved
compare list of players


## Instruction for Grader

- To use the add player function: enter a player's name with the right capitalization and 
press enter, their name, position, and some statistics will show up beside their name at 
the bottom of the app. Currently the only available options are the following players: Messi,
Ronaldo, Benzema, Lewandowski, Salah. Enter their names as they have been written here and 
the add player button will complete the task
- To remove a player, select them in the list and press the remove button. Their name will 
disappear and be removed from the list object displayed
- The visual component is in the form of an image, which is shown in
the form of a photo that appears on the right side of the 
frame, a picture of a goat when the name "Messi" is 
entered and then button "add player" is pressed. Full screen the app
to view everything better after this image appears
- Press the 'save current list' button to save the current list seen at the bottom of the screen
- press the 'load saved list' button to load and present the previously saved list at the 
bottom of the screen


### Phase 4: Task 2 (sample eventLog)

Thu Aug 11 14:36:28 PDT 2022 \
Messi was added to the list \
Thu Aug 11 14:36:52 PDT 2022 \
Ronaldo was added to the list \
Thu Aug 11 14:36:55 PDT 2022 \
Messi was removed from the list \
Thu Aug 11 14:37:03 PDT 2022 \
Benzema was added to the list  \
Thu Aug 11 14:37:03 PDT 2022 \
Ronaldo was added to the list \
Thu Aug 11 14:37:07 PDT 2022 \
Ronaldo was removed from the list 


### Phase 4: Task 3 (reflection)

- To improve my design, I would make my model classes 
more accessible to the GUI so they arent only used for the backend mainly
- A lot of my methods and features on the GUI would break completely
if I was to make any changes to the data or content on the ListModel used
- I would also improve my UI in my phase 3 submission to be more clean,
especially when the visual aspect shows up
