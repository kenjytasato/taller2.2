import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio2 {

    public static void main(String[] args){

        WebDriver driver = null;
        WebDriverManager.chromedriver().version("87.0.4280.88").setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/-/es/");
        driver.manage().window().maximize();

        try{
            Thread.sleep(
                    3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        String localizador1 = "//*[@id=\"twotabsearchtextbox\"]";
        WebElement busqueda = null;

        busqueda = driver.findElement(By.xpath(localizador1));
        busqueda.sendKeys("zapatillas");

        busqueda.sendKeys(Keys.ENTER);

        try{
            Thread.sleep(
                    3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //Primer Resultado

        String localizadorResultado1 ="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/h2/a/span";
        WebElement resulZapatilla1 = null;

        resulZapatilla1 = driver.findElement(By.xpath(localizadorResultado1));

        resulZapatilla1.isDisplayed();

        String localizarprecio1 ="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[4]/div/div/div/a/span/span[2]/span[2]";
        WebElement precio1 = null;
        precio1 = driver.findElement(By.xpath(localizarprecio1));
        precio1.isDisplayed();
        int precioResultado1= Integer.parseInt(precio1.getText());

        try{
            Thread.sleep(
                    3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Descripción: "+ resulZapatilla1.getText() + "  Precio: " + precio1.getText());

        //Segundo resultado
        String localizadorResultado2 ="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/h2/a/span";
        WebElement resulZapatilla2 = null;
        resulZapatilla2 = driver.findElement(By.xpath(localizadorResultado2));

        String localizadorprecio2 = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div[4]/div/div/div/a/span[1]/span[2]/span[2]";
        WebElement precio2 = null;
        precio2 = driver.findElement(By.xpath(localizadorprecio2));
        int precioResultado2= Integer.parseInt(precio2.getText());

        //Comparando
        if(precioResultado1<=precioResultado2){
            System.out.println("La mejor opción de compra es "+resulZapatilla1.getText()+",cuesta "+precio1.getText());

        }else{
            System.out.println("La mejor opción de compra es "+resulZapatilla2.getText()+",cuesta "+precio2.getText());
        }



        driver.close();
    }
}
