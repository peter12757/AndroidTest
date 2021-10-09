cmake_minimum_required(VERSION 3.10.0)

project(Eataudio)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_C_STANDARD 99)

list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/cmake)

message("CMAKE_SYSTEM_NAME:${CMAKE_SYSTEM_NAME}")
message("CMAKE_CURRENT_SOURCE_DIR:${CMAKE_CURRENT_SOURCE_DIR}")

# 设置djinni
set(DJINNI_WITH_JNI ON CACHE BOOL "")
include(AndroidNdkModules)
android_ndk_import_module_cpufeatures()

message("DJINNI_WITH_JNI：${DJINNI_WITH_JNI}")

set(DJINNI_STATIC_LIB ON CACHE BOOL "")
add_subdirectory(../../medialib/djinni/ DJINNI_SRC)
include_directories(
    ${CMAKE_SOURCE_DIR}/../../medialib/djinni/support-lib/jni
    ${CMAKE_SOURCE_DIR}/../../medialib/djinni/support-lib/cpp
)

#audio_record
aux_source_directory(${CMAKE_CURRENT_SOURCE_DIR}/../../medialib/audio/gen-src/jni DJINNI_EATAUDIO_SRC)

add_subdirectory(${CMAKE_CURRENT_SOURCE_DIR}/../../medialib/audio DJINNI_EATAUDIO_SRC)

add_library(Eataudio  SHARED
        DJINNI_EATAUDIO_SRC
        DJINNI_EATAUDIO_SRC)













