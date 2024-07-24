package calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import calculator.screen.CalculatorAction
import calculator.screen.CalculatorState
import getPlatform

class CalculatorViewModel : ViewModel()  {

    var state by mutableStateOf(CalculatorState())
        private set


    val platformName = getPlatform().name

    init{
        state = state.copy(input = "Currently running on $platformName")
    }

    fun processInputs(action: CalculatorAction) {

        when (action) {
            CalculatorAction.Clear -> clearValues()
            CalculatorAction.Delete -> deleteLast()
            CalculatorAction.Calculate -> performCalculation()
            CalculatorAction.Decimal -> enterNumber(".")
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> addOperation(action.operation)
        }

        state = state.copy(input = state.number1 + state.operation + state.number2)
    }

    private fun clearValues() {
        state = state.copy(input = "Currently running on $platformName", result = "", operation = "", number2 = "", number1 = "")
    }

    fun deleteLast() {

        if (state.number2.isNotEmpty()) {
            state = state.copy(number2 = state.number2.dropLast(1))
            return
        }

        if (state.operation.isNotBlank()) {
            state = state.copy(operation = "")
            return
        } else {
            state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun performCalculation() {
        val num1 = state.number1.toDoubleOrNull()
        val num2 = state.number2.toDoubleOrNull()

        if (num1 == null || num2 == null || state.operation.isBlank()) {
            return
        }

        when (state.operation) {
            "+" -> state = state.copy(result = (num1 + num2).toString())
            "-" -> state = state.copy(result = (num1 - num2).toString())
            "X" -> state = state.copy(result = (num1 * num2).toString())
            "/" -> state = state.copy(result = (num1 / num2).toString())
        }
    }

    private fun enterNumber(num: String) {
        val MAX_NUM_LENGTH = 8
        if(state.operation.isBlank() && state.number1.length <= MAX_NUM_LENGTH) {
            state = state.copy(number1 = state.number1 + num)
        } else if (state.operation.isNotBlank() && state.number2.length <= MAX_NUM_LENGTH) {
            state = state.copy(number2 = state.number2 + num)
        }
    }

    private fun addOperation(operation: String) {
        if(state.result.isNotBlank()){
            state = state.copy(number1 = state.result, number2 = "", result = "")
        }
        state = state.copy(operation = operation)
    }

}