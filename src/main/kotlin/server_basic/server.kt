package server_basic


import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.ServerSocket
import java.util.*


fun main() {

}

fun tcpServer(){
    val server = ServerSocket(9999)
    println("Server running on port ${server.localPort}")
    val client = server.accept()
    println("Client connected : ${client.inetAddress.hostAddress}")
    val scanner = Scanner(client.inputStream)
    while (scanner.hasNextLine()) {
        println(scanner.nextLine())
        break
    }
    server.close()
}

fun sendUdp(Message:String,DstAddress:String){
    val socket = DatagramSocket()
    try {
        //Open a port to send the package
        socket.broadcast = true
        val sendData = Message.toByteArray()
        val sendPacket = DatagramPacket(sendData, 2048, InetAddress.getByName(DstAddress), 9999)
        socket.send(sendPacket)
    } catch (e: IOException) {
       log(e);
    }
    finally{
        socket.close()
    }
}

/*
Lo tengo que realisar este functional en thread nuevo.
 */
fun receiveUDP() {
    val buffer = ByteArray(2048)
    var socket: DatagramSocket? = null
    try {
        //Keep a socket open to listen to all the UDP trafic that is destined for this port
        socket = DatagramSocket(9999)
        socket.broadcast = true
        val packet = DatagramPacket(buffer, buffer.size)
        socket.receive(packet)
        println("open fun receiveUDP packet received = " + packet.data)

    } catch (e: Exception) {
//        log(e)

    } finally {
        socket?.close()
    }
}



fun log(Message:String){
    println(Message);
}
fun log(Message:IOException)
{
    println(Message.message);
}
fun log(e:Exception)
{
    println(e.toString())
}