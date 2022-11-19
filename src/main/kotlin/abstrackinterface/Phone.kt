package abstrackinterface

abstract class Phone(private val name: String) {

    init {
        var newName = "Name is $name"
    }

    open fun call() {
        println("calling $name")
    }
}