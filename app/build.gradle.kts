plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
}

android {
	namespace = "com.example.transitionsample"
	compileSdk = 34
	
	defaultConfig {
		applicationId = "com.example.transitionsample"
		minSdk = 30
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}
	
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
//		compose = true
		viewBinding = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	
	//直接羅列してもOK
	//基礎的な便利ライブラリは大抵決まってる（特にドキュメントに乗っていたりするようなものは）
	implementation ("androidx.appcompat:appcompat:1.7.0") //バージョンが下の下位互換をサポートするためのライブラリ
	implementation ("androidx.activity:activity-ktx:1.9.0") // Activityを便利に扱えるライブラリ
	implementation ("androidx.fragment:fragment-ktx:1.8.1") // Fragmentを便利に扱えるライブラリ
	implementation("androidx.constraintlayout:constraintlayout:2.1.4") // ConstraintLayoutを使うためのライブラリ
	
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.transition.ktx)
	
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
}