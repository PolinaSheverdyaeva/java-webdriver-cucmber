
  @predefined
  Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    And I resize window to 400 and 2000
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

    @predefined15
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



    @predefined15
    Scenario: Predefined steps for Youtube
      Given I open url "https://www.youtube.com/"
      Then I should see page title contains "YouTube"
      Then element with xpath "//input[@id='search']" should be present
      When I mouse over element with xpath "//img[@id='thumbnail']"
      Then I click on element using JavaScript with xpath "//img[@id='thumbnail']"
      Then I wait for 10 sec

    Scenario: Predefined steps for Youtube 1
      Given I open url "https://www.youtube.com/"
      Then I should see page title contains "YouTube"
      Then element with xpath "//div[@id='spinner-container']" should be present
      When I mouse over element with xpath "(//ytd-rich-grid-renderer[contains(@class,'-results-renderer')]//div[@id='overlays'])[1]"
      Then I click on element using JavaScript with xpath "(//ytd-thumbnail-overlay-now-playing-renderer[1]/span[1])[1]"
      Then I wait for 10 sec

    @predefined14
    Scenario: Predefined steps for YouTube
      Given I open url "https://www.youtube.com/"
      Then I should see page title contains "YouTube"
      Then I wait for element with xpath "//a[@id='thumbnail']" to be present
      When I mouse over element with xpath "//a[@id='thumbnail']"
      Then I click on element using JavaScript with xpath "//a[@id='thumbnail']"
      Then I wait for 10 sec

