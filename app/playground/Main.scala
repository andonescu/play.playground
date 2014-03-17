package playground

/**
 * Created by iandonescu on 3/13/14.
 */
object Main extends App {


  println(s"problem 1 : find the last element of a list")

  def last[A](list: List[A]): A =
    list match {
      case a :: Nil => a
      case a :: ax => last(ax)
      case _ => throw new RuntimeException("empty list")
    }

  println(last(List(1, 1, 2, 3, 5, 8)))
  println(last(List(1)))

  println(s"problem 2 : find the last but one")

  def penultimate[A](list: List[A]): A =
    list match {
      case first :: _ :: Nil => first
      case first :: second :: last => penultimate(second :: last)
      case _ => throw new RuntimeException("empty list")
    }

  println(penultimate(List(1, 1, 2, 3, 5, 8)))

  println(s"problem 3:  Find the Kth element of a list.")

  def nth[A](pos: Int, list: List[A]): A = {
    if (pos >= list.size) {
      throw new RuntimeException("position out of range!")
    }

    def calcNth(currentPos: Int, parsedList: List[A]): A = {
      if (currentPos.equals(pos)) {
        parsedList.head
      } else {
        calcNth(currentPos + 1, parsedList.tail)
      }
    }

    calcNth(0, list)
  }

  def newNth[A](pos: Int, list: List[A]): A = (pos, list) match {
    case (0, head :: _) => head
    case (n, head :: tail) => newNth(n - 1, tail)
    case (_, Nil) => throw new NoSuchElementException("position out of range")
  }

  println(nth(2, List(1, 1, 2, 3, 5, 8)))

  println("rec = " + newNth(2, List(1, 1, 2, 3, 5, 8)))


  println(s"problem 4:  Find the number of elements of a list:")

  def length[A](list: List[A]): Int = {
    def calcLength(size: Int, list: List[A]): Int = list match {
      case head :: tail => calcLength(size + 1, tail)
      case Nil => size
    }

    calcLength(0, list)
  }

  def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) {
    (c, a) =>  {
      println(" >> " + a)
      c + 1
    }
  }


  println(length(List(1, 1, 2, 3, 5, 8)))
  println(lengthFunctional(List(1, 1, 2, 3, 5, 8)))

  println(s"problem 5:  Reverse a list.")

  def reverse[A] (list: List[A]) : List[A] =
    list.foldLeft(List[A]()){(reverseList, elem) => reverseList :: elem}

  println(reverse(List(1, 1, 2, 3, 5, 8)))
}
