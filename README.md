# isla-SubBook
##Cmput 301 W18 Assignment 1

##SubBook

Application to keep track of monthly subscriptions. Displays values that show the name of a subscription, the date the subscription started, the monthly charge for the subscription, and an optional comment. Users can add new subscriptions, as well as view, edit, and delete existing subscriptions.

The application displays subscriptions in a listview in the Main Activity (SubBook). The user can click on an item in the list to view details of the subscription, and edit or delete the entry in another activity. The user can also click an Add Subscription Button on the main screen that takes them to a new activity to add a new subscription.

The app retains information when it is closed so that subscriptions still exist when they reopen the app later. This information is stored in a file and is read from the same file on app startup (onCreate).

##References

Custom Adapter Implementation:

Using lists in Android wth ListView - Tutorial
Lars Vogel, (c) 2010, 2016 vogella GmbH
Version 6.2,
09.11.2016
http://www.vogella.com/tutorials/AndroidListView/article.html#androidlists_overview

and

Android Studio For Beginners Part 3 video on YouTube
https://www.youtube.com/watch?v=rdGpT1pIJlw

Get Value from child activity and add to listview:

https://stackoverflow.com/questions/47202613/solvedadding-new-listview-item-and-get-value-of-item-from-another-activity

onCreate vs onStart (when to loadfromFile()):

https://stackoverflow.com/questions/6812003/difference-between-oncreate-and-onstart

Pass custom Class object via Serializable:

https://stackoverflow.com/questions/2736389/how-to-pass-an-object-from-one-activity-to-another-on-android

