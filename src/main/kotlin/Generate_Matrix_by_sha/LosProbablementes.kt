package Generate_Matrix_by_sha

fun main (){
    val l = "395896987163878078078268713334103207137262285243543493807861047535610756530352540971693810725283605490433746707213260966100253089421296679626198659634759549";
    var p0 = 0.0 ; var l0 = 0
    var p1 = 0.0 ; var l1 = 0
    var p2 = 0.0; var l2 = 0
    var p3 = 0.0 ; var l3 = 0
    var p4 = 0.0; var l4 = 0
    var p5 = 0.0; var l5 = 0
    var p6 = 0.0 ; var l6 = 0
    var p7 = 0.0; var l7 = 0
    var p8 = 0.0; var l8 = 0
    var p9 = 0.0; var l9 = 0

        l.forEach {
            when (it) {
                '1' -> l1 += 1
                '2' -> l2 += 1
                '3' -> l3 += 1
                '4' -> l4 += 1
                '5' -> l5 += 1
                '6' -> l6 += 1
                '7' -> l7 += 1
                '8' -> l8 += 1
                '9' -> l9 += 1
                '0' -> l0 += 1
            }
        }
    println(l3.toDouble())

    p1 = l1.toDouble()/l.length
    p2 = l2.toDouble()/l.length
    p3 = l3.toDouble()/l.length
    p4 = l4.toDouble()/l.length
    p5 = l5.toDouble()/l.length
    p6 = l6.toDouble()/l.length
    p7 = l7.toDouble()/l.length
    p8 = l8.toDouble()/l.length
    p9 = l9.toDouble()/l.length
    p0 = l0.toDouble()/l.length

    println("$p1 $p2 $p3 $p4 $p5 $p6 $p7 $p8 $p9 $p0")



}