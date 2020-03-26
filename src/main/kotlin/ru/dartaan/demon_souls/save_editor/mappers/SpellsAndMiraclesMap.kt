package ru.dartaan.demon_souls.save_editor.mappers

import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.CURSE_WEAPON
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.DEMONS_PRANK
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.ENCHANT_WEAPON
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.FIREBALL
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.FLAME_TOSS
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.INVOKE_MAGIC_SQ
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.KNOWN
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.MEMORIZED
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.POISON_CLOUD
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.RELIEF
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SOUL_ARROW
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SOUL_THIRST
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.TEST
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.TEST_CURE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.TEST_ENCHANTWEAPON
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.TEST_FIREBOLT
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.TEST_SOS_SIGN
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.UNAVAILABLE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.UNKNOWN
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.IGNITE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SOUL_RAY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.HOMING_SOUL_ARROW
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.CLOAK
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.PROTECTION
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.LIGHT_WEAPON
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.WATER_VEIL
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.DEATH_CLOUD
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.FIRE_SPRAY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SOULSUCKER
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.ACID_CLOUD
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.WARDING
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.FIRESTORM
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.GODS_WRATH
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.ANTIMAGIC_FIELD
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.RECOVERY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SECOND_CHANCE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.REGENERATION
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.RESURRECTION
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.CURE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.HIDDEN_SOUL
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.EVACUATE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.BANISH
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.HEAL
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.ANTIDOTE

object SpellsAndMiraclesMap {

    val name = mapOf(
        0    to TEST,
        1    to TEST_FIREBOLT,
        2    to TEST_ENCHANTWEAPON,
        3    to TEST_CURE,
        4    to TEST_SOS_SIGN,
        100  to INVOKE_MAGIC_SQ,
        1000 to SOUL_ARROW,
        1001 to FLAME_TOSS,
        1002 to RELIEF,
        1003 to ENCHANT_WEAPON,
        1004 to CURSE_WEAPON,
        1005 to SOUL_THIRST,
        1006 to POISON_CLOUD,
        1007 to DEMONS_PRANK,
        1008 to FIREBALL,
        1009 to IGNITE,
        1010 to SOUL_RAY,
        1011 to HOMING_SOUL_ARROW,
        1012 to CLOAK,
        1013 to PROTECTION,
        1014 to LIGHT_WEAPON,
        1015 to WATER_VEIL,
        1016 to DEATH_CLOUD,
        1017 to FIRE_SPRAY,
        1018 to SOULSUCKER,
        1019 to ACID_CLOUD,
        1020 to WARDING,
        1021 to FIRESTORM,
        2000 to GODS_WRATH,
        2001 to ANTIMAGIC_FIELD,
        2002 to RECOVERY,
        2003 to SECOND_CHANCE,
        2004 to REGENERATION,
        2005 to RESURRECTION,
        2006 to CURE,
        2007 to HIDDEN_SOUL,
        2008 to EVACUATE,
        2009 to BANISH,
        2010 to HEAL,
        2011 to ANTIDOTE
    )

    val status = mapOf(
        0 to UNAVAILABLE,
        1 to UNKNOWN,
        2 to KNOWN,
        3 to MEMORIZED
    )
}