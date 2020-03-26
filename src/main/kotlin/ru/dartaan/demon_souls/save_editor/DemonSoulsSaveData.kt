package ru.dartaan.demon_souls.save_editor

import ru.dartaan.demon_souls.save_editor.constants.Constants.BYTE_TYPE
import ru.dartaan.demon_souls.save_editor.constants.Constants.FLOAT_TYPE
import ru.dartaan.demon_souls.save_editor.constants.Constants.INTEGER_TYPE
import ru.dartaan.demon_souls.save_editor.constants.Constants.LONG
import ru.dartaan.demon_souls.save_editor.constants.Constants.STRING_TYPE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.GameInfoObject.BLOCK_INDEX
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.GameInfoObject.WORLD_INDEX
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CHARACTER_NAME
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CURRENT_HP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CURRENT_MP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CURRENT_SOULS
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CURRENT_STAMINA
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CUR_MAX_HP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CUR_MAX_MP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.CUR_MAX_STAMINA
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.DEXTERITY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.ENDURANCE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.FAITH
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.GENDER
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.HAIRSTYLE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.HAIR_COLOR_B
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.HAIR_COLOR_G
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.HAIR_COLOR_R
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.INTELLIGENCE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.LEVELS_PURCHASED
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.LUCK
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAGIC
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAXIMUM_HP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAXIMUM_MP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAXIMUM_STAMINA
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.SOUL_MEMORY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.STARTING_CLASS
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.STRENGTH
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.VITALITY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.MIRACLE_SLOTS
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SPELL_COUNT
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SPELL_SLOTS
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.CHARACTER_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.NEXUS_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_1_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_2_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_3_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_4_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_5_TENDENCY
import ru.dartaan.demon_souls.save_editor.PythonFunctions.pack
import ru.dartaan.demon_souls.save_editor.PythonFunctions.unpack
import ru.dartaan.demon_souls.save_editor.constants.Constants.SPELL_START_INDEX
import ru.dartaan.demon_souls.save_editor.mappers.SpellsAndMiraclesMap
import java.io.File
import java.lang.Float.parseFloat
import java.lang.Integer.parseInt
import kotlin.collections.Map.Entry

class DemonSoulsSaveData(file: File) {

    constructor(s: String) : this(File(s))

    private val sourceFile = file
    val saveData = sourceFile.readBytes()

    // Don't sure what is it. May be NG level
    val gameInfo = mapOf(
        WORLD_INDEX to DataField(4, 1, BYTE_TYPE, 0),
        BLOCK_INDEX to DataField(5, 1, BYTE_TYPE, 0)
    )

    val tendencies = mapOf(
        CHARACTER_TENDENCY to DataField(125936, 4, FLOAT_TYPE, 125940),
        NEXUS_TENDENCY to DataField(125944, 4, FLOAT_TYPE, 125948),
        WORLD_1_TENDENCY to DataField(125952, 4, FLOAT_TYPE, 125956),
        WORLD_2_TENDENCY to DataField(125984, 4, FLOAT_TYPE, 125988),
        WORLD_3_TENDENCY to DataField(125968, 4, FLOAT_TYPE, 125972),
        WORLD_4_TENDENCY to DataField(125960, 4, FLOAT_TYPE, 125964),
        WORLD_5_TENDENCY to DataField(125976, 4, FLOAT_TYPE, 125980)
    )

    val playerStatus = mapOf(
        CURRENT_HP to DataField(80, 4, INTEGER_TYPE, 0),
        CUR_MAX_HP to DataField(84, 4, INTEGER_TYPE, 0),
        MAXIMUM_HP to DataField(88, 4, INTEGER_TYPE, 0),

        CURRENT_MP to DataField(92, 4, INTEGER_TYPE, 0),
        CUR_MAX_MP to DataField(96, 4, INTEGER_TYPE, 0),
        MAXIMUM_MP to DataField(100, 4, INTEGER_TYPE, 0),

        CURRENT_STAMINA to DataField(108, 4, INTEGER_TYPE, 0),
        CUR_MAX_STAMINA to DataField(112, 4, INTEGER_TYPE, 0),
        MAXIMUM_STAMINA to DataField(116, 4, INTEGER_TYPE, 0),

        VITALITY to DataField(124, 4, INTEGER_TYPE, 128),
        INTELLIGENCE to DataField(132, 4, INTEGER_TYPE, 136),
        ENDURANCE to DataField(140, 4, INTEGER_TYPE, 140),
        STRENGTH to DataField(148, 4, INTEGER_TYPE, 152),
        DEXTERITY to DataField(156, 4, INTEGER_TYPE, 160),
        MAGIC to DataField(164, 4, INTEGER_TYPE, 168),
        FAITH to DataField(172, 4, INTEGER_TYPE, 176),
        LUCK to DataField(180, 4, INTEGER_TYPE, 184),

        CURRENT_SOULS to DataField(188, 4, INTEGER_TYPE, 0),
        SOUL_MEMORY to DataField(200, 4, INTEGER_TYPE, 0),
        LEVELS_PURCHASED to DataField(204, 4, INTEGER_TYPE, 0),

        CHARACTER_NAME to DataField(212, 32, STRING_TYPE, 0),
        GENDER to DataField(246, 1, BYTE_TYPE, 0),
        STARTING_CLASS to DataField(251, 1, BYTE_TYPE, 0),
        HAIRSTYLE to DataField(692, 4, INTEGER_TYPE, 0),
        HAIR_COLOR_R to DataField(82792, 4, FLOAT_TYPE, 0),
        HAIR_COLOR_G to DataField(82796, 4, FLOAT_TYPE, 0),
        HAIR_COLOR_B to DataField(82800, 4, FLOAT_TYPE, 0)
    )

