# Image Text Search
### A project created at the Cypher V Hackathon (3/23/2019)
###### Jesse Galloway, Isabella Fernandez, Yang Zhang, Reeves Trott

### Overview:
This project takes a list of links to images, extracts all the text found in the image, and allows the user to search the database to find the original image containing that text.

Uses:
* Search for images based on text
* Censor images based on contained text
* Accessibility of images for the visually impared

### 1. Parse Image Database:
We were able to obtain a database of some of the most popular images on the internet here: https://www.kaggle.com/sayangoswami/reddit-memes-dataset/version/1#db.json
We parsed this db in python using Yang's python script in to a list of links (imagelist.txt)


### 2. Google Cloud Vision
We used Google cloud vision to perform OCR on each image, creating a database of each image url, along with the text contained in the picture. Our sample database for this project is database.zip

### 3. Search Functionality
In Java, we loaded the entire database into an searchable array, which returned results based on relevance using a priority queue.

### Future Directions:
This method could be employed to index and search images on a large scale by image hosting sites, social media, or archives. This utility also has the potential to increase accessibility of images for those who are visually impared.


### Notes:
Before proceeding further, please install pandas, the scipy extension of numpy, and mpl_toolkits into your Python library.
Then add the external libraries onto the project if working in Eclipse.
