DEFAULT_ARGS = test.puzzle
FILES = $(shell ls *.java)
FILES_OUT = $(FILES:java=class)

all:		$(FILES_OUT)

%.class:	%.java
			javac -Xlint:unchecked -cp /usr/lib/com.microsoft.z3.jar:. $<

run:	$(FILES_OUT)
		java -ea -cp /usr/lib/com.microsoft.z3.jar:. Sudoku $(DEFAULT_ARGS)
