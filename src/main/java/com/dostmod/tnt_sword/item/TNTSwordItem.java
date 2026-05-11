package com.dostmod.tnt_sword;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class TNTSwordItem extends SwordItem {
    public TNTSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide) {
            BlockPos blockpos = pPlayer.blockPosition();
            PrimedTnt primedtnt = new PrimedTnt(pLevel, blockpos.getX() + 0.5D, blockpos.getY() + 1.0D, blockpos.getZ() + 0.5D, pPlayer);
            pLevel.addFreshEntity(primedtnt);
            itemstack.hurtAndBreak(1, pPlayer, (p_43130_) -> p_43130_.broadcastBreakEvent(pHand));
        }
        pPlayer.getCooldowns().addCooldown(this, 20);
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (!pTarget.level().isClientSide) {
            BlockPos blockpos = pTarget.blockPosition();
            PrimedTnt primedtnt = new PrimedTnt(pTarget.level(), blockpos.getX() + 0.5D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.5D, pAttacker);
            pTarget.level().addFreshEntity(primedtnt);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
