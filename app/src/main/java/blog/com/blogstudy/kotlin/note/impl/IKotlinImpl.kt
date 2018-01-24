package blog.com.blogstudy.kotlin.note.impl

import blog.com.blogstudy.kotlin.note.inteface.BaseKotlinInterface

/**
 * Created by admin on 18/1/24.
 */
class IKotlinImpl : BaseKotlinInterface<String> {
    override fun create(): String = "abc"
}