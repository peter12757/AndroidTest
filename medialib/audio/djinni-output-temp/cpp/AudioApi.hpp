// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from audio.djinni

#pragma once

#include <cstdint>

namespace textsort {

/**interface */
class AudioApi {
public:
    virtual ~AudioApi() {}

    static int64_t createAudioApi();

    virtual int32_t start_audiorecord(int32_t audioSource, int32_t sampleRateInHz, int32_t channelConfig, int32_t audioFormat, int32_t bufferSizeInBytes) = 0;

    virtual int32_t stop_audiorecord() = 0;
};

}  // namespace textsort
