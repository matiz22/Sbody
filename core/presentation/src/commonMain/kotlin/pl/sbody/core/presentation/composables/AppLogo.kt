package pl.sbody.core.presentation.composables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pl.sbody.core.presentation.res.Res
import pl.sbody.core.presentation.res.app_logo
import pl.sbody.core.presentation.res.logo_black
import pl.sbody.core.presentation.res.logo_white

@Composable
fun AppLogo(modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier,
        painter =
        painterResource(
            if (isSystemInDarkTheme()) Res.drawable.logo_white else Res.drawable.logo_black,
        ),
        contentDescription = stringResource(Res.string.app_logo),
        tint = Color.Unspecified,
    )
}
