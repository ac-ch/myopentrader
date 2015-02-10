#!/bin/bash

echo "*** Starting new Tickprice replayer"
java -server -cp "../libs/*" -Xms3g -Xmx3g -XX:MaxPermSize=512m -Xss256k -XX:+UseParallelGC -XX:ParallelGCThreads=20 -XX:+UseParallelOldGC -XX:+AggressiveOpts -XX:+DisableExplicitGC org.mot.common.util.TickPriceReplayer ../conf $1


