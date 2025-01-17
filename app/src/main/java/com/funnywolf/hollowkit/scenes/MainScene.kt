package com.funnywolf.hollowkit.scenes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.bytedance.scene.Scene
import com.excelsior.scenes.ViewLocationScene
import com.funnywolf.hollowkit.R
import com.funnywolf.hollowkit.scenes.douban.DoubanDetailScene
import com.funnywolf.hollowkit.scenes.behavior.ScrollBehaviorScene

/**
 * 主页
 *
 * @author https://github.com/funnywolfdadada
 * @since 2020/3/21
 */
class MainScene: Scene() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.scene_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(R.id.bt_test, TestScene::class.java)
        bind(R.id.bt_nested_scroll_behavior, ScrollBehaviorScene::class.java)
        bind(R.id.bt_rich_text, RichTextScene::class.java)
        bind(R.id.stateful_layout, StatefulLayoutScene::class.java)
        bind(R.id.okhttp_progress, OkHttpProgressScene::class.java)
        bind(R.id.bt_activity_result, ActivityResultScene::class.java)
        bind(R.id.bt_permission, PermissionRequestScene::class.java)
        bind(R.id.bt_douban, DoubanDetailScene::class.java)
        bind(R.id.bt_view, ViewLocationScene::class.java)
        bind(R.id.bt_view, ViewLocationScene::class.java)

//        ARouter.getInstance().build("/activity_study/StandardActivity").navigation();
    }

    private fun bind(id: Int, clazz: Class<out Scene>) {
        findViewById<View>(id)?.setOnClickListener {
            navigationScene?.push(clazz)
        }
    }

}