package Error;

public class MazeReadingException extends Exception {
	public void MazeReadingException(String fileName , int line , String errorMessage) {
		System.out.println(errorMessage);
	}
}
