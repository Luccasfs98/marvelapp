package br.com.marvel.featurehome.view.decorator

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridItemDecorator(
    val context: Context,
    private val spacingDp: Int,
    private val mGridSize: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val resources = context.resources
        val spacingPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            spacingDp.toFloat(),
            resources.displayMetrics
        )

        val bit = if (spacingPx > mGridSize) Math.round(spacingPx / mGridSize) else 1
        val itemPosition = (view.layoutParams as RecyclerView.LayoutParams).viewAdapterPosition

        outRect.top = if (itemPosition < mGridSize) 0 else bit * mGridSize
        outRect.bottom = 0

        val rowPosition = itemPosition % mGridSize
        outRect.left = rowPosition * bit
        outRect.right = (mGridSize - rowPosition - 1) * bit

    }
}