-----Story Service Endpoints-----

--NOTES--

The key value pairs are what is need to get something back form the database.
Use the exact name for the key that is defined below.
For /allSories and /StoryLane I was not sure with way would be better.
You can ether put the lane type id in the URL or in a key value pair.
They both need a the other id to work as well.

--CREATE--

/addStory
key: board, value: (board ID)
key: storyName, value: (String value)
key: storyPoints, value: (int value 1-10)
key: storyDesc, value: (String value)

--READ--

/story/{Story ID}

/allStories/{Lane Type ID}
key: board, value: (board ID)

/allStories
key: board, value: (board ID)
key: laneType, value: (Lane Type ID)

--UPDATE--

/storyLane/{Lane Type ID}
key: storyId, value: (Story ID)

/storyLane
key: storyId, value: (Story ID)
key: laneType, value: (Lane Type ID)

--DELETE--
