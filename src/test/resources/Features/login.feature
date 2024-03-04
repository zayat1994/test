@Assessment.feature
Feature: Assessment
  

	Scenario: Login to the url
		Given user opens url
		When user enter credentials
		Then login is successful
		
		Scenario: Admin page
		
		Given user open the admin page
		Then User can check the number of records
		
		Scenario: Add user
		Given user opens the admin page 
		When user enters data
		Then user is added
		Then number of records is increased by 1
		
		Scenario: Delete user 
		Given search for username
		When delete username
		Then number of records decrease by 1
		