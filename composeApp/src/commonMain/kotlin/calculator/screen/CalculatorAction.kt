package calculator.screen

sealed class CalculatorAction{
    data class Number(val number: String) : CalculatorAction()
    object Decimal : CalculatorAction()
    data class Operation(val operation: String) : CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()
}