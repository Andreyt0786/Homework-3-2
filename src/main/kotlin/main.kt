fun main() {
    var totalCount = 600001// сумма перечислений за месяц
    val typeOfCard = "VKPay"//VKPay, "Maestro", "Mastercard", "VISA", "MIR"
    val moneyToSend = 1 // количество денег отправляемых в данный момент
    var moneyToSendDay = 0 // количество денег отправленных за день

    val alowToDo = limits(typeOfCard, totalCount, moneyToSendDay, moneyToSend) // Определение лимита
    val countComission = comissionForSend(typeOfCard, moneyToSend, totalCount) // итоговая комиссия
    totalCount = if (alowToDo) totalCount + moneyToSend else totalCount
    println(textToPrint(alowToDo, countComission) + " Ваша сумма переводов за месяц - $totalCount")
}


fun textToPrint(alowToDo: Boolean, countComission: Double): String {
    val text = if (!alowToDo) "Вы превысили лимит на переводы за день или месяц."
    else "Ваша комиссия составила - $countComission, "
    return text
}


fun comissionForSend(typeOfCard: String, moneyToSend: Int, totalCount: Int): Double {
    var comission: Double = 0.0
    val comissionOfVisa = moneyToSend * 0.75/100

    when (typeOfCard) { // вывод итоговой комиссии
        "VKPay" -> comission = 0.0
        "VISA", "MIR" -> comission = if (comissionOfVisa > 35) comissionOfVisa else 35.0
        "Maestro", "Mastercard" -> comission = if(totalCount > 75000 || moneyToSend > 75000
            || totalCount + moneyToSend > 75000) (moneyToSend * 0.6 / 100) + 20 else 0.0
    }
    return comission
}

fun limits(typeOfCard: String, totalCount: Int, moneyToSendDay: Int, moneyToSend: Int): Boolean {
    val countDayCard = 150_000
    val countMonthCard = 600_000
    val countOnceVK = 15000
    val countMonthVK = 40000
    var limit = true
    when (typeOfCard) {
        //Лимиты для карт
        "VISA", "MIR", "Maestro", "Mastercard" -> if (totalCount + moneyToSend >= countMonthCard ||
            totalCount > countMonthCard || moneyToSendDay > countDayCard
            || moneyToSend + moneyToSendDay >= countDayCard
        )
            limit = false else limit = true

        // Лимиты для ВК
        "VKPay" -> if (moneyToSend > countOnceVK || totalCount > countMonthVK ||
            totalCount + moneyToSend>countMonthVK) limit = false
        else limit = true
    }
    return limit
}



