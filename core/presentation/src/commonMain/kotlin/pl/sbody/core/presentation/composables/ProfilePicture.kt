package pl.sbody.core.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.github.panpf.sketch.PainterState
import com.github.panpf.sketch.SubcomposeAsyncImage

@Composable
fun ProfilePicture(
    url: String,
    modifier: Modifier = Modifier.size(40.dp).clip(CircleShape),
    placeholder: ImageVector = Icons.Default.Person,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        uri = url,
        contentScale = ContentScale.Crop,
        contentDescription = "photo",
        content = {
            when (state.painterState) {
                is PainterState.Loading -> {
                    @Suppress("ktlint:compose:modifier-reused-check")
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = placeholder,
                        contentDescription = null,
                    )
                }

                is PainterState.Error -> {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = placeholder,
                        contentDescription = null,
                    )
                }

                else -> {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                        painter = painter,
                        contentDescription = "photo",
                    )
                }
            }
        },
    )
}
