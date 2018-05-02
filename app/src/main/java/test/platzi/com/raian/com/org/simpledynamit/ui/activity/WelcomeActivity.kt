package test.platzi.com.raian.com.org.simpledynamit.ui.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.app_bar_welcome.*
import test.platzi.com.raian.com.org.simpledynamit.R
import test.platzi.com.raian.com.org.simpledynamit.ui.fragments.InitialWelcomeFragment

class WelcomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = WelcomeActivity::class.java.simpleName
    private lateinit var mButtonDimissWelcome: Button
    private lateinit var welcomeMessageLayoutContainer: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        initializeView()
        addDismissListener()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.welcome, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun initializeView() {
        mButtonDimissWelcome = findViewById(R.id.mButtonDimissWelcome)
        welcomeMessageLayoutContainer = findViewById(R.id.welcomeMessageLayoutContainer)
    }

    private fun addDismissListener(){
        mButtonDimissWelcome.setOnClickListener(View.OnClickListener {
            loadInitFragment()
            hideWelcomeMessageLayoutContainer()
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_initial_welcome_fragment -> {
                // Handle the camera action
                Log.d(TAG, "Navigating to -->> onNavigationItemSelected::nav_initial_welcome_fragment")
                loadInitFragment()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun hideWelcomeMessageLayoutContainer(){
        welcomeMessageLayoutContainer.visibility= View.GONE
    }

    private fun loadInitFragment(){
        Runnable {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.mFrameLayoutMainContent,
                            InitialWelcomeFragment(),
                            InitialWelcomeFragment::class.java.simpleName)
                    .commit()
        }.run()
        hideWelcomeMessageLayoutContainer()
    }

}
