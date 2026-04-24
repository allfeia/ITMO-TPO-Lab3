package ts1

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class CategoryRussianChromeTest : CategoryFilterTest(Browser.CHROME, "russian")
class CategoryRussianFirefoxTest : CategoryFilterTest(Browser.FIREFOX, "russian")

class CategoryMobileChromeTest : CategoryFilterTest(Browser.CHROME, "mobile-live")
class CategoryMobileFirefoxTest : CategoryFilterTest(Browser.FIREFOX, "mobile-live")

class CategoryRecChromeTest : CategoryFilterTest(Browser.CHROME, "recordable")
class CategoryRecFirefoxTest : CategoryFilterTest(Browser.FIREFOX, "recordable")

class CategoryHDChromeTest : CategoryFilterTest(Browser.CHROME, "hd-plus")
class CategoryHDFirefoxTest : CategoryFilterTest(Browser.FIREFOX, "hd-plus")

class OpenAllCategoriesChromeTest : OpenAllCategoriesTest(Browser.CHROME)
class OpenAllCategoriesFirefoxTest : OpenAllCategoriesTest(Browser.FIREFOX)

class QuickSearchChromeTest : QuickSearchTest(Browser.CHROME)
class QuickSearchFirefoxTest : QuickSearchTest(Browser.FIREFOX)

class EditViewChromeTest : EditViewTest(Browser.CHROME)
class EditViewFirefoxTest : EditViewTest(Browser.FIREFOX)

class SwitchSectionChromeTest : SwitchSectionTest(Browser.CHROME)
class SwitchSectionFirefoxTest : SwitchSectionTest(Browser.FIREFOX)

class AlphabetModelsChromeTest : AlphabetModelsTest(Browser.CHROME)
class AlphabetModelsFirefoxTest : AlphabetModelsTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    CategoryRussianChromeTest::class,
    CategoryRussianFirefoxTest::class,
    CategoryMobileChromeTest::class,
    CategoryMobileFirefoxTest::class,
    CategoryRecChromeTest::class,
    CategoryRecFirefoxTest::class,
    CategoryHDChromeTest::class,
    CategoryHDFirefoxTest::class,

    OpenAllCategoriesChromeTest::class,
    OpenAllCategoriesFirefoxTest::class,

    QuickSearchChromeTest::class,
    QuickSearchFirefoxTest::class,

    EditViewChromeTest::class,
    EditViewFirefoxTest::class,

    SwitchSectionChromeTest::class,
    SwitchSectionFirefoxTest::class,

    AlphabetModelsChromeTest::class,
    AlphabetModelsFirefoxTest::class
)
class CategorySuite