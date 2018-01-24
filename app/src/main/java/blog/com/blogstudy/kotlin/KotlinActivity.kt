package blog.com.blogstudy.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

import blog.com.blogstudy.R
import blog.com.blogstudy.kotlin.adapter.KotlinAdapter
import blog.com.blogstudy.kotlin.model.KotlinModel
import blog.com.blogstudy.kotlin.note.KotlinNote

class KotlinActivity : AppCompatActivity() {
    //因为Adapter的构造函数，没有支持null（默认不是传为null的对象，需要显示使用？）,所以需要先初始化
    var data = ArrayList<KotlinModel>()
    val TAG = "KotlinActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        init()
        val rlv = findViewById(R.id.rlv) as RecyclerView
        /**
         *  不需要声明new
         *  rlv.layoutManager就是相当于调用了java的set
         */
        rlv.layoutManager = LinearLayoutManager(this)
        rlv.adapter = KotlinAdapter(data)
    }

    private fun init() {
        data = arrayListOf(
                KotlinModel("AAAAAA", R.mipmap.ic_launcher),
                KotlinModel("BBBBBB", R.mipmap.ic_launcher_round),
                KotlinModel("CCCCCC", R.mipmap.ic_launcher),
                KotlinModel("DDDDDD", R.mipmap.ic_launcher_round),
                KotlinModel("EEEEEE", R.mipmap.ic_launcher),
                KotlinModel("FFFFFF", R.mipmap.ic_launcher_round)
        )
    }
}
