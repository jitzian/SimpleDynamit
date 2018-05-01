package test.platzi.com.raian.com.org.simpledynamit.ui

interface BasePresenter<V:BaseView>{
    fun attachView(view: V)
    fun dettachView()
}