import org.junit.Ignore
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
@Ignore
class IntegrationSpec extends Specification {

  "Main page" should {

    "should contain the product catalog" in new WithBrowser {

      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("Product catalog")
    }
  }
}
