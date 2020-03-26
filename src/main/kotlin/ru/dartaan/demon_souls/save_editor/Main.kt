package ru.dartaan.demon_souls.save_editor

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
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.INTELLIGENCE
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.LUCK
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAGIC
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAXIMUM_HP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAXIMUM_MP
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.MAXIMUM_STAMINA
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.STRENGTH
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.PlayerStatus.VITALITY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.MEMORIZED
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.SpellsAndMiracles.SPELL_SLOTS
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.CHARACTER_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.NEXUS_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_1_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_2_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_3_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_4_TENDENCY
import ru.dartaan.demon_souls.save_editor.constants.DataFieldConstants.Tendencies.WORLD_5_TENDENCY
import java.io.File

object Main {

    const val pathToSourceSaveData =
        "D:\\Games\\rpcs3-v0.0.8-9724-df1813b4_win64\\dev_hdd0\\home\\00000001\\savedata\\BLES00932DEMONSS005"
    const val pathToTargetSaveData = "D:\\temp\\BLES00932DEMONSS005"

    @JvmStatic
    fun main(args: Array<String>) {
        val files = File(pathToSourceSaveData).listFiles()!!.filter { it.name.contains(".DAT") }
        val saveDatas = files.map { DemonSoulsSaveData(it) }
        // only by one symbol now
        val uniqueCharInPlayerName = "M"
        val mySaves = saveDatas.filter { (it.playerStatus[CHARACTER_NAME]?.value as String).contains(uniqueCharInPlayerName) }
        mySaves.forEach { it.printCurrentSaveInfo() }

        for (save in mySaves) {
            save.printCurrentSaveInfo()
//            setTendency(save)
//            setStatus(save)
//            setSpells(save)
            save.saveModified(pathToTargetSaveData)
        }

    }

    private fun setTendency(saveData: DemonSoulsSaveData) {
        val pureBlack = -200
        val black = -100
        val neutral = 0
        val white = 100
        val pureWhite = 200
        saveData.tendencies[CHARACTER_TENDENCY]?.value = pureWhite
        saveData.tendencies[NEXUS_TENDENCY]?.value = pureWhite
        saveData.tendencies[WORLD_1_TENDENCY]?.value = pureWhite
        saveData.tendencies[WORLD_2_TENDENCY]?.value = pureWhite
        saveData.tendencies[WORLD_3_TENDENCY]?.value = pureWhite
        saveData.tendencies[WORLD_4_TENDENCY]?.value = pureWhite
        saveData.tendencies[WORLD_5_TENDENCY]?.value = pureWhite
    }

    private fun setStatus(saveData: DemonSoulsSaveData) {
        saveData.playerStatus[CURRENT_HP]?.value = 1000
        saveData.playerStatus[CUR_MAX_HP]?.value = 1000
        saveData.playerStatus[MAXIMUM_HP]?.value = 1000

        saveData.playerStatus[CURRENT_MP]?.value = 1000
        saveData.playerStatus[CUR_MAX_MP]?.value = 1000
        saveData.playerStatus[MAXIMUM_MP]?.value = 1000

        saveData.playerStatus[CURRENT_STAMINA]?.value = 1000
        saveData.playerStatus[CUR_MAX_STAMINA]?.value = 1000
        saveData.playerStatus[MAXIMUM_STAMINA]?.value = 1000

        saveData.playerStatus[VITALITY]?.value = 100
        saveData.playerStatus[INTELLIGENCE]?.value = 100
        saveData.playerStatus[ENDURANCE]?.value = 100
        saveData.playerStatus[STRENGTH]?.value = 100
        saveData.playerStatus[DEXTERITY]?.value = 100
        saveData.playerStatus[MAGIC]?.value = 100
        saveData.playerStatus[FAITH]?.value = 100
        saveData.playerStatus[LUCK]?.value = 100

        saveData.playerStatus[CURRENT_SOULS]?.value = 100000
    }

    private fun setSpells(saveData: DemonSoulsSaveData) {
        saveData.spellsAndMiraclesInfo[SPELL_SLOTS]?.value = 10
        saveData.spellsAndMiraclesInfo[SPELL_SLOTS]?.value = 10
        saveData.spellsAndMiraclesList.forEach { it.value.value = MEMORIZED }
    }
}



