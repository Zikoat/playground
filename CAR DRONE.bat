@echo off
echo starting car drone stream...
cd C:\Program Files (x86)\MPlayer-x86_64-r37451+g531b0a3
mplayer -fps 200 -demuxer h264es ffmpeg://tcp://192.168.42.1:2222/
pause