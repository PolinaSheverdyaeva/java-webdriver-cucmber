@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Bing
    Given I open url "https://bing.com"
    Then I should see page title contains "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element using JavaScript with xpath "//input[@id='sb_form_go']"
    Then I wait for element with xpath "//*[@id='b_results']" to be present
    Then element with xpath "//*[@id='b_results']" should contain text "Cucumber"


  @predefined3
  Scenario: Steps for Duckduckgo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element using JavaScript with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[contains(@class,'results--main')]" to be present
    Then element with xpath "//div[contains(@class,'results--main')]" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com"
    Then I should see page title contains "Yahoo"
    Then element with xpath "//input[@id='uh-search-box']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='uh-search-box']"
    Then I click on element using JavaScript with xpath "//button[@id='uh-search-button']"
    Then I wait for element with xpath "//div[@id='bd']" to be present
    Then element with xpath "//div[@id='bd']" should contain text "Cucumber"


  @predefined5
  Scenario: Steps for Gibiru
    Given I open url "http://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//i[@class='fas fa-search new']"
    Then I wait for element with xpath "//div[@class='gsc-resultsbox-visible']" to be present
    Then element with xpath "//div[@class='gsc-resultsbox-visible']" should contain text "Cucumber"


  @predefined6
  Scenario: Steps for Swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    Then I click on element using JavaScript with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//article" to be present
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"


  @predefined7
  Scenario: Steps for Searchencrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//div[@class='col-md-12 text-center']//input[@placeholder='Search...']" should be present
    When I type "Behavior Driven Development" into element with xpath "//div[@class='col-md-12 text-center']//input[@placeholder='Search...']"
    Then I click on element using JavaScript with xpath "//button[@id='btn-secure-search']"
    Then I wait for element with xpath "//div[@id='results-list']" to be present
    Then element with xpath "//div[@id='results-list']" should contain text "Cucumber"


  @predefined8
  Scenario: Steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='query']"
    Then I click on element using JavaScript with xpath "//button[@class='search-form__button']"
    Then I wait for 2 sec
    Then I wait for element with xpath "//html//body" to be present
    Then element with xpath "//html//body" should contain text "Cucumber"


  @predefined9
  Scenario: Steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title contains "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='content__left']" to be present
    Then I click on element using JavaScript with xpath "//*[contains(@class,'link')][contains(text(),'next')]"
    Then I wait for 2 sec
    Then element with xpath "//div[@class='content__left']" should contain text "Cucumber"


  @predefined10
  Scenario: Steps for Boardreader
    Given I open url "http://boardreader.com"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    Then I click on element using JavaScript with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" to be present
    Then I click on element using JavaScript with xpath "//*[contains(text(),'Next')]"
    Then I wait for 2 sec
    Then I click on element using JavaScript with xpath "//*[contains(text(),'Next')]"
    Then I wait for 2 sec
    Then element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" should contain text "Cucumber"


  @predefined11
  Scenario: Steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"

  @predefined12
  Scenario: Predefined steps for Ebay
    Given I open url "https://www.ebay.com/"
    When I mouse over element with xpath "//li[@class='hl-cat-nav__js-tab']//a[text()='Electronics']"
    And I click on element using JavaScript with xpath "//a[text()='Cameras & Photo']"
    And I wait for element with xpath "//div[@id='mainContent']" to be present
    Then element with xpath "//div[@id='mainContent']" should contain text "Camera Drones"
    When I type "phone" into element with xpath "//input[@id='gh-ac']"
    And I click on element with xpath "//input[@id='gh-btn']"
    Then element with xpath "//div[@id='mainContent']" should contain text "iPhone"
    When I click on element with xpath "//a[text()='Sign in']"
    And I wait for element with xpath "//a[@id='gh-la']" to be present
    Then element with xpath "//h1[text()='Please verify yourself to continue']" should be displayed


  @predefined13
  Scenario: Predefined steps for Youtube
    Given I open url "https://www.youtube.com/"
    Then I should see page title contains "YouTube"
    Then element with xpath "//input[@id='search']" should be present
    When I mouse over element with xpath "//img[@id='thumbnail']"
    Then I click on element using JavaScript with xpath "//img[@id='thumbnail']"
    Then I wait for 10 sec


  @predefined14
  Scenario: Predefined steps for Youtube 1
    Given I open url "https://www.youtube.com/"
    Then I should see page title contains "YouTube"
    Then element with xpath "//div[@id='spinner-container']" should be present
    When I mouse over element with xpath "(//ytd-rich-grid-renderer[contains(@class,'-results-renderer')]//div[@id='overlays'])[1]"
    Then I click on element using JavaScript with xpath "(//ytd-thumbnail-overlay-now-playing-renderer[1]/span[1])[1]"
    Then I wait for 10 sec

  @predefined15
  Scenario: Predefined steps for YouTube
    Given I open url "https://www.youtube.com/"
    Then I should see page title contains "YouTube"
    Then I wait for element with xpath "//a[@id='thumbnail']" to be present
    When I mouse over element with xpath "//a[@id='thumbnail']"
    Then I click on element using JavaScript with xpath "//a[@id='thumbnail']"
    Then I wait for 10 sec

  @predefined16
  Scenario: Predefined steps for Gumtree
    Given I open url "https://www.gumtree.com.au/"
    When I wait for element with xpath "//input[@id='search-query']" to be present
    When I type "sewing machine" into element with xpath "//input[@id='search-query']"
    Then I wait for 2 sec
    And I type "Asquith" into element with xpath "//input[@id='search-area']"
    When I click on element using JavaScript with xpath "//li[@class='header__search-bar-item header__search-bar-item--location search-location-all']//li[4]"
    Then I wait for 2 sec
    Then I click on element with xpath "//button[@class='header__search-button']"


  @predefined17
  Scenario: Predefined steps for Youtube blushsupreme
    Given I open url "https://www.youtube.com/"
    Then I should see page title contains "YouTube"
    Then element with xpath "//input[@id='search']" should be present
    When I type "blushsupreme" into element with xpath "//input[@id='search']"
    Then I click on element using JavaScript with xpath "//button[@id='search-icon-legacy']"
    Then I wait for 4 sec
    Then I click on element using JavaScript with xpath "(//h3//*[@id='video-title'])[1]"
    Then I wait for 10 sec

  @predefined18
  Scenario: Steps for SearchEncrypt
    Given I open url "https://www.searchencrypt.com/"
    Then I should see page title contains "Search Encrypt"
    When I type "BDD" into element with xpath "(//input[@name='q'])[1]"
    And I click on element with xpath "//input[@name='q']"
    Then I wait for element with xpath "//div[@id='results-list']" to be present
    Then element with xpath "//div[@id='results-list']" should contain text "Cucucmber"

  @quote1 @quote
  Scenario: Quote responsive design
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1280 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='currentDate']" should be displayed
    Then element with xpath "//b[@id='currentTime']" should be displayed
    And I resize window to 800 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='currentDate']" should be displayed
    Then element with xpath "//b[@id='currentTime']" should be displayed
    And I resize window to 400 and 1024
    Then element with xpath "//b[@id='location']" should not be displayed
    Then element with xpath "//b[@id='currentDate']" should not be displayed
    Then element with xpath "//b[@id='currentTime']" should not be displayed

  @quote2 @quote
  Scenario: Username field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[ @name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    And element with xpath "//label[@id='username-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='username']"
    And element with xpath "//label[@id='username-error']" should not be displayed
    And I wait for 3 sec

  @quote3
  Scenario: Email field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "psheveryahoo.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    When element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."
    When I clear element with xpath "//input[@name='email']"
    When I type "pshever@yahoo.com" into element with xpath "//input[@name='email']"
    And element with xpath "//label[@id='email-error']" should not be displayed
    And I wait for 3 sec

  @quote4 @quote
  Scenario: Password fields
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='password']" should have attribute "value" as ""
    Then element with xpath "//input[@id='confirmPassword']" should be displayed
    When I type "password" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled


  @quote5 @quote
  Scenario: Name field
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    And element with xpath "//input[@id='firstName']" should be displayed
    When I type "Polina" into element with xpath "//input[@id='firstName']"
    When I type "Shev" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Polina Shev"

  @quote6
  Scenario: Required fiends
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "Polina" into element with xpath "//input[@name='username']"
    And I type "pshever@yahoo" into element with xpath "//input[@name='email']"
    And I type "password" into element with xpath "//input[@id='password']"
    And I type "password" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    When I type "Polina" into element with xpath "//input[@id='firstName']"
    When I type "Shev" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
     #phone number
    When I type "98086942" into element with xpath "//input[@name='phone']"
    #gender
    When I click on element with xpath "//*[@name='gender'][@value='female']"
    #car make
    When I click on element with xpath "//select[@name='carMake']/option[contains(text(),'Other')]"
    # country of origin
    When I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
        # date of birth
    When I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@*='selectMonth']/option[1]"
    And I click on element with xpath "//select[@*='selectYear']/option[@value='1982']"
    And I click on element with xpath "//td[@*='selectDay']/a[text()='28']"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "01/28/1982"
    # third party
    Then I click on element with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should have text as "Submitted Application"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "Shev"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "Russia"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "01/28/1982"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "98086942"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "Other"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "Polina"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "Polina"
    Then element with xpath "//div[@class='well form-container container-fluid']" should not have text as "password"
    Then element with xpath "//div[@class='well form-container container-fluid']" should contain text "Polina Shev"
    Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    Then element with xpath "//b[@name='password']" should contain text "entered"
    And I say helloworld






