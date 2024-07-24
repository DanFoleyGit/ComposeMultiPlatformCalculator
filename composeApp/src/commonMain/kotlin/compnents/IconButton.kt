package compnents

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    icon: ImageVector,
    onClickMethod: () -> Unit,
    width: Int = 80,
) {
    Button(
        modifier = Modifier
            .padding(10.dp)
            .width(width.dp)
            .height(80.dp),
        onClick = { onClickMethod() },
        shape = ButtonDefaults.shape,
    ) {
        Icon(imageVector = icon, contentDescription = "")
    }
}