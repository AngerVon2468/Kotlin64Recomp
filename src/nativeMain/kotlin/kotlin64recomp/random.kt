@file:Suppress("FunctionName", "unused")
@file:OptIn(ExperimentalForeignApi::class)
package kotlin64recomp

import kotlinx.cinterop.*

import kotlin.random.Random

fun randomDefault(): Random = Random.Default

fun randomXorWow(seed: Int): Random = Random(seed)

fun randomXorWow(seed: Long): Random = Random(seed)

// FUNCTIONS

fun random_nextBits(random: Random, bitCount: Int): Int = random.nextBits(bitCount)

fun random_nextInt(random: Random): Int = random.nextInt()

fun random_nextInt(random: Random, until: Int): Int = random.nextInt(until)

fun random_nextInt(random: Random, from: Int, until: Int): Int = random.nextInt(from, until)

fun random_nextLong(random: Random): Long = random.nextLong()

fun random_nextLong(random: Random, until: Long): Long = random.nextLong(until)

fun random_nextLong(random: Random, from: Long, until: Long): Long = random.nextLong(from, until)

fun random_nextBoolean(random: Random): Boolean = random.nextBoolean()

fun random_nextDouble(random: Random): Double = random.nextDouble()

fun random_nextDouble(random: Random, until: Double): Double = random.nextDouble(until)

fun random_nextDouble(random: Random, from: Double, until: Double): Double = random.nextDouble(from, until)

fun random_nextFloat(random: Random): Float = random.nextFloat()

fun random_nextBytes(random: Random, array: ByteArray): ByteArray = random.nextBytes(array)
fun random_nextBytes(random: Random, array: ByteArray, fromIndex: Int): ByteArray = random.nextBytes(array, fromIndex)
fun random_nextBytes(random: Random, array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray = random.nextBytes(array, fromIndex, toIndex)

fun random_nextBytes(random: Random, size: Int): ByteArray = random.nextBytes(size)