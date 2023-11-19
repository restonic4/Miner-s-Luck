package me.restonic4.minersluck;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Random;

public class Miner_sLuck
{
	public static final String MOD_ID = "minersluck";

	public static final Item[] overworldLoot = {Items.IRON_NUGGET, Items.GOLD_NUGGET, Items.RAW_COPPER, Items.AMETHYST_SHARD, Items.COAL, Items.DIAMOND};
	public static final Item[] netherLoot = {Items.GOLD_NUGGET, Items.QUARTZ, Items.NETHERITE_SCRAP};

	private static boolean randomChance(int percentage) {
		Random random = new Random();
		int randomNum = random.nextInt(100) + 1;

		return randomNum <= percentage;
	}

	public static ItemEntity spawnAtLocation(ItemStack itemStack, float f, Level level, double x, double y, double z) {
		if (itemStack.isEmpty()) {
			return null;
		} else if (level.isClientSide) {
			return null;
		} else {
			ItemEntity itemEntity = new ItemEntity(level, x, y + (double)f, z, itemStack);
			itemEntity.setDefaultPickUpDelay();
			level.addFreshEntity(itemEntity);
			return itemEntity;
		}
	}

	public static Item getRandomDrop(Item[] lootTable) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(lootTable.length);

		return lootTable[randomIndex];
	}

	public static void init() {
		BlockEvent.BREAK.register(
				(level, blockPos, blockState, serverPlayer, n) -> {
					Block block = blockState.getBlock();

					boolean canDrop = randomChance(50);

					if (canDrop) {
						boolean isStone = (block == Blocks.STONE || block == Blocks.DEEPSLATE || block == Blocks.ANDESITE || block == Blocks.DIORITE || block == Blocks.GRANITE || block == Blocks.TUFF);
						boolean isNether = (block == Blocks.NETHERRACK || block == Blocks.BASALT || block == Blocks.BLACKSTONE);

						if (isStone) {
							spawnAtLocation(new ItemStack(getRandomDrop(overworldLoot)), 0, level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
						} else if (isNether) {
							spawnAtLocation(new ItemStack(getRandomDrop(netherLoot)), 0, level, blockPos.getX(), blockPos.getY(), blockPos.getZ());
						}
					}

					return EventResult.pass();
				}
		);
	}
}
