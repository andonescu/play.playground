package playground

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable._

/**
 * Created by iandonescu on 3/17/14.
 */
@RunWith(classOf[JUnitRunner])
class MainTest extends Specification {

  "#problem 6 : Find out whether a list is a palindrome" should {
    "works good if there is a palindrome" in {
      Main.isPalindrome(List(1, 2, 3, 2, 1)) equals true
    }

    "works good if there is not a palindrome" in {
      Main.isPalindrome(List(1, 4, 3, 2, 1)) equals false
    }
  }

  "#problem 7 : Flatten a nested list structure" should {
    "works good in the following example" in {
      Main.flatten(List(List(1, 1), 2, List(3, List(5, 8)))).equals(List(1, 1, 2, 3, 5, 8))
    }

    "flatten2 : works good in the following example" in {
      Main.flatten2(List(List(1, 1), 2, List(3, List(5, 8)))).equals(List(1, 1, 2, 3, 5, 8))
    }
  }

  "#problem 8 :  Eliminate consecutive duplicates of list elements : If a list contains repeated elements they should " +
    "be replaced with a single copy of the element. The order of the elements should not be changed. " should {
    "the method should eliminate all duplicates " in {
      val list = Main.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      list.equals(List('a, 'b, 'c, 'a, 'd, 'e))
    }

    "the method will not have duplicates to remove" in {
      Main.compress(List('a, 'b, 'c, 'a, 'd, 'e)).equals(List('a, 'b, 'c, 'a, 'd, 'e))
    }
  }

  "#problem 9 : Pack consecutive duplicates of list elements into sublists. If a list contains repeated elements they should be placed in separate sublists. " should {
    "the method should separate the input in different lists " in {
      Main.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        .equals(List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)));
    }

    "the method should create only a single sublist" in {
      Main.pack(List('a, 'a, 'a, 'a))
        .equals(List(List('a, 'a, 'a, 'a)));
    }

    "testing with an empty list" in {
      Main.pack(List()).equals(List())
    }
  }

  "#problem 9 - with span - : Pack consecutive duplicates of list elements into sublists. If a list contains repeated elements they should be placed in separate sublists. " should {
    "the method should separate the input in different lists " in {
      Main.packWithSpan(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        .equals(List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)));
    }

    "the method should create only a single sublist" in {
      Main.packWithSpan(List('a, 'a, 'a, 'a))
        .equals(List(List('a, 'a, 'a, 'a)));
    }

    "testing with an empty list" in {
      Main.packWithSpan(List()).equals(List(List()))
    }
  }

  "#problem 10 - Run-length encoding of a list - : Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E." should {

    "separate the input and number it" in {
      val encodeResult = Main.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      encodeResult.size mustEqual 6
      // different ways to check a list
      encodeResult must haveTheSameElementsAs(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
      // encodeResult must contain(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
      encodeResult.toSeq should equalTo(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)).toSeq)
    }

    "when nothing to separate, should create at least a list with all element with flag '1 " in {
      val encodeResult = Main.encode(List('a, 'b, 'c))
      encodeResult.size mustEqual 3
    }

    "when a list empty is used as input, we should receve an empty list" in {
      val encodeResult = Main.encode(List())
      encodeResult.size mustEqual 0
      encodeResult mustEqual List()
    }
  }


  "#problem 11 : Modified run-length encoding.\nModify the result of problem P10 in such a way that if an element has " +
    "no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms." should {

    "work as expected with a proper list" in {
      val encodeResult = Main.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      encodeResult.size mustEqual 6
      encodeResult must haveTheSameElementsAs(List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))
    }
  }

}
