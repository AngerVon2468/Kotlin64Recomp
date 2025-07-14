plugins {
	alias(libs.plugins.kotlinMultiplatform)
}

val libName = "kotlin64recomp"
group = libName
version = "1.0.0"

repositories {
	mavenCentral()
}

@Suppress("PropertyName")
val file_io_version: String by project

kotlin {
	val hostOs = System.getProperty("os.name")
	val isArm64 = System.getProperty("os.arch") == "aarch64"
	val isMac = hostOs == "Mac OS X"
	val isLinux = hostOs == "Linux"
	val isMingwX64 = hostOs.startsWith("Windows")
	val nativeTarget = when {
		isMac && isArm64 -> macosArm64(libName)
		isMac && !isArm64 -> macosX64(libName)
		isLinux && isArm64 -> linuxArm64(libName)
		isLinux && !isArm64 -> linuxX64(libName)
		isMingwX64 -> mingwX64(libName)
		else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
	}

	nativeTarget.apply {
		binaries {
			sharedLib {
				baseName = "${if (isMingwX64) "lib" else ""}${libName}"
			}
		}
	}

	sourceSets {
		nativeMain.dependencies {
			implementation("me.archinamon:file-io:${file_io_version}")
		}
		// No idea if the following is right...
//		macosMain.dependencies {
//			implementation("me.archinamon:file-io-macosx64:${file_io_version}")
//		}
//		linuxMain.dependencies {
//			implementation("me.archinamon:file-io-linuxx64:${file_io_version}")
//		}
//		mingwMain.dependencies {
//			implementation("me.archinamon:file-io-mingwx64:${file_io_version}")
//		}
	}
}

tasks.wrapper {
	distributionType = Wrapper.DistributionType.ALL
}