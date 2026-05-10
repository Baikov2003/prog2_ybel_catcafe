package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

    @Test
    void addCat_shouldIncreaseCatCount() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Mimi", 5);

        // when
        cafe.addCat(cat);

        // then
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void addMultipleCats_shouldIncreaseCountCorrectly() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Mimi", 5));
        cafe.addCat(new FelineOverLord("Balu", 7));

        // then
        assertEquals(2, cafe.getCatCount());
    }

    @Test
    void getCatCount_emptyCafe_shouldBeZero() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        long count = cafe.getCatCount();

        // then
        assertEquals(0, count);
    }

    @Test
    void getCatByName_shouldReturnCorrectCat() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Mimi", 5);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByName("Mimi");

        // then
        assertEquals(cat, result);
    }

    @Test
    void getCatByName_unknownName_shouldReturnNull() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        FelineOverLord result = cafe.getCatByName("Ghost");

        // then
        assertNull(result);
    }

    @Test
    void getCatByName_null_shouldReturnNull() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        FelineOverLord result = cafe.getCatByName(null);

        // then
        assertNull(result);
    }

    @Test
    void getCatByWeight_shouldReturnCatInRange() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Mimi", 5);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByWeight(4, 6);

        // then
        assertEquals(cat, result);
    }

    @Test
    void getCatByWeight_outOfRange_shouldReturnNull() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Mimi", 5));

        // when
        FelineOverLord result = cafe.getCatByWeight(6, 10);

        // then
        assertNull(result);
    }

    @Test
    void getCatByWeight_invalidRange_shouldReturnNull() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        FelineOverLord result = cafe.getCatByWeight(10, 5);

        // then
        assertNull(result);
    }

    @Test
    void addCat_null_shouldThrowException() {
        // given
        CatCafe cafe = new CatCafe();

        // when + then
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }
}
