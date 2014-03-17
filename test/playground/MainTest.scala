package playground

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

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
      Main.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)).equals(List('a, 'b, 'c, 'a, 'd, 'e))
    }

    "the method will not have duplicates to remove" in {
      Main.compress(List('a, 'b, 'c, 'a, 'd, 'e)).equals(List('a, 'b, 'c, 'a, 'd, 'e))
    }
  }
}
