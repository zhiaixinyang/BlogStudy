package blog.com.blogstudy.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by MDove on 2017/12/12.
 */

public class BaseActivity extends AppCompatActivity {
    private List<IBackHandler> backHandlers = new ArrayList<>();

    public interface IBackHandler {
        boolean handleBackPressed();
    }

    protected boolean handleBack() {
        if (backHandlers.isEmpty()) {
            return false;
        }
        ListIterator<IBackHandler> li = backHandlers.listIterator(backHandlers.size());
        while (li.hasPrevious()) {
            if (li.previous().handleBackPressed()) {
                return true;
            }
        }

        return false;
    }

    //需要特殊操作，可以在子类中复写此方法
    protected boolean interceptExitBackPress() {
        return false;
    }
    protected Intent createBackIntent() {
        return null;
    }

    @Override
    public void onBackPressed() {
        if (handleBack()) {
            return;
        }
        if (isTaskRoot()) {
            Intent backIntent = createBackIntent();
            if (backIntent != null) {
                startActivity(backIntent);
                finish();
                return;
            }
        }
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount == 0) {
            if (interceptExitBackPress()) {
                return;
            }
        }
        super.onBackPressed();
    }
    public void addBackHandler(IBackHandler backHandler) {
        if (backHandlers.contains(backHandler)) {
            backHandlers.remove(backHandler);
        }
        backHandlers.add(backHandler);
    }

    public void removeBackHandler(IBackHandler backHandler) {
        backHandlers.remove(backHandler);
    }
}
