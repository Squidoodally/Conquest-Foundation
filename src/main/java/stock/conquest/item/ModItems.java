package stock.conquest.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import stock.conquest.Conquest;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public class ModItems {
    public static final Item COPPER_ORE = registerItem("copper_ore", new Item(new Item.Settings()));
    public static final Item COPPER = registerItem("copper", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Conquest.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Conquest.LOGGER.info("Registering Mod Items for " + Conquest.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(COPPER_ORE);
            entries.add(COPPER);
        });
    }
}
