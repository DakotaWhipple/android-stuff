package io.dakotawhipple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.PARENT_ID
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.constraintSet
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.viewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

    }
}

class ConstraintGroup {
    fun defineGroup(c: ConstraintLayout): List<View> = with(c) {
        listOf(
    }

    fun chainStuff(v: View) {

    }
}

inline fun ConstraintLayout.constraintMerge(init: ConstraintGroup.() -> Unit): ConstraintGroup {
    //({ UserSimpleViewComponentA(nameText, pic).createView(AnkoContext.createReusable(it)) } }, theme, { init() })
}

class MainActivityUI: AnkoComponent<MainActivity> {
    lateinit var tabLabels: ConstraintGroup
    lateinit var label1: TextView
    lateinit var label2: TextView
    lateinit var label3: TextView

    lateinit var secondaryTabLabels: ConstraintGroup

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        constraintLayout {
            tabLabels = constraintMerge {
                label1 = textView(Texts.TAB_LABEL_1) {
                    id = View.generateViewId()
                }
                label2 = textView(Texts.TAB_LABEL_2)
                label3 = textView(Texts.TAB_LABEL_3)

                applyConstraintSet {
                    firstChild { next: View ->
                        connect(START to START of PARENT_ID,
                            END to START of next)
                    }
                    getChildAt(childCount - 1) { prev ->
                        connect(START to END of prev,
                            END to END of PARENT_ID)
                    }

                }
            }


        }
    }
}