object HOFScala {

  // Higher Order Function
  // (HOF) : function take another function as an argument or return function as output or both

  // function test1
  val test1 :(Double) =>Double = _ / 2
  // function test1
  val test2 :(Double) => Double = _ / 4 + 1

  def main(args: Array[String]): Unit = {

    println(test2(test1(5))) //    results :  (1.625) = (2.5 / 4 +1 ) <= 5 / 2
    println(test1(test2(5))) //    results : (1.125) = (2.25 / 2) <= (5 / 4 +1)

    // it is a list of delegates that is refer to a group of functions in memory
    val listOfFunctions = List[Double => Double](test1 , test2)

    println(listOfFunctions(0)(5))
    println(listOfFunctions(1)(5))

    println(test3(test1 , 5))
    println(test3(test2 , 5))

  }


  // it is a higher order function
 def test3 (f:Double  => Double , x:Double) = f(x) + x



}
