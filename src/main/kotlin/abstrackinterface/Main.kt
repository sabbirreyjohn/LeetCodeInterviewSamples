package abstrackinterface

import java.util.Stack

fun main() {

    var phone = SmartPhone("Sabbir")
    //phone.sendMsg()

}

class SmartPhone(private val name: String) : Phone(name) {

    override fun call() {

        var sms = object : Sms{

        }

    }


}