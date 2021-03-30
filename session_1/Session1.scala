
object Session1 {

  def main(args: Array[String]): Unit = {

    val myData = List(7 , 4 , 5 , 6 , 3 , 8 , 10)

    // Imparative

    println("Imparative way of doing things")

    for(i <- myData)
    {
       println(subtractTen(square(addOne(i))))

    }

    // Declarative
    println("Declarative way of doing things")

    val results = myData
      .map(addOne(_))
      .map(square(_))
      .filter(_ < 70)
      .sorted
      .take(2)
      .map(subtractTen(_))

    results.foreach(println)   // 6.0 \n 15.0


  }

  // pure Functions

  def addOne (x :Double):Double = x+1

  def square(x:Double) :Double = x * x

  def subtractTen(x:Double) :Double = x - 10

}
