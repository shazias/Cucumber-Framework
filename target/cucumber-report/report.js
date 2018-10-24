$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Backend.feature");
formatter.feature({
  "line": 2,
  "name": "Backend Tests",
  "description": "",
  "id": "backend-tests",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@REGRESSION"
    }
  ]
});
formatter.before({
  "duration": 166118544,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Establish connection to Druid",
  "description": "",
  "id": "backend-tests;establish-connection-to-druid",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@DRUID"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am connected to: \"http://10.79.236.138:8082/druid/v2/?pretty\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I use the Jason query: \"C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery.json\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I save data to Location: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/DRUID//\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the result should be pulled",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://10.79.236.138:8082/druid/v2/?pretty",
      "offset": 20
    }
  ],
  "location": "DruidStepDefinition.iAmConnectedToDruid(String)"
});
formatter.result({
  "duration": 94887016,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery.json",
      "offset": 24
    }
  ],
  "location": "DruidStepDefinition.iSpecifyJsonQuery(String)"
});
formatter.result({
  "duration": 46065,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/DRUID//",
      "offset": 26
    }
  ],
  "location": "DruidStepDefinition.iSpecifyDataDumpLocation(String)"
});
formatter.result({
  "duration": 7929592,
  "status": "passed"
});
formatter.match({
  "location": "DruidStepDefinition.thePageHeaderShouldBe()"
});
formatter.result({
  "duration": 1459816631,
  "status": "passed"
});
formatter.after({
  "duration": 18424850,
  "status": "passed"
});
formatter.before({
  "duration": 10963460,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "NULL CHECK data from Druid",
  "description": "",
  "id": "backend-tests;null-check-data-from-druid",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@DRUID"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I am connected to: \"http://10.79.236.138:8082/druid/v2/?pretty\"",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I use the Jason query: \"C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery.json\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I save data to Location: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/DRUID//\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "the result should be pulled",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the Druid file is extracted and NULL check begins",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://10.79.236.138:8082/druid/v2/?pretty",
      "offset": 20
    }
  ],
  "location": "DruidStepDefinition.iAmConnectedToDruid(String)"
});
formatter.result({
  "duration": 64189,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery.json",
      "offset": 24
    }
  ],
  "location": "DruidStepDefinition.iSpecifyJsonQuery(String)"
});
formatter.result({
  "duration": 51351,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/DRUID//",
      "offset": 26
    }
  ],
  "location": "DruidStepDefinition.iSpecifyDataDumpLocation(String)"
});
formatter.result({
  "duration": 183127,
  "status": "passed"
});
formatter.match({
  "location": "DruidStepDefinition.thePageHeaderShouldBe()"
});
formatter.result({
  "duration": 649089235,
  "status": "passed"
});
formatter.match({
  "location": "DruidStepDefinition.DruidDataCheckNull()"
});
formatter.result({
  "duration": 1804462,
  "error_message": "java.io.IOException: Stream closed\r\n\tat java.io.BufferedReader.ensureOpen(BufferedReader.java:122)\r\n\tat java.io.BufferedReader.readLine(BufferedReader.java:317)\r\n\tat java.io.BufferedReader.readLine(BufferedReader.java:389)\r\n\tat com.sdc.automation.utilities.FileUtils.hasNullData(FileUtils.java:35)\r\n\tat com.sdc.automation.backend.DruidConnection.DruidDataCheckNull(DruidConnection.java:40)\r\n\tat com.sdc.automation.stepdefinitions.DruidStepDefinition.DruidDataCheckNull(DruidStepDefinition.java:18)\r\n\tat ✽.And the Druid file is extracted and NULL check begins(Backend.feature:17)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 8726289,
  "status": "passed"
});
formatter.before({
  "duration": 11059365,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Capacity variation above a treshold in Druid",
  "description": "",
  "id": "backend-tests;capacity-variation-above-a-treshold-in-druid",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@DRUID"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "I am connected to: \"http://10.79.236.138:8082/druid/v2/?pretty\"",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I use the Jason query: \"C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery1.json\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "Druid connection to Maria Database is established:\"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "The Druid Data is dumped in MariaDbTable:\"sdc_qa.druid_capacity_status\"",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "The variation in Druid for last two days is less than percent :50",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://10.79.236.138:8082/druid/v2/?pretty",
      "offset": 20
    }
  ],
  "location": "DruidStepDefinition.iAmConnectedToDruid(String)"
});
formatter.result({
  "duration": 82313,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery1.json",
      "offset": 24
    }
  ],
  "location": "DruidStepDefinition.iSpecifyJsonQuery(String)"
});
formatter.result({
  "duration": 69098,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset",
      "offset": 51
    }
  ],
  "location": "DruidStepDefinition.theMAriaDBConnectionisEstablished(String)"
});
formatter.result({
  "duration": 4695777580,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdc_qa.druid_capacity_status",
      "offset": 42
    }
  ],
  "location": "DruidStepDefinition.theDruidDatadumpedtoMariaDataBase(String)"
});
formatter.result({
  "duration": 4411279269,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50",
      "offset": 63
    }
  ],
  "location": "DruidStepDefinition.theDruidDataExtracted(int)"
});
formatter.result({
  "duration": 451501906,
  "error_message": "java.lang.Exception: Variation is -205 greater than threshold for DRUID_BLOCK_CAPACITY AND VSPG_56744 DATE -205.23844246266577\r\n\tat com.sdc.automation.backend.DruidConnection.DruidVariationForLastTwoDays(DruidConnection.java:100)\r\n\tat com.sdc.automation.stepdefinitions.DruidStepDefinition.theDruidDataExtracted(DruidStepDefinition.java:48)\r\n\tat ✽.Then The variation in Druid for last two days is less than percent :50(Backend.feature:25)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 4981057,
  "status": "passed"
});
formatter.before({
  "duration": 13514779,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Number of devices variation above a treshold in Druid",
  "description": "",
  "id": "backend-tests;number-of-devices-variation-above-a-treshold-in-druid",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 27,
      "name": "@DRUID"
    }
  ]
});
formatter.step({
  "line": 29,
  "name": "I am connected to: \"http://10.79.236.138:8082/druid/v2/?pretty\"",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "I use the Jason query: \"C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery1.json\"",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Druid connection to Maria Database is established:\"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset\"",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "The Druid Data is dumped in MariaDbTable:\"sdc_qa.druid_capacity_status\"",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "The variation in Druid for last two days is less than number :50",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://10.79.236.138:8082/druid/v2/?pretty",
      "offset": 20
    }
  ],
  "location": "DruidStepDefinition.iAmConnectedToDruid(String)"
});
formatter.result({
  "duration": 61924,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C:/Users/Sshaikh/Desktop/SDC/sdc-ui-selenium/functional-tests/DruidQuery1.json",
      "offset": 24
    }
  ],
  "location": "DruidStepDefinition.iSpecifyJsonQuery(String)"
});
formatter.result({
  "duration": 37381,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset",
      "offset": 51
    }
  ],
  "location": "DruidStepDefinition.theMAriaDBConnectionisEstablished(String)"
});
formatter.result({
  "duration": 38891,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdc_qa.druid_capacity_status",
      "offset": 42
    }
  ],
  "location": "DruidStepDefinition.theDruidDatadumpedtoMariaDataBase(String)"
});
formatter.result({
  "duration": 4299445257,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50",
      "offset": 62
    }
  ],
  "location": "DruidStepDefinition.theDruidDeviceNumbers(int)"
});
formatter.result({
  "duration": 462330192,
  "error_message": "java.lang.Exception: Variation is -205 greater than threshold for DRUID_BLOCK_CAPACITY AND VSPG_56744 DATE -205.23844246266577\r\n\tat com.sdc.automation.backend.DruidConnection.DruidNumberVariation(DruidConnection.java:88)\r\n\tat com.sdc.automation.stepdefinitions.DruidStepDefinition.theDruidDeviceNumbers(DruidStepDefinition.java:54)\r\n\tat ✽.Then The variation in Druid for last two days is less than number :50(Backend.feature:33)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 4742803,
  "status": "passed"
});
formatter.before({
  "duration": 10709725,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Establish connection to CMDB",
  "description": "",
  "id": "backend-tests;establish-connection-to-cmdb",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 35,
      "name": "@CMDB"
    }
  ]
});
formatter.step({
  "line": 37,
  "name": "I use the CMDB URL: \"dgsddevcmdb01.mcs.local:3306/car_nomura\"",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "I use the CMDB userid: \"iawan\"",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "I use the CMDB password: \"yasmijNth!!\"",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "I use CMDB query: \"SELECT \u0027Hello World!\u0027\"",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "the CMDB connection is established",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "dgsddevcmdb01.mcs.local:3306/car_nomura",
      "offset": 21
    }
  ],
  "location": "CMDBConnectionStepDefinition.iAmConnectedToCmdb(String)"
});
formatter.result({
  "duration": 12021066,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iawan",
      "offset": 24
    }
  ],
  "location": "CMDBConnectionStepDefinition.iSpecifyuserId(String)"
});
formatter.result({
  "duration": 72118,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "yasmijNth!!",
      "offset": 26
    }
  ],
  "location": "CMDBConnectionStepDefinition.iSpecifyPassword(String)"
});
formatter.result({
  "duration": 53994,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SELECT \u0027Hello World!\u0027",
      "offset": 19
    }
  ],
  "location": "CMDBConnectionStepDefinition.iUseQuery(String)"
});
formatter.result({
  "duration": 56638,
  "status": "passed"
});
formatter.match({
  "location": "CMDBConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 1429685241,
  "status": "passed"
});
formatter.after({
  "duration": 3440146,
  "status": "passed"
});
formatter.before({
  "duration": 11995390,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "Extract data from CMDB",
  "description": "",
  "id": "backend-tests;extract-data-from-cmdb",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 43,
      "name": "@CMDB"
    }
  ]
});
formatter.step({
  "line": 45,
  "name": "I insert CMDB query: \"select * from tblcountry\"",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "the CMDB connection is established",
  "keyword": "Then "
});
formatter.step({
  "line": 47,
  "name": "the CMDB table data is extracted at: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/CMDB//\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "select * from tblcountry",
      "offset": 22
    }
  ],
  "location": "CMDBConnectionStepDefinition.iUseExtractQuery(String)"
});
formatter.result({
  "duration": 79292,
  "status": "passed"
});
formatter.match({
  "location": "CMDBConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 1253183957,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/CMDB//",
      "offset": 38
    }
  ],
  "location": "CMDBConnectionStepDefinition.theCMDBDataExtracted(String)"
});
formatter.result({
  "duration": 342516370,
  "status": "passed"
});
formatter.after({
  "duration": 1160308,
  "status": "passed"
});
formatter.before({
  "duration": 9075552,
  "status": "passed"
});
formatter.scenario({
  "line": 50,
  "name": "NULL CHECK data from CMDB",
  "description": "",
  "id": "backend-tests;null-check-data-from-cmdb",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 49,
      "name": "@CMDB"
    }
  ]
});
formatter.step({
  "line": 51,
  "name": "I insert CMDB query: \"select * from tblcountry\"",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "the CMDB connection is established",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "the CMDB table data is extracted at: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/CMDB//\"",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "the CMDB file is extracted and NULL check begins",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "select * from tblcountry",
      "offset": 22
    }
  ],
  "location": "CMDBConnectionStepDefinition.iUseExtractQuery(String)"
});
formatter.result({
  "duration": 75894,
  "status": "passed"
});
formatter.match({
  "location": "CMDBConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 1242605252,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/CMDB//",
      "offset": 38
    }
  ],
  "location": "CMDBConnectionStepDefinition.theCMDBDataExtracted(String)"
});
formatter.result({
  "duration": 346161543,
  "status": "passed"
});
formatter.match({
  "location": "CMDBConnectionStepDefinition.CmdbDataCheckNull()"
});
formatter.result({
  "duration": 832568,
  "error_message": "java.io.IOException: Stream closed\r\n\tat java.io.BufferedReader.ensureOpen(BufferedReader.java:122)\r\n\tat java.io.BufferedReader.readLine(BufferedReader.java:317)\r\n\tat java.io.BufferedReader.readLine(BufferedReader.java:389)\r\n\tat com.sdc.automation.utilities.FileUtils.hasNullData(FileUtils.java:35)\r\n\tat com.sdc.automation.backend.CMDBConnector.CmdbDataCheckNull(CMDBConnector.java:36)\r\n\tat com.sdc.automation.stepdefinitions.CMDBConnectionStepDefinition.CmdbDataCheckNull(CMDBConnectionStepDefinition.java:19)\r\n\tat ✽.Then the CMDB file is extracted and NULL check begins(Backend.feature:54)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1398940,
  "status": "passed"
});
formatter.before({
  "duration": 9618892,
  "status": "passed"
});
formatter.scenario({
  "line": 57,
  "name": "Establish connection to HIVE",
  "description": "",
  "id": "backend-tests;establish-connection-to-hive",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 56,
      "name": "@HIVE"
    }
  ]
});
formatter.step({
  "line": 58,
  "name": "I am connected to Hive: \"dgsddevhdp03.mcs.local:10000/nomura\"",
  "keyword": "Given "
});
formatter.step({
  "line": 59,
  "name": "I use the Hive userid: \"pentaho\"",
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "I use the Hive password: \"yetReN6tegaw\"",
  "keyword": "And "
});
formatter.step({
  "line": 61,
  "name": "I use Hive query: \"select * from block_app_flattened limit 1\"",
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "the Hive connection is established",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "dgsddevhdp03.mcs.local:10000/nomura",
      "offset": 25
    }
  ],
  "location": "HiveConnectionStepDefinition.iAmConnectedToHive(String)"
});
formatter.result({
  "duration": 14603347,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "pentaho",
      "offset": 24
    }
  ],
  "location": "HiveConnectionStepDefinition.iSpecifyuserId(String)"
});
formatter.result({
  "duration": 64188,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "yetReN6tegaw",
      "offset": 26
    }
  ],
  "location": "HiveConnectionStepDefinition.iSpecifyPassword(String)"
});
formatter.result({
  "duration": 55505,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "select * from block_app_flattened limit 1",
      "offset": 19
    }
  ],
  "location": "HiveConnectionStepDefinition.iUseQuery(String)"
});
formatter.result({
  "duration": 63056,
  "status": "passed"
});
formatter.match({
  "location": "HiveConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 2829456577,
  "status": "passed"
});
formatter.after({
  "duration": 1348722,
  "status": "passed"
});
formatter.before({
  "duration": 10617595,
  "status": "passed"
});
formatter.scenario({
  "line": 65,
  "name": "Extract data from HIVE",
  "description": "",
  "id": "backend-tests;extract-data-from-hive",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 64,
      "name": "@HIVE"
    }
  ]
});
formatter.step({
  "line": 66,
  "name": "the Hive connection is established",
  "keyword": "Given "
});
formatter.step({
  "line": 67,
  "name": "I insert HIVE query: \"select * from  nomura.file_spool_flattened_rupesh where datetime in(select distinct datetime from nomura.file_spool_flattened_rupesh FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),30))\"",
  "keyword": "When "
});
formatter.step({
  "line": 68,
  "name": "the HIVE table data is extracted at: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HIVE//\"",
  "keyword": "Then "
});
formatter.match({
  "location": "HiveConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 1840654137,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "select * from  nomura.file_spool_flattened_rupesh where datetime in(select distinct datetime from nomura.file_spool_flattened_rupesh FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),30))",
      "offset": 22
    }
  ],
  "location": "HiveConnectionStepDefinition.iUseExtractHiveQuery(String)"
});
formatter.result({
  "duration": 177841,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HIVE//",
      "offset": 38
    }
  ],
  "location": "HiveConnectionStepDefinition.theHiveDataExtracted(String)"
});
formatter.result({
  "duration": 19623319667,
  "status": "passed"
});
formatter.after({
  "duration": 953394,
  "status": "passed"
});
formatter.before({
  "duration": 10149394,
  "status": "passed"
});
formatter.scenario({
  "line": 71,
  "name": "NULL CHECK data from HIVE",
  "description": "",
  "id": "backend-tests;null-check-data-from-hive",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 70,
      "name": "@HIVE"
    }
  ]
});
formatter.step({
  "line": 72,
  "name": "the Hive connection is established",
  "keyword": "Given "
});
formatter.step({
  "line": 73,
  "name": "I insert HIVE query: \"select * from  nomura.file_spool_flattened_rupesh where datetime in(select distinct datetime from nomura.file_spool_flattened_rupesh FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),30))\"",
  "keyword": "When "
});
formatter.step({
  "line": 74,
  "name": "the HIVE table data is extracted at: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HIVE//\"",
  "keyword": "And "
});
formatter.step({
  "line": 75,
  "name": "the file is extracted and NULL check begins",
  "keyword": "Then "
});
formatter.match({
  "location": "HiveConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 1767105392,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "select * from  nomura.file_spool_flattened_rupesh where datetime in(select distinct datetime from nomura.file_spool_flattened_rupesh FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),30))",
      "offset": 22
    }
  ],
  "location": "HiveConnectionStepDefinition.iUseExtractHiveQuery(String)"
});
formatter.result({
  "duration": 38135,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HIVE//",
      "offset": 38
    }
  ],
  "location": "HiveConnectionStepDefinition.theHiveDataExtracted(String)"
});
formatter.result({
  "duration": 29202885554,
  "status": "passed"
});
formatter.match({
  "location": "HiveConnectionStepDefinition.HiveDataCheckNull()"
});
formatter.result({
  "duration": 2177135,
  "error_message": "java.io.IOException: Stream closed\r\n\tat java.io.BufferedReader.ensureOpen(BufferedReader.java:122)\r\n\tat java.io.BufferedReader.readLine(BufferedReader.java:317)\r\n\tat java.io.BufferedReader.readLine(BufferedReader.java:389)\r\n\tat com.sdc.automation.utilities.FileUtils.hasNullData(FileUtils.java:35)\r\n\tat com.sdc.automation.backend.HiveConnection.HiveDataCheckNull(HiveConnection.java:56)\r\n\tat com.sdc.automation.stepdefinitions.HiveConnectionStepDefinition.HiveDataCheckNull(HiveConnectionStepDefinition.java:19)\r\n\tat ✽.Then the file is extracted and NULL check begins(Backend.feature:75)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 3141856,
  "status": "passed"
});
formatter.before({
  "duration": 14268054,
  "status": "passed"
});
formatter.scenario({
  "line": 78,
  "name": "Capacity variation above a threshold in  HIVE",
  "description": "",
  "id": "backend-tests;capacity-variation-above-a-threshold-in--hive",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 77,
      "name": "@HIVE"
    }
  ]
});
formatter.step({
  "line": 79,
  "name": "the Hive connection is established",
  "keyword": "Given "
});
formatter.step({
  "line": 80,
  "name": "I insert HIVE query: \"select distinct service_type,device_devicename,from_unixtime(unix_timestamp(datetime),\u0027yyyy-MM-dd\u0027),used from  nomura.block_device_flattened where datetime in(select distinct datetime from nomura.block_device_flattened FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),20))\"",
  "keyword": "When "
});
formatter.step({
  "line": 81,
  "name": "connection to Maria Database is established:\"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset\"",
  "keyword": "Then "
});
formatter.step({
  "line": 82,
  "name": "The Hive Data is dumped in MariaDbTable:\"sdc_qa.hive_capacity_status\"",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "The variation in last two days is less than percent :100",
  "keyword": "Then "
});
formatter.match({
  "location": "HiveConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 1890719195,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "select distinct service_type,device_devicename,from_unixtime(unix_timestamp(datetime),\u0027yyyy-MM-dd\u0027),used from  nomura.block_device_flattened where datetime in(select distinct datetime from nomura.block_device_flattened FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),20))",
      "offset": 22
    }
  ],
  "location": "HiveConnectionStepDefinition.iUseExtractHiveQuery(String)"
});
formatter.result({
  "duration": 137817,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset",
      "offset": 45
    }
  ],
  "location": "HiveConnectionStepDefinition.theMAriaDBConnectionisEstablished(String)"
});
formatter.result({
  "duration": 429311,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdc_qa.hive_capacity_status",
      "offset": 41
    }
  ],
  "location": "HiveConnectionStepDefinition.theHiveDatadumpedtoMariaDataBase(String)"
});
formatter.result({
  "duration": 135992609595,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 53
    }
  ],
  "location": "HiveConnectionStepDefinition.theHiveDataExtracted(int)"
});
formatter.result({
  "duration": 1912155258,
  "error_message": "java.lang.Exception: Variation is -276 greater than threshold for BLOCK AND INBANHVM001 DATE -276.4777085574373\r\n\tat com.sdc.automation.backend.HiveConnection.HiveVariationForLastTwoDays(HiveConnection.java:131)\r\n\tat com.sdc.automation.stepdefinitions.HiveConnectionStepDefinition.theHiveDataExtracted(HiveConnectionStepDefinition.java:74)\r\n\tat ✽.Then The variation in last two days is less than percent :100(Backend.feature:83)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 2319106,
  "status": "passed"
});
formatter.before({
  "duration": 12991829,
  "status": "passed"
});
formatter.scenario({
  "line": 86,
  "name": "Number of devices variation above a threshold in  HIVE",
  "description": "",
  "id": "backend-tests;number-of-devices-variation-above-a-threshold-in--hive",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 85,
      "name": "@HIVE"
    }
  ]
});
formatter.step({
  "line": 87,
  "name": "the Hive connection is established",
  "keyword": "Given "
});
formatter.step({
  "line": 88,
  "name": "I insert HIVE query: \"select distinct service_type,device_devicename,from_unixtime(unix_timestamp(datetime),\u0027yyyy-MM-dd\u0027),used from  nomura.block_device_flattened where datetime in(select distinct datetime from nomura.block_device_flattened FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),20))\"",
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "connection to Maria Database is established:\"jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset\"",
  "keyword": "Then "
});
formatter.step({
  "line": 90,
  "name": "The Hive Data is dumped in MariaDbTable:\"sdc_qa.hive_capacity_status\"",
  "keyword": "And "
});
formatter.step({
  "line": 91,
  "name": "The variation in last two days is less than number :100",
  "keyword": "Then "
});
formatter.match({
  "location": "HiveConnectionStepDefinition.theConnectionIsEstablished()"
});
formatter.result({
  "duration": 1865373273,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "select distinct service_type,device_devicename,from_unixtime(unix_timestamp(datetime),\u0027yyyy-MM-dd\u0027),used from  nomura.block_device_flattened where datetime in(select distinct datetime from nomura.block_device_flattened FOO where FOO.datetime\u003eDATE_SUB(FROM_UNIXTIME(UNIX_TIMESTAMP()),20))",
      "offset": 22
    }
  ],
  "location": "HiveConnectionStepDefinition.iUseExtractHiveQuery(String)"
});
formatter.result({
  "duration": 122714,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jdbc:mariadb://10.79.236.111:3306/sdc_qa?user\u003droot\u0026password\u003dsuperset",
      "offset": 45
    }
  ],
  "location": "HiveConnectionStepDefinition.theMAriaDBConnectionisEstablished(String)"
});
formatter.result({
  "duration": 90242,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sdc_qa.hive_capacity_status",
      "offset": 41
    }
  ],
  "location": "HiveConnectionStepDefinition.theHiveDatadumpedtoMariaDataBase(String)"
});
formatter.result({
  "duration": 132839909924,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "100",
      "offset": 52
    }
  ],
  "location": "HiveConnectionStepDefinition.theHiveDeviceNumbers(int)"
});
formatter.result({
  "duration": 2156230436,
  "error_message": "java.lang.Exception: Variation is -276 greater than threshold for BLOCK AND INBANHVM001 DATE -276.4777085574373\r\n\tat com.sdc.automation.backend.HiveConnection.HiveNumberVariation(HiveConnection.java:119)\r\n\tat com.sdc.automation.stepdefinitions.HiveConnectionStepDefinition.theHiveDeviceNumbers(HiveConnectionStepDefinition.java:88)\r\n\tat ✽.Then The variation in last two days is less than number :100(Backend.feature:91)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 3251356,
  "status": "passed"
});
formatter.before({
  "duration": 13632584,
  "status": "passed"
});
formatter.scenario({
  "line": 94,
  "name": "Establish connection to HDCA",
  "description": "",
  "id": "backend-tests;establish-connection-to-hdca",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 93,
      "name": "@HDCA"
    }
  ]
});
formatter.step({
  "line": 95,
  "name": "I am connected to HDCA: \"https://dnomprddca01.mcs.local:8443/dbapi.do?action\u003dquery\u0026dataset\u003ddefaultDs\u0026processSync\u003dtrue\"",
  "keyword": "Given "
});
formatter.step({
  "line": 96,
  "name": "I use the HDCA Authorisation: \"Basic YWRtaW46Tm9tdXJhQGhkY2Ex\"",
  "keyword": "And "
});
formatter.step({
  "line": 97,
  "name": "I use the HDCA Resource: \"raidStorage\"",
  "keyword": "And "
});
formatter.step({
  "line": 98,
  "name": "I use the HDCA Query: \"[\u003dname rx .*][\u003dserialNumber rx .*][\u003dopenReservedCapacityGB rx .*][\u003dunAllocatedCapacityInGB rx .*][\u003dallocatedCapacityInGB rx .*]/raidPool[\u003dname rx .*][\u003dtotalCapacityInGB rx .*][\u003dusedCapacityInGB rx .*][\u003dpoolType rx .*][\u003dsubscribedCapacity rx .*]\"",
  "keyword": "And "
});
formatter.step({
  "line": 99,
  "name": "I use the HDCA START_TIME: \"20180706_000000\"",
  "keyword": "And "
});
formatter.step({
  "line": 100,
  "name": "I use the HDCA END_TIME: \"20180706_000000\"",
  "keyword": "And "
});
formatter.step({
  "line": 101,
  "name": "the HDCA connection is established",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://dnomprddca01.mcs.local:8443/dbapi.do?action\u003dquery\u0026dataset\u003ddefaultDs\u0026processSync\u003dtrue",
      "offset": 25
    }
  ],
  "location": "HDCAstepDefinition.iAmConnectedToHDCA(String)"
});
formatter.result({
  "duration": 20239130,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Basic YWRtaW46Tm9tdXJhQGhkY2Ex",
      "offset": 31
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAauthorisation(String)"
});
formatter.result({
  "duration": 62678,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "raidStorage",
      "offset": 26
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAresource(String)"
});
formatter.result({
  "duration": 83068,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "[\u003dname rx .*][\u003dserialNumber rx .*][\u003dopenReservedCapacityGB rx .*][\u003dunAllocatedCapacityInGB rx .*][\u003dallocatedCapacityInGB rx .*]/raidPool[\u003dname rx .*][\u003dtotalCapacityInGB rx .*][\u003dusedCapacityInGB rx .*][\u003dpoolType rx .*][\u003dsubscribedCapacity rx .*]",
      "offset": 23
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAquery(String)"
});
formatter.result({
  "duration": 65699,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20180706_000000",
      "offset": 28
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAstartTime(String)"
});
formatter.result({
  "duration": 129888,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20180706_000000",
      "offset": 26
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAendTime(String)"
});
formatter.result({
  "duration": 57015,
  "status": "passed"
});
formatter.match({
  "location": "HDCAstepDefinition.theHDCAconnection()"
});
formatter.result({
  "duration": 4844335559,
  "status": "passed"
});
formatter.after({
  "duration": 1977395,
  "status": "passed"
});
formatter.before({
  "duration": 11039732,
  "status": "passed"
});
formatter.scenario({
  "line": 104,
  "name": "Extract data from HDCA",
  "description": "",
  "id": "backend-tests;extract-data-from-hdca",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 103,
      "name": "@HDCA"
    }
  ]
});
formatter.step({
  "line": 105,
  "name": "the HDCA connection is established",
  "keyword": "Given "
});
formatter.step({
  "line": 106,
  "name": "I use the HDCA Resource: \"raidStorage\"",
  "keyword": "When "
});
formatter.step({
  "line": 107,
  "name": "I use the HDCA Query: \"[\u003dname rx .*][\u003dserialNumber rx .*][\u003dopenReservedCapacityGB rx .*][\u003dunAllocatedCapacityInGB rx .*][\u003dallocatedCapacityInGB rx .*]/raidPool[\u003dname rx .*][\u003dtotalCapacityInGB rx .*][\u003dusedCapacityInGB rx .*][\u003dpoolType rx .*][\u003dsubscribedCapacity rx .*]\"",
  "keyword": "And "
});
formatter.step({
  "line": 108,
  "name": "I use the HDCA START_TIME: \"20180706_000000\"",
  "keyword": "And "
});
formatter.step({
  "line": 109,
  "name": "I use the HDCA END_TIME: \"20180706_000000\"",
  "keyword": "And "
});
formatter.step({
  "line": 110,
  "name": "the HDCA data is extracted at: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HDCA//\"",
  "keyword": "Then "
});
formatter.match({
  "location": "HDCAstepDefinition.theHDCAconnection()"
});
formatter.result({
  "duration": 4155694270,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "raidStorage",
      "offset": 26
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAresource(String)"
});
formatter.result({
  "duration": 126113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "[\u003dname rx .*][\u003dserialNumber rx .*][\u003dopenReservedCapacityGB rx .*][\u003dunAllocatedCapacityInGB rx .*][\u003dallocatedCapacityInGB rx .*]/raidPool[\u003dname rx .*][\u003dtotalCapacityInGB rx .*][\u003dusedCapacityInGB rx .*][\u003dpoolType rx .*][\u003dsubscribedCapacity rx .*]",
      "offset": 23
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAquery(String)"
});
formatter.result({
  "duration": 156697,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20180706_000000",
      "offset": 28
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAstartTime(String)"
});
formatter.result({
  "duration": 97416,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20180706_000000",
      "offset": 26
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAendTime(String)"
});
formatter.result({
  "duration": 71363,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HDCA//",
      "offset": 32
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAfilePath(String)"
});
formatter.result({
  "duration": 15279973,
  "status": "passed"
});
formatter.after({
  "duration": 742703,
  "status": "passed"
});
formatter.before({
  "duration": 7575420,
  "status": "passed"
});
formatter.scenario({
  "line": 113,
  "name": "Extract data from HDCA",
  "description": "",
  "id": "backend-tests;extract-data-from-hdca",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 112,
      "name": "@HDCA"
    }
  ]
});
formatter.step({
  "line": 114,
  "name": "the HDCA connection is established",
  "keyword": "Given "
});
formatter.step({
  "line": 115,
  "name": "I use the HDCA Resource: \"raidStorage\"",
  "keyword": "When "
});
formatter.step({
  "line": 116,
  "name": "I use the HDCA Query: \"[\u003dname rx .*][\u003dserialNumber rx .*][\u003dopenReservedCapacityGB rx .*][\u003dunAllocatedCapacityInGB rx .*][\u003dallocatedCapacityInGB rx .*]/raidPool[\u003dname rx .*][\u003dtotalCapacityInGB rx .*][\u003dusedCapacityInGB rx .*][\u003dpoolType rx .*][\u003dsubscribedCapacity rx .*]\"",
  "keyword": "And "
});
formatter.step({
  "line": 117,
  "name": "I use the HDCA START_TIME: \"20180706_000000\"",
  "keyword": "And "
});
formatter.step({
  "line": 118,
  "name": "I use the HDCA END_TIME: \"20180706_000000\"",
  "keyword": "And "
});
formatter.step({
  "line": 119,
  "name": "the HDCA data is extracted at: \"C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HDCA//\"",
  "keyword": "And "
});
formatter.step({
  "line": 120,
  "name": "the HDCA  NULL check begins",
  "keyword": "Then "
});
formatter.match({
  "location": "HDCAstepDefinition.theHDCAconnection()"
});
formatter.result({
  "duration": 4117420332,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "raidStorage",
      "offset": 26
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAresource(String)"
});
formatter.result({
  "duration": 117806,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "[\u003dname rx .*][\u003dserialNumber rx .*][\u003dopenReservedCapacityGB rx .*][\u003dunAllocatedCapacityInGB rx .*][\u003dallocatedCapacityInGB rx .*]/raidPool[\u003dname rx .*][\u003dtotalCapacityInGB rx .*][\u003dusedCapacityInGB rx .*][\u003dpoolType rx .*][\u003dsubscribedCapacity rx .*]",
      "offset": 23
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAquery(String)"
});
formatter.result({
  "duration": 155563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20180706_000000",
      "offset": 28
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAstartTime(String)"
});
formatter.result({
  "duration": 77404,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20180706_000000",
      "offset": 26
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAendTime(String)"
});
formatter.result({
  "duration": 72873,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C://Users//Sshaikh//Desktop//SDC//sdc-ui-selenium//functional-tests//data-dump/HDCA//",
      "offset": 32
    }
  ],
  "location": "HDCAstepDefinition.iSpecifyHDCAfilePath(String)"
});
formatter.result({
  "duration": 13697151,
  "status": "passed"
});
formatter.match({
  "location": "HDCAstepDefinition.hasNullValues()"
});
formatter.result({
  "duration": 649440,
  "status": "passed"
});
formatter.after({
  "duration": 540697,
  "status": "passed"
});
});