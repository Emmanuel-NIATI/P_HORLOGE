export DISPLAY=:0.0
cd /home/pi/java
java -classpath '.:classes:*:classes:/opt/pi4j/lib/*' fr.horloge.test.TestHorloge
