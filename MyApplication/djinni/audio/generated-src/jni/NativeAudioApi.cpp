// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from audio.djinni

#include "NativeAudioApi.hpp"  // my header
#include "Marshal.hpp"

namespace djinni_generated {

NativeAudioApi::NativeAudioApi() : ::djinni::JniInterface<::textsort::AudioApi, NativeAudioApi>("com/eathemeat/audio/AudioApi$CppProxy") {}

NativeAudioApi::~NativeAudioApi() = default;


CJNIEXPORT void JNICALL Java_com_eathemeat_audio_AudioApi_00024CppProxy_nativeDestroy(JNIEnv* jniEnv, jobject /*this*/, jlong nativeRef)
{
    try {
        DJINNI_FUNCTION_PROLOGUE1(jniEnv, nativeRef);
        delete reinterpret_cast<::djinni::CppProxyHandle<::textsort::AudioApi>*>(nativeRef);
    } JNI_TRANSLATE_EXCEPTIONS_RETURN(jniEnv, )
}

CJNIEXPORT jint JNICALL Java_com_eathemeat_audio_AudioApi_00024CppProxy_native_1startAudiorecord(JNIEnv* jniEnv, jobject /*this*/, jlong nativeRef, jint j_audioSource, jint j_sampleRateInHz, jint j_channelConfig, jint j_audioFormat, jint j_bufferSizeInBytes)
{
    try {
        DJINNI_FUNCTION_PROLOGUE1(jniEnv, nativeRef);
        const auto& ref = ::djinni::objectFromHandleAddress<::textsort::AudioApi>(nativeRef);
        auto r = ref->start_audiorecord(::djinni::I32::toCpp(jniEnv, j_audioSource),
                                        ::djinni::I32::toCpp(jniEnv, j_sampleRateInHz),
                                        ::djinni::I32::toCpp(jniEnv, j_channelConfig),
                                        ::djinni::I32::toCpp(jniEnv, j_audioFormat),
                                        ::djinni::I32::toCpp(jniEnv, j_bufferSizeInBytes));
        return ::djinni::release(::djinni::I32::fromCpp(jniEnv, r));
    } JNI_TRANSLATE_EXCEPTIONS_RETURN(jniEnv, 0 /* value doesn't matter */)
}

}  // namespace djinni_generated
