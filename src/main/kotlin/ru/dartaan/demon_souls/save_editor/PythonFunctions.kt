package ru.dartaan.demon_souls.save_editor

import org.python.core.*
import org.python.util.PythonInterpreter

object PythonFunctions {

    private val PYTHON_SCRIPT = """
import struct


def unpack_ba(fmt, ba):
    string = "".join(map(chr, ba))
    return struct.unpack(fmt, string)[0]


def unpack_s(fmt, string):
    return struct.unpack(fmt, string)[0]


def pack(fmt, *args):
    return struct.pack(fmt, *args)
        """.trimIndent()

    private val interpreter = PythonInterpreter()

    fun unpack(fmt: String, ia: IntArray): String {
        interpreter.exec(PYTHON_SCRIPT)
        val someFunc = interpreter["unpack_ba"]
        val result = someFunc.__call__(PyString(fmt), PyByteArray(ia))
        return result.toString()
    }

//    fun unpack(fmt: String, string: String): String {
//        interpreter.exec(PYTHON_SCRIPT)
//        val someFunc = interpreter["unpack_s"]
//        val result = someFunc.__call__(PyString(fmt), PyString(string))
//        return result.toString()
//    }

    fun pack(fmt: String, value: Number): String {
        interpreter.exec(PYTHON_SCRIPT)
        val packFunc = interpreter["pack"]
        return when (value) {
            is Int -> packFunc.__call__(PyString(fmt), PyInteger(value.toInt())).toString()
            is Long-> packFunc.__call__(PyString(fmt), PyLong(value.toLong())).toString()
            is Float -> packFunc.__call__(PyString(fmt), PyFloat(value.toFloat())).toString()
            else -> ""
        }
    }
}

