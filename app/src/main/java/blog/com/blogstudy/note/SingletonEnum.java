package blog.com.blogstudy.note;

/**
 * Created by MDove on 2017/12/12.
 */

public enum  SingletonEnum {
    INSTANCE;
    private Singleton instance;
    SingletonEnum() {
        instance = Singleton.getInstance();
    }
    public Singleton getInstance() {
        return instance;
    }
}
