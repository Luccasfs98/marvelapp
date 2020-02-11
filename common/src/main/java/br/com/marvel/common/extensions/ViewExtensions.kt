package br.com.marvel.common.extensions

import androidx.constraintlayout.widget.ConstraintLayout
import br.com.marvel.common.extensions.toDp


/**
 * Função responsável por setar programaticamente as margins de um ConstraintLayout
 * @param[marginStart] variável inteira referente a margin Start/Left
 * @param[marginTop] variável inteira referente a margin Top
 * @param[marginEnd] variável inteira referente a margin End/Right
 * @param[marginBottom] variável inteira referente a margin Bottom
 * */
fun ConstraintLayout.setMargins(
    marginStart: Int = 0,
    marginTop: Int = 0,
    marginEnd: Int = 0,
    marginBottom: Int = 0
) {

    val params = ConstraintLayout.LayoutParams(
        ConstraintLayout.LayoutParams.WRAP_CONTENT,
        ConstraintLayout.LayoutParams.WRAP_CONTENT
    )

    params.setMargins(
        marginStart.toDp,
        marginTop.toDp,
        marginEnd.toDp,
        marginBottom.toDp
    )
    this.layoutParams = params
}
