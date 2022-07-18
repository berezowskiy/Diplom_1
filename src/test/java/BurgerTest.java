import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;
import praktikum.Bun;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    Burger burger = new Burger();

    @Test
    public void shouldReturnBurgerPrice() {
        float expectedBurgerPrice = 300f;
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient1.getPrice()).thenReturn(100f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(expectedBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void shouldReturnBurgerReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("dinosaur");

        String expectedReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
