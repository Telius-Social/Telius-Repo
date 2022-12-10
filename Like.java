

public class Like extends Message {
	private int numberOfLikes;	
	public int likeCounter(int numberOfLikes) {
		return numberOfLikes;
	}
	private static int newLike(int numberOfLikes) {
		return ++numberOfLikes;
	}
	private static int takeLikeBack(int numberOfLikes) {
		return --numberOfLikes;
	}
}
