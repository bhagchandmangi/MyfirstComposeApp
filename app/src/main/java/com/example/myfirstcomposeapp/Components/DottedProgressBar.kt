
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DotsProgressBar(progress: Float, modifier: Modifier = Modifier) {

    val dotColor = MaterialTheme.colorScheme.primary

    // Create a coroutine scope to animate the progress
    val coroutineScope = rememberCoroutineScope()

    // State to hold the current progress
    var currentProgress by remember { mutableStateOf(0f) }

    // Animate the progress when it changes
    LaunchedEffect(progress) {
        coroutineScope.launch {
            while (currentProgress < progress) {
                currentProgress += 0.01f // You can adjust the animation speed here
                delay(20) // You can adjust the delay between updates here
            }
        }
    }

    // Calculate the number of dots based on the progress
    val numDots = (currentProgress * 10).toInt()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        for (i in 0 until 130) {
            Dot(
                color = if (i < numDots) dotColor else Color.Gray,
                modifier = Modifier
                    .size(1.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun Dot(color: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .background(color)
    )
}

@Composable
fun DottedProgressBar() {
    var progress by remember { mutableStateOf(0f) }

    // Simulate progress change
    LaunchedEffect(Unit) {
        while (progress < 1.0f) {
            delay(100)
            progress += 0.1f
        }
    }

    DotsProgressBar(progress = progress, modifier = Modifier
        .background(colorResource(id = R.color.white))
        .width(280.dp)
        .height(47.dp)
        .padding(start = 5.dp))
}

@Preview(showBackground = true)
@Composable
fun DotsProgressBarPreview() {
    DottedProgressBar()
}