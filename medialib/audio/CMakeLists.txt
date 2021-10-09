cmake_minimum_required(VERSION 3.10.0)

project(eataudiolib)

list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/cmake)

message("AudioLib CMAKE_SYSTEM_NAME:${CMAKE_SYSTEM_NAME}")
message("AudioLib CMAKE_CURRENT_SOURCE_DIR:${CMAKE_CURRENT_SOURCE_DIR}")
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/gen-src/cpp)

aux_source_directory(${CMAKE_CURRENT_SOURCE_DIR}src DJINNI_EATAUDIO_SRC)







