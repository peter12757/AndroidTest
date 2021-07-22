package com.eathemeat.audiolib.record

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log

const val TAG = "AudioRecordHandler"


const val MSG_START = 0x01
const val MSG_STOP  = 0x02

class AudioRecorder: Handler.Callback{


    private var audioRecord: AudioRecord? = null
    val thread:HandlerThread = HandlerThread("audio_record")
    var handler:Handler?=null

    /**
     * 该参数指的是音频采集的输入源，可选值以常量的 形式定义在类AudioSource(MediaRecorder的一个内部类)中，
     * 常用的值包括:
     * ·DEFAULT(默认)
     * ·VOICE_RECOGNITION(用于语音识别，等同于DEFAULT)
     * ·MIC(由手机麦克风输入)
     * ·VOICE_COMMUNICATION(用于VoIP应用)等
     */
    var audioSource = MediaRecorder.AudioSource.DEFAULT

    /**
     * 指定以多大的采样频率来采集音频，现在用 得最多的就是44100的采样频率(就是我们常说的44.1kHz的采样率)，
     * 如果使用该采样率初始化录音器失败的话，则可以使用16000的采样频 率(就是我们常说的16kHz的采样率)来尝试一下。
     */
    var sampleRateInHz = 44100

    /**
     * 参数用于指定录音器采集几个声道的声音，可 选值以常量的形式定义在AudioFormat类中，
     * 常用的值包括:
     * ·CHANNEL_IN_MONO(单声道)
     * ·CHANNEL_IN_STEREO(立体声)
     */
    var channelConfig = AudioFormat.CHANNEL_IN_MONO

    /**
     * 采样的表示格式，可 选值以常量的形式定义在AudioFormat类中，常用的值包括:
     * ·ENCODING_PCM_16BIT(16bit)
     * ·ENCODING_PCM_8BIT(8bit)
     * ·注意，前者可以保证兼容大部分的Android手机。
     */
    var audioFormat = AudioFormat.ENCODING_PCM_16BIT

    /**
     * AudioRecord内部的音频缓冲区的大小，而具体的大小，不同的厂商 会有不同的实现，该音频缓冲区越小，产生的延时就会越小。
     * AudioRecord类提供了一个静态方法用于确定该bufferSizeInBytes的函 数
     */
    var bufferSizeInBytes = -1


    fun start(audioSource: Int, sampleRateInHz: Int, channelConfig: Int, audioFormat: Int) {
        this.audioSource = audioSource
        this.sampleRateInHz = sampleRateInHz
        this.channelConfig = channelConfig
        this.audioFormat = audioFormat

        if (audioRecord == null) {
            bufferSizeInBytes = AudioRecord.getMinBufferSize(sampleRateInHz,channelConfig,audioFormat)
            audioRecord = AudioRecord(audioSource,sampleRateInHz,channelConfig,audioFormat,bufferSizeInBytes)
        }
        if (audioRecord?.getRecordingState() == AudioRecord.RECORDSTATE_STOPPED) {
            thread.start()
            if (handler == null) {
                handler = Handler(thread.getLooper(),this)
            }
        }
        handler?.sendEmptyMessage(MSG_START)
    }

    fun stop(): Unit {
        handler?.sendEmptyMessage(MSG_STOP)
    }

    fun release(): Unit {
        handler?.sendEmptyMessage(MSG_STOP)

    }

    override fun handleMessage(msg: Message): Boolean {
        var ret = false
        when(msg.what) {
            MSG_START->{
                audioRecord?.startRecording()
            }
            MSG_STOP ->{
                audioRecord?.stop()
            }
        }
    }


}