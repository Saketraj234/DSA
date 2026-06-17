/**
 * Problem: 355. Design Twitter
 *
 * Design a simplified version of Twitter where users can:
 * - Post tweets
 * - Follow / Unfollow other users
 * - Retrieve the 10 most recent tweets in their news feed
 *
 * Approach:
 * We use:
 * 1. HashMap<Integer, Set<Integer>> to store follow relationships.
 * 2. HashMap<Integer, Tweet> to store latest tweet of each user.
 * 3. Linked List of tweets for every user.
 * 4. Max Heap (PriorityQueue) to get most recent tweets.
 *
 * Each tweet stores:
 * - tweetId
 * - timestamp
 * - next pointer (older tweet)
 *
 * For getNewsFeed():
 * - Add latest tweet of user and followees into Max Heap.
 * - Remove most recent tweet.
 * - Add its next older tweet into heap.
 * - Repeat until 10 tweets are collected.
 *
 * Time Complexity:
 * postTweet()  : O(1)
 * follow()     : O(1)
 * unfollow()   : O(1)
 * getNewsFeed(): O(10 * log(F))
 * where F = number of followees
 *
 * Space Complexity:
 * O(N)
 */

class Twitter {

    // Tweet node
    class Tweet {

        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {

            this.tweetId = tweetId;
            this.time = time;
            this.next = null;
        }
    }

    // userId -> set of followees
    private Map<Integer, Set<Integer>> followMap;

    // userId -> latest tweet
    private Map<Integer, Tweet> tweetMap;

    // Global timestamp
    private int time;

    public Twitter() {

        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        // Create new tweet
        Tweet newTweet = new Tweet(tweetId, time++);

        // Link with previous latest tweet
        newTweet.next = tweetMap.get(userId);

        // Update latest tweet
        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> newsFeed = new ArrayList<>();

        // Max Heap according to timestamp
        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // User should follow himself
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Add latest tweet of every followee
        for (int followeeId : followMap.get(userId)) {

            if (tweetMap.containsKey(followeeId)) {

                maxHeap.offer(tweetMap.get(followeeId));
            }
        }

        // Get latest 10 tweets
        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {

            Tweet currTweet = maxHeap.poll();

            // Add tweet id to answer
            newsFeed.add(currTweet.tweetId);

            // Push next older tweet of same user
            if (currTweet.next != null) {

                maxHeap.offer(currTweet.next);
            }
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        // User cannot unfollow himself
        if (followerId == followeeId) {

            return;
        }

        if (followMap.containsKey(followerId)) {

            followMap.get(followerId).remove(followeeId);
        }
    }
}