package old
import java.util.Scanner

val scanner = Scanner(System.`in`)

fun main() {
    val red = "\u001b[31m"
    val reset = "\u001b[0m"
    val green = "\u001b[32m"
    var price = 0.0

    price = printmenu(green, red, reset, price)
    apagar(price, red, reset, green)
}

fun apagar(price: Double, red: String, reset: String, green: String) {
    var pricefinal = price;
    pricefinal = (Math.round(price*100)/100.0)
    introducedinero(pricefinal, red, reset, green)

}

fun introducedinero(pricefinal: Double, red: String, reset: String, green: String) {
    var falta = pricefinal
    var dinero = 0.0
    do {
        println(green+"Debes pagar un total de: "+reset+red+falta+"$"+reset)
        println(green+"Aceptamos los siguientes billetes: "+reset)
        println(red+"200€, 100€, 50€, 20€, 10€, 5€"+reset)
        println(green+"Aceptamos las siguientes monedas: "+reset)
        println(red+"2€, 1€, 0.50€, 0.20€, 0.10€, 0.5€, 0.2€, 0.1€"+reset)
        dinero = scanner.nextDouble()
        when (dinero){
            200.0 -> {
                falta = falta - 200.0
            }
            100.0->{
                falta= falta - 100.0
            }
            50.0->{
                falta= falta - 50.0
            }
            20.0->{
                falta= falta - 20.0
            }
            10.0->{
                falta= falta - 10.0
            }
            5.0->{
                falta= falta - 5.0
            }
            2.0->{
                falta= falta - 2.0
            }
            1.0->{
                falta= falta - 1.0
            }
            0.5->{
                falta= falta - 0.5
            }
            0.2->{
                falta= falta - 0.2
            }
            0.1->{
                falta= falta - 0.1
            }
            else->{
                println("ERROR, introduce un numero valido")
            }
        }
    }while (falta > 0.0)
    darcambio(falta)
}

fun darcambio(falta: Double) {
    if (falta != 0.0){
        var cambio = Math.abs(falta)
        println("Te devolvemos: "+cambio+"€ de cambio")
    }else{
        println("No hace falta cambio")
    }
    println("¡Gracias por comprar con nosotros!")
    println("Saliendo... ")
    println("Marcmachines© Corporation. Todos los derechos reservados")
}

fun printmenu(green: String, red: String, reset: String, price: Double): Double {
    var menu: Int
    var pricetotal = 0.0
    var billetes = 0
    do {
        println("${green}====================================${reset}")
        println("${red}           RENFE BILLETES${reset}")
        println("${green}====================================${reset}")
        println("¿Qué billete quieres comprar?")
        println("1....Billete Sencillo 2.40€ (1 zona)")
        println("2............Tcasual 11.35€ (1 zona)")
        println("3.............TUsual 40.00€ (1 zona)")
        println("4..........TFamiliar 10.00€ (1 zona)")
        println("5..............TJove 80.00€ (1 zona)")
        println("6....... PAGAR BILLETES SELECCIONADOS")
        menu = scanner.nextInt()

        var price = 0.0
        when (menu) {
            1 -> {
                println("Has elegido Billete Sencillo")
                price = 2.40
            }
            2 -> {
                println("Has elegido Tcasual")
                price = 11.35
            }
            3 -> {
                println("Has elegido TUsual")
                price = 40.00
            }
            4 -> {
                println("Has elegido Tfamiliar")
                price = 10.00
            }
            5 -> {
                println("Has elegido Tjove")
                price = 80.00
            }
            6 -> {
                println("Moviendo al menú de pago...")
            }
            else -> {
                println("ERROR, elige una opción correcta")
            }
        }

        if (menu in 1..5) {
            price = elegirzona(menu, price)
            pricetotal += price
            billetes++
        }

    } while (menu != 6 && billetes < 3)

    billetesmax(billetes)
    return pricetotal
}

fun elegirzona(menu: Int, price: Double): Double {
    var preciodezona = price
    var elegirzona: Int
    do {
        println("¿Para qué zona quieres el billete?")
        println("1. Zona 1")
        println("2. Zona 2")
        println("3. Zona 3")
        println("4. Zona 4")
        println("5. Zona 5")
        elegirzona = scanner.nextInt()

        preciodezona = when (elegirzona) {
            1 -> price
            2 -> price * 2
            3 -> price * 3
            4 -> price * 4
            5 -> price * 5
            else -> {
                println("Elige un número válido")
                price
            }
        }
    } while (elegirzona !in 1..5)

    return preciodezona
}

fun billetesmax(billetes: Int) {
    when {
        billetes == 3 -> {
            println("El máximo número de billetes es 3, procede a pagar")
            println("Moviendo al menú de pago...")
        }
        billetes == 0 -> {
            println("No has seleccionado ningún billete")
        }
        else -> {
            println("Has seleccionado $billetes billete(s)")
        }
    }
}