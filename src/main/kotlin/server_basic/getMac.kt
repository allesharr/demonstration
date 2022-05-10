package server_basic


import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.*


class netStatus {


public fun getMyMACLinux(name: String): String? {
    return try {
        val network = NetworkInterface.getByName(name)
        val mac = network.hardwareAddress
        val sb = StringBuilder()
        for (i in mac.indices) {
            sb.append(String.format("%02X%s", mac[i], if (i < mac.size - 1) ":" else ""))
        }
        sb.toString()
    } catch (E: Exception) {
        System.err.println("System Linux MAC Exp : " + E.message)
        null
    }
}


//

    fun  PingExample(ip:String):Boolean {
        var reachable:Boolean = false
        try {
            val address = InetAddress.getByName(ip)
            reachable = address.isReachable(10000)
            println("Is host reachable? $reachable")
        } catch (e: Exception) {
            e.printStackTrace() }


        return reachable
    }


    fun getDstMacAddr(ip:String):String {
        val readable = PingExample(ip)
        if (readable) {
//            val command = "ping  -c 1 $ip "

            val command = "arp -a"
            val pr = Runtime.getRuntime().exec(command)
            val input = BufferedReader(InputStreamReader(pr.inputStream))

            val lns = input.readLines()

//            var listOfMacBytes = mutableListOf<String>()
            lns.forEach {
                if(it.contains(ip)) {
                    val kt = it.split(" ")
                    kt.forEach {
                        if (it.contains(":"))
//                            listOfMacBytes.add(it)
                            return it
                    }
                }
            }
            return ""
//            return listOfMacBytes.toString()

        }
        else{
            return ""
        }
    }
}



fun main() {
//    val s = netStatus().getMyMacAddr();
//    val s = netStatus().getDstMacAddr("_gateway")
    val s = netStatus().getMyMACLinux("wlo1")

    println(s)
}