@REGRESSION
Feature: Backend Tests

 		@DRUID
   	Scenario: Establish connection to Druid
    Given I am connected to: "http://10.79.236.138:8082/druid/v2/?pretty"
    And I use the Jason query: "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery.json"
    And I save data to Location: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/DRUID//"
    Then the result should be pulled
    
  	@DRUID
    Scenario: NULL CHECK data from Druid
    Given I am connected to: "http://10.79.236.138:8082/druid/v2/?pretty"
    When I use the Jason query: "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery.json"
    And I save data to Location: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/DRUID//"
    Then the result should be pulled
    And the Druid file is extracted and NULL check begins
 
  	@DRUID
    Scenario: Capacity variation above a treshold in Druid
    Given I am connected to: "http://10.79.236.138:8082/druid/v2/?pretty"
    When I use the Jason query: "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery1.json"
    Then Druid connection to Maria Database is established:"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user=root&password=superset"
    And The Druid Data is dumped in MariaDbTable:"sdc_qa.druid_capacity_status"
    Then The variation in Druid for last two days is less than percent :50
    
   	@DRUID
    Scenario: Number of devices variation above a treshold in Druid
    Given I am connected to: "http://10.79.236.138:8082/druid/v2/?pretty"
    When I use the Jason query: "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery1.json"
    Then Druid connection to Maria Database is established:"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user=root&password=superset"
    And The Druid Data is dumped in MariaDbTable:"sdc_qa.druid_capacity_status"
    Then The variation in Druid for last two days is less than number :50
    
   	@CMDB
    Scenario: Establish connection to CMDB
    Given I use the CMDB URL: "dgsddevcmdb01.mcs.local:3306/car_nomura"
    And I use the CMDB userid: "iawan"
    And I use the CMDB password: "yasmijNth!!"
    And I use CMDB query: "SELECT 'Hello World!'"
    Then the CMDB connection is established
    
  	@CMDB
    Scenario: Extract data from CMDB
    When I insert CMDB query: "select * from tblcountry"
   	Then the CMDB connection is established
   	And the CMDB table data is extracted at: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/CMDB//"
   	
  	@CMDB
   	Scenario: NULL CHECK data from CMDB
    When I insert CMDB query: "select * from tblcountry"
   	Then the CMDB connection is established
   	And the CMDB table data is extracted at: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/CMDB//"
   	Then the CMDB file is extracted and NULL check begins
   	
  	@HIVE
    Scenario: Establish connection to HIVE
    Given I am connected to Hive: "dgsddevhdp03.mcs.local:10000/nomura"
    And I use the Hive userid: "pentaho"
    And I use the Hive password: "yetReN6tegaw"
    And I use Hive query: "select * from block_app_flattened limit 1"
    Then the Hive connection is established
    
 		@HIVE
    Scenario: Extract data from HIVE
    Given the Hive connection is established
    When I insert HIVE query: "select * from  nomura.file_spool_flattened_rupesh where datetime in(select distinct datetime from nomura.file_spool_flattened_rupesh FOO where FOO.datetime>DATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),30))"
    Then the HIVE table data is extracted at: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HIVE//"
    
 		@HIVE
		Scenario: NULL CHECK data from HIVE
		Given the Hive connection is established
		When I insert HIVE query: "select * from  nomura.file_spool_flattened_rupesh where datetime in(select distinct datetime from nomura.file_spool_flattened_rupesh FOO where FOO.datetime>DATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),30))"
		And the HIVE table data is extracted at: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HIVE//"
		Then the file is extracted and NULL check begins
		    
 		@HIVE
    Scenario: Capacity variation above a threshold in  HIVE
    Given the Hive connection is established
    When I insert HIVE query: "select distinct service_type,device_devicename,from_unixtime(unix_timestamp(datetime),'yyyy-MM-dd'),used from  nomura.block_device_flattened where datetime in(select distinct datetime from nomura.block_device_flattened FOO where FOO.datetime>DATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),20))"
    Then connection to Maria Database is established:"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user=root&password=superset"
    And The Hive Data is dumped in MariaDbTable:"sdc_qa.hive_capacity_status"
    Then The variation in last two days is less than percent :100
    
  	@HIVE
    Scenario: Number of devices variation above a threshold in  HIVE
    Given the Hive connection is established
    When I insert HIVE query: "select distinct service_type,device_devicename,from_unixtime(unix_timestamp(datetime),'yyyy-MM-dd'),used from  nomura.block_device_flattened where datetime in(select distinct datetime from nomura.block_device_flattened FOO where FOO.datetime>DATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),20))"
    Then connection to Maria Database is established:"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user=root&password=superset"
    And The Hive Data is dumped in MariaDbTable:"sdc_qa.hive_capacity_status"
    Then The variation in last two days is less than number :100
    
 		@HDCA
    Scenario: Establish connection to HDCA
    Given I am connected to HDCA: "https://dnomprddca01.mcs.local:8443/dbapi.do?action=query&dataset=defaultDs&processSync=true"
    And I use the HDCA Authorisation: "Basic YWRtaW46Tm9tdXJhQGhkY2Ex"
    And I use the HDCA Resource: "raidStorage"
    And I use the HDCA Query: "[=name rx .*][=serialNumber rx .*][=openReservedCapacityGB rx .*][=unAllocatedCapacityInGB rx .*][=allocatedCapacityInGB rx .*]/raidPool[=name rx .*][=totalCapacityInGB rx .*][=usedCapacityInGB rx .*][=poolType rx .*][=subscribedCapacity rx .*]"
    And I use the HDCA START_TIME: "20180706_000000"
    And I use the HDCA END_TIME: "20180706_000000"
    And the HDCA connection is established
        
 		@HDCA
 		Scenario: Extract data from HDCA
 		Given the HDCA connection is established
 		When I use the HDCA Resource: "raidStorage"
 		And I use the HDCA Query: "[=name rx .*][=serialNumber rx .*][=openReservedCapacityGB rx .*][=unAllocatedCapacityInGB rx .*][=allocatedCapacityInGB rx .*]/raidPool[=name rx .*][=totalCapacityInGB rx .*][=usedCapacityInGB rx .*][=poolType rx .*][=subscribedCapacity rx .*]"
    And I use the HDCA START_TIME: "20180706_000000"
    And I use the HDCA END_TIME: "20180706_000000"
    Then the HDCA data is extracted at: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HDCA//"
    
 		@HDCA
 		Scenario: Extract data from HDCA
 		Given the HDCA connection is established
 		When I use the HDCA Resource: "raidStorage"
 		And I use the HDCA Query: "[=name rx .*][=serialNumber rx .*][=openReservedCapacityGB rx .*][=unAllocatedCapacityInGB rx .*][=allocatedCapacityInGB rx .*]/raidPool[=name rx .*][=totalCapacityInGB rx .*][=usedCapacityInGB rx .*][=poolType rx .*][=subscribedCapacity rx .*]"
    And I use the HDCA START_TIME: "20180706_000000"
    And I use the HDCA END_TIME: "20180706_000000"
    And the HDCA data is extracted at: "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HDCA//"
    Then the HDCA  NULL check begins