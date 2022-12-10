

public class Like extends Message {
	private int numberOfLikes;	
	public int likeCounter(int numberOfLikes) {
		return numberOfLikes;
	}
	private int newLike(int numberOfLikes) {
		return ++numberOfLikes;
	}
	private int takeLikeBack(int numberOfLikes) {
		return --numberOfLikes;
	}
}
