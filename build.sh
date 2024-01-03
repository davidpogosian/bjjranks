#!/bin/bash

# Source directory
src_dir="src/com/bjjranks/"

# Destination directory
dest_dir="WEB-INF/classes/"

# Library directory
lib_dir="WEB-INF/lib/"

# Create destination directory if it doesn't exist
mkdir -p "$dest_dir"

# Compile all .java files in the source directory with all JAR files in lib_dir in the classpath
find "$src_dir" -name "*.java" -exec javac -cp "$lib_dir*" -d "$dest_dir" {} +

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful. Class files are in $dest_dir"
else
    echo "Compilation failed."
fi
