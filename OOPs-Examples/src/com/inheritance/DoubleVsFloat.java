package com.inheritance;


public class DoubleVsFloat {
	public static void main(String[] args) {
		float f = 10.12345678912f;
		double d = 10.1234567823456344566;
		System.out.println(f);
		System.out.println(d);
	}

}
//public void deleteTweet(Scanner scanner) {
//
//    System.out.println("Enter the ID of the tweet to delete: ");
//    String tweetId = scanner.nextLine();
//
//    Tweet tweet = findTweetById(tweetId);
//    if (tweet != null && tweet.getAuthor().equals(currentUser.getUsername())) {
//        tweets.remove(tweet);
//        currentUser.deleteTweet(tweetId);
//        System.out.println("Tweet deleted successfully.");
//    } else {
//        System.out.println("Tweet not found or you don't have permission to delete it.");
//    }
//}
//
//
//private Tweet findTweetById(String tweetId) {
//	for(Tweet tweet : tweets) {
//		if(tweet.getTweetId().equals(tweetId)) {
//			return tweet;
//		};
//	}
//	return null;
//}





//private static final String USERS_FILE = "users.txt";
//private static final String TWEETS_FILE = "tweets.txt";
//
//public static void saveData(Map<String, User> users, List<Tweet> tweets) {
//    saveUsers(users);
//    saveTweets(tweets);
//    System.out.println("Data saved successfully.");
//}
//
//public static Map<String, User> loadDataUsers() {
//    return loadUsers();
//}
//
//public static List<Tweet> loadDataTweets() {
//    return loadTweets();
//}
//
//static void saveUsers(Map<String, User> users) {
//    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
//        oos.writeObject(users);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//static Map<String, User> loadUsers() {
//    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
//        return (Map<String, User>) ois.readObject();
//    } catch (IOException | ClassNotFoundException e) {
//        return new HashMap<>();
//    }
//}
//
//static void saveTweets(List<Tweet> tweets) {
//    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TWEETS_FILE))) {
//        oos.writeObject(tweets);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//static List<Tweet> loadTweets() {
//    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TWEETS_FILE))) {
//        return (List<Tweet>) ois.readObject();
//    } catch (IOException | ClassNotFoundException e) {
//        return new ArrayList<>();
//    }
//}
//public static String generateTweetId() {
//    String uniqueId = UUID.randomUUID().toString(); // Generate a unique identifier
//    LocalDateTime currentTime = LocalDateTime.now(); // Get the current timestamp
//
//    String tweetId = uniqueId + "_" + currentTime.toString();
//
//    return tweetId;
//}
//
//
//public void saveData() {
//    DataStore.saveUsers(users);
//    DataStore.saveTweets(tweets);
//}
//
//public void loadData() {
//    users = DataStore.loadUsers();
//    tweets = DataStore.loadTweets();
//}