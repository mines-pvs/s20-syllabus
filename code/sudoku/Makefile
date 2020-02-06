FILES = $(shell ls *.java)
FILES_OUT = $(FILES:java=class)

all:		$(FILES_OUT)

%.class:	%.java
			javac -Xlint:unchecked -cp /usr/lib/com.microsoft.z3.jar:. $<

run:	
		java -ea -cp /usr/lib/com.microsoft.z3.jar:. Sudoku