    val spellsAndMiraclesInfo = mapOf(
        SPELL_SLOTS to DataField(66272, 4, LONG, 0),
        MIRACLE_SLOTS to DataField(66316, 4, LONG, 0),
        SPELL_COUNT to DataField(82920, 4, LONG, 0)
    )

    val spellsAndMiraclesList = fillSpellsAndMiracles()
    private fun fillSpellsAndMiracles(): Map<String, DataField> {
        val map = mutableMapOf<String, DataField>()
        for (i in 0 until spellsAndMiraclesInfo[SPELL_COUNT]?.value as Int) {
            val statusPos = SPELL_START_INDEX + (16 * i)
            val idPos = SPELL_START_INDEX + 4 + (16 * i)

            val id = unpack(LONG, getBytesFromSaveData(idPos, 4)).dropLast(1)
            val name = SpellsAndMiraclesMap.name[id.toInt()] ?: "Unknown spell $id"
            map[name] = DataField(statusPos, 4, LONG, 0)
        }
        return map.toMap()
    }

    fun getBytesFromSaveData(pos: Int, size: Int) =
        saveData.copyOfRange(pos, pos + size).map { it.toUByte().toInt() }.toIntArray()

    fun printCurrentSaveInfo() {
        fun printSaveField(e: Entry<String, DataField>) = println("${e.key} - ${e.value.value}")
        fun printSpellField(e: Entry<String, DataField>) =
            println("${e.key} - ${SpellsAndMiraclesMap.status[e.value.value]}")

        println("\n\n${sourceFile.name}")
        println("\nGameInfo")
        gameInfo.forEach(::printSaveField)
        println("\nTendencies")
        tendencies.forEach(::printSaveField)
        println("\nPlayer Status")
        playerStatus.forEach(::printSaveField)
        println("\nSpells And Miracles Info")
        spellsAndMiraclesInfo.forEach(::printSaveField)
        println("\nSpells And Miracles List")
        spellsAndMiraclesList.forEach(::printSpellField)
    }

    fun saveModified(targetPath: String) {
        val file = File("${targetPath}/${sourceFile.nameWithoutExtension} mod.${sourceFile.extension}")
        file.createNewFile()
        file.writeBytes(saveData)
        println("${file.absolutePath} created")
    }

    inner class DataField(
        private val pos: Int,
        private val size: Int,
        private val fmt: String,
        private val copyValuePos: Int
    ) {
        private var _value: IntArray
        var value: Any
            get() = when (fmt) {
                INTEGER_TYPE -> parseInt(unpack(fmt, _value))
                LONG -> parseInt(unpack(fmt, _value).dropLast(1))
                FLOAT_TYPE -> parseFloat(unpack(fmt, _value))
                BYTE_TYPE -> _value[0]
                STRING_TYPE -> String(_value, 0, 32)
                else -> 0
            }
            set(value) {
                if (pos in (SPELL_START_INDEX + 1)..84968)
                    setSpellStatus(value)
                else
                    setStandardValue(value)
            }

        init {
            _value = getBytesFromSaveData(pos, size)
        }

        private fun setStandardValue(value: Any) {
            if (fmt.contains(STRING_TYPE))
                TODO() // TODO: I forget what I want here
            _value = pack(fmt, value as Number).map { it.toInt() }.toIntArray()
            for (i in 0 until 0 + size) {
                saveData[pos + i] = _value[i].toByte()
                if (copyValuePos != 0)
                    saveData[copyValuePos + i] = _value[i].toByte()
            }
        }

        private fun setSpellStatus(status: Any) {
            val intStatus = if (status is String)
                SpellsAndMiraclesMap.status.entries.find { it.value == status }!!.key
            else
                status as Number
            setStandardValue(intStatus)
        }
    }


}