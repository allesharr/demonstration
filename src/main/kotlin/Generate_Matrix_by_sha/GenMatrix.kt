package Generate_Matrix_by_sha



import server_basic.netStatus
import Cyfer.Sha256
//import test_sha.*
import java.math.BigInteger
import java.nio.charset.Charset


data class Cell (val row : Int, val column :Int)
interface MatrixInterface <E> {
    val height:Int; val width : Int;

    fun <E> createMatrix(height: Int, width: Int, e: E): Matrix<E> = TODO()


    operator fun get(row:Int,column :Int): E
    operator fun get(cell:Cell) = get(cell.row, cell.column)
    operator fun set(row: Int, column: Int, value: E)
    operator fun set(cell: Cell, value: E) = set (cell.row,cell.column, value)

}

class Matrix<E>(override val height: Int, override val width: Int) : MatrixInterface<E> {
    private var meanings = mutableListOf<E>()

    override fun get(row: Int, column: Int): E {
        return meanings.get(row*width*height + column)
    }

    override fun set(row: Int, column: Int, value: E) {
        meanings[row*width*height + column] = value
    }

    fun append (value: E) {
        meanings += value;
    }

    fun countOfRows(): Int {
        return height
    }

    fun countOfColumns(): Int {
        return width
    }

    fun BonitoEscribir(){
        for ( i in 0..meanings.size-1)
        {
            if (i % width == 0 ){
                print("\n")
            }
            print(meanings[i])
        }
    }



}

class GenMatrix {

    public fun generate(): String {
        var row = GenMatrix().generateRow()
        var result = row.BonitoEscribir().toString()
        result = result.replace("kotlin.Unit", "")
        return result
    }


    private fun generateRow(): Matrix<Char> {
        var matrix =  Matrix<Char>(79,79);

        var appendString = ""



        var  bytes :ByteArray = byteArrayOf();
        val net = netStatus()
        val anotherMac = net.getDstMacAddr("_gateway");
        val myMac = net.getMyMACLinux("wlo1");
        var str = myMac +"0xeeb2622" + anotherMac;

        println("Basic string is $str")
        for (i in 1.. 16)
        {
            val  halfNumber = str.length.div(2)
            var partOne = ""
            var partTwo = ""

            //заполнение полустрок
            for ( i in 0..halfNumber){
                partOne += str.get(i);
            }
            for (i in halfNumber..str.length-1){
                partTwo +=str.get(i);
            }
            //Сеть фейстеля
            val newPartTwo = BigInteger(Sha256.hash(partTwo.toByteArray()));
            println("newPartTwo + ${newPartTwo}")
            str = newPartTwo.toString() + partOne



        }
        //добавление элементов в матрицу
        str.forEach {
            matrix.append(it)
        }

        return matrix
    }



}

fun main(){

    var row = GenMatrix().generate()

    println(row)


}