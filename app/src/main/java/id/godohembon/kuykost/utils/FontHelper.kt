package id.godohembon.kuykost.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import id.godohembon.kuykost.R

object FontHelper {
    val openSansFamily = FontFamily(
        Font(R.font.opensans_light, FontWeight.Light),
        Font(R.font.opensans_regular, FontWeight.Normal),
        Font(R.font.opensans_bold, FontWeight.Bold),
        Font(R.font.opensans_semibold, FontWeight.SemiBold)
    )
}