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

            switch (item.name) {
                case AGED_BRIE:
                    decreaseSellIn(item);
                    updateAgedBrieQuality(item);
                    break;
                case BACKSTAGE_PASSES:
                    decreaseSellIn(item);
                    updateBackstagePassesQuality(item);
                    break;
                case SULFURAS:
                    break;
                default:
                    decreaseSellIn(item);
                    updateRegularItemQuality(item);
                    break;
            }
        }
    }

    private void updateBackstagePassesQuality(Item item) {
        if (item.quality < ALLOWED_MAX_QUALITY) {
            item.quality++;

            if (item.sellIn < BACKSTAGE_PASSES_DOUBLE_QUALITY_SELL_IN_LIMIT) {
                incrementQualityIfMaxNotReached(item);
            }

            if (item.sellIn < BACKSTAGE_PASSES_TRIPLE_QUALITY_SELL_IN_LIMIT) {
                incrementQualityIfMaxNotReached(item);
            }
        }

        if (item.sellIn < BACKSTAGE_PASSES_QUALITY_RESET_SELL_IN_LIMIT) {
            item.quality = NO_QUALITY;
        }
    }


    private void updateAgedBrieQuality(Item item) {
        incrementQualityIfMaxNotReached(item);
    }

    private void updateRegularItemQuality(Item item) {
        decreamentQualityIfMinNotReached(item);

        if (item.sellIn < REGULAR_ITEM_QUALITY_DECREASE_DOUBLE_SELL_IN_LIMIT) {
            decreamentQualityIfMinNotReached(item);
        }
    }

    private void incrementQualityIfMaxNotReached(Item item) {
        if (item.quality < ALLOWED_MAX_QUALITY) {
            item.quality++;
        }
    }

    private void decreamentQualityIfMinNotReached(Item item) {
        if (item.quality > ALLOWED_MIN_QUALITY) {
            item.quality--;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
