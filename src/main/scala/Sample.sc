import scala.collection.mutable.ArrayBuffer

val alist = List(3,4,2,1,5)

case class A(name: String, error: String)
val seqA = Seq(A("name","missing"),A("def","wrong"),A("tags","corrected"))
seqA.foreach(f => println(f.name))


//ODD EVEN
for(i <- alist)
  println(i)

val elist = for( i <-alist if(i%2 ==0)) yield i
val olist = for( i<- alist if(i%2)!=0) yield i

//FizzBUZZ
def fizzbuzz(n: Int) =
if(n%15 ==0) println("fizzbuzz")
else if (n%5 ==0) println("fizz")
else if (n%3 ==0) println("buzz")
else println("quack")

fizzbuzz(5)

//FACTORIAL
def factorial(n: Int): Int = if(n <=1) return 1
                             else return n*factorial(n-1)
factorial(4)

//PRIME
def isPrime(n : Int) = (2 until n) forall(n %_ !=0)

isPrime(31)
def isAltPrime(n : Int): Unit = for( i <- 2 until n)  if(n% i !=0) return true
isPrime(112)

util.Random.nextInt(10)


// Arrays and Array Buffers
var favNums = new Array[Int](20)
val friends = Array("shoukat", "nihal", "younus")

val empty = List()

val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
//we can change the element by array(0) ="something" but not add a new Array
friends(0) = "khan"

val friendsBuffer = ArrayBuffer[String]()

//insert an elemnet at zero index
friendsBuffer.insert(0,"Chakri")

friendsBuffer :+ "jay"      // add Elemnt at next available slot
friendsBuffer += "Mark"
friendsBuffer ++= friends   // add Array at next available slots

friendsBuffer.insert(1,"hajira","kamran") // add elemnet after/next to 1st position/slot
friendsBuffer.remove(1,3)                 // remove 3 element at index 2nd elemnt

for (i <- friendsBuffer)
  println(i)

// Add values to an array with a loop
for (j <- 0 to (favNums.length - 1)){
  favNums(j) = j
  println(favNums(j))
}

val MultiBy2 = for (num <- favNums) yield 2*num

// Array functions
val sum = favNums.sum
val min = favNums.min
val max = favNums.max
val desc = favNums.sortWith(_>_)
val asc = favNums.sortWith(_<_).mkString(",")
friendsBuffer.toList.sortBy(_.length).reverse

val testBuffer = 1 +: friendsBuffer :+ 4
val testList =  1 +: alist :+ 4


//READ FROM A FILE
val textFile = io.Source.fromFile("/Users/mudasser_smd/Desktop/bashrc.txt").getLines.foreach{
  line => print(line)
}

val init = 5
// 5 to 10 by 2
init to 10 by 2
// 10 to 5 by -1
10 to init by -1


def Bubblesort(input: Array[Int]): Array[Int] = {
  val limit = input.size - 1
  for (a <- 1 to limit) {
    for (b <- limit to a by -1) {
      if (input(b) < input(b - 1)) {
        val x = input(b)
        input(b) = input(b - 1)
        input(b - 1) = x
      }
    }
  }
  input
}
Bubblesort(alist.toArray)


def selectionsort(lst : Array[Int]) : Array[Int] =
{
  val list : Array[Int] = new Array[Int](lst.length)
  Array.copy(lst, 0, list, 0, lst.length)

  for (i <- 0 until (list.length -1))
  {
    var min = i
    //find min
    for(j <- (i+1) until list.length)
    {
      if (list(j) < list(min))
        min = j
    }
    //swap ith number with that at min position
    if (i != min)
    {
      val swap = list(i);
      list(i) = list(min);
      list(min) = swap;
    }
  }
  return list
}

selectionsort(alist.toArray)

//  insertion sort, which works as follows:
// To sort a non-empty list x :: xs, sort the remainder xs and insert the first element x at the right position in the result.
def iSort[T](alist: List[T], max: Int) :List[T] = alist match {
  case Nil => Nil
  case x::xs =>
    val newMax = if(x < max) x
    if(x < xs.head) x::xs
  else xs.head :: iSort(xs.tail, x)
}