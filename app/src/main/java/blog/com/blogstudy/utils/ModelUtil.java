package blog.com.blogstudy.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MDove on 2017/12/18.
 */
public class ModelUtil {

    public static <T extends IModel> IModel convertTo(T model) {
        return model;
    }

    public static <T extends IModel> List<IModel> convertTo(List<T> list) {
        if (list == null) {
            return null;
        }
        List<IModel> result = new ArrayList<>();
        for (T t : list) {
            result.add(t);
        }
        return result;
    }
}
