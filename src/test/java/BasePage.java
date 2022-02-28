import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {

    // protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Step("<wait> saniye kadar bekle")
    public void waitForSeconds(int wait) throws InterruptedException {        // ....... saniye bekler.
        Thread.sleep(wait * 1000);

    }

    @Step("id<id> li elemente tıkla")
    public void clickById(String id) {

        appiumDriver.findElement(By.id(id)).click();            //.........id'li elemente tıklar
        Logger.info("Alisverise Basla Butonuna Tiklanir");
    }

    @Step("id<id> li elementi kontrol et")
    public void checkText(String id) {
        String chectText = appiumDriver.findElement(By.id(id)).getText();                                          // ....... elementi kontrol eder
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA", chectText);
        Logger.info("Tiklama Islemi Basarili");
    }



    @Step("id<id> kategoriye tıkla")
    public void clickBykategori(String id) {
        appiumDriver.findElement(By.id(id)).click();                                                        //Kategoriye tıklar
        Logger.info("Katagorilere Tiklanir");
    }
    @Step("id<id> li elementli kontrol et")
    public void checkText1(String id) {
        String chectText1 = appiumDriver.findElement(By.id(id)).getText();                          //......... id'li elementi kontrol eder
        Assertions.assertEquals("Market", chectText1);
        Logger.info("Tiklama Islemi Basarili");
    }

    @Step("xpath<xpath> kadın kategorisine tıkla")
    public void clickBykadın(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();                                              // Kadın kategorisine tıklar
        Logger.info("Kadin Kategorisine Tiklanir");
    }


    @Step("xpath<xpath> pantolon kategorisine tıkla")
    public void clickBypantolon(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();                                      //...........xPath'li Pantolon kategorisine tıklar
        Logger.info("Pantolon Kategorisine Tiklanir");
    }

    @Step("scroll et")
    public void scrollEt() {
        TouchAction ts = new TouchAction(appiumDriver);                                            //...............  belirtilen kordinatlar ile scroll eder
        ts.press(PointOption.point(538, 1538)).moveTo(PointOption.point(538, 420)).release().perform();
        Logger.info("Scroll edilir");
    }

    @Step("Rastgele bir ürün seçme")
    public void selectRandomproduct() {
        Random random = new Random();                                       //Rastgele ürün seçer
        List<MobileElement> randomUrun = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        MobileElement element = randomUrun.get(random.nextInt(randomUrun.size()));
        element.click();
        Logger.info("Rastgele Urun Secilir");
    }
    @Step("id<id> urun detay kontrolü")
    public void checkText2(String id) {
        String chectText2 = appiumDriver.findElement(By.id(id)).getText();              // Urun detay kontrolu yapar
        Assertions.assertEquals("Beden:", chectText2);
        Logger.info("Urun Detay Kontrolu Yapilir");
    }

    @Step("xpath <xpath> favoriye ekle")
    public void favorilereEkle(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();          //.........Xpath'li favorilere tıklama işlemi yapılır
        Logger.info("Favorilere Eklenme Islemi Yapilir");
    }
    @Step("id<id> giris  kontrolü")
    public void checkText3(String id) {
        String chectText3 = appiumDriver.findElement(By.id(id)).getText();                  //..........id'li giris kontrolu yapılır
        Assertions.assertEquals("Beni Hatırla", chectText3);
        Logger.info("Giris Kontrolu Yapildi");

    }

    @Step("<id> id'li elemente <mail> mail adresi girme")
    public void kullaniciAdi(String mailId, String mailText) {
        appiumDriver.findElement(By.id(mailId)).sendKeys(mailText);                     //Mail adresi girilir
        Logger.info("Mail Adresi Grisi  yapildi");
    }

    @Step("<id> 'li elemente <sifre> şifre girme")
    public void kullaniciSifre(String sifreId, String sifreText) {
        appiumDriver.findElement(By.id(sifreId)).sendKeys(sifreText);                   //Sifre girilir
        Logger.info("Sifre Girisi Yapildi");
    }
    @Step("<id> sepete ekleme yap")
    public  void AddToCart(String sepetId){
        appiumDriver.findElement(By.id(sepetId)).click();                                   //Sepete ekleme İslemine tıklanır
        Logger.info("Sepete Ekleme Islemine Tiklandi");
    }


}



