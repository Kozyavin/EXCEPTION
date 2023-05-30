import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product item1 = new Product(1, "Хлеб", 30);
    Product item2 = new Product(2, "Батон", 50);
    Product item3 = new Product(3, "Колбаса", 250);
    Product item4 = new Product(4, "Баранки", 150);
    Product item5 = new Product(2, "Батон", 50);

    @Test
    public void RemoveProductTest() {

        ShopRepository repo = new ShopRepository();//проверка успешности удаления существующего элемента (4)

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        repo.remove(2);

        Product[] expected = {item1, item3, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void NegativeRemoveProductTest() { //генерации NotFoundException при попытке удаления несуществующего элемента.

        ShopRepository repo = new ShopRepository();

        repo.add(item4);
        repo.add(item3);
        repo.add(item2);
        repo.add(item1);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(10);
        });
    }
}


