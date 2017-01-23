package com.odai.firecats.cats

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.odai.firecats.CatApplication
import com.odai.firecats.R
import com.odai.firecats.cats.view.AndroidCatsView
import com.odai.firecats.cats.displayer.CatsDisplayer
import com.odai.firecats.loading.LoadingDisplayer
import com.odai.firecats.navigation.AndroidNavigator
import kotlinx.android.synthetic.main.activity_cats.*

class CatsActivity : AppCompatActivity() {

    private var _catsPresenter: CatsPresenter? = null

    private var catsPresenter: CatsPresenter
        get() = _catsPresenter!!
        set(value) {
            _catsPresenter = value
        };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats)
        catsPresenter = CatsPresenter(
                getCatApplication().catsService,
                getCatApplication().favouriteCatsService,
                AndroidNavigator(this),
                content,
                loadingView
        )
    }

    private fun getCatApplication(): CatApplication {
        return application as CatApplication
    }

    override fun onResume() {
        super.onResume()
        catsPresenter.startPresenting()
    }

    override fun onPause() {
        super.onPause()
        catsPresenter.stopPresenting()
    }

}