Your assignment is to create a multithreaded program to copy a directory to a new location. 

We will assume that the directory only contains files and no sub directories (you can thank your graders for suggesting to remove that component of the assignment)

Your file should accept two command line arguments, the existing directory path and the destination directory path. If the path conflicts, you will append the suffix “_copy” onto the end of the new directory. If that exists, then add a number to the end.  

Your program will output the new directory twice. The first time it will make all copies sequentially. The second time it will make copies multithreaded. You will use the Java’s built in timing to calculate the time to generate the new directories to compare a single threaded vs a multithreaded copy. You should display timing information to the user. 

A sample program execution might be,

java CopyAll <existing_directory_path> <new_directory_path>

Remember this will create two directories. 

You might want to consider using files of significant size for testing to see a difference in timing. 

When the program has finished executing, you should have identical contents in both your existing directory and well as the new directories your program created. 
