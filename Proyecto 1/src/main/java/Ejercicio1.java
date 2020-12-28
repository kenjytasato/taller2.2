import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio1 {

    public static void main(String[] args){
        /*##Ejercicio 1:
                *Ir a amazon.com
                *Buscar zapatillas
                *Seleccionar el primer resultado y entrar
                *Imprimir por consola la descripción
                *Imprimir por consola el precio
                *Verificar si el ahorro es en porcentaje, correcto*/

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

        String localizadorResultado ="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/h2/a/span";
        WebElement resulZapatilla = null;

        resulZapatilla = driver.findElement(By.xpath(localizadorResultado));

        resulZapatilla.isDisplayed();
        resulZapatilla.click();

        try{
            Thread.sleep(
                    3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        String localizarprecio ="//*[@id=\"priceblock_ourprice\"]";
        String localizardescripcion ="//*[@id=\"productTitle\"]";
        WebElement precio = null;
        WebElement descripcion = null;

        precio = driver.findElement(By.xpath(localizarprecio));
        descripcion = driver.findElement(By.xpath(localizardescripcion));

        descripcion.isDisplayed();
        precio.isDisplayed();

        try{
            Thread.sleep(
                    3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Descripción: "+descripcion.getText() + "Precio: " + precio.getText());




        driver.close();
    }
}
