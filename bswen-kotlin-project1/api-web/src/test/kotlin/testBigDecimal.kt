import java.math.BigDecimal
import java.math.RoundingMode

class testBigDecimal {
}

fun main() {
    test2();
}


fun test1() {
    //val value = "0.01"
    val value:String = (29.9923*2).toString()
    val v1 = BigDecimal(value).multiply(BigDecimal(100)).
            setScale(0,RoundingMode.UP).toString();
    println(v1);
}

fun test2() {
    val value:String = (1).toString()
    val v1 = BigDecimal(value).divide(BigDecimal(100)).
    setScale(2,RoundingMode.UP).toString();
    println(v1);
}
