Feature: HappyPathAZ
	HappyPath test to AZ problem
	
	Scenario: Happy Path
		Given I am at the homepage
		And All elements are on the page
		When I click on the Advanced Search link
		And Browser1 closes
		And Browser2 opens
		And I enter in search criteria
		And I hit the search button
		And Browser2 closes
		And Browser3 opens
		And I validate all are BMWs
		Then Browser3 closes