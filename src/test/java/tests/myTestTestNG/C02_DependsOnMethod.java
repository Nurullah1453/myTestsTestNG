package tests.myTestTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethod {

    @Test
    public void ilkTest(){

        System.out.println("Birinci test calıstı");

    }

    @Test (dependsOnMethods = "ilkTest")
    public void ikinciTest(){

        System.out.println("Ikinci test calıstı");


    }

    @Test (dependsOnMethods = "ikinciTest")
    public void ucuncuTest(){

        System.out.println("Ucuncu test calıstı");


    }
}
