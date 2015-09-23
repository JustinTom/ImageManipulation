import os
from PIL import Image

def rotate(imgObj):
	#Prompts user for their preferred rotation degree manipulation (clock-wise)
	#If the degree isn't a 90 degree variable, it will fill a black background to accomodate the extra space
	rotationDegree = raw_input("How much would you like to rotate the image (clock-wise)? \n")
	#The true rotate function.
	manipulatedImage = imgObj.rotate(float(rotationDegree), expand=1)
	#Show the rotated, manipulated image 
	manipulatedImage.show()

if __name__ == "__main__":
	#Prompts user for image selection to manipulate.
	imageFile = raw_input("What image would you like to use to manipulate (file extension included)? \n")
	directory = os.getcwd()
	#Gets the file path of the requested image from the user.
	imagePath = directory + "/Images/" + imageFile
	#Create an image object with the user selected image.
	imageObj = Image.open(imagePath)
	#Show the originally selected image before any manipulation.
	imageObj.show()
	rotate(imageObj)