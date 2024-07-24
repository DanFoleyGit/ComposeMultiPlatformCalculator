package calculator.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import calculator.CalculatorViewModel
import compnents.CalculatorButton
import compnents.CalculatorDisplay
import compnents.CalculatorResult
import compnents.IconButton
import getPlatform

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel,
    innerPadding: PaddingValues
) {
    val state = viewModel.state

    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)) {
        CalculatorDisplay(state.input)
        CalculatorResult(state.result)


        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(text = "AC",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Clear) },
                164)
            IconButton(icon = Icons.Sharp.ArrowBack,
                onClickMethod = { viewModel.processInputs(CalculatorAction.Delete) }
            )
            CalculatorButton(text = "/",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Operation("/")) }
            )
        }
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                text = "7",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("7")) }
            )
            CalculatorButton(
                text = "8",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("8")) }
            )
            CalculatorButton(
                text = "9",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("9")) }
            )
            CalculatorButton(
                text = "X",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Operation("X")) }
            )
        }
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                text = "4",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("4")) }
            )
            CalculatorButton(
                text = "5",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("5")) }
            )
            CalculatorButton(
                text = "6",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("6")) }
            )
            CalculatorButton(
                text = "-",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Operation("-")) }
            )
        }

        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                text = "1",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("1")) }
            )
            CalculatorButton(
                text = "2",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("2")) }
            )
            CalculatorButton(
                text = "3",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("3")) }
            )
            CalculatorButton(
                text = "+",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Operation("+")) }
            )
        }
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CalculatorButton(
                text = "0",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Number("0")) },
                180
            )
            CalculatorButton(
                text = ".",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Decimal) }
            )
            CalculatorButton(
                text = "=",
                onClickMethod = { viewModel.processInputs(CalculatorAction.Calculate) }
            )
        }
    }
}
