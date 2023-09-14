
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.R

@Composable
fun DashedProgressBar(
    modifier: Modifier = Modifier
        .background(colorResource(id = R.color.white))
        .width(280.dp)
        .height(47.dp),
    progress: Int = 10,
    totalNumberOfBars: Int = 50
) {
    Canvas(modifier = modifier) {
        val barArea = size.width / 40
        val barLength = barArea - 10.dp.toPx()

        var nextBarStartPosition = 0F

        for (i in 0..totalNumberOfBars) {
            val barStartPosition = nextBarStartPosition + 5.dp.toPx()
            val barEndPosition = barStartPosition + barLength

            val start = Offset(x = barStartPosition, y = size.height / 2)
            val end = Offset(x = barEndPosition, y = size.height / 2)

            drawLine(
               // cap = StrokeCap.Round,
                color = if (i < progress) Color.Gray else Color.Gray.copy(alpha = .5F),
                start = start,
                end = end,
                strokeWidth = 13F
            )

            nextBarStartPosition = barEndPosition + 5.dp.toPx()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DashedProgressBarPreview() {
    DashedProgressBar()
}