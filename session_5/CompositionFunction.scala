object Composition {

  def main(args: Array[String]): Unit = {

    val myData = List[Int](3, 5, 7, 8)


    println("------------------------ Method one ------------------------------------")

    val results = myData
      .map(addOne(_))
      .map(square(_))
      .map(subtractTen(_))

    results.foreach(println)

    println("------------------------ Method Two ------------------------------------")

    
    val results1 = myData.map(x => subtractTen(square(addOne(x))))
    
    results1.foreach(println)

    
    println("-------------------------  Method Three --------------------------------")

    val myComposeFunction: Double => Double = composeFunction(addOne, square, subtractTen)

    val res = myData.map(x => myComposeFunction(x.toDouble))

    res.foreach(println)

  }


  def composeFunction(f: Double => Double, f1: Double => Double, f2: Double => Double): (Double => Double) = {

    x => {

      f2(f1(f(x)))

    }

  }

  def addOne(x: Double): Double = x + 1

  def square(x: Double): Double = x * x

  def subtractTen(x: Double): Double = x - 10


}
