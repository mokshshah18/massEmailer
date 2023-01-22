#!/bin/bash
#to create a script that uses a given name to create a new word document based on a previously written document
if [ "$1" == "man" ]; then
	cat manE
elif [ "$3" == "cus" ]; then
	sed 's/'"$4"'/'"$2"'/g' $1 | tee ./copies/"$2.docx"
elif [ "$2" == "reset" ]; then
	a=$(tail -1 log)
	sed -i 's/'"$a"'/\[person\]/g' $1
elif [ "$2" == "str" ]; then
	sed -i 's/\[person\]/loremipsum/g' $1 | echo loremipsum >> log
else
	sed 's/\[person\]/'"$2"'/g' $1 | tee ./copies/"$2.docx"
	echo "$2">> log
fi
