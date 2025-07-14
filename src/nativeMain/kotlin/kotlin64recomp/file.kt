@file:Suppress("FunctionName", "unused")
@file:OptIn(ExperimentalForeignApi::class)

package kotlin64recomp

import kotlinx.cinterop.*

import me.archinamon.fileio.*

// Everything is heavily abstracted because of the way Kotlin/Native produces headers.
// The File class will be turned into a struct containing only a void* 'pinned' property.
// Therefore, all methods must be implemented again.

fun file(path: String): File = File(path)

// ???

fun file_length(file: File): Long = file.length()

// DATA

fun file_parent(file: File): String? = file.getParent()

fun file_parentFile(file: File): File? = file.getParentFile()

fun file_absolutePath(file: File): String = file.getAbsolutePath()

fun file_path(file: File): String = file.getPath()

fun file_name(file: File): String = file.getName()

fun file_nameWithoutExtension(file: File): String = file.nameWithoutExtension

fun file_lastModified(file: File): Long = file.lastModified()

fun file_isFile(file: File): Boolean = file.isFile()

fun file_isDirectory(file: File): Boolean = file.isDirectory()

fun file_exists(file: File): Boolean = file.exists()

fun file_canRead(file: File): Boolean = file.canRead()

fun file_canWrite(file: File): Boolean = file.canWrite()

fun file_list0(file: File): Array<String> = file.list()

fun file_list(file: File): CPointer<CPointerVar<ByteVar>> = file_list0(file).toCStringArray(MemScope())

fun file_listFiles0(file: File): Array<File> = file.listFiles()

fun file_listFiles(file: File) = file_listFiles0(file)

fun file_toString(file: File): String = file.toString()

// OPERATIONS

fun file_delete(file: File): Boolean = file.delete()

fun file_mkdir(file: File): Boolean = file.mkdir()

fun file_mkdirs(file: File): Boolean = file.mkdirs()

fun file_createNewFile(file: File): Boolean = file.createNewFile()

// READ, WRITE

fun file_readBytes(file: File): ByteArray = file.readBytes()

fun file_writeBytes(file: File, bytes: ByteArray) = file.writeBytes(bytes)

fun file_readText(file: File): String = file.readText()

fun file_appendText(file: File, text: String) = file.appendText(text)

fun file_appendBytes(file: File, bytes: ByteArray) = file.appendBytes(bytes)

fun file_writeText(file: File, text: String) = file.writeText(text)

fun file_separator(): Char = filePathSeparator