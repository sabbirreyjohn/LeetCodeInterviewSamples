package abstrackinterface

abstract class Phone(private val name: String) {

    init {
        var newName = "Name is $name"
    }

    constructor(name: String, phone: String) : this(phone){

    }

    open fun call() {
        println("calling $name")
    }
}