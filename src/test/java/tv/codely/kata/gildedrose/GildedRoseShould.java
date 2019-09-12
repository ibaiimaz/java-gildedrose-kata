package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseShould {
    private Item[] arrayWith(Item item) {
        return new Item[]{item};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = new Item("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(9, whateverItem.sellIn);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = new Item("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(9, whateverItem.quality);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = new Item("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(8, whateverItem.quality);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = new Item("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(0, whateverItem.quality);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = new Item("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(2, agedBrie.quality);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose(arrayWith(sulfuras));
        gildedRose.updateQuality();

        assertEquals(25, sulfuras.quality);
        assertEquals(0, sulfuras.sellIn);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(21, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(22, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(23, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(0, backstagePasses.quality);
    }
}
