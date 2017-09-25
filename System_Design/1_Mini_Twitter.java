/**
 * Question description: Implement a simple twitter. Support the following method:
 * 
 *	postTweet(user_id, tweet_text). Post a tweet.
 *	getTimeline(user_id). Get the given user's most recently 10 tweets posted by himself, order by timestamp from 
 *		most recent to least recent.
 *	getNewsFeed(user_id). Get the given user's most recently 10 tweets in his news feed (posted by his friends and 
 *		himself). Order by timestamp from most recent to least recent.
 * 	follow(from_user_id, to_user_id). from_user_id followed to_user_id.
 *	unfollow(from_user_id, to_user_id). from_user_id unfollowed to to_user_id.
 *
 */

/**
 * Author: Jinglong Guo
 * Category: System Design.
 */

/**
 * Progress...
 * Create Date: 09/23/2017
 */

/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */

// More reasonable solution.


// One simple work solution.
public class MiniTwitter {

    // Need two tables: friendship table and tweets table.
    private Map<Integer, List<Integer>> friendship;
    private List<Tweet> tweets;
    
    public MiniTwitter() {
        friendship = new HashMap<>();
        tweets = new ArrayList<>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet= Tweet.create(user_id, tweet_text);
        tweets.add(tweet);
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        List<Tweet> result = new ArrayList<>();
        List<Integer> friends = friendship.get(user_id);
        for (int i = tweets.size() - 1; i >= 0 && result.size() < 10; i--) {
            Tweet tempTweet = tweets.get(i);
            if (tempTweet.user_id == user_id || (friends != null && friends.contains(tempTweet.user_id))) {
                result.add(tempTweet);
            }
        }
        
        return result;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        List<Tweet> result = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0 && result.size() < 10; i--) {
            Tweet tempTweet = tweets.get(i);
            if (tempTweet.user_id == user_id) {
                result.add(tempTweet);
            }
        }
        
        return result;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        if (!friendship.containsKey(from_user_id)) {
            List<Integer> list = new ArrayList<>();
            friendship.put(from_user_id, list);
        }
        friendship.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        if (!friendship.containsKey(from_user_id)) {
            return;
        }
        List<Integer> list = friendship.get(from_user_id);
        System.out.println(list.get(0));
        if (!list.contains(to_user_id)) {
            return;
        }
        list.remove((Integer) to_user_id);
        if (list.size() == 0) {
            friendship.remove(from_user_id);
        }
    }
}


