package tv.codely.kata.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static final int ALLOWED_MIN_QUALITY = 0;
    public static final int ALLOWED_MAX_QUALITY = 50;

    public static final int REGULAR_ITEM_QUALITY_DECREASE_DOUBLE_SELL_IN_LIMIT = 0;

    public static final int BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_LIMIT = 0;
    public static final int BACKSTAGE_PASSES_DOUBLE_QUALITY_SELL_IN_LIMIT = 10;
    public static final int BACKSTAGE_PASSES_TRIPLE_QUALITY_SELL_IN_LIMIT = 5;

    public static final int NO_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (isRegularItem(item)
            ) {
                item.sellIn = item.sellIn - 1;

                if (item.quality > ALLOWED_MIN_QUALITY) {
                    item.quality = item.quality - 1;
                }

                if (item.sellIn < REGULAR_ITEM_QUALITY_DECREASE_DOUBLE_SELL_IN_LIMIT) {
                    if (item.quality > ALLOWED_MIN_QUALITY) {
                        item.quality = item.quality - 1;
                    }
                }
            }

            if (item.name.equals(AGED_BRIE)) {
                item.sellIn = item.sellIn - 1;

                if (item.quality < ALLOWED_MAX_QUALITY) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.name.equals(BACKSTAGE_PASSES)) {
                item.sellIn = item.sellIn - 1;

                if (item.quality < ALLOWED_MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < BACKSTAGE_PASSES_DOUBLE_QUALITY_SELL_IN_LIMIT) {
                        if (item.quality < ALLOWED_MAX_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < BACKSTAGE_PASSES_TRIPLE_QUALITY_SELL_IN_LIMIT) {
                        if (item.quality < ALLOWED_MAX_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }
                }


                if (item.sellIn < BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_LIMIT) {
                    item.quality = NO_QUALITY;
                }
            }
        }
    }

    private boolean isRegularItem(Item item) {
        return !item.name.equals(AGED_BRIE) &&
            !item.name.equals(BACKSTAGE_PASSES) &&
            !item.name.equals(SULFURAS);
    }
}
