@wip
Feature: US_001 HepsiBurada Urun Islemleri

  Background: ortak step adimlari
    Given Kullanici "hepsiburada" sitesine gider

  Scenario: TC_1001 Urun Degerlendirme
    Then Kullanici "iphone" icin arama islemi yapar
    And Kullanici arama sonucunda gelen ilk urune gider
      #Ürün Açıklaması || Değerlendirmeler || Soru & Cevap || Taksit Seçenekleri || Alışveriş Kredisi || İptal ve İade Koşulları || Tüm Satıcılar
    When Kullanici gidilen urundeki "Değerlendirmeler" tabina tiklar
      #Evet || Hayır
    And Kullanici gelen yorumlar icerisinde ilk degerlendirmenin "Evet" butonuna tiklar
    Then Kullanici "Teşekkür Ederiz." yazisini gorur
    Then Kullanici sayfayi kapatir