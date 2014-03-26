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
    (c, a) => {
      println(" >> " + a)
      c + 1
    }
  }


  println(length(List(1, 1, 2, 3, 5, 8)))
  println(lengthFunctional(List(1, 1, 2, 3, 5, 8)))

  println(s"problem 5:  Reverse a list.")

  def reverse[A](list: List[A]): List[A] =
    list.foldLeft(List[A]()) {
      (reverseList, elem) => elem :: reverseList
    }

  println(reverse(List(1, 1, 2, 3, 5, 8)))


  println(s"problem 6:  Find out whether a list is a palindrome.")

  def isPalindrome[A](list: List[A]): Boolean =
    list.reverse.equals(list)


  println(isPalindrome(List(1, 2, 3, 2, 1)))
  println(isPalindrome(List(1, 4, 3, 2, 1)))
  println(isPalindrome(List(1, 4, 3, 4, 1)))
  println(isPalindrome(List(1, 2, 3, 2, 6)))

  def flatten(list: List[Any]): List[Any] =

    list.foldLeft(List[Any]()) {
      (newList, elem) =>
        elem match {
          case a: List[Any] => newList ::: flatten(a)
          case b: Any => newList ::: List(b)
        }
    }

  def flatten2(list: List[Any]): List[Any] = list.flatMap {
    case ms: List[_] => flatten2(ms)
    case e => List(e)
  }


  def compress[A](list: List[A]): List[A] =
  //  list.foldLeft(List[A]()) {
  //    (list, elem) => if (!elem.equals(list.last)) list else list ::: List(elem)
  //  }
    list.foldRight(List[A]()) {
      (elem, newList) => if (newList.nonEmpty && elem.equals(newList.head)) newList else elem :: newList
    }

  def pack[A](list: List[A]): List[List[A]] = list.foldRight(List[List[A]]()) {
    (elem, subLists) => {
      if (subLists.nonEmpty && subLists.head.head.equals(elem)) List(elem :: subLists.head) ::: subLists.tail
      else
        List(List(elem)) ::: subLists
    }
  }

  def packWithSpan[A](list: List[A]): List[List[A]] =
    if (list.isEmpty) List(List[A]())
    else {
      val (packed, next) = list span (_ == list.head)
      if (next == Nil) List(packed)
      else packed :: packWithSpan(next)
    }

  def encode[A](list: List[A]): List[(Int, A)] = {
    if (list.isEmpty)
      List()
    else {
      // ## functionality replaced by foldRight
      //      def numberList(packedList: List[List[A]], result: List[(Int, A)]): List[(Int, A)] =
      //        packedList match {
      //          case head :: tail => numberList(tail, (head.size, head.head) :: result)
      //          case _ => result
      //        }
      //      numberList(pack(list), List())

      pack(list).foldRight(List[(Int, A)]()) {
        (group, result) => (group.size, group.head) :: result
      }

      // another way to resolve the problem
      //      pack(list) map {
      //        elem => (elem.size, elem.head)
      //      }
    }
  }
}
