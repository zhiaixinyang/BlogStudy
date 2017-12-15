package blog.com.blogstudy.note;

/**
 * Created by MDove on 2017/12/12.
 */

public class Singleton {

    private Singleton (){}

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
