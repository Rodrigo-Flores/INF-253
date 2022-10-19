# java makefile

# Compiler
CC = javac

# Compiler flags
CFLAGS = -g

# Source files
SRC = $(wildcard *.java)

# Object files
OBJ = $(SRC:.java=.class)

# Target
TARGET = $(OBJ)

# Makefile rules
all: $(TARGET)

$(TARGET): $(OBJ)
	@echo "Build complete."

$(OBJ): $(SRC)
	$(CC) $(CFLAGS) $(SRC)

clean:
	rm -f $(OBJ)

# End of makefile
