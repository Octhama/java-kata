package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                BackstagePass(item);
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                PastSellin(item);
            }

            if(!item.name.equals("Conjured Mana Cake")){
                increaseQuality(item);
            }
        }
    }

    private void PastSellin(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (item.quality > 0) {
                    item.quality = item.quality + 1;
                }
        } else {
            item.sellIn = 0;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                BackstagePass(item);
            }
        }
    }

    private void BackstagePass(Item backstagePass) {
        if (backstagePass.sellIn < 11) {
            if (backstagePass.quality < 50) {
                backstagePass.quality = backstagePass.quality + 1;
            }
        }

        if (backstagePass.sellIn < 6) {
            if (backstagePass.quality < 50) {
                backstagePass.quality = backstagePass.quality + 1;
            }
        }
    }
}