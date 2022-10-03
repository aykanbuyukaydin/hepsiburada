@wip
Feature: US_002 HepsiBurada Crud Islemleri

  Scenario: TC_2001 Kisileri okuma
    Then Kullanici kisiyi okumak icin "https://restful-booker.herokuapp.com/booking/75" endpointe gider
    And Status kodunun 200 oldugunu kontrol eder

  Scenario: TC_2001 Kisi ekleme
    Then Kullanici kisi eklemek icin "https://restful-booker.herokuapp.com/booking" endpointe gider
    And Status kodunun 200 oldugunu kontrol eder


