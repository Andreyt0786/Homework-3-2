import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun textToPrintWithFalse() {
        var alowToDo = false
        var countComission = 500.0
        val result = textToPrint(alowToDo,countComission)
        val expected = "Вы превысили лимит на переводы за день или месяц."
        assertEquals(expected, result)
    }

    @Test
    fun textToPrintWithTrue(){
        var alowToDo = true
        var countComission = 500.0
        val result = textToPrint(alowToDo,countComission)
        val expected = "Ваша комиссия составила - $countComission, "
        assertEquals(expected, result)
    }

    @Test
    fun comissionForSendVKPay(){
       val typeOfCard = "VKPay"
       val moneyToSend = 100
       val totalCount = 300
       val result:Double = comissionForSend(typeOfCard,moneyToSend,totalCount)
        val expected = 0.0
        assertEquals(expected,result,0.0)
    }

    @Test
    fun comissionForSendVISAMinCom(){
        val typeOfCard = "VISA"
        val moneyToSend = 100
        val totalCount = 300
        val result:Double = comissionForSend(typeOfCard,moneyToSend,totalCount)
        val expected = 35.0
      assertEquals(expected,result,1.0)
    }


    @Test
    fun comissionForSendVISAMaxCom(){
        val typeOfCard = "VISA"
        val moneyToSend = 15000
        val totalCount = 300
        val result:Double = comissionForSend(typeOfCard,moneyToSend,totalCount)
        val expected = 112.5
        assertEquals(expected,result,1.0)
    }

    @Test
    fun comissionForSendMastercardMinCom(){
        val typeOfCard = "Mastercard"
        val moneyToSend = 100
        val totalCount = 300
        val result:Double = comissionForSend(typeOfCard,moneyToSend,totalCount)
        val expected = 0.0
        assertEquals(expected,result,1.0)
    }

    @Test
    fun comissionForSendMastercardTotalCount(){
        val typeOfCard = "Mastercard"
        val moneyToSend = 100
        val totalCount = 76000
        val result:Double = comissionForSend(typeOfCard,moneyToSend,totalCount)
        val expected =20.0
        assertEquals(expected,result,1.0)
    }

    @Test
    fun comissionForSendMastercardMoneyToSend(){
        val typeOfCard = "Mastercard"
        val moneyToSend = 75001
        val totalCount = 1
        val result:Double = comissionForSend(typeOfCard,moneyToSend,totalCount)
        val expected =470.0
        assertEquals(expected,result,1.0)
    }

    @Test
    fun comissionForSendMastercardMoneyToSendTotalCount(){
        val typeOfCard = "Mastercard"
        val moneyToSend = 1500
        val totalCount = 74000
        val result:Double = comissionForSend(typeOfCard,moneyToSend,totalCount)
        val expected =29.0
        assertEquals(expected,result,1.0)
    }

@Test
fun limitsFalseMastercardTotalSendDay(){
    val typeOfCard = "Mastercard"
    val moneyToSend = 15000
    val totalCount = 640000
    val moneyToSendDay = 1
    val expected = false
    val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
    assertEquals(expected,result)
}
    @Test
    fun limitsFalseMastercardTotal(){
        val typeOfCard = "VISA"
        val moneyToSend = 1
        val totalCount = 600_001
        val moneyToSendDay = 1
        val expected = false
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }

    @Test
    fun limitsFalseMastercardSendDay(){
        val typeOfCard = "Mastercard"
        val moneyToSend = 100
        val totalCount = 700
        val moneyToSendDay = 200_000
        val expected = false
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }

    @Test
    fun limitsFalseMastercardSendDaySendOnce(){
        val typeOfCard = "Mastercard"
        val moneyToSend = 150001
        val totalCount = 70
        val moneyToSendDay = 15001
        val expected = false
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }

    @Test
    fun limitsTrue(){
        val typeOfCard = "Mastercard"
        val moneyToSend = 1
        val totalCount = 70
        val moneyToSendDay = 1
        val expected = true
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }

    @Test
    fun limitsVKPayfalseMoneyToSend(){
        val typeOfCard = "VKPay"
        val moneyToSend = 16000
        val totalCount = 70
        val moneyToSendDay = 1
        val expected = false
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }

    @Test
    fun limitsVKPayfalseTotalCount(){
        val typeOfCard = "VKPay"
        val moneyToSend = 1
        val totalCount = 40005
        val moneyToSendDay = 1
        val expected = false
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }


    @Test
    fun limitsVKPayfalseTotalCountMoneyToSend(){
        val typeOfCard = "VKPay"
        val moneyToSend = 12000
        val totalCount = 30000
        val moneyToSendDay = 1
        val expected = false
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }

    @Test
    fun limitsVKPayTrue(){
        val typeOfCard = "VKPay"
        val moneyToSend = 12
        val totalCount = 30000
        val moneyToSendDay = 1
        val expected = true
        val result = limits(typeOfCard,totalCount,moneyToSendDay,moneyToSend)
        assertEquals(expected,result)
    }

    @Test
    fun mainFalse(){
        main()
      /*  val alowToDo = false // Определение лимита
        val countComission= 5
        val totalCount = 10
        val result = "Вы превысили лимит на переводы за день или месяц."*/


    }
}