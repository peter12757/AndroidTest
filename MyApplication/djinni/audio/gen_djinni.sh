#! /usr/bin/env bash

cpp_out="cpp"
jni_out="jni"
objc_out="objc"
java_out="java/com/eathemeat/audio"
java_package="com.eathemeat.audio"
namespace="eathemeat"
jni_namespace="eathemeat_jni"
objc_prefix="Audio"
djinni_file="audio.djinni"



../lib/djinni/src/run \
   --java-out $java_out \
   --java-package $java_package \
   --java-cpp-exception DbxException \ # Choose between a customized C++ exception in Java and java.lang.RuntimeException (the default).
   --ident-java-field mFooBar \ # Optional, this adds an "m" in front of Java field names
   \
   --cpp-out $cpp_out \
   \
   --jni-out $jni \
   --ident-jni-class JNIFooBar \ # This adds a "Native" prefix to JNI class
   --ident-jni-file JNIFooBar \ # This adds a prefix to the JNI filenames otherwise the cpp and jni filenames are the same.
   \
   --objc-out $objc_out \
   --objc-type-prefix $objc_prefix \ # Apple suggests Objective-C classes have a prefix for each defined type.
   \
   --objcpp-out $objc_out/private \
   \
   --idl $djinni_file
