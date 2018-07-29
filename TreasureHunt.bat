mkdir out\production\TreasureHunt\
javac -classpath out\production\TreasureHunt\ -sourcepath src -d out\production\TreasureHunt @files.txt
java -classpath out\production\TreasureHunt\ org.test.asim.treasurehunt.main.Main Instructions.txt