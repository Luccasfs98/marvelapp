package br.com.marvel.navigation.features

import android.content.Intent
import br.com.marvel.navigation.loadIntentOrNull

object SampleNavigation : DynamicFeature<Intent> {

    const val USER_ID_KEY = "USER_ID_KEY"
    const val CHARACTER_ID_KEY = "CHARACTER_ID_KEY"

    private const val HOME_ACTIVITY = "br.com.marvel.featurehome.view.activity.HomeActivity"
    private const val DETAIL_ACTIVITY = "com.marvel.detailcharacter.view.activity.DetailCharacterActivity"

    override val dynamicStart: Intent?
        get() = HOME_ACTIVITY.loadIntentOrNull()

    override val dynamicStart2: Intent?
        get() = DETAIL_ACTIVITY.loadIntentOrNull()

    fun characterDetails(dCharacter: Long?): Intent? =
        DETAIL_ACTIVITY.loadIntentOrNull()
            ?.apply {
                putExtra(CHARACTER_ID_KEY, dCharacter)
            }
}
