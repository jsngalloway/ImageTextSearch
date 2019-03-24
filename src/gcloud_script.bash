#!/bin/bash
filename=imagelist.txt
i=0
while IFS= read line
do
    #echo $line
    URL=$line
    text=`gcloud ml vision detect-text $URL | grep -m 1 "description" | cut -c 27- | tr -d '\n'`
    text=${text%????}
    text=${text//'\n'/' '}
    #echo $text
    echo $URL > database/$i.txt
    echo $text >> database/$i.txt
    echo "Finished ($i): $URL"
    ((i++))
done < "$filename"