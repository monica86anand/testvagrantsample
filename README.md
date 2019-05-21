
# testvagrantsample -feedback/improvements
1. webdriver is initialized before setting the driver path

2. page factory intialization can be used to avoid clutter ,enhance reusability and for ease of maintainance

3. utilclass can be added with frequently used methods to avoid code duplication

4. explicit waits can be added instead of hardcoding sleep time in some cases

5. relative xpaths are used instead of absolute xpath

6. locators which frequently change are used to identify elemnents

7. incorrect id's are used 

8. webelements can be renamed to identify the kind of element from the name

9. page object methods to interact with elements need to be public 

10. test methods can be added in testng.xml and this can then be referenced in pom.xml to invoke the tests all at once instead of invoking the tests from individual classes

