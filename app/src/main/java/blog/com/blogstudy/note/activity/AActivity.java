package blog.com.blogstudy.note.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import blog.com.blogstudy.R;

/**
 * Created by admin on 18/1/4.
 */

public class AActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_a);
    }

    public void aaa(View view) {
        Intent to = new Intent(this, BActivity.class);
        startActivity(to);
    }
}
