package jp.mixi.practice.test.target;

/**
 * TODO: TestPractice2 の各テストケースをパスするメソッドを書く
 */
public class TestTarget2 {
    public boolean isValidLength(String string) {
    	int length = string.length();
    	
    	if (0 < length && length <= 10) {
    		return true;
    	}
        return false;
    }

    public String formatTextCount(int count, int max) {
        return count + " / " + max;
    }
}