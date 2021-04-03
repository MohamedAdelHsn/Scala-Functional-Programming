object Closures {

  def test (x:Double) : (Double => Double) = {

    var x1 = x +10
    a =>
      {
        a+x1
      }

  }

  def main(args: Array[String]): Unit = {

    var Q10 = test(10)
    println(Q10(4))
    Q10 = test(20)
    println(Q10(4))

    case class Employee(segment:String , baseSalary:Double)

    val listOfEmployees = List(
      Employee("a" , 1000.00) ,
      Employee("b" , 2000.00) ,
      Employee("c" , 3000.00)
    )


    val GrossSalaryCalculators = listOfEmployees
      .map(emp => (emp.segment , GrossSalaryCalculator(emp.baseSalary)))

    println(GrossSalaryCalculators.head._2(80))   // 1280
    println(GrossSalaryCalculators(1)._2(90))   // 2490
    println(GrossSalaryCalculators(2)._2(100))  // 3700


  }


  def GrossSalaryCalculator(basicSalary:Double):(Double => Double) =
  {

    var tax = 0.2 * basicSalary
    bonus =>
    {
      bonus + tax + basicSalary

    }


  }

}
