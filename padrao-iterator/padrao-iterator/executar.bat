@echo off
if not exist out mkdir out
javac -encoding UTF-8 -d out src\iterator\*.java test\iterator\*.java
echo ===== Programa =====
java -cp out iterator.Main
echo.
echo ===== Testes =====
java -cp out iterator.TesteIterator
pause
