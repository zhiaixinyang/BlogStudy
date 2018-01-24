package blog.com.blogstudy.recyclerview.refresh.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

import java.util.ArrayList
import java.util.Timer
import java.util.TimerTask

import blog.com.blogstudy.R
import blog.com.blogstudy.recyclerview.refresh.adapter.LoadMoreAdapter
import blog.com.blogstudy.recyclerview.refresh.listener.EndlessRecyclerOnScrollListener

/**
 * Created by MDove on 17/12/15.
 */

class RlvRefreshActivity : AppCompatActivity() {
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null
    private var loadMoreAdapter: LoadMoreAdapter? = null
    private val dataList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rlv_refresh)

        init()
    }

    private fun init() {
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout) as SwipeRefreshLayout
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView

        // 设置刷新控件颜色
        swipeRefreshLayout!!.setColorSchemeColors(Color.parseColor("#4DB6AC"))

        // 模拟获取数据
        getData()
        loadMoreAdapter = LoadMoreAdapter(dataList)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = loadMoreAdapter

        swipeRefreshLayout!!.setOnRefreshListener {
            dataList.clear()
            getData()
            loadMoreAdapter!!.notifyDataSetChanged()

            swipeRefreshLayout!!.postDelayed({
                if (swipeRefreshLayout != null && swipeRefreshLayout!!.isRefreshing) {
                    swipeRefreshLayout!!.isRefreshing = false
                }
            }, 2000)
        }

        recyclerView!!.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                loadMoreAdapter!!.setLoadState(loadMoreAdapter!!.LOADING)
                if (dataList.size < 52) {
                    Timer().schedule(object : TimerTask() {
                        override fun run() {
                            runOnUiThread {
                                getData()
                                loadMoreAdapter!!.setLoadState(loadMoreAdapter!!.LOADING_COMPLETE)
                            }
                        }
                    }, 2000)
                } else {
                    loadMoreAdapter!!.setLoadState(loadMoreAdapter!!.LOADING_END)
                }
            }
        })
    }

    private fun getData() {
        var letter = 'A'
        for (i in 0..25) {
            dataList.add(letter.toString())
            letter++
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.layout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.liner -> recyclerView!!.layoutManager = LinearLayoutManager(this)

            R.id.grid -> recyclerView!!.layoutManager = GridLayoutManager(this, 2)
        }
        dataList.clear()
        getData()
        recyclerView!!.adapter = loadMoreAdapter
        return super.onOptionsItemSelected(item)
    }
}
