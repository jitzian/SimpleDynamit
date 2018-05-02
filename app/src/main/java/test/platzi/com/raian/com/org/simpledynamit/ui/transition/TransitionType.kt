package test.platzi.com.raian.com.org.simpledynamit.ui.transition

enum class TransitionType constructor(val entryAnimationResource: Int,
                                      val exitAnimationResource: Int,
                                      val popEntryAnimationResource: Int,
                                      val popExitAnimationResource: Int){

    CROSS_FADE(17432576, 17432577, 17432576, 17432577)
}

