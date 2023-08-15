package net.pererillo.coalings.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.pererillo.coalings.EntityInit;

public class Coaling extends Monster {

    public Coaling(EntityType<Coaling> type, Level level) {
        super(type, level);
    }

    public Coaling(Level level, double x, double y, double z) {
        this(EntityInit.COALING.get(), level);
        setPos(x,y,z);
    }
    public Coaling(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new FloatGoal(this));
        this.goalSelector.addGoal(2,new LeapAtTargetGoal(this, 0.5f));
        this.goalSelector.addGoal(3,new MeleeAttackGoal(this, 1.2D,true));
        this.goalSelector.addGoal(4,new LookAtPlayerGoal(this, Player.class,6.0f));
        this.goalSelector.addGoal(5,new WaterAvoidingRandomStrollGoal(this,1.0D));
        this.goalSelector.addGoal(6,new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1,new HurtByTargetGoal(this).setAlertOthers());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.2f).add(Attributes.ATTACK_DAMAGE, 1.0f).add(Attributes.ATTACK_SPEED,1.0f).add(Attributes.ATTACK_KNOCKBACK,0.3D).add(Attributes.FOLLOW_RANGE,16).add(Attributes.KNOCKBACK_RESISTANCE,0.6);
    }
    public static boolean canSpawn(EntityType<Coaling> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource  random) {
        return Monster.checkMonsterSpawnRules(entityType, level, spawnType, position, random) && position.getY() < 25;
    }
}
