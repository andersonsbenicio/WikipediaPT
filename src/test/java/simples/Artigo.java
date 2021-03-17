package simples;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Artigo {

    String url; // endereço do site alvo
    WebDriver driver; // Objeto do Selenium Web Driver

    @Before
    public void iniciar(){

        url = "https://pt.wikipedia.org/";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/88/chromedriver.exe"); //Onde está o chromedriver
        driver = new ChromeDriver(); // Instanciar o Selenium como Chrome Driver
        driver.manage().window().maximize(); //Maximizar a janela do navegador
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS); // Define uma espera implicita de 1 min, verificando a cada milisegundo

    }

    @Test
    public void consultarArquivo(){

        driver.get(url); // Abrir o Site
        driver.findElement(By.id("searchInput")).sendKeys("Ovo de Páscoa"); // Pesquisar por Ovos de Pascoa
        driver.findElement(By.cssSelector("button.wvui-button")).click(); // Clica na Lupa
        //assertEquals("Ovo de Páscoa – Wikipédia, a enciclopédia livre", driver.getTitle()); // Validar o Titulo da Pagina
        assertTrue(driver.getTitle().contains("Ovo de Páscoa"));
    }

    @After
    public void finalizar(){

        driver.quit();

    }

}
