

It will accept command line parameters using the following flags.

-i 		input file name
-o 		output file name 
-e 		encode
-d 		decode

The program would then be executed as follows.

java Huffman -i war_and_peace.txt -o compressed_file.comp -e

java Huffman -i compressed_file.comp  -o war_and_peace_decoded.txt -d

diff war_and_peace.txt war_and_peace_decoded.txt 

…should return no differences


