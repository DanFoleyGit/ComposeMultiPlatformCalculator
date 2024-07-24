package compnents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorDisplay(
    value:String = "",
) {

    Text(
        text = value,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 50.dp),
        style = TextStyle(fontSize = 30.sp),
        maxLines = 3
    )

}