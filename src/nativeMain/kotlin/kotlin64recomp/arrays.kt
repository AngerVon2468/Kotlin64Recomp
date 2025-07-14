@file:Suppress("FunctionName", "unused")
@file:OptIn(ExperimentalForeignApi::class)
package kotlin64recomp

import kotlinx.cinterop.*

fun byteArrayOf(cArray: CPointer<ByteVar>, size: Int): ByteArray {
	val ret = ByteArray(size)
	for (i in 0..<size) ret[i] = cArray[i]
	return ret
}