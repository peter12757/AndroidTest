#需要放到djinni生成的文件下面，增加编译djinni
include_directories(
    cpp
)

if(APPLE)
    aux_source_directory(objc/private SRC)
    aux_source_directory(objc/public SRC)
    add_library(djinni_media OBJECT ${SRC})
    include_directories(
        objc/public
        objc/private
        ${CMAKE_SOURCE_DIR}/../djinni/support-lib/objc
    )
elseif(ANDROID)
    aux_source_directory(jni SRC)
    add_library(djinni_media STATIC ${SRC})
    include_directories(
        ${CMAKE_SOURCE_DIR}/../djinni/support-lib/jni
    )
endif()


