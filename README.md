# testvagrantsample
feedback/suggested improvements are:
webdriver is initialized before setting the driver path
page factory intialization can be used to avoid clutter ,enhance reusability and for ease of maintainance
utilclass can be added with frequently used methods to avoid code duplication
explicit waits can be added instead of hardcoding sleep time in some cases
relative xpaths are used instead of absolute xpath
element can be located using xpath instead of using list of web elements and then clicking on the first element
locators which frequently change are used to identify elemnents
incorrect id's are used 
webelements can be renamed to identify the kind of element from the name
page object methods to interact with elements need to be public 
test methods can be added in testng.xml and this can then be referenced in pom.xml to invoke the tests all at once instead of invoking the tests from individual classes
code to disable chrome notifications need to be added else the drop down that lists airports doesnt get loaded

