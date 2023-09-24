# enocaCase

#Proje kurulumu

1) Proje Bağımlılıkları
   a-JDK 18
   b-MySql 8.0.33
2) Projeyi localinizdeki belirdediğiniz bir folder'a çekin.
3)  mysql'de bir database oluşuturun ve bir isim verin.

5) "src/main/resources/application.properties" içindeki şu alanları doldurun ;

spring.datasource.url=jdbc:mysql://localhost:3306/{$yourDbName}   -> Database portu ve database ismi
spring.datasource.username={$yourusername} -> mysqsl'e erişim için kullancı adınız
spring.datasource.password={$yourpassword} -> mysql'e erişim için şifreniz
server.port=8082 -> projenin çalışmasını istediğiniz portu değiştirebilirsiniz.

5)  Projeyi intellij IDEA ile açın ve terminalden "mvn clean" ve "mvn install" komutlarını çalıştırın.
6)  Projeyi ayağa kaldırın

   Proje Detayları

Projede Employee ve Company Entity'leri için 2 adet controller yazılmış, her iki entity onetoMany ilişkisi ile birbirine bağlanmıştır.

EnocaCaseAPICollection.json dosyasında projede bulunan apilerin collection'ları iletilmiştir, Postman'a import ederek API'ler test edilebilir.




