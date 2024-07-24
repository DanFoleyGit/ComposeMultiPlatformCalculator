package calculator.screen

data class CalculatorState(
    var input: String = "",
    var number1: String = "",
    var number2: String = "",
    var result: String = "",
    var operation: String = ""
)