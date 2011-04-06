#! /bin/sh

export ANT_HOME=tools/apache-ant-1.8.2

tools/apache-ant-1.8.2/bin/ant -buildfile build.xml $*
