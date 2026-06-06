package com.chromatic.chromaticadditions.common.item;

import com.chromatic.chromaticadditions.common.data.tools.ChromaticToolMaterials;

import com.gregtechceu.gtceu.api.item.ComponentItem;

import net.minecraft.world.item.*;

import com.tterrag.registrate.util.entry.ItemEntry;

import static com.chromatic.chromaticadditions.ChromaticAdditions.HERRJOLO_REGISTRATE;

public class ChromaticItems {

    public static void init() {}

    public static ItemEntry<ComponentItem> DRILL_HEAD = HERRJOLO_REGISTRATE.item("drill_head", ComponentItem::create)
            .lang("Drill Head")
            .properties(p -> p.stacksTo(4))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/drill")))
            .register();

    public static ItemEntry<ComponentItem> MV_MINING_CIRCUITE1 = HERRJOLO_REGISTRATE
            .item("mv_mining_circuite_1", ComponentItem::create)
            .lang("MV Mining Circuite")
            .properties(p -> p.stacksTo(1))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/mv_mining_circuits_1")))
            .register();

    public static ItemEntry<ComponentItem> HV_MINING_CIRCUITE1 = HERRJOLO_REGISTRATE
            .item("hv_mining_circuite_1", ComponentItem::create)
            .lang("HV Mining Circuite")
            .properties(p -> p.stacksTo(1))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/hv_mining_circuits_1")))
            .register();

    public static ItemEntry<ComponentItem> EV_MINING_CIRCUITE1 = HERRJOLO_REGISTRATE
            .item("ev_mining_circuite_1", ComponentItem::create)
            .lang("EV Mining Circuite")
            .properties(p -> p.stacksTo(1))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/ev_mining_circuits_1")))
            .register();

    public static ItemEntry<ComponentItem> IV_MINING_CIRCUITE1 = HERRJOLO_REGISTRATE
            .item("iv_mining_circuite_1", ComponentItem::create)
            .lang("IV Mining Circuite")
            .properties(p -> p.stacksTo(1))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/iv_mining_circuits_1")))
            .register();

    public static ItemEntry<ComponentItem> LUV_MINING_CIRCUITE1 = HERRJOLO_REGISTRATE
            .item("luv_mining_circuite_1", ComponentItem::create)
            .lang("LuV Mining Circuite")
            .properties(p -> p.stacksTo(1))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/luv_mining_circuits_1")))
            .register();

    public static ItemEntry<ComponentItem> ZPM_MINING_CIRCUITE1 = HERRJOLO_REGISTRATE
            .item("zpm_mining_circuite_1", ComponentItem::create)
            .lang("ZPM Mining Circuite")
            .properties(p -> p.stacksTo(1))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/zpm_mining_circuits_1")))
            .register();

    public static ItemEntry<ComponentItem> UV_MINING_CIRCUITE1 = HERRJOLO_REGISTRATE
            .item("uv_mining_circuite_1", ComponentItem::create)
            .lang("UV Mining Circuite")
            .properties(p -> p.stacksTo(1))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/uv_mining_circuits_1")))
            .register();

    public static ItemEntry<ComponentItem> IRON_BRICK_MOLD = HERRJOLO_REGISTRATE
            .item("iron_brick_mold", ComponentItem::create)
            .lang("Iron Brick Mold")
            .properties(p -> p.stacksTo(8))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/iron_brick_mold")))
            .register();

    public static ItemEntry<ComponentItem> IRON_BLOCK_MOLD = HERRJOLO_REGISTRATE
            .item("iron_block_mold", ComponentItem::create)
            .lang("Iron Block Mold")
            .properties(p -> p.stacksTo(8))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/iron_block_mold")))
            .register();
}
