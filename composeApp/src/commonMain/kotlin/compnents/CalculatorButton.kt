package compnents

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorButton(
    text: String = "",
    onClickMethod: (String) -> Unit,
    width: Int = 80,
) {
    Button(
        modifier = Modifier.padding(10.dp)
            .width(width.dp).height(80.dp),
        onClick = { onClickMethod(text) },
//        shape = MaterialTheme.shapes.small,
        shape = androidx.compose.material3.ButtonDefaults.shape,
    ) {
        Text(text = text, style = MaterialTheme.typography.h3 )
    }
}