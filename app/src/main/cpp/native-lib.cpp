#include <jni.h>
#include <string>
#include <iostream>
#include <time.h>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_example_simplendkdemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_simplendkdemo_MainActivity_timeforc(JNIEnv *env, jobject instance,
                                                     jdouble forTimea) {
    jdouble temp;
    clock_t start,finish;
    start=clock();
    while(forTimea>0){//计算这么多次的的加法运算
        jint a=1,b=1;
        a=a+b;
        forTimea--;
    }
    finish = clock();
    temp=(jdouble)(finish-start)/CLOCKS_PER_SEC;
    return temp;
}