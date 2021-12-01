import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DetalTest {
    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testIdNegativeDataProvider")
    public void testIdNegative(int id, float  Price, int idProizvoditel, String Name, int Articul){
        Detal obj = new Detal.Builder().setId(id).setPrice( Price).setidProizvoditel(idProizvoditel).setArticul(Articul).setName(Name).build();
    }

    @DataProvider
    public Object[][] testIdNegativeDataProvider(){
        return new Object[][] {{1,7580,5,24,"Porshen"}};
    }

    @Test(dataProvider = "testIdPositiveDataProvider")
    public void testIdPositive(int id, float  Price, int idProizvoditel, String Name, int Articul){
        Detal obj = new Detal.Builder().setId(id).setPrice( Price).setidProizvoditel(idProizvoditel).setArticul(Articul).setName(Name).build();

    }

    @DataProvider
    public Object[][] testIdPositiveDataProvider(){
        return new Object[][] {{1,5480,5,24,"Porshen"}};
    }


    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testArticulNegativeDataProvider")
    public void testArticulNegative(int  id, int Articul, int idProizvoditel){
        Detal obj = new Detal.Builder().setId( id).setArticul(Articul).setidProizvoditel(idProizvoditel).build();
        assertEquals(obj.getArticul(),Articul);
    }

    @DataProvider
    public Object[][] testArticulNegativeDataProvider(){
        return new Object[][] {{895,0,7852}};
    }

    @Test(dataProvider = "testArticulPositiveDataProvider")
    public void testArticulPositive(int  id, int Articul, int idProizvoditel){
        Detal obj = new Detal.Builder().setId( id).setArticul(Articul).setidProizvoditel(idProizvoditel).build();
        assertEquals(obj.getArticul(),Articul);
    }

    @DataProvider
    public Object[][] testArticulPositiveDataProvider(){
        return new Object[][] {{1,5,25}};
    }


    @Test(dataProvider = "testNamePositiveDataProvider")
    public void testNamePositive(String Name,int  id, int idProizvoditel, int Articul, float Price){
        Detal obj = new Detal.Builder().setName(Name).setId( id).setidProizvoditel(idProizvoditel).setArticul(Articul).setPrice(Price).build();
        assertEquals(obj.getName(),Name);
    }

    @DataProvider
    public Object[][] testNamePositiveDataProvider(){
        return new Object[][] {{"Porshen",1,25,5,8250}};
    }


    @Test(dataProvider = "testPricePositiveDataProvider")
    public void testPricePositive(float Price, int id, int Articul){
        Detal obj = new Detal.Builder().setPrice( Price).setId(id).setArticul(Articul).build();
        assertEquals(obj.getPrice(), Price);
    }

    @DataProvider
    public Object[][] testPricePositiveDataProvider(){
        return new Object[][] {{8250,1,25}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class,dataProvider = "testPriceNegativeDataProvider")
    public void testPriceNegative(float Price, int id, int Articul){
        Detal obj = new Detal.Builder().setPrice( Price).setId(id).setArticul(Articul).build();
        assertEquals(obj.getPrice(), Price);
    }

    @DataProvider
    public Object[][] testPriceNegativeDataProvider(){
        return new Object[][] {{299,1,25}};
    }
}
