object RealWorldExample {

  /*

   Important points of enum :

    1- In Scala, there is no enum keyword unlike Java or C.
    2- Scala provides an Enumeration class which we can extend in order to create our enumerations.
    3- Every Enumeration constant represents an object of type Enumeration.
    4- Enumeration values are defined as val members of the evaluation.
    5- When we extended the Enumeration class, a lot of functions get inherited. ID is one among the them.
    6 -We can iterate the members.

 */

  object ProductType extends Enumeration
  {
    val Food , Beverage , RawMaterial = Value
  }


  case class Order(OrderID:Int , ProductIndex:Int ,  Quantity:Double ,UnitPrice:Double)

  val listOfFunctions =
    List[Int => (Double , Double)](ProductParamtersFood,ProductParamtersBeverage ,ProductParamtersRawMaterial)

  def main(args: Array[String]): Unit = {

    var product =  ProductType.RawMaterial
    val A = listOfFunctions(0)
    val B = listOfFunctions(1)
    val C = listOfFunctions(2)

    var R = new Order(OrderID = 10, ProductIndex = 100, Quantity = 20, UnitPrice = 4 );


   val P = product match
    {
      case ProductType.Food  => A
      case ProductType.Beverage => B
      case ProductType.RawMaterial => C

    }

    println(CalculateDiscount(P ,R))

  }
  def CalculateDiscount(ProductParamterCalc:Int => (Double , Double) , order: Order):Double = {

     val paramters = ProductParamterCalc(order.ProductIndex)
      paramters._1* order.Quantity + paramters._2* order.UnitPrice

  }

  def ProductParamtersFood(ProductIndex:Int):(Double , Double) =
  {
    ( ProductIndex.toDouble / (ProductIndex + 100) ,  ProductIndex.toDouble / (ProductIndex + 300))

  }

  def ProductParamtersBeverage(ProductIndex:Int) :(Double , Double) =
  {
    ( ProductIndex.toDouble / (ProductIndex + 300) ,  ProductIndex.toDouble / (ProductIndex + 400))

  }

  def ProductParamtersRawMaterial(ProductIndex:Int) :(Double , Double) =
  {
    ( ProductIndex.toDouble / (ProductIndex + 400) ,  ProductIndex.toDouble / (ProductIndex + 700))

  }



}
